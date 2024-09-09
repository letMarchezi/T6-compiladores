package br.ufscar.dc.compiladores.alguma.rotina;

import java.util.Map;

import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaAgenda.DiaSemana;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaEvento.CategoriaAtividades;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Prioridade;

import java.util.List;
import java.time.LocalDate;
import java.util.HashMap;
import java.time.LocalTime;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;;
public class TabelaDeSimbolos {

    
    public static Modalidade determinarTipoModalidade(String tipoVariavel){
        Modalidade tipoItem = Modalidade.INVALIDO; 
        
        switch (tipoVariavel) {
            case "estudo_para_prova":
                tipoItem = Modalidade.ESTUDO_PARA_PROVA;
                break;
            case "projeto":
                tipoItem = Modalidade.PROJETO;
                break;
            case "estudo_teorico":
                tipoItem = Modalidade.ESTUDO_TEORICO;
                break;
            case "lista_de_exercicios":
                tipoItem = Modalidade.LISTA_DE_EXERCICIOS;
                break;
            case "revisao":
                tipoItem = Modalidade.REVISAO;
                break;
        }
        return tipoItem;
    }
    
    public static Prioridade determinarTipoPrioridade(String tipoVariavel){
        Prioridade tipoItem = Prioridade.INVALIDO; 
        
        switch (tipoVariavel) {
            case "alta":
                tipoItem = Prioridade.ALTA;
                break;
            case "media":
                tipoItem = Prioridade.MEDIA;
                break;
            case "baixa":
                tipoItem = Prioridade.BAIXA;
                break;
        }

        return tipoItem;
    }

    
    public static CategoriaAtividades determinarCategoriaAtividades(String tipoVariavel){
        CategoriaAtividades tipoItem = CategoriaAtividades.INVALIDO; 
        
        switch (tipoVariavel) {
            case "pessoal":
                tipoItem = CategoriaAtividades.PESSOAL;
                break;
            case "trabalho":
                tipoItem = CategoriaAtividades.TRABALHO;
                break;
            case "aula":
                tipoItem = CategoriaAtividades.AULA;
                break;

        }
        return tipoItem;
    }  

    

    public static DiaSemana determinarDiaSemana(String tipoVariavel){
        DiaSemana tipoItem = DiaSemana.INVALIDO; 
        
        switch (tipoVariavel) {
            case "DOMINGO":
                tipoItem = DiaSemana.DOMINGO;
                break;
            case "SEGUNDA":
                tipoItem = DiaSemana.SEGUNDA;
                break;
            case "TERCA":
                tipoItem = DiaSemana.TERCA;
                break;
            case "QUARTA":
                tipoItem = DiaSemana.QUARTA;
                break;
            case "QUINTA":
                tipoItem = DiaSemana.QUINTA;
                break;
            case "SEXTA":
                tipoItem = DiaSemana.SEXTA;
                break;
            case "SABADO":
                tipoItem = DiaSemana.SABADO;
                break;
        }
        return tipoItem;
    }  

    class Horario_inicio_fim{
        LocalTime horaInicio;
        LocalTime horaFim;

        public Horario_inicio_fim(String horaInicio, String horaFim) {
            this.horaInicio = timeToLocalTime(horaInicio);
            this.horaFim = timeToLocalTime(horaFim);
        }

        public LocalTime retornaInicio() {
            return horaInicio;
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
        // public static long calculateTimeDifference(LocalTime start, LocalTime end) {
        //     Duration duracao = Duration.between(start, end);
        //     return duracao.toMinutes(); // Retorna a diferença em minutos
        // }

        public long retornaDuracaoMinutos() {
            Duration duracao = Duration.between(this.horaInicio, this.horaFim);
            return duracao.toMinutes(); // Retorna a diferença em minutos
        }

        // Retorna se um horário está contido em outro 
        public boolean fits(Horario_inicio_fim outro) {
            return horaInicio.isBefore(outro.horaFim) && horaFim.isAfter(outro.horaInicio);
        }

        // Método para verificar sobreposição
        public boolean overlaps(Horario_inicio_fim outro) {
            return this.horaInicio.isBefore(outro.horaFim) && outro.horaInicio.isBefore(this.horaFim);
    }
    
    }
    // Especificação das tabelas de símbolos para cada caso relacionada a agenda de estudos
    public Map<DiaSemana, EntradaTabelaAgenda> agenda = new HashMap<>();
    public Map<String, EntradaTabelaRotina> rotinas = new HashMap<>();
    public Map<String, EntradaTabelaEvento> eventos = new HashMap<>();
    public Map<String, EntradaTabelaCompromisso> compromissos = new HashMap<>();

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
    public void adicionarEvento(String nome, String inicio, String fim, LocalDate data_comp) {
        eventos.put(nome, new EntradaTabelaEvento(nome, inicio, fim, data_comp));
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
    public void adicionarCompromisso(String nome, String titulo, String descricao, LocalDate data) {
        compromissos.put(nome, new EntradaTabelaCompromisso(nome, titulo, descricao, data));
    }

    // Obtém um compromisso da tabela de símbolos
    public EntradaTabelaCompromisso obterCompromisso(String nome) {
        return compromissos.get(nome);
    }

    // Verifica se o compromisso já existe
    public boolean existeCompromisso(String nome) {
        return compromissos.containsKey(nome);
    }

    public void exportAll(String filePath){
        try (FileWriter writer = new FileWriter(filePath)) {
        }
        catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo " + filePath + ": " + e.getMessage());
        }
    }

    public void printAll() {
        // Print compromissos
        System.out.println("\n## Compromissos:");
        for (Map.Entry<String, EntradaTabelaCompromisso> entry : compromissos.entrySet()) {
            System.out.println("Compromisso: " + entry.getKey() + " -> " + entry.getValue().toString());
        }
        
        // Print rotinas
        System.out.println("\n## Rotinas:");
        for (Map.Entry<String, EntradaTabelaRotina> entry : rotinas.entrySet()) {
            System.out.println("Rotina: " + entry.getKey() + " -> " + entry.getValue().toString()+"\n");
        }

        // Print agendas
        System.out.println("\n## Agenda:");
        for (Map.Entry<DiaSemana, EntradaTabelaAgenda> entry : agenda.entrySet()) {
            System.out.println("Dia: " + entry.getKey() + " -> " + entry.getValue().toString());
        }
        
        // Print eventos
        System.out.println("\n## Eventos:");
        for (Map.Entry<String, EntradaTabelaEvento> entry : eventos.entrySet()) {
            System.out.println("Evento: " + entry.getKey() + " -> " + entry.getValue().toString());
        }

        
    }
}