package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.CategoriaAtividades;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.DiaSemana;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Prioridade;

public class AlgumaRotina extends AlgumaRotinaBaseVisitor<Void> {
    // Declaração da tabela de símbolos
    TabelaDeSimbolos tabela;
    TabelaDeSimbolos tabelaEscopos;
    
    // Declaração da tabela de Escopos
    static Escopos escoposAninhados = new Escopos();

    public Prioridade determinarTipoPrioridade(String tipoVariavel){
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
    
    public CategoriaAtividades determinarCategoriaAtividades(String tipoVariavel){
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

    public DiaSemana determinarDiaSemana(String tipoVariavel){
        DiaSemana tipoItem = DiaSemana.INVALIDO; 
        
        switch (tipoVariavel) {
            case "domingo":
                tipoItem = DiaSemana.DOMINGO;
                break;
            case "segunda":
                tipoItem = DiaSemana.SEGUNDA;
                break;
            case "terca":
                tipoItem = DiaSemana.TERCA;
                break;
            case "quarta":
                tipoItem = DiaSemana.QUARTA;
                break;
            case "quinta":
                tipoItem = DiaSemana.QUINTA;
                break;
            case "sexta":
                tipoItem = DiaSemana.SEXTA;
                break;
            case "sabado":
                tipoItem = DiaSemana.SABADO;
                break;
        }
        return tipoItem;
    }  

    public Modalidade determinarTipoModalidade(String tipoVariavel){
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

    // public static class Rotina {
    //     private String nome;
    //     private List<Registro> registros;

    //     public Rotina(String nome) {
    //         this.nome = nome;
    //         this.registros = new ArrayList<>();
    //     }

    //     public void adicionarRegistro(Registro registro) {
    //         this.registros.add(registro);
    //     }
    // }

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

    // // Adiciona uma rotina na tabela de símbolos
    public void adicionaRotinaTabela(String nome, 
        String titulo, String descricao, Prioridade prioridade, Modalidade modalidade, 
        String tempo_desejado, Compromisso compromisso, Token nomeToken) {
        
            tabelaEscopos = escoposAninhados.obterEscopoAtual();

            if (tabela.existeRotina(nome)) {
                AlgumaRotinaUtils.adicionarErroSemantico(nomeToken, 
                "Rotina " + nome + " ja declarado");
            }
            else{
                tabelaEscopos.adicionarRotina(nome, 
                titulo, descricao, prioridade, modalidade, tempo_desejado, compromisso );
    
            }
            
        // escopos = escoposAninhados.obterEscopoAtual();

        // // tipoRotina = determinarTipoModalidade(rotina.)
        // if (!escopos.existeRotina(nomeRotina)) {
        //     escopos.adicionarRotina(nomeRotina, rotina);
        // } else {
        //     AlgumaRotinaUtils.adicionarErroSemantico(nomeToken, "Rotina " + nomeRotina + " já declarada anteriormente");
        // }
    }

    public Void visitRotinas(AlgumaRotinaParser.RotinasContext ctx) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        // Itera sobre cada IDENT dentro da rotina
        for (var rotina: ctx.rotina()) {
            
            String nomeRotina = rotina.IDENT(0).getSymbol().getText(); 
            var tipoPrioridade = determinarTipoPrioridade(rotina.prioridade_tipo().getText());
            var tipoModalidade = determinarTipoModalidade(rotina.modalidade().getText());

            System.out.println(rotina.getText());
            
            System.out.println(rotina.IDENT(0).getSymbol().getText());
            
            System.out.println(tipoPrioridade);
            
            System.out.println(tipoModalidade);

            System.out.println("\n\n");
            
            
            if (tabelaEscopos.existeRotina(nomeRotina)) {
                AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(0).getSymbol(), 
                    "Rotina " + nomeRotina + " ja declarado");
            }

            if (tipoPrioridade==Prioridade.INVALIDO){
                AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(0).getSymbol(), "Prioridade da rotina " + nomeRotina + " invalida");
                
            }

            if (tipoModalidade==Modalidade.INVALIDO){
                AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(0).getSymbol(), "Modalidade da rotina " + nomeRotina + " invalida");
                   
            }

            adicionaRotinaTabela(nomeRotina, rotina.CADEIA(0).getText(), rotina.CADEIA(1).getText(), rotina.prioridade_tipo(),rotina.modalidade(),rotina.HORA().getText(),rotina.IDENT(1).getText(),rotina.IDENT(0).getSymbol());
            
            // for (var tabela : escoposAninhados.percorrerEscoposAninhados()) {
            //     if (tabela.existeRotina(nomeRotina)) {
            //         AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(0).getSymbol(), 
            //         "Rotina " + nomeRotina + " ja declarado");
            //         break;
            //     }
            // }


            
        }
        return super.visitRotinas(ctx);
    }

    @Override
    public Void visitRotina(AlgumaRotinaParser.RotinaContext ctx) {
        // Itera sobre cada IDENT dentro da rotina
        // for (var rotina: ctx) {
        // for (int i = 0; i < ctx.IDENT().size(); i++) {
        //     String nomeRotina = ctx.IDENT(i).getText();
        //     System.out.println("nomeRotina" + nomeRotina + "\n");
        //     dados_rotina = ctx.
        //     // Adiciona a rotina na tabela de símbolos
        //     tabela.adicionarRotina(nomeRotina, novaRotina);

        //     if (!tabela.existeRotina(nomeRotina)) {
        //         tabela.adicionarRotina(nomeRotina, novaRotina);
        //     } else {
        //         AlgumaRotinaUtils.adicionarErroSemantico(ctx.IDENT(i).getSymbol(), "Rotina " + nomeRotina + " já declarada anteriormente");
        //     }
        // }
        return super.visitRotina(ctx);
    }
}
