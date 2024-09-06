package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.util.AbstractMap;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotinaParser.Atividades_agendaContext;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.CategoriaAtividades;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.DiaSemana;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.EntradaTabelaCompromisso;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Prioridade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Horario_inicio_fim;;

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

    // IMPLEMENTAR ESSE AQUI PARA PODER IMPLEMENTAR O visitAgenda
    public Void visitAtividades_agenda(AlgumaRotinaParser.Atividades_agendaContext ctx) {

        return super.visitAtividades_agenda(ctx);
    }

    public Void visitAgenda(AlgumaRotinaParser.AgendaContext ctx) {
        System.out.println("\n\n"+ctx.getText());

        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        for (var diaAgendaCtx : ctx.dias_sem()) {
            // Extrai o dia da semana
            String diaSemanaStr = diaAgendaCtx.getText(); 
            DiaSemana diaSemana = null;
    
            // Mapeia o dia da semana
            try {
                diaSemana = DiaSemana.valueOf(diaSemanaStr); // Converte a String para enum
                if (diaSemana == DiaSemana.INVALIDO){
                    AlgumaRotinaUtils.adicionarErroSemantico(diaAgendaCtx.getStart(), "Dia invalido: " + diaSemanaStr); 
                }
            } catch (IllegalArgumentException e) {
                AlgumaRotinaUtils.adicionarErroSemantico(diaAgendaCtx.getStart(), "Dia invalido: " + diaSemanaStr);
            }
    
            // Recupera a programação do dia
            AlgumaRotinaParser.Prog_diaContext progDiaCtx = ctx.prog_dia(ctx.dias_sem().indexOf(diaAgendaCtx));
    

            // Extrai o horário de início e de fim, convertendo para a classe de horários
            String inicio = progDiaCtx.HORA(0).getText();
            String fim = progDiaCtx.HORA(1).getText();
            Horario_inicio_fim inicio_fim = tabela.new Horario_inicio_fim(inicio,fim);

            // Checa se existem atividades e extrai os horários
            if (progDiaCtx.lista_atividades() != null) {
                var atividades = progDiaCtx.lista_atividades().atividades_agenda();
                List<Horario_inicio_fim> horarios_ocupados = new ArrayList<Horario_inicio_fim>();

                for (var atividadeCtx : atividades) {
                    getNovo_horario(horarios_ocupados, atividadeCtx);
                }
                // Adiciona a agenda com horários das atividades
                tabelaEscopos.adicionarAgenda(diaSemana, inicio_fim, horarios_ocupados);
                
            }else{
                // Adiciona a agenda sem atividades
                tabelaEscopos.adicionarAgenda(diaSemana, inicio_fim, null);
            }
        }
        return super.visitAgenda(ctx);
    }

    private void getNovo_horario(List<Horario_inicio_fim> horarios_ocupados, Atividades_agendaContext atividadeCtx) {
        String inicioAtividade = atividadeCtx.HORA(0).getText();
        String fimAtividade = atividadeCtx.HORA(1).getText();
        Horario_inicio_fim novo_horario = tabela.new Horario_inicio_fim(inicioAtividade,fimAtividade);
        System.out.println(novo_horario.toString());
        horarios_ocupados.add(novo_horario);
    }

    // Adiciona uma rotina na tabela de símbolos
    public void adicionaRotinaTabela(String nome, 
        String titulo, String descricao, Prioridade prioridade, Modalidade modalidade, 
        String tempo_desejado, EntradaTabelaCompromisso compromisso, Token nomeToken) {
        
        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        tabelaEscopos.adicionarRotina(nome, titulo, descricao, prioridade, modalidade, tempo_desejado, compromisso);
    }

    // Retorna erros semânticos para tipos de prioridade e modalidade inexistentes,
    // compromissos não declarados e rotinas com nome duplicado
    public Void visitRotinas(AlgumaRotinaParser.RotinasContext ctx) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();

        // Itera sobre cada IDENT dentro da rotina
        for (var rotina: ctx.rotina()) {
            
            String nomeRotina = rotina.IDENT(0).getSymbol().getText(); 
            var tipoPrioridade = determinarTipoPrioridade(rotina.prioridade_tipo().getText());
            var tipoModalidade = determinarTipoModalidade(rotina.modalidade().getText());

            // Obtendo o compromisso referenciado com a classe Compromisso
            EntradaTabelaCompromisso compromisso = null;
            String nomeCompromisso = rotina.IDENT(1).getText();
            if (nomeCompromisso != "NULL"){
                compromisso = tabelaEscopos.obterCompromisso(nomeCompromisso);
                if (compromisso == null)
                    AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(1).getSymbol(), 
                        "Compromisso " + nomeCompromisso + " nao declarado");
            }
            
            
            // Verificação de rotina já declarada
            if (tabelaEscopos.existeRotina(nomeRotina)) {
                AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(0).getSymbol(), 
                    "Rotina " + nomeRotina + " ja declarada");
            }
            // Verificação de tipos
            else {
                if (tipoPrioridade==Prioridade.INVALIDO) {
                    AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(0).getSymbol(), "Prioridade da " + nomeRotina + " invalida");   
                }
                if (tipoModalidade==Modalidade.INVALIDO) {
                    AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(0).getSymbol(), "Modalidade da " + nomeRotina + " invalida");   
                }
                adicionaRotinaTabela(nomeRotina, rotina.CADEIA(0).getText(), rotina.CADEIA(1).getText(), tipoPrioridade, tipoModalidade, rotina.HORA().getText(), compromisso, rotina.IDENT(0).getSymbol());
            }
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

    public void adicionaEventoTabela(String nome, String inicio, String fim, LocalDate data, Token nomeToken) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();

        if (tabela.existeEvento(nome)) {
            AlgumaRotinaUtils.adicionarErroSemantico(nomeToken, "Evento " + nome + " ja declarado");
        }
        else {
            tabelaEscopos.adicionarEvento(nome, inicio, fim, data);
        }
    }

    @Override
    public Void visitEvento_parc(AlgumaRotinaParser.Evento_parcContext ctx) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        
        // Atibuição dos atributos do compromisso
        String nome = ctx.CADEIA().getText(); 
        String inicio = ctx.HORA(0).getText();
        String fim = ctx.HORA(1).getText();
        String data_evento = ctx.date().getText();

        /*System.out.println("Nome Evento: " + nome);
        System.out.println("Início Evento: " + inicio);
        System.out.println("Fim Evento: " + fim);
        System.out.println("Data Evento: " + data_evento);
        System.out.println("\n\n");*/
        
        // Verifica se o compromisso já existe
        if (tabelaEscopos.existeEvento(nome)) {
            AlgumaRotinaUtils.adicionarErroSemantico(ctx.CADEIA().getSymbol(), 
                "Evento " + nome + " ja declarado anteriormente");
        }
        
        // Criação do objeto Compromisso
        LocalDate data = LocalDate.parse(data_evento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        // Adiciona o compromisso na tabela de símbolos
        tabelaEscopos.adicionarEvento(nome, inicio, fim, data);
        
        return super.visitEvento_parc(ctx);
    }

    // Adiciona um compromisso na tabela de símbolos
    public void adicionaCompromissoTabela(String nome, String descricao, LocalDate data_compromisso, Token nomeToken) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();

        if (tabela.existeCompromisso(nome)) {
            AlgumaRotinaUtils.adicionarErroSemantico(nomeToken, "Compromisso " + nome + " ja declarado");
        }
        else {
            tabelaEscopos.adicionarCompromisso(nome, descricao, data_compromisso);
        }
    }
    
    @Override
    public Void visitComp_parc(AlgumaRotinaParser.Comp_parcContext ctx) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        
        // Atibuição dos atributos do compromisso
        String nome = ctx.IDENT().getText(); 
        String descricao = ctx.CADEIA(0).getText();
        String data_compromisso = ctx.date().getText();

        /*System.out.println("Nome Compromisso: " + nome);
        System.out.println("Descrição Compromisso: " + descricao);
        System.out.println("Data Compromisso: " + data_compromisso);
        System.out.println("\n\n");*/
        
        // Verifica se o compromisso já existe
        if (tabelaEscopos.existeCompromisso(nome)) {
            AlgumaRotinaUtils.adicionarErroSemantico(ctx.IDENT().getSymbol(), 
                "Compromisso " + nome + " ja declarado anteriormente");
        }
        
        // Criação do objeto Compromisso
        LocalDate data = LocalDate.parse(data_compromisso, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        // Adiciona o compromisso na tabela de símbolos
        tabelaEscopos.adicionarCompromisso(nome, descricao, data);
        
        return super.visitComp_parc(ctx);
    }
}
