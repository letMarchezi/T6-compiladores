package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Prioridade;

public class AlgumaRotina extends AlgumaRotinaBaseVisitor<Void> {
    // Declaração da tabela de símbolos
    TabelaDeSimbolos tabela;
    
    // Declaração da tabela de Escopos
    static Escopos escoposAninhados = new Escopos();
    TabelaDeSimbolos escopos;

    public class Registro {
        private String nome;
        private String descricao;
        private TabelaDeSimbolos.Prioridade prioridade;
        private TabelaDeSimbolos.Modalidade modalidade;
        private String tempoDesejado;
        private String compromisso; // Referência ao identificador de compromisso
    
        public Registro(String nome, String descricao, Prioridade prioridade,
                        Modalidade modalidade, String tempoDesejado, String compromisso) {
            this.nome = nome;
            this.descricao = descricao;
            this.prioridade = prioridade;
            this.modalidade = modalidade;
            this.tempoDesejado = tempoDesejado;
            this.compromisso = compromisso;
        }
    }    

    public static class Rotina {
        private String nome;
        private List<Registro> registros;

        public Rotina(String nome) {
            this.nome = nome;
            this.registros = new ArrayList<>();
        }

        public void adicionarRegistro(Registro registro) {
            this.registros.add(registro);
        }
    }

    public static class Evento {
        private String nome;
        private LocalTime inicio;
        private LocalTime fim;
        private LocalDate data;

        public Evento(String nome, LocalTime inicio, LocalTime fim, LocalDate data) {
            this.nome = nome;
            this.inicio = inicio;
            this.fim = fim;
            this.data = data;
        }
    }

    public static class Compromisso {
        private String nome;
        private String descricao;
        private LocalDate data_compromisso;

        public Compromisso(String nome, String descricao, LocalDate data_compromisso) {
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

    // Adiciona uma rotina na tabela de símbolos
    public void adicionaRotinaTabela(String nomeRotina, Rotina rotina, Token nomeToken) {
        escopos = escoposAninhados.obterEscopoAtual();

        if (!escopos.existeRotina(nomeRotina)) {
            escopos.adicionarRotina(nomeRotina, rotina);
        } else {
            AlgumaRotinaUtils.adicionarErroSemantico(nomeToken, "Rotina " + nomeRotina + " já declarada anteriormente");
        }
    }

    @Override
    public Void visitRotina(AlgumaRotinaParser.RotinaContext ctx) {
        // Itera sobre cada IDENT dentro da rotina
        for (int i = 0; i < ctx.IDENT().size(); i++) {
            String nomeRotina = ctx.IDENT(i).getText();
            System.out.println("nomeRotina" + nomeRotina + "\n");
            Rotina novaRotina = new Rotina(nomeRotina);

            // Itera sobre os registros associados à rotina
            for (AlgumaRotinaParser.RegistroContext regCtx : ctx.registro()) {
                // Cria um novo registro a partir do contexto
                Registro registro = processarRegistro(regCtx);
                novaRotina.adicionarRegistro(registro);
            }

            // Adiciona a rotina na tabela de símbolos
            tabela.adicionarRotina(nomeRotina, novaRotina);

            if (!tabela.existeRotina(nomeRotina)) {
                tabela.adicionarRotina(nomeRotina, novaRotina);
            } else {
                AlgumaRotinaUtils.adicionarErroSemantico(ctx.IDENT(i).getSymbol(), "Rotina " + nomeRotina + " já declarada anteriormente");
            }
        }
        return super.visitRotina(ctx);
    }

    private Registro processarRegistro(AlgumaRotinaParser.RegistroContext regCtx) {
        String nome = regCtx.CADEIA(0).getText();
        String descricao = regCtx.CADEIA(1).getText();
        Prioridade prioridade = Prioridade.valueOf(regCtx.prior_tipo().getText().toUpperCase());
        Modalidade modalidade = Modalidade.valueOf(regCtx.modals().getText().toUpperCase());
        String tempoDesejado = regCtx.HORA().getText();
        String compromisso = regCtx.IDENT().getText();
    
        return new Registro(nome, descricao, prioridade, modalidade, tempoDesejado, compromisso);
    }
}
