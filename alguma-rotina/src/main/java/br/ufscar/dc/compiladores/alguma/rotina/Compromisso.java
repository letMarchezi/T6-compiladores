
package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.LocalDate;

class EntradaTabelaCompromisso {
    String nome;
    String titulo;
    String descricao;
    LocalDate data_compromisso;

    public EntradaTabelaCompromisso(String nome, String titulo, String descricao, LocalDate data_compromisso) {
        this.nome = nome;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data_compromisso = data_compromisso;
    }

    @Override
    public String toString() {
        return "Compromissos {" +
                "nome='" + nome + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data_compromisso=" + data_compromisso +
                '}';
    }
}
