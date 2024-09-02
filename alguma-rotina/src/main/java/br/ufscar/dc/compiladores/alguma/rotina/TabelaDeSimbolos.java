package br.ufscar.dc.compiladores.alguma.rotina;

import java.util.Map;
import java.util.HashMap;

import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotina.Compromisso;
import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotina.Evento;
import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotina.Rotina;

public class TabelaDeSimbolos {
    // Criação das especificações de PRIORIDADE de estudo
    public enum Prioridade {
        ALTA,
        MEDIA,
        BAIXA
    }

    // Criação das especificações de MODALIDADE de estudo
    public enum Modalidade {
        ESTUDO_PARA_PROVA,
        PROJETO,
        ESTUDO_TEORICO,
        LISTA_DE_EXERCICIOS,
        REVISAO
    }

    // Criação das especificações de DIAS DA SEMANA
    public enum DiaSemana {
        DOMINGO,
        SEGUNDA,
        TERCA,
        QUARTA,
        QUINTA,
        SEXTA,
        SABADO
    }

    // Criação das especificação das CATEGORIAS DE EVENTO
    public enum CatEvento {
        PESSOAL,
        TRABALHO,
        AULA,
        INVALIDO
    }

    // Especificação das tabelas de símbolos para cada caso relacionada a agenda de estudos
    private Map<String, Rotina> rotinas = new HashMap<>();
    private Map<String, Evento> eventos = new HashMap<>();
    private Map<String, Compromisso> compromissos = new HashMap<>();

    // Adiciona uma rotina à tabela de símbolos
    public void adicionarRotina(String nome, Rotina rotina) {
        rotinas.put(nome, rotina);
    }

    // Obtém uma rotina da tabela de símbolos
    public Rotina obterRotina(String nome) {
        return rotinas.get(nome);
    }

    // Verifica se a rotina já existe
    public boolean existeRotina(String nome) {
        return rotinas.containsKey(nome);
    }

    // Adiciona um compromisso à tabela de símbolos
    public void adicionarCompromisso(String nome, Compromisso compromisso) {
        compromissos.put(nome, compromisso);
    }

    // Obtém um compromisso da tabela de símbolos
    public Compromisso obterCompromisso(String nome) {
        return compromissos.get(nome);
    }

    // Verifica se o compromisso já existe
    public boolean existeCompromisso(String nome) {
        return compromissos.containsKey(nome);
    }

    // Adiciona um evento à tabela de símbolos
    public void adicionarEvento(String nome, Evento evento) {
        eventos.put(nome, evento);
    }

    // Obtém um evento da tabela de símbolos
    public Evento obterEvento(String nome) {
        return eventos.get(nome);
    }

    // Verifica se o evento já existe
    public boolean existeEvento(String nome) {
        return eventos.containsKey(nome);
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