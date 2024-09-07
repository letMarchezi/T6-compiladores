
package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.LocalDate;

class EntradaTabelaEvento {
    
    // Criação das especificação das CATEGORIAS DE EVENTO
    public enum CategoriaAtividades {
        PESSOAL,
        TRABALHO,
        AULA,
        INVALIDO
    }
    
    String nome;
    String inicio;
    String fim;
    LocalDate data_comp;

    public EntradaTabelaEvento(String nome, String inicio, String fim, LocalDate data_comp) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.data_comp = data_comp;
    }
    

    @Override
    public String toString() {
        return "Eventos {" +
                "nome='" + nome + '\'' +
                ", inicio='" + inicio + '\'' +
                ", fim='" + fim + '\'' +
                ", data='" + data_comp + '\'' +
                '}';
    }
}
