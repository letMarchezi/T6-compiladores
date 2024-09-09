package br.ufscar.dc.compiladores.alguma.rotina;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import br.ufscar.dc.compiladores.alguma.rotina.EntradaTabelaAgenda.DiaSemana;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Horario_inicio_fim;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

public class GeradorAlgumaRotinaHTML extends AlgumaRotinaBaseVisitor<Void> {

    // Declaração da tabela de de escopos
    // => não utilizados
    //TabelaDeSimbolos tabelaEscopos;
    //static Escopos escoposAninhados = new Escopos();

    public Planejador planner = new Planejador();

    private StringBuilder html = new StringBuilder();
    private boolean finished = false;

    public String getHtml() {
        return html.toString();
    }


    public void onFinish(){
        System.out.println("ACABOU");
    }

    // @Override
    // public Void visitPrograma(AlgumaRotinaParser.ProgramaContext ctx) {
    //     html.append("<html><body>");
    //     html.append("<h1>Cronograma de Estudos</h1>");
    //     return super.visitPrograma(ctx);
    // }


    @Override
    public Void visitPrograma(AlgumaRotinaParser.ProgramaContext ctx) {
        html.append("<html><body>");
        html.append("<h1>Cronograma de Estudos</h1>");

        Void result = super.visitPrograma(ctx);
        
        // After visiting all nodes in the program, print the final message
        planner.agendarAtividades();
        onFinish();
        return result;
    }

    // @Override
    // public Void visitAgenda(AlgumaRotinaParser.AgendaContext ctx) {
    //     html.append("<h2>Agenda</h2>");
    //     for (var diaAgendaCtx : ctx.DIAS_SEM()) {
    //         String diaSemanaStr = diaAgendaCtx.getText();
    //         html.append("<h3>Dia: ").append(diaSemanaStr).append("</h3>");

    //         AlgumaRotinaParser.Prog_diaContext progDiaCtx = ctx.prog_dia(ctx.DIAS_SEM().indexOf(diaAgendaCtx));
    //         String inicioStr = progDiaCtx.HORA(0).getText();
    //         String fimStr = progDiaCtx.HORA(1).getText();

    //         html.append("<p>Horário livre: ").append(inicioStr).append(" - ").append(fimStr).append("</p>");

    //         if (progDiaCtx.lista_atividades() != null) {
    //             html.append("<ul>");
    //             for (var atividadeCtx : progDiaCtx.lista_atividades().atividades_agenda()) {
    //                 html.append("<li>Atividade: ").append(atividadeCtx.getText()).append("</li>");
    //             }
    //             html.append("</ul>");
    //         }
    //     }
    //     return null;
    // }

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
        
        html.append("</table>");
        
        return super.visitAgenda(ctx);
    }


    // @Override
    // public Void visitAgenda(AlgumaRotinaParser.AgendaContext ctx) {
    //     LocalDate today_day = LocalDate.now();
    //     LocalDate first_day = today_day.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
    //     LocalDate last_day = today_day.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));

    //     html.append("<h2>Agenda Semanal (")
    //         .append(first_day.toString())
    //         .append(" - ")
    //         .append(last_day.toString())
    //         .append(")</h2>");

    //     html.append("<table border='1'><tr><th>Dia da Semana</th><th>Horário Disponível</th><th>Atividades</th></tr>");

    //     // Processa os dias da agenda e armazena horários disponíveis
    //     for (var diaAgendaCtx : ctx.DIAS_SEM()) {
    //         String diaSemanaStr = diaAgendaCtx.getText();
    //         AlgumaRotinaParser.Prog_diaContext progDiaCtx = ctx.prog_dia(ctx.DIAS_SEM().indexOf(diaAgendaCtx));

    //         String inicioStr = progDiaCtx.HORA(0).getText();
    //         String fimStr = progDiaCtx.HORA(1).getText();

    //         // Armazena os horários disponíveis
    //         horariosDisponiveis.putIfAbsent(diaSemanaStr, new ArrayList<>());
    //         horariosDisponiveis.get(diaSemanaStr).add(new String[]{inicioStr, fimStr});

    //         html.append("<tr><td><strong>").append(diaSemanaStr).append("</strong></td>");
    //         html.append("<td>").append(inicioStr).append(" - ").append(fimStr).append("</td>");
            
    //         // Verifica se existem atividades no dia
    //         if (progDiaCtx.lista_atividades() != null) {
    //             html.append("<td><ul>");
    //             for (var atividadeCtx : progDiaCtx.lista_atividades().atividades_agenda()) {
    //                 String categoria = atividadeCtx.CATEG_ATIVIDADES().getText();
    //                 String inicioAtividade = atividadeCtx.HORA(0).getText();
    //                 String fimAtividade = atividadeCtx.HORA(1).getText();
                    
    //                 html.append("<li>")
    //                     .append("Atividade: ").append(categoria)
    //                     .append(", Início: ").append(inicioAtividade)
    //                     .append(", Fim: ").append(fimAtividade)
    //                     .append("</li>");
    //             }
    //             html.append("</ul></td>");
    //         } else {
    //             html.append("<td>Sem atividades</td>");
    //         }
    //         html.append("</tr>");
    //     }
        
    //     html.append("</table>");
        
    //     return super.visitAgenda(ctx);
    // }

    
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
            //String nomeCompromisso = rotina.IDENT(1).getText();

            planner.adicionarRotina(nomeRotina,titulo,descricao, TabelaDeSimbolos.determinarTipoPrioridade(prioridade),TabelaDeSimbolos.determinarTipoModalidade(modalidade),tempoDesejado,null);
            
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

    
    @Override
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
    }

    @Override
    public Void visitEvento_parc(AlgumaRotinaParser.Evento_parcContext ctx) {
        html.append("<h2>Eventos</h2>");

        String nome = ctx.CADEIA().getText();
        String inicio = ctx.HORA(0).getText();
        String fim = ctx.HORA(1).getText();
        String dataEvento = ctx.date().getText();

        html.append("<div class='evento'>")
            .append("<h3>Evento: ").append(nome).append("</h3>")
            .append("<p><strong>Início:</strong> ").append(inicio).append("</p>")
            .append("<p><strong>Fim:</strong> ").append(fim).append("</p>")
            .append("<p><strong>Data:</strong> ").append(dataEvento).append("</p>")
            .append("</div>");
        

        planner.adicionarHoraOcupado(converterDataDiaSemana(dataEvento),inicio,fim);
        return super.visitEvento_parc(ctx);
    }

   
    // @Override
    // public Void visitRotinas(AlgumaRotinaParser.RotinasContext ctx) {
    //     tabelaEscopos = escoposAninhados.obterEscopoAtual();

    //     html.append("<h2>Rotinas</h2>");

    //     for (var rotina : ctx.rotina()) {
    //         String nomeRotina = rotina.IDENT(0).getText();
    //         String titulo = rotina.CADEIA(0).getText();
    //         String descricao = rotina.CADEIA(1).getText();
    //         String prioridade = rotina.PRIORIDADE_TIPO().getText();
    //         String modalidade = rotina.MODALIDADE().getText();
    //         String tempo_desejado = rotina.HORA().getText();

    //         // Verificação do compromisso associado
    //         EntradaTabelaCompromisso compromisso = null;
    //         String nomeCompromisso = rotina.IDENT(1).getText();
    //         System.out.println("nomeCompromisso: " + nomeCompromisso + "\n");
    //         if (nomeCompromisso != null) {
    //             compromisso = tabelaEscopos.obterCompromisso(nomeCompromisso);
    //             System.out.println("Compromisso: " + compromisso + "\n");
    //         } else 
    //             compromisso = null;
            
                
    //         // Tenta encaixar a rotina nos horários disponíveis
    //         encaixarRotina(nomeRotina, titulo, descricao, tempo_desejado, compromisso);

    //         html.append("<div class='rotina'>")
    //             .append("<h3>Rotina: ").append(nomeRotina).append("</h3>")
    //             .append("<p><strong>Título:</strong> ").append(titulo).append("</p>")
    //             .append("<p><strong>Descrição:</strong> ").append(descricao).append("</p>")
    //             .append("<p><strong>Prioridade:</strong> ").append(prioridade).append("</p>")
    //             .append("<p><strong>Modalidade:</strong> ").append(modalidade).append("</p>")
    //             .append("<p><strong>Tempo Desejado:</strong> ").append(tempo_desejado).append("</p>")
    //             .append("<p><strong>Compromisso:</strong> ").append(nomeCompromisso).append("</p>")
    //             .append("</div>");
    //     }

    //     return super.visitRotinas(ctx);
    // }

    // private void encaixarRotina(String nomeRotina, String titulo, String descricao, String tempoDesejado, EntradaTabelaCompromisso compromisso) {
    //     LocalDate day_today = LocalDate.now();
    //     System.out.println("##################################################");
    //     // Converte o tempo desejado para minutos
    //     int horasDesejadas = Integer.parseInt(tempoDesejado.split("h")[0]);
    //     int tempoRestanteMinutos = horasDesejadas * 60;
    //     System.out.println("Compromisso: " + compromisso + "\n");
    //     System.out.println("nomeRotina:" + nomeRotina + " | tempoRestanteMinutos:" + tempoRestanteMinutos + " | Horas desejadas: " + horasDesejadas + "\n");

    //     int totalTempoAlocadoMinutos = 0; // Tempo que foi possível alocar

    //     // Define o dia limite para alocar a rotina (um dia antes do compromisso)
    //     LocalDate dataLimite;
    //     if (compromisso != null) {
    //         dataLimite = compromisso.data_compromisso.minusDays(1); // 24 horas antes do compromisso, isto é, um dia antes
    //         System.out.println("dataLimite: " + dataLimite + "dataCompromisso: " + compromisso.data_compromisso + "\n");
    //     }
    //     else
    //         dataLimite = null; // Sem limite de data

    //     // Percorre os horários disponíveis armazenados no visitAgenda
    //     for (Map.Entry<String, List<String[]>> entry : horariosDisponiveis.entrySet()) {
    //         String diaSemana = entry.getKey();
    //         List<String[]> horarios = entry.getValue();

    //         // Converte o nome do dia da semana para LocalDate
    //         LocalDate dataAtual = converterDiaSemanaParaData(diaSemana, day_today);
    //         System.out.println("dataAtual: " + dataAtual + "\n");

    //         // Verifica se já ultrapassou o limite de encaixe
    //         if (dataLimite != null && !dataAtual.isBefore(dataLimite)) {
    //             continue; // Pula esse dia se já for após o limite
    //         }

    //         for (String[] horario : horarios) {
    //             String inicioDisponivelStr = horario[0];
    //             String fimDisponivelStr = horario[1];

    //             // Converte os horários disponíveis para LocalTime
    //             LocalTime inicioDisponivel = LocalTime.parse(inicioDisponivelStr);
    //             LocalTime fimDisponivel = LocalTime.parse(fimDisponivelStr);

    //             // Calcula a duração do intervalo disponível em minutos
    //             int duracaoDisponivelMinutos = (int) java.time.Duration.between(inicioDisponivel, fimDisponivel).toMinutes();

    //             System.out.println("inicioDisponivel: " + inicioDisponivel + "fimDisponivel: " + fimDisponivel + "duracaoDisponivelMinutos: " + duracaoDisponivelMinutos + "\n");

    //             // Verifica se há tempo disponível para alocar uma parte da rotina
    //             if (duracaoDisponivelMinutos > 0) {
    //                 // Calcula o tempo que pode ser alocado
    //                 int minutosParaEncaixar = Math.min(duracaoDisponivelMinutos, tempoRestanteMinutos);

    //                 // Atualiza o tempo restante e o tempo alocado
    //                 tempoRestanteMinutos -= minutosParaEncaixar;
    //                 totalTempoAlocadoMinutos += minutosParaEncaixar;

    //                 LocalTime fimAlocado = inicioDisponivel.plusMinutes(minutosParaEncaixar);

    //                 html.append("<p>Parte da rotina '").append(nomeRotina)
    //                     .append("' encaixada em ").append(diaSemana)
    //                     .append(" das ").append(inicioDisponivel)
    //                     .append(" às ").append(fimAlocado).append("</p>");

    //                 // Se alocou tudo, encerra o processo
    //                 if (tempoRestanteMinutos == 0) {
    //                     return; // Todo o tempo foi alocado
    //                 }
    //             }
    //         }
    //     }

    //     // Caso ainda reste tempo da rotina que não pôde ser encaixado
    //     if (tempoRestanteMinutos > 0) {
    //         html.append("<p>Não foi possível alocar toda a rotina '").append(nomeRotina)
    //             .append("'. Tempo alocado: ").append(totalTempoAlocadoMinutos / 60).append("h")
    //             .append(" Tempo restante: ").append(tempoRestanteMinutos / 60).append("h</p>");
    //     }
    // }

    // Método auxiliar para converter o dia da semana em uma data específica
    // private LocalDate converterDiaSemanaParaData(String diaSemana, LocalDate dataInicial) {
    //     DayOfWeek dia = DayOfWeek.valueOf(diaSemana.toUpperCase()); // Converte o nome do dia para DayOfWeek
    //     return dataInicial.with(TemporalAdjusters.nextOrSame(dia)); // Retorna a próxima data que corresponde ao dia da semana
    // }

    private DiaSemana converterDataDiaSemana(String dataevento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataevento, formatter);
        String diaSemana = data.getDayOfWeek()
                                    .getDisplayName(TextStyle.FULL, new Locale("pt", "BR"))
                                    .toUpperCase()
                                    .replace("Ç", "C")
                                    .split("-")[0];
        DiaSemana dia = TabelaDeSimbolos.determinarDiaSemana(diaSemana);
        return dia;
    }    
}
