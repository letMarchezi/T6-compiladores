package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotinaParser.Atividades_agendaContext;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaAgenda.DiaSemana;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Prioridade;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Horario_inicio_fim;

public class AlgumaRotina extends AlgumaRotinaBaseVisitor<Void> {
    // Declaração da tabela de símbolos
    TabelaDeSimbolos tabela;
    TabelaDeSimbolos tabelaEscopos;

    // Declaração da tabela de Escopos
    static Escopos escoposAninhados = new Escopos();
    // Exporta a tabela de símbolos para um arquivo
    public void exportarTabelaArquivo(String filePath) {
        tabela.exportAll(filePath); 
    }

    public void verificaHorarioInicioFim(String inicioStr, String fimStr, Token Token_type){
                    
        LocalTime inicio = LocalTime.parse(inicioStr.replace("h", ""));
        LocalTime fim = LocalTime.parse(fimStr.replace("h", ""));

        // Verifica se o horário de início é anterior ao de fim
        if (!inicio.isBefore(fim)) {
            AlgumaRotinaUtils.adicionarErroSemantico(Token_type, 
                "Horario de inicio (" + inicioStr + ") nao pode ser igual ou posterior ao horario de fim (" + fimStr + ")");
        }
    }

    // Método base para a inicialização do programa
    @Override
    public Void visitPrograma(AlgumaRotinaParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    public Void visitAgenda(AlgumaRotinaParser.AgendaContext ctx) {

        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        for (var diaAgendaCtx : ctx.DIAS_SEM()) {
            // Extrai o dia da semana
            String diaSemanaStr = diaAgendaCtx.getText();
            DiaSemana diaSemana = null;

            // Mapeia o dia da semana
            try {
                diaSemana = DiaSemana.valueOf(diaSemanaStr); // Converte a String para enum
                if (diaSemana == DiaSemana.INVALIDO){
                    AlgumaRotinaUtils.adicionarErroSemantico(diaAgendaCtx.getSymbol(), "Dia invalido: " + diaSemanaStr); 
                }
            } catch (IllegalArgumentException e) {
                AlgumaRotinaUtils.adicionarErroSemantico(diaAgendaCtx.getSymbol(), "Dia invalido: " + diaSemanaStr);
            }
    
            // Recupera a programação do dia
            AlgumaRotinaParser.Prog_diaContext progDiaCtx = ctx.prog_dia(ctx.DIAS_SEM().indexOf(diaAgendaCtx));

            // Extrai o horário de início e de fim, convertendo para a classe de horários
            String inicioStr = progDiaCtx.HORA(0).getText();
            String fimStr = progDiaCtx.HORA(1).getText();

            verificaHorarioInicioFim(inicioStr, fimStr, progDiaCtx.HORA(0).getSymbol());

            Horario_inicio_fim inicio_fim = tabela.new Horario_inicio_fim(inicioStr,fimStr);

            // Checa se existem atividades e extrai os horários
            if (progDiaCtx.lista_atividades() != null) {
                var atividades = progDiaCtx.lista_atividades().atividades_agenda();
                List<Horario_inicio_fim> horarios_ocupados = new ArrayList<Horario_inicio_fim>();

                for (var atividadeCtx : atividades) {
                    getNovo_horario(horarios_ocupados, atividadeCtx);
                }
                // Adiciona a agenda com horários das atividades
                tabelaEscopos.adicionarAgenda(diaSemana, inicio_fim, horarios_ocupados);
                
            } else{
                // Adiciona a agenda sem atividades
                tabelaEscopos.adicionarAgenda(diaSemana, inicio_fim, null);
            }
        }
        return super.visitAgenda(ctx);
    }

    private void getNovo_horario(List<Horario_inicio_fim> horarios_ocupados, Atividades_agendaContext atividadeCtx) {
        String inicioAtividade = atividadeCtx.HORA(0).getText();
        String fimAtividade = atividadeCtx.HORA(1).getText();

        verificaHorarioInicioFim(inicioAtividade, fimAtividade, atividadeCtx.HORA(0).getSymbol());

        Horario_inicio_fim novo_horario = tabela.new Horario_inicio_fim(inicioAtividade,fimAtividade);
        horarios_ocupados.add(novo_horario);
    }

    // Adiciona uma rotina na tabela de símbolos
    public void adicionaRotinaTabela(String nome, 
        String titulo, String descricao, Prioridade prioridade, Modalidade modalidade, 
        String tempo_desejado, EntradaTabelaCompromisso compr, Token nomeToken) {
        
        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        tabelaEscopos.adicionarRotina(nome, titulo, descricao, prioridade, modalidade, tempo_desejado, compr);
    }

    // Retorna erros semânticos para tipos de prioridade e modalidade inexistentes,
    // compromissos não declarados e rotinas com nome duplicado
    public Void visitRotinas(AlgumaRotinaParser.RotinasContext ctx) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();

        // Itera sobre cada IDENT dentro da rotina
        for (var rotina: ctx.rotina()) {
            
            String nomeRotina = rotina.IDENT(0).getSymbol().getText(); 
            var tipoPrioridade = TabelaDeSimbolos.determinarTipoPrioridade(rotina.PRIORIDADE_TIPO().getText());
            var tipoModalidade = TabelaDeSimbolos.determinarTipoModalidade(rotina.MODALIDADE().getText());

            // Obtendo o compromisso referenciado com a classe Compromisso
            EntradaTabelaCompromisso compromisso = null;
            String nomeCompromisso = rotina.IDENT(1).getText();
            if (nomeCompromisso != "NULL"){
                compromisso = tabelaEscopos.obterCompromisso(nomeCompromisso);
                if (compromisso == null)
                    AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(1).getSymbol(), 
                        "Compromisso da Rotina " + nomeRotina + " nao declarado");
            }
            
            
            // Verificação de rotina já declarada
            if (tabelaEscopos.existeRotina(nomeRotina)) {
                AlgumaRotinaUtils.adicionarErroSemantico(rotina.IDENT(0).getSymbol(), 
                    "Rotina " + nomeRotina + " ja declarada anteriormente");
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

        return super.visitRotina(ctx);
    }

    @Override
    public Void visitEvento_parc(AlgumaRotinaParser.Evento_parcContext ctx) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        
        // Atibuição dos atributos do compromisso
        String nome = ctx.CADEIA().getText(); 
        String inicio = ctx.HORA(0).getText();
        String fim = ctx.HORA(1).getText();
        String data_evento = ctx.date().getText();

        verificaHorarioInicioFim(inicio, fim, ctx.HORA(0).getSymbol());

        // Criação do objeto Evento
        LocalDate data = LocalDate.parse(data_evento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        tabelaEscopos.adicionarEvento(nome, inicio, fim, data);
        
        // Método para mostrar todo o conteúdo da tabela de símbolos
        // Recomendado para depuração
        // tabelaEscopos.printAll();
        return super.visitEvento_parc(ctx);
    }   

    // Adiciona um compromisso na tabela de símbolos
    public void adicionaCompromissoTabela(String nome, String titulo, String descricao, LocalDate data_compromisso, Token nomeToken) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();

        if (tabela.existeCompromisso(nome)) {
            AlgumaRotinaUtils.adicionarErroSemantico(nomeToken, "Compromisso " + nome + " ja declarado");
        }
        else {
            tabelaEscopos.adicionarCompromisso(nome, titulo, descricao, data_compromisso);
        }
    }
    
    @Override
    public Void visitComp_parc(AlgumaRotinaParser.Comp_parcContext ctx) {
        tabelaEscopos = escoposAninhados.obterEscopoAtual();
        
        // Atibuição dos atributos do compromisso
        String nome = ctx.IDENT().getText(); 
        String titulo = ctx.CADEIA(0).getText();
        String descricao = ctx.CADEIA(1).getText();
        String data_compromisso = ctx.date().getText();

        // Verifica se o compromisso já existe
        if (tabelaEscopos.existeCompromisso(nome)) {
            AlgumaRotinaUtils.adicionarErroSemantico(ctx.IDENT().getSymbol(), 
                "Compromisso " + nome + " ja declarado anteriormente");
        }
        
        // Criação do objeto Compromisso
        LocalDate data = LocalDate.parse(data_compromisso, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        // Adiciona o compromisso na tabela de símbolos
        tabelaEscopos.adicionarCompromisso(nome, titulo, descricao, data);
        
        return super.visitComp_parc(ctx);
    }
}
