package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaAgenda.DiaSemana;

public class GeradorAlgumaRotinaHTML extends AlgumaRotinaBaseVisitor<Void> {

    // Tabela de compromissos para resgatar os dados nas rotinas
    public Map<String, EntradaTabelaCompromisso> compromissos = new HashMap<>();
    // Planejador com funções utilitárias
    public Planejador planner = new Planejador();
    // Html gerado durante o programa
    private StringBuilder html = new StringBuilder();

    
    public String getHtml() {
        return html.toString();
    }
 
    // Inicia o programa, realiza o agendamento e gera as tags html 
    @Override
    public Void visitPrograma(AlgumaRotinaParser.ProgramaContext ctx) {
        StringBuilder inicio_html = new StringBuilder();
        inicio_html.append("<html>\n<head>");
        // Adiciona estilização do HTML
        inicio_html.append(planner.retornaEstilo());
        inicio_html.append("<body><font size='2'>");
        inicio_html.append("<h1>Cronograma de Estudos</h1>");

        Void result = super.visitPrograma(ctx);
        
        // Após visitar todos os bloco, chama o agendador
        planner.planejarEstudos();

        // Concatena o html da tabela do cronograma de estudos com as informações gerais
        inicio_html.append(planner.mostrarAgenda());
        inicio_html.append("</body></html>");
        html = inicio_html.append(html);
        return result;
    }

    // Registra os dias da semana e o período de tempo disponível para estudos
    // Insere as atividades como tempo ocupado 
    @Override
    public Void visitAgenda(AlgumaRotinaParser.AgendaContext ctx) {
        LocalDate today_day = LocalDate.now();
        LocalDate first_day = today_day.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate last_day = today_day.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));

        html.append("<h2>Agenda Semanal (")
            .append(first_day.toString())
            .append(" - ")
            .append(last_day.toString())
            .append(")</h2>");

        html.append("<table border='1'><tr><th>Dia da Semana</th><th>Horário Disponível</th><th>Atividades</th></tr>");

        // Processa os dias da agenda e armazena horários disponíveis
        for (var diaAgendaCtx : ctx.DIAS_SEM()) {
            String diaSemanaStr = diaAgendaCtx.getText();
            AlgumaRotinaParser.Prog_diaContext progDiaCtx = ctx.prog_dia(ctx.DIAS_SEM().indexOf(diaAgendaCtx));

            String inicioStr = progDiaCtx.HORA(0).getText();
            String fimStr = progDiaCtx.HORA(1).getText();

            DiaSemana dia = TabelaDeSimbolos.determinarDiaSemana(diaSemanaStr);
            // Armazena os horários disponíveis
            planner.adicionarPeriodoEstudo(dia, inicioStr, fimStr);

            html.append("<tr><td><strong>").append(diaSemanaStr).append("</strong></td>");
            html.append("<td>").append(inicioStr).append(" - ").append(fimStr).append("</td>");
            
            // Verifica se existem atividades no dia
            if (progDiaCtx.lista_atividades() != null) {
                html.append("<td><ul>");
                for (var atividadeCtx : progDiaCtx.lista_atividades().atividades_agenda()) {
                    String categoria = atividadeCtx.CATEG_ATIVIDADES().getText();
                    String inicioAtividade = atividadeCtx.HORA(0).getText();
                    String fimAtividade = atividadeCtx.HORA(1).getText();
                    
                    html.append("<li>")
                        .append("Atividade: ").append(categoria)
                        .append(", Início: ").append(inicioAtividade)
                        .append(", Fim: ").append(fimAtividade)
                        .append("</li>");
                    planner.adicionarHoraOcupado(TabelaDeSimbolos.determinarDiaSemana(diaSemanaStr),inicioAtividade,fimAtividade);
                }
                html.append("</ul></td>");
            } else {
                html.append("<td>Sem atividades</td>");
            }
            html.append("</tr>");
        }
        
        html.append("</table>\n");
        
        return super.visitAgenda(ctx);
    }

    
    // Registra as rotinas a serem planejadas
    @Override
    public Void visitRotinas(AlgumaRotinaParser.RotinasContext ctx) {
        html.append("<h2>Rotinas</h2>");
        for (var rotina : ctx.rotina()) {
            String nomeRotina = rotina.IDENT(0).getText();
            String titulo = rotina.CADEIA(0).getText();
            String descricao = rotina.CADEIA(1).getText();
            String prioridade = rotina.PRIORIDADE_TIPO().getText();
            String modalidade = rotina.MODALIDADE().getText();
            String tempoDesejado = rotina.HORA().getText();

            // Recuperando informações do compromisso
            EntradaTabelaCompromisso compromisso = null;
            String nomeCompromisso = rotina.IDENT(1).getText();
            if (nomeCompromisso != null) {
                compromisso = compromissos.get(nomeCompromisso);
            } else 
                compromisso = null;

            planner.adicionarRotina(nomeRotina,titulo,descricao, TabelaDeSimbolos.determinarTipoPrioridade(prioridade),TabelaDeSimbolos.determinarTipoModalidade(modalidade),tempoDesejado,compromisso);
            
            html.append("\t\t\t<div class='rotina'>\n")
                .append("\t\t\t<h3>Rotina: ").append(nomeRotina).append("</h3>\n")
                .append("\t\t\t<p><strong>Título:</strong> ").append(titulo).append("</p>\n")
                .append("\t\t\t<p><strong>Descrição:</strong> ").append(descricao).append("</p>\n")
                .append("\t\t\t<p><strong>Prioridade:</strong> ").append(prioridade).append("</p>\n")
                .append("\t\t\t<p><strong>Modalidade:</strong> ").append(modalidade).append("</p>\n")
                .append("\t\t\t<p><strong>Tempo Desejado:</strong> ").append(tempoDesejado).append("</p>\n")
                .append("\t\t\t</div>\n");
        }
        return super.visitRotinas(ctx);
    }

    

    @Override
    public Void visitSeq_comp(AlgumaRotinaParser.Seq_compContext ctx) {
        html.append("<h2>Compromissos</h2>");

        return super.visitSeq_comp(ctx);
    }


    // Registra os compromissos e seus dados
    @Override
    public Void visitComp_parc(AlgumaRotinaParser.Comp_parcContext ctx) {
        String nome = ctx.IDENT().getText();
        String titulo = ctx.CADEIA(0).getText();
        String descricao = ctx.CADEIA(1).getText();
        String dataCompromisso = ctx.date().getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataCompromisso, formatter);
        
        // Adiciona o compromisso ao Hashmap
        compromissos.put(nome, new EntradaTabelaCompromisso(nome, titulo, descricao, data));

        html.append("<div class='compromisso'>\n")
            .append("\t<h3>Compromisso: ").append(nome).append("</h3>\n")
            .append("\t\t<p><strong>Título:</strong> ").append(titulo).append("</p>\n")
            .append("\t\t<p><strong>Descrição:</strong> ").append(descricao).append("</p>\n")
            .append("\t\t<p><strong>Data:</strong> ").append(dataCompromisso).append("</p>\n")
            .append("\t\t</div>\n");

        return super.visitComp_parc(ctx);
    }


    @Override
    public Void visitSeq_evento(AlgumaRotinaParser.Seq_eventoContext ctx) {
        html.append("<h2>Eventos</h2>");
        return super.visitSeq_evento(ctx);
    }

    // Adiciona os eventos à lista de horários ocupados
    @Override
    public Void visitEvento_parc(AlgumaRotinaParser.Evento_parcContext ctx) {

        String nome = ctx.CADEIA().getText();
        String inicio = ctx.HORA(0).getText();
        String fim = ctx.HORA(1).getText();
        String dataEvento = ctx.date().getText();
        html.append("<div class='evento'>\n")
            .append("\t<h3>Evento: ").append(nome).append("</h3>\n")
            .append("\t\t<p><strong>Início:</strong> ").append(inicio).append("</p>\n")
            .append("\t\t<p><strong>Fim:</strong> ").append(fim).append("</p>\n")
            .append("\t\t<p><strong>Data:</strong> ").append(dataEvento).append("</p>\n")
            .append("</div>\n");
        
        DiaSemana dia_evento = converterDataDiaSemana(dataEvento, false);
        // Apenas adiciona o evento na agenda se estiver 
        if (dia_evento != DiaSemana.INVALIDO){
            planner.adicionarHoraOcupado(dia_evento ,inicio,fim);
        }
        
        return super.visitEvento_parc(ctx);
    }

    // Converte uma data para um dia da semana
    // Caso o parâmetro testar_periodo seja verdadeiro, verifica se a data está entre
    // o período do último domingo até o próximo sábado para retornar o tipo verdadeiro
    private DiaSemana converterDataDiaSemana(String dataevento, boolean testar_periodo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataevento, formatter);

        LocalDate today_day = LocalDate.now();
        LocalDate first_day = today_day.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate last_day = today_day.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));

        // Extrai o dia e mapeia para o tipo
        String diaSemana = data.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, new Locale("pt", "BR"))
                .toUpperCase()
                .replace("Ç", "C")
                .split("-")[0];
        DiaSemana dia = TabelaDeSimbolos.determinarDiaSemana(diaSemana);
  
        // Verifica se a data está no período, ou caso testar_periodo não estiver habilitado
        if ((!data.isBefore(first_day) && data.isBefore(last_day)) || !testar_periodo) {
            return dia;                       
        } else {
            // Se não estiver na próxima semana, retorna inválido
            return DiaSemana.INVALIDO;
        }
        

        
    }    
}
