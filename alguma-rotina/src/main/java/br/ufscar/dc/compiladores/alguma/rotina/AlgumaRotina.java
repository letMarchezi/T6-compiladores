package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Prioridade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.CatEvento;

public class AlgumaRotina extends AlgumaRotinaBaseVisitor<Void> {
    // Declaração da tabela de símbolos
    TabelaDeSimbolos tabela;
    
    // Declaração da tabela de Escopos
    static Escopos escoposAninhados = new Escopos();
    TabelaDeSimbolos escopos;

    public static class Rotina {
        private String nome;
        private String descricao;
        private TabelaDeSimbolos.Prioridade prioridade;
        private TabelaDeSimbolos.Modalidade modalidade;
        private LocalTime tempo_desejado;
        private List<Compromissos> Compromissos;

        public Rotina(String nome, String descricao, Prioridade prioridade, Modalidade modalidade, LocalTime tempo_desejado, List<Compromissos> compromissos) {
            this.nome = nome;
            this.descricao = descricao;
            this.prioridade = prioridade;
            this.modalidade = modalidade;
            this.tempo_desejado = tempo_desejado;
            this.Compromissos = compromissos;
        }

    }

    public static class Eventos {
        private String nome;
        private LocalTime inicio;
        private LocalTime fim;
        private LocalDate data;

        public Eventos(String nome, LocalTime inicio, LocalTime fim, LocalDate data) {
            this.nome = nome;
            this.inicio = inicio;
            this.fim = fim;
            this.data = data;
        }
    }

    public static class Compromissos {
        private String nome;
        private String descricao;
        private LocalDate data_compromisso;

        public Compromissos(String nome, String descricao, LocalDate data_compromisso) {
            this.nome  = nome;
            this.descricao = descricao;
            this.data_compromisso = data_compromisso;
        }
    }

    // Método base para a inicialização do programa
    @Override
    public Void visitPrograma(AlgumaRotinaParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    // Método
    public void adicionaVariavelTabela(String nomeVariavel, String tipoVariavel, Token tipoToken) {
        // Definição do escopo atual
        escopos = escoposAninhados.obterEscopoAtual();

        // Definição do tipo do item analisado no escopo
        CatEvento tipoItem;

        switch(tipoVariavel) {
            case "pessoal":
                tipoItem = TabelaDeSimbolos.CatEvento.PESSOAL;
                break;
            case "aula":
                tipoItem = TabelaDeSimbolos.CatEvento.AULA;
                break;
            case "trabalho":
                tipoItem = TabelaDeSimbolos.CatEvento.TRABALHO;
                break;
            default:
                tipoItem = TabelaDeSimbolos.CatEvento.INVALIDO;
                break;
        }

        // Verificação se o tipo da categoria do evento é inválido para gerar erro semântico
        /*if (tipoItem == TabelaDeSimbolos.CatEvento.INVALIDO) {
            escopos.adicionarEvento(nomeVariavel, tipoItem);
            AlgumaRotinaUtils.adicionarErroSemantico(tipoToken, "tipo " + tipoVariavel + " nao declarado");
        }*/

        // Estou confusa aqui! Como fazer essa verificação?
        // Estou confundido nossa regra de EVENTOS com o eventos que está em AGENDA
    }
}
