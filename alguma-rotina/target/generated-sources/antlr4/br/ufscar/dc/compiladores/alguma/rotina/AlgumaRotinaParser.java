// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.alguma.rotina;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AlgumaRotinaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, IDENT=50, HORA=51, CADEIA=52, 
		CADEIA_NAO_FECHADA=53, DIGIT=54, WS=55;
	public static final int
		RULE_categ_atividades = 0, RULE_dias_sem = 1, RULE_prioridade_tipo = 2, 
		RULE_modalidade = 3, RULE_rotinas = 4, RULE_rotina = 5, RULE_programa = 6, 
		RULE_corpo = 7, RULE_date = 8, RULE_agenda = 9, RULE_seq_evento = 10, 
		RULE_evento_parc = 11, RULE_seq_comp = 12, RULE_comp_parc = 13, RULE_prog_dia = 14, 
		RULE_lista_atividades = 15, RULE_atividades_agenda = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"categ_atividades", "dias_sem", "prioridade_tipo", "modalidade", "rotinas", 
			"rotina", "programa", "corpo", "date", "agenda", "seq_evento", "evento_parc", 
			"seq_comp", "comp_parc", "prog_dia", "lista_atividades", "atividades_agenda"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pessoal'", "'aula'", "'trabalho'", "'DOMINGO'", "'SEGUNDA'", 
			"'TERCA'", "'QUARTA'", "'QUINTA'", "'SEXTA'", "'SABADO'", "'alta'", "'media'", 
			"'baixa'", "'estudo_para_prova'", "'projeto'", "'estudo_teorico'", "'lista_de_exercicios'", 
			"'revisao'", "':'", "'('", "'titulo='", "','", "'descricao='", "'prioridade='", 
			"'modalidade='", "'tempo_desejado='", "'compromisso='", "')'", "'ROTINA'", 
			"'FIMROTINA'", "'AGENDA'", "'FIMAGENDA'", "'/'", "'EVENTOS'", "'FIMEVENTOS'", 
			"'nome'", "'inicio'", "'fim'", "'data'", "'COMPROMISSOS'", "'FIMCOMPROMISSOS'", 
			"'titulo'", "'descricao'", "'data_compromisso'", "'atividades'", "'='", 
			"'{'", "'}'", "'categoria'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "IDENT", "HORA", "CADEIA", "CADEIA_NAO_FECHADA", "DIGIT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlgumaRotinaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Categ_atividadesContext extends ParserRuleContext {
		public Categ_atividadesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_categ_atividades; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterCateg_atividades(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitCateg_atividades(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitCateg_atividades(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Categ_atividadesContext categ_atividades() throws RecognitionException {
		Categ_atividadesContext _localctx = new Categ_atividadesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_categ_atividades);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dias_semContext extends ParserRuleContext {
		public Dias_semContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dias_sem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterDias_sem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitDias_sem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitDias_sem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dias_semContext dias_sem() throws RecognitionException {
		Dias_semContext _localctx = new Dias_semContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dias_sem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 2032L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Prioridade_tipoContext extends ParserRuleContext {
		public Prioridade_tipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prioridade_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterPrioridade_tipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitPrioridade_tipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitPrioridade_tipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prioridade_tipoContext prioridade_tipo() throws RecognitionException {
		Prioridade_tipoContext _localctx = new Prioridade_tipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prioridade_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModalidadeContext extends ParserRuleContext {
		public ModalidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modalidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterModalidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitModalidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitModalidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModalidadeContext modalidade() throws RecognitionException {
		ModalidadeContext _localctx = new ModalidadeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_modalidade);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 507904L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RotinasContext extends ParserRuleContext {
		public List<RotinaContext> rotina() {
			return getRuleContexts(RotinaContext.class);
		}
		public RotinaContext rotina(int i) {
			return getRuleContext(RotinaContext.class,i);
		}
		public RotinasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotinas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterRotinas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitRotinas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitRotinas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotinasContext rotinas() throws RecognitionException {
		RotinasContext _localctx = new RotinasContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rotinas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				rotina();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RotinaContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AlgumaRotinaParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AlgumaRotinaParser.IDENT, i);
		}
		public List<TerminalNode> CADEIA() { return getTokens(AlgumaRotinaParser.CADEIA); }
		public TerminalNode CADEIA(int i) {
			return getToken(AlgumaRotinaParser.CADEIA, i);
		}
		public Prioridade_tipoContext prioridade_tipo() {
			return getRuleContext(Prioridade_tipoContext.class,0);
		}
		public ModalidadeContext modalidade() {
			return getRuleContext(ModalidadeContext.class,0);
		}
		public TerminalNode HORA() { return getToken(AlgumaRotinaParser.HORA, 0); }
		public RotinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterRotina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitRotina(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitRotina(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotinaContext rotina() throws RecognitionException {
		RotinaContext _localctx = new RotinaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rotina);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(47);
			match(IDENT);
			setState(48);
			match(T__18);
			setState(49);
			match(T__19);
			setState(50);
			match(T__20);
			setState(51);
			match(CADEIA);
			setState(52);
			match(T__21);
			setState(53);
			match(T__22);
			setState(54);
			match(CADEIA);
			setState(55);
			match(T__21);
			setState(56);
			match(T__23);
			setState(57);
			prioridade_tipo();
			setState(58);
			match(T__21);
			setState(59);
			match(T__24);
			setState(60);
			modalidade();
			setState(61);
			match(T__21);
			setState(62);
			match(T__25);
			setState(63);
			match(HORA);
			setState(64);
			match(T__21);
			setState(65);
			match(T__26);
			setState(66);
			match(IDENT);
			setState(67);
			match(T__27);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public Seq_compContext seq_comp() {
			return getRuleContext(Seq_compContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AlgumaRotinaParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			seq_comp();
			setState(70);
			corpo();
			setState(71);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CorpoContext extends ParserRuleContext {
		public RotinasContext rotinas() {
			return getRuleContext(RotinasContext.class,0);
		}
		public AgendaContext agenda() {
			return getRuleContext(AgendaContext.class,0);
		}
		public Seq_eventoContext seq_evento() {
			return getRuleContext(Seq_eventoContext.class,0);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitCorpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_corpo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__28);
			setState(74);
			rotinas();
			setState(75);
			match(T__29);
			setState(76);
			match(T__30);
			setState(77);
			agenda();
			setState(78);
			match(T__31);
			setState(79);
			seq_evento();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(AlgumaRotinaParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(AlgumaRotinaParser.DIGIT, i);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(DIGIT);
			setState(82);
			match(DIGIT);
			setState(83);
			match(T__32);
			setState(84);
			match(DIGIT);
			setState(85);
			match(DIGIT);
			setState(86);
			match(T__32);
			setState(87);
			match(DIGIT);
			setState(88);
			match(DIGIT);
			setState(89);
			match(DIGIT);
			setState(90);
			match(DIGIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AgendaContext extends ParserRuleContext {
		public List<Dias_semContext> dias_sem() {
			return getRuleContexts(Dias_semContext.class);
		}
		public Dias_semContext dias_sem(int i) {
			return getRuleContext(Dias_semContext.class,i);
		}
		public List<Prog_diaContext> prog_dia() {
			return getRuleContexts(Prog_diaContext.class);
		}
		public Prog_diaContext prog_dia(int i) {
			return getRuleContext(Prog_diaContext.class,i);
		}
		public AgendaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agenda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterAgenda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitAgenda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitAgenda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgendaContext agenda() throws RecognitionException {
		AgendaContext _localctx = new AgendaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_agenda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				dias_sem();
				setState(93);
				match(T__19);
				setState(94);
				prog_dia();
				setState(95);
				match(T__27);
				}
				}
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 2032L) != 0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Seq_eventoContext extends ParserRuleContext {
		public List<Evento_parcContext> evento_parc() {
			return getRuleContexts(Evento_parcContext.class);
		}
		public Evento_parcContext evento_parc(int i) {
			return getRuleContext(Evento_parcContext.class,i);
		}
		public Seq_eventoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq_evento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterSeq_evento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitSeq_evento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitSeq_evento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Seq_eventoContext seq_evento() throws RecognitionException {
		Seq_eventoContext _localctx = new Seq_eventoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_seq_evento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__33);
			setState(103); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(102);
				evento_parc();
				}
				}
				setState(105); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__19 );
			setState(107);
			match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Evento_parcContext extends ParserRuleContext {
		public TerminalNode CADEIA() { return getToken(AlgumaRotinaParser.CADEIA, 0); }
		public List<TerminalNode> HORA() { return getTokens(AlgumaRotinaParser.HORA); }
		public TerminalNode HORA(int i) {
			return getToken(AlgumaRotinaParser.HORA, i);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public Evento_parcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evento_parc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterEvento_parc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitEvento_parc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitEvento_parc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Evento_parcContext evento_parc() throws RecognitionException {
		Evento_parcContext _localctx = new Evento_parcContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_evento_parc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__19);
			setState(110);
			match(T__35);
			setState(111);
			match(CADEIA);
			setState(112);
			match(T__21);
			setState(113);
			match(T__36);
			setState(114);
			match(HORA);
			setState(115);
			match(T__21);
			setState(116);
			match(T__37);
			setState(117);
			match(HORA);
			setState(118);
			match(T__21);
			setState(119);
			match(T__38);
			setState(120);
			date();
			setState(121);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Seq_compContext extends ParserRuleContext {
		public List<Comp_parcContext> comp_parc() {
			return getRuleContexts(Comp_parcContext.class);
		}
		public Comp_parcContext comp_parc(int i) {
			return getRuleContext(Comp_parcContext.class,i);
		}
		public Seq_compContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterSeq_comp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitSeq_comp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitSeq_comp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Seq_compContext seq_comp() throws RecognitionException {
		Seq_compContext _localctx = new Seq_compContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_seq_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__39);
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				comp_parc();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(129);
			match(T__40);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comp_parcContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(AlgumaRotinaParser.IDENT, 0); }
		public List<TerminalNode> CADEIA() { return getTokens(AlgumaRotinaParser.CADEIA); }
		public TerminalNode CADEIA(int i) {
			return getToken(AlgumaRotinaParser.CADEIA, i);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public Comp_parcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_parc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterComp_parc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitComp_parc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitComp_parc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_parcContext comp_parc() throws RecognitionException {
		Comp_parcContext _localctx = new Comp_parcContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comp_parc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(IDENT);
			setState(132);
			match(T__18);
			setState(133);
			match(T__19);
			setState(134);
			match(T__41);
			setState(135);
			match(CADEIA);
			setState(136);
			match(T__21);
			setState(137);
			match(T__42);
			setState(138);
			match(CADEIA);
			setState(139);
			match(T__21);
			setState(140);
			match(T__43);
			setState(141);
			date();
			setState(142);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Prog_diaContext extends ParserRuleContext {
		public List<TerminalNode> HORA() { return getTokens(AlgumaRotinaParser.HORA); }
		public TerminalNode HORA(int i) {
			return getToken(AlgumaRotinaParser.HORA, i);
		}
		public Lista_atividadesContext lista_atividades() {
			return getRuleContext(Lista_atividadesContext.class,0);
		}
		public Prog_diaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog_dia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterProg_dia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitProg_dia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitProg_dia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prog_diaContext prog_dia() throws RecognitionException {
		Prog_diaContext _localctx = new Prog_diaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_prog_dia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__36);
			setState(145);
			match(HORA);
			setState(146);
			match(T__21);
			setState(147);
			match(T__37);
			setState(148);
			match(HORA);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(149);
				match(T__21);
				setState(150);
				match(T__44);
				setState(151);
				match(T__45);
				setState(152);
				match(T__46);
				setState(153);
				lista_atividades();
				setState(154);
				match(T__47);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lista_atividadesContext extends ParserRuleContext {
		public List<Atividades_agendaContext> atividades_agenda() {
			return getRuleContexts(Atividades_agendaContext.class);
		}
		public Atividades_agendaContext atividades_agenda(int i) {
			return getRuleContext(Atividades_agendaContext.class,i);
		}
		public Lista_atividadesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_atividades; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterLista_atividades(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitLista_atividades(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitLista_atividades(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lista_atividadesContext lista_atividades() throws RecognitionException {
		Lista_atividadesContext _localctx = new Lista_atividadesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lista_atividades);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			atividades_agenda();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(159);
				match(T__21);
				setState(160);
				atividades_agenda();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Atividades_agendaContext extends ParserRuleContext {
		public Categ_atividadesContext categ_atividades() {
			return getRuleContext(Categ_atividadesContext.class,0);
		}
		public List<TerminalNode> HORA() { return getTokens(AlgumaRotinaParser.HORA); }
		public TerminalNode HORA(int i) {
			return getToken(AlgumaRotinaParser.HORA, i);
		}
		public Atividades_agendaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atividades_agenda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterAtividades_agenda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitAtividades_agenda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitAtividades_agenda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atividades_agendaContext atividades_agenda() throws RecognitionException {
		Atividades_agendaContext _localctx = new Atividades_agendaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atividades_agenda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__19);
			setState(167);
			match(T__48);
			setState(168);
			categ_atividades();
			setState(169);
			match(T__21);
			setState(170);
			match(T__36);
			setState(171);
			match(HORA);
			setState(172);
			match(T__21);
			setState(173);
			match(T__37);
			setState(174);
			match(HORA);
			setState(175);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00017\u00b2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004"+
		",\b\u0004\u000b\u0004\f\u0004-\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004"+
		"\tb\b\t\u000b\t\f\tc\u0001\n\u0001\n\u0004\nh\b\n\u000b\n\f\ni\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0004\f~\b\f\u000b\f\f"+
		"\f\u007f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u009d\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00a2\b"+
		"\u000f\n\u000f\f\u000f\u00a5\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000"+
		"\u0004\u0001\u0000\u0001\u0003\u0001\u0000\u0004\n\u0001\u0000\u000b\r"+
		"\u0001\u0000\u000e\u0012\u00a6\u0000\"\u0001\u0000\u0000\u0000\u0002$"+
		"\u0001\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000\u0006(\u0001\u0000"+
		"\u0000\u0000\b+\u0001\u0000\u0000\u0000\n/\u0001\u0000\u0000\u0000\fE"+
		"\u0001\u0000\u0000\u0000\u000eI\u0001\u0000\u0000\u0000\u0010Q\u0001\u0000"+
		"\u0000\u0000\u0012a\u0001\u0000\u0000\u0000\u0014e\u0001\u0000\u0000\u0000"+
		"\u0016m\u0001\u0000\u0000\u0000\u0018{\u0001\u0000\u0000\u0000\u001a\u0083"+
		"\u0001\u0000\u0000\u0000\u001c\u0090\u0001\u0000\u0000\u0000\u001e\u009e"+
		"\u0001\u0000\u0000\u0000 \u00a6\u0001\u0000\u0000\u0000\"#\u0007\u0000"+
		"\u0000\u0000#\u0001\u0001\u0000\u0000\u0000$%\u0007\u0001\u0000\u0000"+
		"%\u0003\u0001\u0000\u0000\u0000&\'\u0007\u0002\u0000\u0000\'\u0005\u0001"+
		"\u0000\u0000\u0000()\u0007\u0003\u0000\u0000)\u0007\u0001\u0000\u0000"+
		"\u0000*,\u0003\n\u0005\u0000+*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.\t\u0001\u0000"+
		"\u0000\u0000/0\u00052\u0000\u000001\u0005\u0013\u0000\u000012\u0005\u0014"+
		"\u0000\u000023\u0005\u0015\u0000\u000034\u00054\u0000\u000045\u0005\u0016"+
		"\u0000\u000056\u0005\u0017\u0000\u000067\u00054\u0000\u000078\u0005\u0016"+
		"\u0000\u000089\u0005\u0018\u0000\u00009:\u0003\u0004\u0002\u0000:;\u0005"+
		"\u0016\u0000\u0000;<\u0005\u0019\u0000\u0000<=\u0003\u0006\u0003\u0000"+
		"=>\u0005\u0016\u0000\u0000>?\u0005\u001a\u0000\u0000?@\u00053\u0000\u0000"+
		"@A\u0005\u0016\u0000\u0000AB\u0005\u001b\u0000\u0000BC\u00052\u0000\u0000"+
		"CD\u0005\u001c\u0000\u0000D\u000b\u0001\u0000\u0000\u0000EF\u0003\u0018"+
		"\f\u0000FG\u0003\u000e\u0007\u0000GH\u0005\u0000\u0000\u0001H\r\u0001"+
		"\u0000\u0000\u0000IJ\u0005\u001d\u0000\u0000JK\u0003\b\u0004\u0000KL\u0005"+
		"\u001e\u0000\u0000LM\u0005\u001f\u0000\u0000MN\u0003\u0012\t\u0000NO\u0005"+
		" \u0000\u0000OP\u0003\u0014\n\u0000P\u000f\u0001\u0000\u0000\u0000QR\u0005"+
		"6\u0000\u0000RS\u00056\u0000\u0000ST\u0005!\u0000\u0000TU\u00056\u0000"+
		"\u0000UV\u00056\u0000\u0000VW\u0005!\u0000\u0000WX\u00056\u0000\u0000"+
		"XY\u00056\u0000\u0000YZ\u00056\u0000\u0000Z[\u00056\u0000\u0000[\u0011"+
		"\u0001\u0000\u0000\u0000\\]\u0003\u0002\u0001\u0000]^\u0005\u0014\u0000"+
		"\u0000^_\u0003\u001c\u000e\u0000_`\u0005\u001c\u0000\u0000`b\u0001\u0000"+
		"\u0000\u0000a\\\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ca\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u0013\u0001\u0000\u0000"+
		"\u0000eg\u0005\"\u0000\u0000fh\u0003\u0016\u000b\u0000gf\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0005#\u0000\u0000l\u0015\u0001"+
		"\u0000\u0000\u0000mn\u0005\u0014\u0000\u0000no\u0005$\u0000\u0000op\u0005"+
		"4\u0000\u0000pq\u0005\u0016\u0000\u0000qr\u0005%\u0000\u0000rs\u00053"+
		"\u0000\u0000st\u0005\u0016\u0000\u0000tu\u0005&\u0000\u0000uv\u00053\u0000"+
		"\u0000vw\u0005\u0016\u0000\u0000wx\u0005\'\u0000\u0000xy\u0003\u0010\b"+
		"\u0000yz\u0005\u001c\u0000\u0000z\u0017\u0001\u0000\u0000\u0000{}\u0005"+
		"(\u0000\u0000|~\u0003\u001a\r\u0000}|\u0001\u0000\u0000\u0000~\u007f\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0005)\u0000"+
		"\u0000\u0082\u0019\u0001\u0000\u0000\u0000\u0083\u0084\u00052\u0000\u0000"+
		"\u0084\u0085\u0005\u0013\u0000\u0000\u0085\u0086\u0005\u0014\u0000\u0000"+
		"\u0086\u0087\u0005*\u0000\u0000\u0087\u0088\u00054\u0000\u0000\u0088\u0089"+
		"\u0005\u0016\u0000\u0000\u0089\u008a\u0005+\u0000\u0000\u008a\u008b\u0005"+
		"4\u0000\u0000\u008b\u008c\u0005\u0016\u0000\u0000\u008c\u008d\u0005,\u0000"+
		"\u0000\u008d\u008e\u0003\u0010\b\u0000\u008e\u008f\u0005\u001c\u0000\u0000"+
		"\u008f\u001b\u0001\u0000\u0000\u0000\u0090\u0091\u0005%\u0000\u0000\u0091"+
		"\u0092\u00053\u0000\u0000\u0092\u0093\u0005\u0016\u0000\u0000\u0093\u0094"+
		"\u0005&\u0000\u0000\u0094\u009c\u00053\u0000\u0000\u0095\u0096\u0005\u0016"+
		"\u0000\u0000\u0096\u0097\u0005-\u0000\u0000\u0097\u0098\u0005.\u0000\u0000"+
		"\u0098\u0099\u0005/\u0000\u0000\u0099\u009a\u0003\u001e\u000f\u0000\u009a"+
		"\u009b\u00050\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u0095"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u001d"+
		"\u0001\u0000\u0000\u0000\u009e\u00a3\u0003 \u0010\u0000\u009f\u00a0\u0005"+
		"\u0016\u0000\u0000\u00a0\u00a2\u0003 \u0010\u0000\u00a1\u009f\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u001f\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0014"+
		"\u0000\u0000\u00a7\u00a8\u00051\u0000\u0000\u00a8\u00a9\u0003\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005\u0016\u0000\u0000\u00aa\u00ab\u0005%\u0000\u0000"+
		"\u00ab\u00ac\u00053\u0000\u0000\u00ac\u00ad\u0005\u0016\u0000\u0000\u00ad"+
		"\u00ae\u0005&\u0000\u0000\u00ae\u00af\u00053\u0000\u0000\u00af\u00b0\u0005"+
		"\u001c\u0000\u0000\u00b0!\u0001\u0000\u0000\u0000\u0006-ci\u007f\u009c"+
		"\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}