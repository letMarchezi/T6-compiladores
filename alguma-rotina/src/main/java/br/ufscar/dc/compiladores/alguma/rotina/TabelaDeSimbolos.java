package br.ufscar.dc.compiladores.alguma.rotina;

import java.util.Map;

import com.ibm.icu.util.BasicTimeZone.LocalOption;

import java.util.List;
import java.time.LocalDate;
import java.util.HashMap;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.Duration;

import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotina.Compromisso;

public class TabelaDeSimbolos {
    // Criação das especificações de PRIORIDADE de estudo
    public enum Prioridade {
        ALTA,
        MEDIA,
        BAIXA,
        INVALIDO
    }

    // Criação das especificações de MODALIDADE de estudo
    public enum Modalidade {
        ESTUDO_PARA_PROVA,
        PROJETO,
        ESTUDO_TEORICO,
        LISTA_DE_EXERCICIOS,
        REVISAO,
        INVALIDO
    }

    // Criação das especificações de DIAS DA SEMANA
    public enum DiaSemana {
        DOMINGO,
        SEGUNDA,
        TERCA,
        QUARTA,
        QUINTA,
        SEXTA,
        SABADO,
        INVALIDO
    }

    // Criação das especificação das CATEGORIAS DE EVENTO
    public enum CategoriaAtividades {
        PESSOAL,
        TRABALHO,
        AULA,
        INVALIDO
    }

    class EntradaTabelaRotina {
        String titulo;
        String nome;
        String descricao;
        Prioridade prioridade;
        Modalidade modalidade;
        String tempo_desejado;
        Compromisso compromisso;

        private EntradaTabelaRotina(String nome, String titulo, String descricao, Prioridade prioridade, Modalidade modalidade, String tempo_desejado, EntradaTabelaCompromisso compromisso) {
            this.nome = nome;
            this.titulo = titulo;
            this.descricao = descricao;
            this.prioridade = prioridade;
            this.modalidade = modalidade;
            this.tempo_desejado = tempo_desejado;
        }
    }

    class EntradaTabelaEvento {
        String nome;
        String inicio;
        String fim;
        String data;

        private EntradaTabelaEvento(String nome, String inicio, String fim, LocalDate data) {
            this.nome = nome;
            this.inicio = inicio;
            this.fim = fim;
        }
    }
    
    class EntradaTabelaCompromisso {
        String nome;
        String descricao;
        LocalDate data_compromisso;

        private EntradaTabelaCompromisso(String nome, String descricao, LocalDate data_compromisso) {
            this.nome = nome;
            this.descricao = descricao;
            this.data_compromisso = data_compromisso;
        }
    }


    class Horario_inicio_fim{
        LocalTime horaInicio;
        LocalTime horaFim;

        public Horario_inicio_fim(String horaInicio, String horaFim) {
            this.horaInicio = timeToLocalTime(horaInicio);
            this.horaFim = timeToLocalTime(horaFim);
        }


        @Override
        public String toString() {
            return "Início: " + horaInicio + ", Fim: " + horaFim;
        }

        // Função para converter a string no formato HH:MMh para LocalTime
        public static LocalTime timeToLocalTime(String timeStr) {
            timeStr = timeStr.replace("h", ""); // Remove o 'h'
            return LocalTime.parse(timeStr); // Parsea a string para local time
        }

        // Calcula a diferença entre dois horários
        public static long calculateTimeDifference(LocalTime start, LocalTime end) {
            Duration duration = Duration.between(start, end);
            return duration.toMinutes(); // Retorna a diferença em minutos
        }
    
    }

    class EntradaTabelaAgenda {
        DiaSemana dia;
        Horario_inicio_fim inicio_fim;
        List<Horario_inicio_fim> horarios_ocupados;
        

        private EntradaTabelaAgenda(DiaSemana dia, Horario_inicio_fim inicio_fim, List<Horario_inicio_fim> horarios_atividades) {
            this.dia = dia;
            this.inicio_fim = inicio_fim;
            this.horarios_ocupados = horarios_atividades;
        }
    }
    // Especificação das tabelas de símbolos para cada caso relacionada a agenda de estudos
    private Map<DiaSemana, EntradaTabelaAgenda> agenda = new HashMap<>();
    private Map<String, EntradaTabelaRotina> rotinas = new HashMap<>();
    private Map<String, EntradaTabelaEvento> eventos = new HashMap<>();
    private Map<String, EntradaTabelaCompromisso> compromissos = new HashMap<>();

    // Verifica se a string é um dia da semana presente no enum DiaSemana 
    public static boolean isDiaSemanaValido(String dia) {
        // Caso exista a string no enum, retorna true
        try {
            var result_dia = DiaSemana.valueOf(dia.toUpperCase()); 
            if (result_dia != DiaSemana.INVALIDO)
                return true; 
            else
                return false;
        } catch (IllegalArgumentException e) {
            return false; 
        }
    }

    // Adiciona a agenda à tabela de símbolos
    public void adicionarAgenda(DiaSemana dia, Horario_inicio_fim inicio_fim, List<Horario_inicio_fim> atividades_horarios) {
        agenda.put(dia, new EntradaTabelaAgenda(dia, inicio_fim, atividades_horarios));
    }

    // Obtém a agenda da tabela de símbolos
    public EntradaTabelaAgenda obterAgenda(DiaSemana dia) {
        return agenda.get(dia);
    }

    
    // Verifica se a agenda já existe
    public boolean existeAgenda(DiaSemana dia) {
        return agenda.containsKey(dia);
    }

    // Adiciona uma rotina à tabela de símbolos
    public void adicionarRotina(String nome, String titulo, String descricao, Prioridade prioridade, Modalidade modalidade, String tempo_desejado, EntradaTabelaCompromisso compromisso) {
        rotinas.put(nome, new EntradaTabelaRotina(nome, titulo, descricao, prioridade, modalidade, tempo_desejado, compromisso));
    }

    // Obtém uma rotina da tabela de símbolos
    public EntradaTabelaRotina obterRotina(String nome) {
        return rotinas.get(nome);
    }

    // Verifica se a rotina já existe
    public boolean existeRotina(String nome) {
        return rotinas.containsKey(nome);
    }

    // Adiciona um evento à tabela de símbolos
    public void adicionarEvento(String nome, String inicio, String fim, LocalDate data) {
        eventos.put(nome, new EntradaTabelaEvento(nome, inicio, fim, data));
    }

    // Obtém um evento da tabela de símbolos
    public EntradaTabelaEvento obterEvento(String nome) {
        return eventos.get(nome);
    }

    // Verifica se o evento já existe
    public boolean existeEvento(String nome) {
        return eventos.containsKey(nome);
    }

    // Adiciona um compromisso à tabela de símbolos
    public void adicionarCompromisso(String nome, String descricao, LocalDate data) {
        compromissos.put(nome, new EntradaTabelaCompromisso(nome, descricao, data));
    }

    // Obtém um compromisso da tabela de símbolos
    public EntradaTabelaCompromisso obterCompromisso(String nome) {
        return compromissos.get(nome);
    }

    // Verifica se o compromisso já existe
    public boolean existeCompromisso(String nome) {
        return compromissos.containsKey(nome);
    }

    @Override
    public String toString() {
        return "TabelaDeSimbolos{" +
                "rotinas=" + rotinas +
                ", compromissos=" + compromissos +
                ", eventos=" + eventos +
                '}';
    }
}