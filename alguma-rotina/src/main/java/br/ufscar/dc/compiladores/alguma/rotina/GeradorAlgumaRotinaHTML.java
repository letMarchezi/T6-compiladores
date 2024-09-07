package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotinaParser.RotinasContext;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Modalidade;
import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaRotina.Prioridade;

public class GeradorAlgumaRotinaHTML extends AlgumaRotinaBaseVisitor<Void> {
    private StringBuilder html = new StringBuilder();

    public String getHtml() {
        return html.toString();
    }

    @Override
    public Void visitPrograma(AlgumaRotinaParser.ProgramaContext ctx) {
        html.append("<html><body>");
        html.append("<h1>Cronograma de Estudos</h1>");
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitAgenda(AlgumaRotinaParser.AgendaContext ctx) {
        LocalDate today_day = LocalDate.now();
        LocalDate first_day = today_day.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate last_day = today_day.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));

        html.append("<h2>Agenda Semanal (")
        .append(first_day.toString())
        .append(" - ")
        .append(last_day.toString())
        .append(")</h2>");

        for (var diaAgendaCtx : ctx.DIAS_SEM()) {
            String diaSemanaStr = diaAgendaCtx.getText();
            
            // Extrai o contexto do dia
            AlgumaRotinaParser.Prog_diaContext progDiaCtx = ctx.prog_dia(ctx.DIAS_SEM().indexOf(diaAgendaCtx));
            String inicioStr = progDiaCtx.HORA(0).getText();
            String fimStr = progDiaCtx.HORA(1).getText();
            
            html.append("<tr><td><strong>").append(diaSemanaStr);
            html.append("<br>Horário Disponível: </strong></td>");
            html.append("<td>").append(inicioStr).append(" - ").append(fimStr).append("</td>");
            
            // Checando se existem atividades neste dia
            if (progDiaCtx.lista_atividades() != null) {
                html.append("<td><ul>");
                for (var atividadeCtx : progDiaCtx.lista_atividades().atividades_agenda()) {
                    // Aqui você pode substituir 'atividadeCtx.getText()' pelos valores correspondentes da atividade
                    String categoria = atividadeCtx.CATEG_ATIVIDADES().getText();
                    String inicioAtividade = atividadeCtx.HORA(0).getText();
                    String fimAtividade = atividadeCtx.HORA(1).getText();
                    
                    html.append("<li>")
                        .append("Atividade: ").append(categoria)
                        .append(", Início: ").append(inicioAtividade)
                        .append(", Fim: ").append(fimAtividade)
                        .append("</li>");
                }
                html.append("</ul></td>");
            } else {
                html.append("<td><ul>");
                // Caso não haja atividades
                html.append("<li><td>Sem atividades</td></li>");
                html.append("</td></ul>");
            }
            html.append("</tr>");
        }
        html.append("</table>");
        return null;
    }   

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

            html.append("<div class='rotina'>")
                .append("<h3>Rotina: ").append(nomeRotina).append("</h3>")
                .append("<p><strong>Título:</strong> ").append(titulo).append("</p>")
                .append("<p><strong>Descrição:</strong> ").append(descricao).append("</p>")
                .append("<p><strong>Prioridade:</strong> ").append(prioridade).append("</p>")
                .append("<p><strong>Modalidade:</strong> ").append(modalidade).append("</p>")
                .append("<p><strong>Tempo Desejado:</strong> ").append(tempoDesejado).append("</p>")
                .append("</div>");
        }
        return super.visitRotinas(ctx);
    }

    /*@Override
    public Void visitComp_parc(AlgumaRotinaParser.Comp_parcContext ctx) {
        html.append("<h2>Compromissos</h2>");

        String nome = ctx.IDENT().getText();
        String titulo = ctx.CADEIA(0).getText();
        String descricao = ctx.CADEIA(1).getText();
        String dataCompromisso = ctx.date().getText();

        html.append("<div class='compromisso'>")
            .append("<h3>Compromisso: ").append(nome).append("</h3>")
            .append("<p><strong>Título:</strong> ").append(titulo).append("</p>")
            .append("<p><strong>Descrição:</strong> ").append(descricao).append("</p>")
            .append("<p><strong>Data:</strong> ").append(dataCompromisso).append("</p>")
            .append("</div>");

        return super.visitComp_parc(ctx);
    }*/

    /*@Override
    public Void visitEvento_parc(AlgumaRotinaParser.Evento_parcContext ctx) {
        String nome = ctx.CADEIA().getText();
        String inicio = ctx.HORA(0).getText();
        String fim = ctx.HORA(1).getText();
        String dataEvento = ctx.date().getText();

        html.append("<h2>Eventos</h2>");
        html.append("<div class='evento'>")
            .append("<h3>Evento: ").append(nome).append("</h3>")
            .append("<p><strong>Início:</strong> ").append(inicio).append("</p>")
            .append("<p><strong>Fim:</strong> ").append(fim).append("</p>")
            .append("<p><strong>Data:</strong> ").append(dataEvento).append("</p>")
            .append("</div>");

        return super.visitEvento_parc(ctx);
    }*/
}
