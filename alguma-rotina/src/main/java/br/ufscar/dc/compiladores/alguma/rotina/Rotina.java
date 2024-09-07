
package br.ufscar.dc.compiladores.alguma.rotina;

class EntradaTabelaRotina {
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

    String titulo;
    String nome;
    String descricao;
    Prioridade prioridade;
    Modalidade modalidade;
    String tempo_desejado;
    EntradaTabelaCompromisso compromisso;

    public EntradaTabelaRotina(String nome, String titulo, String descricao, Prioridade prioridade, Modalidade modalidade, String tempo_desejado, EntradaTabelaCompromisso compromisso) {
        this.nome = nome;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.modalidade = modalidade;
        this.tempo_desejado = tempo_desejado;
        this.compromisso = compromisso;
    }
    @Override
    public String toString() {
        return "Rotinas {" +
                "titulo='" + titulo + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", prioridade=" + prioridade +
                ", modalidade=" + modalidade +
                ", tempo_desejado='" + tempo_desejado + '\'' +
                ", compromisso=" + compromisso +
                '}';
    }
    
}