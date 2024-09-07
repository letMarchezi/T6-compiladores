// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.alguma.rotina;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlgumaRotinaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlgumaRotinaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#categ_atividades}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCateg_atividades(AlgumaRotinaParser.Categ_atividadesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#dias_sem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDias_sem(AlgumaRotinaParser.Dias_semContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#prioridade_tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrioridade_tipo(AlgumaRotinaParser.Prioridade_tipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#modalidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModalidade(AlgumaRotinaParser.ModalidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#rotinas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotinas(AlgumaRotinaParser.RotinasContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#rotina}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotina(AlgumaRotinaParser.RotinaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(AlgumaRotinaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(AlgumaRotinaParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(AlgumaRotinaParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#agenda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgenda(AlgumaRotinaParser.AgendaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#seq_evento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq_evento(AlgumaRotinaParser.Seq_eventoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#evento_parc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvento_parc(AlgumaRotinaParser.Evento_parcContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#seq_comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq_comp(AlgumaRotinaParser.Seq_compContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#comp_parc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_parc(AlgumaRotinaParser.Comp_parcContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#prog_dia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg_dia(AlgumaRotinaParser.Prog_diaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#lista_atividades}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_atividades(AlgumaRotinaParser.Lista_atividadesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaRotinaParser#atividades_agenda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtividades_agenda(AlgumaRotinaParser.Atividades_agendaContext ctx);
}