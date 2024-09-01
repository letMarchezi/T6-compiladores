package br.ufscar.dc.compiladores.alguma.rotina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotina.Compromissos;
import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotina.Eventos;
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
    private Map<String, Rotina> rotinas;
    private Map<String, Eventos> eventos;
    private Map<String, Compromissos> compromissos;

    // Adiciona uma rotina à tabela de símbolos
    public void adicionarRotina(String nome, Rotina rotina) {
        rotinas.put(nome, rotina);
    }

    // Obtém uma rotina da tabela de símbolos
    public Rotina obterRotina(String nome) {
        return rotinas.get(nome);
    }

    // Adiciona um compromisso à tabela de símbolos
    public void adicionarCompromisso(String nome, Compromissos compromisso) {
        compromissos.put(nome, compromisso);
    }

    // Obtém um compromisso da tabela de símbolos
    public Compromissos obterCompromisso(String nome) {
        return compromissos.get(nome);
    }

    // Adiciona um evento à tabela de símbolos
    public void adicionarEvento(String nome, Eventos evento) {
        eventos.put(nome, evento);
    }

    // Obtém um evento da tabela de símbolos
    public Eventos obterEvento(String nome) {
        return eventos.get(nome);
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