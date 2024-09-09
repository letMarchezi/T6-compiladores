package br.ufscar.dc.compiladores.alguma.rotina;

import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaAgenda.DiaSemana;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Prioridade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Horario_inicio_fim;

import java.time.LocalTime;
import java.util.*;

public class Planejador {

    // Rotinas armazenadas
    public List<EntradaTabelaRotina> rotinas;
    // Horários ocupados
    public Map<DiaSemana, List<Horario_inicio_fim>> agendaOcupada;
    // Periodo disponível para cada dia de estudo
    public Map<DiaSemana, Horario_inicio_fim> periodoEstudo;
    // Rotina de estudos
    public Map<DiaSemana, List<Pair<Horario_inicio_fim,EntradaTabelaRotina>>> rotinaPlanejada;

    public TabelaDeSimbolos tabela;

    class Pair<K, V> {
        public K first;
        public V second;
    
        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public Planejador() {
        rotinas = new ArrayList<>();
        rotinaPlanejada = new HashMap<>();
        agendaOcupada = new HashMap<>();
        periodoEstudo = new HashMap<>();
        this.tabela = new TabelaDeSimbolos();;
    }

    // Adiciona horário de estudos para um dia da semana
    public void adicionarPeriodoEstudo(DiaSemana dia, String inicio, String fim) {
        periodoEstudo.put(dia, this.tabela.new Horario_inicio_fim(inicio,fim));
    }
    // Adiciona horário ocupado para um dia da semana
    public void adicionarHoraOcupado(DiaSemana dia, String inicio, String fim) {
        agendaOcupada.computeIfAbsent(dia, k -> new ArrayList<>()).add(tabela.new Horario_inicio_fim(inicio,fim));
    }

    // Adiciona rotina
    public void adicionarRotina(String nome, String titulo, String descricao, Prioridade prioridade, Modalidade modalidade, String tempo_desejado, EntradaTabelaCompromisso compromisso) {
        rotinas.add(new EntradaTabelaRotina(nome, titulo, descricao, prioridade, modalidade, tempo_desejado, compromisso));
    }

    // Gera horários disponíveis subtraindo os horários ocupados
    private List<Horario_inicio_fim> processaHorariosLivres(DiaSemana dia) {
        // Lista para armazenar os slots disponíveis após eliminação dos horarios ocupados 
        List<Horario_inicio_fim> slotsDisponiveis = new ArrayList<>();
        // Período de início e fim de estudos no dia
        Horario_inicio_fim periodo_estudo = periodoEstudo.get(dia);

        // To-do: FAZER UM SORT NOS TEMPOS
        List<Horario_inicio_fim> temposOcupados = agendaOcupada.getOrDefault(dia, new ArrayList<>());

        temposOcupados.sort(Comparator.comparing(Horario_inicio_fim::retornaInicio));
        LocalTime inicio = periodo_estudo.horaInicio;
        // Caso não haja atividades no dia, adiciona o dia inteiro como disponível
        if (temposOcupados.isEmpty()){
            slotsDisponiveis.add(tabela.new Horario_inicio_fim(periodo_estudo.horaInicio.toString(), periodo_estudo.horaFim.toString()));      
        }
        else{
            // Para cada horário ocupado, adiciona na lista de slots disponívei
            for (Horario_inicio_fim ocupado : temposOcupados) {
                if (ocupado.horaInicio.isAfter(periodo_estudo.horaFim)){
                    continue;
                }
                // Caso o início do período do dia seja antes do início da atividade
                // Adiciona o slot: (inicio_periodo, inicio_atividade)
                if (inicio.isBefore(ocupado.horaInicio)) {
                    slotsDisponiveis.add(tabela.new Horario_inicio_fim(inicio.toString(), ocupado.horaInicio.toString()));
                    System.out.println("\tSlot disponível no dia "+dia +": "+inicio.toString()+" à "+ocupado.horaInicio.toString());
                }
                inicio = ocupado.horaFim;
            }
            if (inicio.isBefore(periodo_estudo.horaFim)) {
                slotsDisponiveis.add(tabela.new Horario_inicio_fim(inicio.toString(), periodo_estudo.horaFim.toString()));
                System.out.println("\tSlot disponível dia "+dia +": "+inicio.toString()+" à "+periodo_estudo.horaFim.toString());
            }
        }

        return slotsDisponiveis;
    }
    // Agenda as atividades nos horários livres
    public void agendarAtividades() {
        // Ordena as rotinas por ordem de prioridade
        rotinas.sort(Comparator.comparing(EntradaTabelaRotina::getPrioridade));

        for (EntradaTabelaRotina entrada : rotinas) {
            long tempoDesejado = entrada.retornaTempoDesejadoMinutos();
            
            for (DiaSemana dia : periodoEstudo.keySet()) {
                List<Horario_inicio_fim> slotDisponivel = processaHorariosLivres(dia);
                // Adiciona os horários de estudos nos slots disponíveis
                for (Horario_inicio_fim slot : slotDisponivel) {
                    if (tempoDesejado <= 0) break;

                    long slotDuracao = slot.retornaDuracaoMinutos();
                    if (slotDuracao >= tempoDesejado) {
                        // Adiciona a rotina completa ao slot
                        Horario_inicio_fim horarioAgendado = tabela.new Horario_inicio_fim(slot.horaInicio.toString(), 
                            slot.horaInicio.plusMinutes(tempoDesejado).toString());
                        rotinaPlanejada.computeIfAbsent(dia, k -> new ArrayList<>()).add(new Pair<>(horarioAgendado, entrada));

                        // Adiciona o tempo ocupado
                        agendaOcupada.computeIfAbsent(dia, k -> new ArrayList<>()).add(horarioAgendado);


                        System.out.println("Agendou " + entrada.titulo + " na " + dia +
                                " das " + slot.horaInicio + " às " + slot.horaInicio.plusMinutes(tempoDesejado));
                                tempoDesejado = 0;
                    } else {
                        // Adição parcial da rotina

                        Horario_inicio_fim horarioAgendado = tabela.new Horario_inicio_fim(slot.horaInicio.toString(), slot.horaFim.toString());
                        rotinaPlanejada.computeIfAbsent(dia, k -> new ArrayList<>()).add(new Pair<>(horarioAgendado, entrada));

                        // Marca o horário como ocupado
                        agendaOcupada.computeIfAbsent(dia, k -> new ArrayList<>()).add(horarioAgendado);

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
