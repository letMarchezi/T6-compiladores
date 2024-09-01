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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, IDENT=45, 
		HORA=46, COMENTARIO=47, CADEIA=48, CADEIA_NAO_FECHADA=49, COMENTARIO_NAO_FECHADO=50, 
		DIGIT=51, WS=52;
	public static final int
		RULE_categ_evento = 0, RULE_dias_sem = 1, RULE_prior_tipo = 2, RULE_modals = 3, 
		RULE_rotina = 4, RULE_programa = 5, RULE_corpo = 6, RULE_agenda = 7, RULE_seq_evento = 8, 
		RULE_evento_parc = 9, RULE_seq_comp = 10, RULE_comp_parc = 11, RULE_registro = 12, 
		RULE_date = 13, RULE_prog_dia = 14, RULE_evento_agenda = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"categ_evento", "dias_sem", "prior_tipo", "modals", "rotina", "programa", 
			"corpo", "agenda", "seq_evento", "evento_parc", "seq_comp", "comp_parc", 
			"registro", "date", "prog_dia", "evento_agenda"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pessoal'", "'aula'", "'trabalho'", "'DOMINGO'", "'SEGUNDA'", 
			"'TERCA'", "'QUARTA'", "'QUINTA'", "'SEXTA'", "'SABADO'", "'alta'", "'media'", 
			"'baixa'", "'estudo_para_prova'", "'projeto'", "'estudo_teorico'", "'lista_de_exercicios'", 
			"'revisao'", "':'", "'('", "')'", "'ROTINA'", "'FIMROTINA'", "'AGENDA'", 
			"'FIMAGENDA'", "'EVENTOS'", "'FIMEVENTOS'", "'nome'", "','", "'inicio'", 
			"'fim'", "'data'", "'COMPROMISSOS'", "'FIMCOMPROMISSOS'", "'descricao'", 
			"'data_compromisso'", "'prioridade'", "'modalidade'", "'tempo_desejado'", 
			"'compromisso'", "'/'", "'quero_estudar'", "'eventos'", "'categoria'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "IDENT", "HORA", 
			"COMENTARIO", "CADEIA", "CADEIA_NAO_FECHADA", "COMENTARIO_NAO_FECHADO", 
			"DIGIT", "WS"
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
	public static class Categ_eventoContext extends ParserRuleContext {
		public Categ_eventoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_categ_evento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterCateg_evento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitCateg_evento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitCateg_evento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Categ_eventoContext categ_evento() throws RecognitionException {
		Categ_eventoContext _localctx = new Categ_eventoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_categ_evento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
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
			setState(34);
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
	public static class Prior_tipoContext extends ParserRuleContext {
		public Prior_tipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prior_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterPrior_tipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitPrior_tipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitPrior_tipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prior_tipoContext prior_tipo() throws RecognitionException {
		Prior_tipoContext _localctx = new Prior_tipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prior_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
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
	public static class ModalsContext extends ParserRuleContext {
		public ModalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterModals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitModals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitModals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModalsContext modals() throws RecognitionException {
		ModalsContext _localctx = new ModalsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_modals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
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
	public static class RotinaContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AlgumaRotinaParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AlgumaRotinaParser.IDENT, i);
		}
		public List<RegistroContext> registro() {
			return getRuleContexts(RegistroContext.class);
		}
		public RegistroContext registro(int i) {
			return getRuleContext(RegistroContext.class,i);
		}
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
		enterRule(_localctx, 8, RULE_rotina);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				match(IDENT);
				setState(41);
				match(T__18);
				setState(42);
				match(T__19);
				setState(43);
				registro();
				setState(44);
				match(T__20);
				}
				}
				setState(48); 
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
	public static class ProgramaContext extends ParserRuleContext {
		public RotinaContext rotina() {
			return getRuleContext(RotinaContext.class,0);
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
		enterRule(_localctx, 10, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__21);
			setState(51);
			rotina();
			setState(52);
			corpo();
			setState(53);
			match(T__22);
			setState(54);
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
		public AgendaContext agenda() {
			return getRuleContext(AgendaContext.class,0);
		}
		public Seq_eventoContext seq_evento() {
			return getRuleContext(Seq_eventoContext.class,0);
		}
		public Seq_compContext seq_comp() {
			return getRuleContext(Seq_compContext.class,0);
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
		enterRule(_localctx, 12, RULE_corpo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__23);
			setState(57);
			agenda();
			setState(58);
			match(T__24);
			setState(59);
			seq_evento();
			setState(60);
			seq_comp();
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
		enterRule(_localctx, 14, RULE_agenda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				dias_sem();
				setState(63);
				match(T__19);
				setState(64);
				prog_dia();
				setState(65);
				match(T__20);
				}
				}
				setState(69); 
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
		enterRule(_localctx, 16, RULE_seq_evento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__25);
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				evento_parc();
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__19 );
			setState(77);
			match(T__26);
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
		enterRule(_localctx, 18, RULE_evento_parc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__19);
			setState(80);
			match(T__27);
			setState(81);
			match(CADEIA);
			setState(82);
			match(T__28);
			setState(83);
			match(T__29);
			setState(84);
			match(HORA);
			setState(85);
			match(T__28);
			setState(86);
			match(T__30);
			setState(87);
			match(HORA);
			setState(88);
			match(T__28);
			setState(89);
			match(T__31);
			setState(90);
			date();
			setState(91);
			match(T__20);
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
		enterRule(_localctx, 20, RULE_seq_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__32);
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				comp_parc();
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(99);
			match(T__33);
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
		enterRule(_localctx, 22, RULE_comp_parc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IDENT);
			setState(102);
			match(T__18);
			setState(103);
			match(T__19);
			setState(104);
			match(T__27);
			setState(105);
			match(CADEIA);
			setState(106);
			match(T__28);
			setState(107);
			match(T__34);
			setState(108);
			match(CADEIA);
			setState(109);
			match(T__28);
			setState(110);
			match(T__35);
			setState(111);
			date();
			setState(112);
			match(T__20);
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
	public static class RegistroContext extends ParserRuleContext {
		public List<TerminalNode> CADEIA() { return getTokens(AlgumaRotinaParser.CADEIA); }
		public TerminalNode CADEIA(int i) {
			return getToken(AlgumaRotinaParser.CADEIA, i);
		}
		public Prior_tipoContext prior_tipo() {
			return getRuleContext(Prior_tipoContext.class,0);
		}
		public ModalsContext modals() {
			return getRuleContext(ModalsContext.class,0);
		}
		public TerminalNode HORA() { return getToken(AlgumaRotinaParser.HORA, 0); }
		public TerminalNode IDENT() { return getToken(AlgumaRotinaParser.IDENT, 0); }
		public RegistroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_registro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterRegistro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitRegistro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitRegistro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegistroContext registro() throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_registro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__27);
			setState(115);
			match(CADEIA);
			setState(116);
			match(T__28);
			setState(117);
			match(T__34);
			setState(118);
			match(CADEIA);
			setState(119);
			match(T__28);
			setState(120);
			match(T__36);
			setState(121);
			prior_tipo();
			setState(122);
			match(T__28);
			setState(123);
			match(T__37);
			setState(124);
			modals();
			setState(125);
			match(T__28);
			setState(126);
			match(T__38);
			setState(127);
			match(HORA);
			setState(128);
			match(T__28);
			setState(129);
			match(T__39);
			setState(130);
			match(IDENT);
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
		enterRule(_localctx, 26, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(DIGIT);
			setState(133);
			match(DIGIT);
			setState(134);
			match(T__40);
			setState(135);
			match(DIGIT);
			setState(136);
			match(DIGIT);
			setState(137);
			match(T__40);
			setState(138);
			match(DIGIT);
			setState(139);
			match(DIGIT);
			setState(140);
			match(DIGIT);
			setState(141);
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
	public static class Prog_diaContext extends ParserRuleContext {
		public List<TerminalNode> HORA() { return getTokens(AlgumaRotinaParser.HORA); }
		public TerminalNode HORA(int i) {
			return getToken(AlgumaRotinaParser.HORA, i);
		}
		public List<Evento_agendaContext> evento_agenda() {
			return getRuleContexts(Evento_agendaContext.class);
		}
		public Evento_agendaContext evento_agenda(int i) {
			return getRuleContext(Evento_agendaContext.class,i);
		}
		public List<TerminalNode> CADEIA() { return getTokens(AlgumaRotinaParser.CADEIA); }
		public TerminalNode CADEIA(int i) {
			return getToken(AlgumaRotinaParser.CADEIA, i);
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
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(143);
				match(T__41);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CADEIA) {
					{
					{
					setState(144);
					match(CADEIA);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(T__28);
				}
			}

			setState(153);
			match(T__29);
			setState(154);
			match(HORA);
			setState(155);
			match(T__28);
			setState(156);
			match(T__30);
			setState(157);
			match(HORA);
			setState(158);
			match(T__28);
			setState(159);
			match(T__42);
			setState(160);
			evento_agenda();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__28) {
				{
				{
				setState(161);
				match(T__28);
				setState(162);
				evento_agenda();
				}
				}
				setState(167);
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
	public static class Evento_agendaContext extends ParserRuleContext {
		public Categ_eventoContext categ_evento() {
			return getRuleContext(Categ_eventoContext.class,0);
		}
		public List<TerminalNode> HORA() { return getTokens(AlgumaRotinaParser.HORA); }
		public TerminalNode HORA(int i) {
			return getToken(AlgumaRotinaParser.HORA, i);
		}
		public Evento_agendaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evento_agenda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).enterEvento_agenda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgumaRotinaListener ) ((AlgumaRotinaListener)listener).exitEvento_agenda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgumaRotinaVisitor ) return ((AlgumaRotinaVisitor<? extends T>)visitor).visitEvento_agenda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Evento_agendaContext evento_agenda() throws RecognitionException {
		Evento_agendaContext _localctx = new Evento_agendaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_evento_agenda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__19);
			setState(169);
			match(T__43);
			setState(170);
			categ_evento();
			setState(171);
			match(T__28);
			setState(172);
			match(T__29);
			setState(173);
			match(HORA);
			setState(174);
			match(T__28);
			setState(175);
			match(T__30);
			setState(176);
			match(HORA);
			setState(177);
			match(T__20);
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
		"\u0004\u00014\u00b4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004/\b\u0004\u000b\u0004\f\u00040\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007D\b"+
		"\u0007\u000b\u0007\f\u0007E\u0001\b\u0001\b\u0004\bJ\b\b\u000b\b\f\bK"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0004\n`\b\n\u000b\n\f\na\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0005\u000e\u0092\b\u000e\n\u000e\f\u000e\u0095"+
		"\t\u000e\u0001\u000e\u0003\u000e\u0098\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u00a4\b\u000e\n\u000e\f\u000e\u00a7"+
		"\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0004\u0001\u0000\u0001\u0003"+
		"\u0001\u0000\u0004\n\u0001\u0000\u000b\r\u0001\u0000\u000e\u0012\u00aa"+
		"\u0000 \u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u0004"+
		"$\u0001\u0000\u0000\u0000\u0006&\u0001\u0000\u0000\u0000\b.\u0001\u0000"+
		"\u0000\u0000\n2\u0001\u0000\u0000\u0000\f8\u0001\u0000\u0000\u0000\u000e"+
		"C\u0001\u0000\u0000\u0000\u0010G\u0001\u0000\u0000\u0000\u0012O\u0001"+
		"\u0000\u0000\u0000\u0014]\u0001\u0000\u0000\u0000\u0016e\u0001\u0000\u0000"+
		"\u0000\u0018r\u0001\u0000\u0000\u0000\u001a\u0084\u0001\u0000\u0000\u0000"+
		"\u001c\u0097\u0001\u0000\u0000\u0000\u001e\u00a8\u0001\u0000\u0000\u0000"+
		" !\u0007\u0000\u0000\u0000!\u0001\u0001\u0000\u0000\u0000\"#\u0007\u0001"+
		"\u0000\u0000#\u0003\u0001\u0000\u0000\u0000$%\u0007\u0002\u0000\u0000"+
		"%\u0005\u0001\u0000\u0000\u0000&\'\u0007\u0003\u0000\u0000\'\u0007\u0001"+
		"\u0000\u0000\u0000()\u0005-\u0000\u0000)*\u0005\u0013\u0000\u0000*+\u0005"+
		"\u0014\u0000\u0000+,\u0003\u0018\f\u0000,-\u0005\u0015\u0000\u0000-/\u0001"+
		"\u0000\u0000\u0000.(\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u0000"+
		"0.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001\t\u0001\u0000\u0000"+
		"\u000023\u0005\u0016\u0000\u000034\u0003\b\u0004\u000045\u0003\f\u0006"+
		"\u000056\u0005\u0017\u0000\u000067\u0005\u0000\u0000\u00017\u000b\u0001"+
		"\u0000\u0000\u000089\u0005\u0018\u0000\u00009:\u0003\u000e\u0007\u0000"+
		":;\u0005\u0019\u0000\u0000;<\u0003\u0010\b\u0000<=\u0003\u0014\n\u0000"+
		"=\r\u0001\u0000\u0000\u0000>?\u0003\u0002\u0001\u0000?@\u0005\u0014\u0000"+
		"\u0000@A\u0003\u001c\u000e\u0000AB\u0005\u0015\u0000\u0000BD\u0001\u0000"+
		"\u0000\u0000C>\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u000f\u0001\u0000\u0000"+
		"\u0000GI\u0005\u001a\u0000\u0000HJ\u0003\u0012\t\u0000IH\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0005\u001b\u0000\u0000N\u0011"+
		"\u0001\u0000\u0000\u0000OP\u0005\u0014\u0000\u0000PQ\u0005\u001c\u0000"+
		"\u0000QR\u00050\u0000\u0000RS\u0005\u001d\u0000\u0000ST\u0005\u001e\u0000"+
		"\u0000TU\u0005.\u0000\u0000UV\u0005\u001d\u0000\u0000VW\u0005\u001f\u0000"+
		"\u0000WX\u0005.\u0000\u0000XY\u0005\u001d\u0000\u0000YZ\u0005 \u0000\u0000"+
		"Z[\u0003\u001a\r\u0000[\\\u0005\u0015\u0000\u0000\\\u0013\u0001\u0000"+
		"\u0000\u0000]_\u0005!\u0000\u0000^`\u0003\u0016\u000b\u0000_^\u0001\u0000"+
		"\u0000\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0005\"\u0000\u0000d\u0015"+
		"\u0001\u0000\u0000\u0000ef\u0005-\u0000\u0000fg\u0005\u0013\u0000\u0000"+
		"gh\u0005\u0014\u0000\u0000hi\u0005\u001c\u0000\u0000ij\u00050\u0000\u0000"+
		"jk\u0005\u001d\u0000\u0000kl\u0005#\u0000\u0000lm\u00050\u0000\u0000m"+
		"n\u0005\u001d\u0000\u0000no\u0005$\u0000\u0000op\u0003\u001a\r\u0000p"+
		"q\u0005\u0015\u0000\u0000q\u0017\u0001\u0000\u0000\u0000rs\u0005\u001c"+
		"\u0000\u0000st\u00050\u0000\u0000tu\u0005\u001d\u0000\u0000uv\u0005#\u0000"+
		"\u0000vw\u00050\u0000\u0000wx\u0005\u001d\u0000\u0000xy\u0005%\u0000\u0000"+
		"yz\u0003\u0004\u0002\u0000z{\u0005\u001d\u0000\u0000{|\u0005&\u0000\u0000"+
		"|}\u0003\u0006\u0003\u0000}~\u0005\u001d\u0000\u0000~\u007f\u0005\'\u0000"+
		"\u0000\u007f\u0080\u0005.\u0000\u0000\u0080\u0081\u0005\u001d\u0000\u0000"+
		"\u0081\u0082\u0005(\u0000\u0000\u0082\u0083\u0005-\u0000\u0000\u0083\u0019"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u00053\u0000\u0000\u0085\u0086\u0005"+
		"3\u0000\u0000\u0086\u0087\u0005)\u0000\u0000\u0087\u0088\u00053\u0000"+
		"\u0000\u0088\u0089\u00053\u0000\u0000\u0089\u008a\u0005)\u0000\u0000\u008a"+
		"\u008b\u00053\u0000\u0000\u008b\u008c\u00053\u0000\u0000\u008c\u008d\u0005"+
		"3\u0000\u0000\u008d\u008e\u00053\u0000\u0000\u008e\u001b\u0001\u0000\u0000"+
		"\u0000\u008f\u0093\u0005*\u0000\u0000\u0090\u0092\u00050\u0000\u0000\u0091"+
		"\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096"+
		"\u0098\u0005\u001d\u0000\u0000\u0097\u008f\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0005\u001e\u0000\u0000\u009a\u009b\u0005.\u0000\u0000\u009b\u009c"+
		"\u0005\u001d\u0000\u0000\u009c\u009d\u0005\u001f\u0000\u0000\u009d\u009e"+
		"\u0005.\u0000\u0000\u009e\u009f\u0005\u001d\u0000\u0000\u009f\u00a0\u0005"+
		"+\u0000\u0000\u00a0\u00a5\u0003\u001e\u000f\u0000\u00a1\u00a2\u0005\u001d"+
		"\u0000\u0000\u00a2\u00a4\u0003\u001e\u000f\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u001d\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0014"+
		"\u0000\u0000\u00a9\u00aa\u0005,\u0000\u0000\u00aa\u00ab\u0003\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0005\u001d\u0000\u0000\u00ac\u00ad\u0005\u001e\u0000"+
		"\u0000\u00ad\u00ae\u0005.\u0000\u0000\u00ae\u00af\u0005\u001d\u0000\u0000"+
		"\u00af\u00b0\u0005\u001f\u0000\u0000\u00b0\u00b1\u0005.\u0000\u0000\u00b1"+
		"\u00b2\u0005\u0015\u0000\u0000\u00b2\u001f\u0001\u0000\u0000\u0000\u0007"+
		"0EKa\u0093\u0097\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}