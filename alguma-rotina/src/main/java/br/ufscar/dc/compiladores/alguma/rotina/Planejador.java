package br.ufscar.dc.compiladores.alguma.rotina;

import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaAgenda.DiaSemana;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Prioridade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Horario_inicio_fim;

import java.time.LocalTime;
import java.util.*;

public class Planejador {

    // Rotinas armazenadas
    public List<EntradaTabelaRotina> rotina;
    // Horários ocupados
    public Map<DiaSemana, List<Horario_inicio_fim>> agendaOcupada;
    // Horários de rotinas de estudos
    public Map<DiaSemana, List<Horario_inicio_fim>> planejamentoEstudos;

    public TabelaDeSimbolos tabela;

    public Planejador(TabelaDeSimbolos tabela) {
        this.planejamentoEstudos = new HashMap<>();
        this.agendaOcupada = new HashMap<>();
        this.rotina = new ArrayList<>();
        this.tabela = tabela;
    }

    // Adiciona horário de estudos para um dia da semana
    public void adicionarHoraEstudo(DiaSemana dia, Horario_inicio_fim horario_estudos) {
        planejamentoEstudos.computeIfAbsent(dia, k -> new ArrayList<>()).add(horario_estudos);
    }
    // Adiciona horário de estudos para um dia da semana
    public void adicionarHoraOcupado(DiaSemana dia, Horario_inicio_fim horario_ocupado) {
        agendaOcupada.computeIfAbsent(dia, k -> new ArrayList<>()).add(horario_ocupado);
    }

    // Adiciona rotina
    public void adicionarRotina(String nome, String titulo, String descricao, Prioridade prioridade, Modalidade modalidade, String tempo_desejado, EntradaTabelaCompromisso compromisso) {
        rotina.add(new EntradaTabelaRotina(nome, titulo, descricao, prioridade, modalidade, tempo_desejado, compromisso));
    }

    // Gera horários disponíveis subtraindo os horários ocupados
    private List<Horario_inicio_fim> processaHorariosLivres(DiaSemana dia) {
        List<Horario_inicio_fim> temposDisponiveis = new ArrayList<>();
        List<Horario_inicio_fim> temposEstudos = planejamentoEstudos.getOrDefault(dia, new ArrayList<>());
        List<Horario_inicio_fim> temposOcupados = agendaOcupada.getOrDefault(dia, new ArrayList<>());

        for (Horario_inicio_fim estudo : temposEstudos) {
            LocalTime inicio = estudo.horaInicio;
            for (Horario_inicio_fim ocupado : temposOcupados) {
                if (inicio.isBefore(ocupado.horaInicio)) {
                    temposDisponiveis.add(tabela.new Horario_inicio_fim(inicio.toString(), ocupado.horaInicio.toString()));
                }
                inicio = ocupado.horaFim;
            }
            if (inicio.isBefore(estudo.horaFim)) {
                temposDisponiveis.add(tabela.new Horario_inicio_fim(inicio.toString(), estudo.horaFim.toString()));
            }
        }

        return temposDisponiveis;
    }
    // Agenda as atividades nos horários livres
    public void scheduleActivities() {
        // Ordena as rotinas por ordem de prioridade
        rotina.sort(Comparator.comparing(EntradaTabelaRotina::getPrioridade));

        for (EntradaTabelaRotina entrada : rotina) {
            long tempoDesejado = entrada.retornaTempoDesejadoMinutos();
            
            for (DiaSemana dia : planejamentoEstudos.keySet()) {
                List<Horario_inicio_fim> slotDisponivel = processaHorariosLivres(dia);
                for (Horario_inicio_fim slot : slotDisponivel) {

                    // Adiciona os horários de estudos nos slots disponíveis
                    long slotDuracao = slot.getDuracaoMinutos();
                    if (tempoDesejado <= 0) break;

                    if (slotDuracao >= tempoDesejado) {
                        System.out.println("Agendou " + entrada.titulo + " na " + dia +
                                " das " + slot.horaInicio + " às " + slot.horaInicio.plusMinutes(tempoDesejado));
                                tempoDesejado = 0;
                    } else {
                        System.out.println("Agendou parte de " + entrada.titulo + " na " + dia +
                                " das " + slot.horaInicio + " às " + slot.horaFim);
                                tempoDesejado -= slotDuracao;
                    }
                }
            }

            if (tempoDesejado > 0) {
                System.out.println("Não foi possível agendar todo o tempo de " + entrada.titulo +
                        ", tempo restante: " + tempoDesejado + " minutos.");
            }
        }
    }
}
