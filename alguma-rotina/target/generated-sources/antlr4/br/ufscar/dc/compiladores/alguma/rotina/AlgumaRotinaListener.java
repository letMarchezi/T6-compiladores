// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.alguma.rotina;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlgumaRotinaParser}.
 */
public interface AlgumaRotinaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#categ_evento}.
	 * @param ctx the parse tree
	 */
	void enterCateg_evento(AlgumaRotinaParser.Categ_eventoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#categ_evento}.
	 * @param ctx the parse tree
	 */
	void exitCateg_evento(AlgumaRotinaParser.Categ_eventoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#dias_sem}.
	 * @param ctx the parse tree
	 */
	void enterDias_sem(AlgumaRotinaParser.Dias_semContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#dias_sem}.
	 * @param ctx the parse tree
	 */
	void exitDias_sem(AlgumaRotinaParser.Dias_semContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#prior_tipo}.
	 * @param ctx the parse tree
	 */
	void enterPrior_tipo(AlgumaRotinaParser.Prior_tipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#prior_tipo}.
	 * @param ctx the parse tree
	 */
	void exitPrior_tipo(AlgumaRotinaParser.Prior_tipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#modals}.
	 * @param ctx the parse tree
	 */
	void enterModals(AlgumaRotinaParser.ModalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#modals}.
	 * @param ctx the parse tree
	 */
	void exitModals(AlgumaRotinaParser.ModalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#rotina}.
	 * @param ctx the parse tree
	 */
	void enterRotina(AlgumaRotinaParser.RotinaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#rotina}.
	 * @param ctx the parse tree
	 */
	void exitRotina(AlgumaRotinaParser.RotinaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(AlgumaRotinaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(AlgumaRotinaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(AlgumaRotinaParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(AlgumaRotinaParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#agenda}.
	 * @param ctx the parse tree
	 */
	void enterAgenda(AlgumaRotinaParser.AgendaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#agenda}.
	 * @param ctx the parse tree
	 */
	void exitAgenda(AlgumaRotinaParser.AgendaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#seq_evento}.
	 * @param ctx the parse tree
	 */
	void enterSeq_evento(AlgumaRotinaParser.Seq_eventoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#seq_evento}.
	 * @param ctx the parse tree
	 */
	void exitSeq_evento(AlgumaRotinaParser.Seq_eventoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#evento_parc}.
	 * @param ctx the parse tree
	 */
	void enterEvento_parc(AlgumaRotinaParser.Evento_parcContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#evento_parc}.
	 * @param ctx the parse tree
	 */
	void exitEvento_parc(AlgumaRotinaParser.Evento_parcContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#seq_comp}.
	 * @param ctx the parse tree
	 */
	void enterSeq_comp(AlgumaRotinaParser.Seq_compContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#seq_comp}.
	 * @param ctx the parse tree
	 */
	void exitSeq_comp(AlgumaRotinaParser.Seq_compContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#comp_parc}.
	 * @param ctx the parse tree
	 */
	void enterComp_parc(AlgumaRotinaParser.Comp_parcContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#comp_parc}.
	 * @param ctx the parse tree
	 */
	void exitComp_parc(AlgumaRotinaParser.Comp_parcContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(AlgumaRotinaParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(AlgumaRotinaParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(AlgumaRotinaParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(AlgumaRotinaParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#prog_dia}.
	 * @param ctx the parse tree
	 */
	void enterProg_dia(AlgumaRotinaParser.Prog_diaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#prog_dia}.
	 * @param ctx the parse tree
	 */
	void exitProg_dia(AlgumaRotinaParser.Prog_diaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgumaRotinaParser#evento_agenda}.
	 * @param ctx the parse tree
	 */
	void enterEvento_agenda(AlgumaRotinaParser.Evento_agendaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgumaRotinaParser#evento_agenda}.
	 * @param ctx the parse tree
	 */
	void exitEvento_agenda(AlgumaRotinaParser.Evento_agendaContext ctx);
}