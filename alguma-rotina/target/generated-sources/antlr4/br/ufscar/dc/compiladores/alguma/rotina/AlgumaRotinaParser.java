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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, CATEG_ATIVIDADES=30, 
		DIAS_SEM=31, PRIORIDADE_TIPO=32, MODALIDADE=33, IDENT=34, HORA=35, CADEIA=36, 
		CADEIA_NAO_FECHADA=37, DIGIT=38, WS=39;
	public static final int
		RULE_rotinas = 0, RULE_rotina = 1, RULE_programa = 2, RULE_corpo = 3, 
		RULE_date = 4, RULE_agenda = 5, RULE_seq_evento = 6, RULE_evento_parc = 7, 
		RULE_seq_comp = 8, RULE_comp_parc = 9, RULE_prog_dia = 10, RULE_lista_atividades = 11, 
		RULE_atividades_agenda = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"rotinas", "rotina", "programa", "corpo", "date", "agenda", "seq_evento", 
			"evento_parc", "seq_comp", "comp_parc", "prog_dia", "lista_atividades", 
			"atividades_agenda"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'('", "'titulo'", "'='", "','", "'descricao'", "'prioridade'", 
			"'modalidade'", "'tempo_desejado'", "'compromisso'", "')'", "'ROTINA'", 
			"'FIMROTINA'", "'AGENDA'", "'FIMAGENDA'", "'/'", "'EVENTOS'", "'FIMEVENTOS'", 
			"'nome'", "'inicio'", "'fim'", "'data'", "'COMPROMISSOS'", "'FIMCOMPROMISSOS'", 
			"'data_compromisso'", "'atividades'", "'{'", "'}'", "'categoria'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "CATEG_ATIVIDADES", "DIAS_SEM", "PRIORIDADE_TIPO", 
			"MODALIDADE", "IDENT", "HORA", "CADEIA", "CADEIA_NAO_FECHADA", "DIGIT", 
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
		enterRule(_localctx, 0, RULE_rotinas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				rotina();
				}
				}
				setState(29); 
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
		public TerminalNode PRIORIDADE_TIPO() { return getToken(AlgumaRotinaParser.PRIORIDADE_TIPO, 0); }
		public TerminalNode MODALIDADE() { return getToken(AlgumaRotinaParser.MODALIDADE, 0); }
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
		enterRule(_localctx, 2, RULE_rotina);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(31);
			match(IDENT);
			setState(32);
			match(T__0);
			setState(33);
			match(T__1);
			setState(34);
			match(T__2);
			setState(35);
			match(T__3);
			setState(36);
			match(CADEIA);
			setState(37);
			match(T__4);
			setState(38);
			match(T__5);
			setState(39);
			match(T__3);
			setState(40);
			match(CADEIA);
			setState(41);
			match(T__4);
			setState(42);
			match(T__6);
			setState(43);
			match(T__3);
			setState(44);
			match(PRIORIDADE_TIPO);
			setState(45);
			match(T__4);
			setState(46);
			match(T__7);
			setState(47);
			match(T__3);
			setState(48);
			match(MODALIDADE);
			setState(49);
			match(T__4);
			setState(50);
			match(T__8);
			setState(51);
			match(T__3);
			setState(52);
			match(HORA);
			setState(53);
			match(T__4);
			setState(54);
			match(T__9);
			setState(55);
			match(T__3);
			setState(56);
			match(IDENT);
			setState(57);
			match(T__10);
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
		enterRule(_localctx, 4, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			seq_comp();
			setState(60);
			corpo();
			setState(61);
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
		public Seq_eventoContext seq_evento() {
			return getRuleContext(Seq_eventoContext.class,0);
		}
		public RotinasContext rotinas() {
			return getRuleContext(RotinasContext.class,0);
		}
		public AgendaContext agenda() {
			return getRuleContext(AgendaContext.class,0);
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
		enterRule(_localctx, 6, RULE_corpo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			seq_evento();
			setState(64);
			match(T__11);
			setState(65);
			rotinas();
			setState(66);
			match(T__12);
			setState(67);
			match(T__13);
			setState(68);
			agenda();
			setState(69);
			match(T__14);
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
		enterRule(_localctx, 8, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(DIGIT);
			setState(72);
			match(DIGIT);
			setState(73);
			match(T__15);
			setState(74);
			match(DIGIT);
			setState(75);
			match(DIGIT);
			setState(76);
			match(T__15);
			setState(77);
			match(DIGIT);
			setState(78);
			match(DIGIT);
			setState(79);
			match(DIGIT);
			setState(80);
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
		public List<TerminalNode> DIAS_SEM() { return getTokens(AlgumaRotinaParser.DIAS_SEM); }
		public TerminalNode DIAS_SEM(int i) {
			return getToken(AlgumaRotinaParser.DIAS_SEM, i);
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
		enterRule(_localctx, 10, RULE_agenda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				match(DIAS_SEM);
				setState(83);
				match(T__1);
				setState(84);
				prog_dia();
				setState(85);
				match(T__10);
				}
				}
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIAS_SEM );
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
		enterRule(_localctx, 12, RULE_seq_evento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__16);
			setState(93); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				evento_parc();
				}
				}
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(97);
			match(T__17);
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
		enterRule(_localctx, 14, RULE_evento_parc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__1);
			setState(100);
			match(T__18);
			setState(101);
			match(T__3);
			setState(102);
			match(CADEIA);
			setState(103);
			match(T__4);
			setState(104);
			match(T__19);
			setState(105);
			match(T__3);
			setState(106);
			match(HORA);
			setState(107);
			match(T__4);
			setState(108);
			match(T__20);
			setState(109);
			match(T__3);
			setState(110);
			match(HORA);
			setState(111);
			match(T__4);
			setState(112);
			match(T__21);
			setState(113);
			match(T__3);
			setState(114);
			date();
			setState(115);
			match(T__10);
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
		enterRule(_localctx, 16, RULE_seq_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__22);
			setState(119); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(118);
				comp_parc();
				}
				}
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(123);
			match(T__23);
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
		enterRule(_localctx, 18, RULE_comp_parc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(IDENT);
			setState(126);
			match(T__0);
			setState(127);
			match(T__1);
			setState(128);
			match(T__2);
			setState(129);
			match(T__3);
			setState(130);
			match(CADEIA);
			setState(131);
			match(T__4);
			setState(132);
			match(T__5);
			setState(133);
			match(T__3);
			setState(134);
			match(CADEIA);
			setState(135);
			match(T__4);
			setState(136);
			match(T__24);
			setState(137);
			match(T__3);
			setState(138);
			date();
			setState(139);
			match(T__10);
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
		enterRule(_localctx, 20, RULE_prog_dia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__19);
			setState(142);
			match(T__3);
			setState(143);
			match(HORA);
			setState(144);
			match(T__4);
			setState(145);
			match(T__20);
			setState(146);
			match(T__3);
			setState(147);
			match(HORA);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(148);
				match(T__4);
				setState(149);
				match(T__25);
				setState(150);
				match(T__3);
				setState(151);
				match(T__26);
				setState(152);
				lista_atividades();
				setState(153);
				match(T__27);
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
		enterRule(_localctx, 22, RULE_lista_atividades);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			atividades_agenda();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(158);
				match(T__4);
				setState(159);
				atividades_agenda();
				}
				}
				setState(164);
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
		public TerminalNode CATEG_ATIVIDADES() { return getToken(AlgumaRotinaParser.CATEG_ATIVIDADES, 0); }
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
		enterRule(_localctx, 24, RULE_atividades_agenda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__1);
			setState(166);
			match(T__28);
			setState(167);
			match(T__3);
			setState(168);
			match(CATEG_ATIVIDADES);
			setState(169);
			match(T__4);
			setState(170);
			match(T__19);
			setState(171);
			match(T__3);
			setState(172);
			match(HORA);
			setState(173);
			match(T__4);
			setState(174);
			match(T__20);
			setState(175);
			match(T__3);
			setState(176);
			match(HORA);
			setState(177);
			match(T__10);
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
		"\u0004\u0001\'\u00b4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000\f\u0000\u001d"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0004\u0005X\b\u0005\u000b\u0005\f\u0005Y\u0001"+
		"\u0006\u0001\u0006\u0004\u0006^\b\u0006\u000b\u0006\f\u0006_\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0004\bx\b\b\u000b\b\f\by\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u009c\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00a1\b\u000b\n\u000b\f\u000b\u00a4\t\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0000\u00ac\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0002\u001f\u0001\u0000\u0000\u0000\u0004"+
		";\u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\bG\u0001\u0000"+
		"\u0000\u0000\nW\u0001\u0000\u0000\u0000\f[\u0001\u0000\u0000\u0000\u000e"+
		"c\u0001\u0000\u0000\u0000\u0010u\u0001\u0000\u0000\u0000\u0012}\u0001"+
		"\u0000\u0000\u0000\u0014\u008d\u0001\u0000\u0000\u0000\u0016\u009d\u0001"+
		"\u0000\u0000\u0000\u0018\u00a5\u0001\u0000\u0000\u0000\u001a\u001c\u0003"+
		"\u0002\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001"+
		"\u0000\u0000\u0000\u001e\u0001\u0001\u0000\u0000\u0000\u001f \u0005\""+
		"\u0000\u0000 !\u0005\u0001\u0000\u0000!\"\u0005\u0002\u0000\u0000\"#\u0005"+
		"\u0003\u0000\u0000#$\u0005\u0004\u0000\u0000$%\u0005$\u0000\u0000%&\u0005"+
		"\u0005\u0000\u0000&\'\u0005\u0006\u0000\u0000\'(\u0005\u0004\u0000\u0000"+
		"()\u0005$\u0000\u0000)*\u0005\u0005\u0000\u0000*+\u0005\u0007\u0000\u0000"+
		"+,\u0005\u0004\u0000\u0000,-\u0005 \u0000\u0000-.\u0005\u0005\u0000\u0000"+
		"./\u0005\b\u0000\u0000/0\u0005\u0004\u0000\u000001\u0005!\u0000\u0000"+
		"12\u0005\u0005\u0000\u000023\u0005\t\u0000\u000034\u0005\u0004\u0000\u0000"+
		"45\u0005#\u0000\u000056\u0005\u0005\u0000\u000067\u0005\n\u0000\u0000"+
		"78\u0005\u0004\u0000\u000089\u0005\"\u0000\u00009:\u0005\u000b\u0000\u0000"+
		":\u0003\u0001\u0000\u0000\u0000;<\u0003\u0010\b\u0000<=\u0003\u0006\u0003"+
		"\u0000=>\u0005\u0000\u0000\u0001>\u0005\u0001\u0000\u0000\u0000?@\u0003"+
		"\f\u0006\u0000@A\u0005\f\u0000\u0000AB\u0003\u0000\u0000\u0000BC\u0005"+
		"\r\u0000\u0000CD\u0005\u000e\u0000\u0000DE\u0003\n\u0005\u0000EF\u0005"+
		"\u000f\u0000\u0000F\u0007\u0001\u0000\u0000\u0000GH\u0005&\u0000\u0000"+
		"HI\u0005&\u0000\u0000IJ\u0005\u0010\u0000\u0000JK\u0005&\u0000\u0000K"+
		"L\u0005&\u0000\u0000LM\u0005\u0010\u0000\u0000MN\u0005&\u0000\u0000NO"+
		"\u0005&\u0000\u0000OP\u0005&\u0000\u0000PQ\u0005&\u0000\u0000Q\t\u0001"+
		"\u0000\u0000\u0000RS\u0005\u001f\u0000\u0000ST\u0005\u0002\u0000\u0000"+
		"TU\u0003\u0014\n\u0000UV\u0005\u000b\u0000\u0000VX\u0001\u0000\u0000\u0000"+
		"WR\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z\u000b\u0001\u0000\u0000\u0000[]\u0005"+
		"\u0011\u0000\u0000\\^\u0003\u000e\u0007\u0000]\\\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000ab\u0005\u0012\u0000\u0000b\r\u0001\u0000"+
		"\u0000\u0000cd\u0005\u0002\u0000\u0000de\u0005\u0013\u0000\u0000ef\u0005"+
		"\u0004\u0000\u0000fg\u0005$\u0000\u0000gh\u0005\u0005\u0000\u0000hi\u0005"+
		"\u0014\u0000\u0000ij\u0005\u0004\u0000\u0000jk\u0005#\u0000\u0000kl\u0005"+
		"\u0005\u0000\u0000lm\u0005\u0015\u0000\u0000mn\u0005\u0004\u0000\u0000"+
		"no\u0005#\u0000\u0000op\u0005\u0005\u0000\u0000pq\u0005\u0016\u0000\u0000"+
		"qr\u0005\u0004\u0000\u0000rs\u0003\b\u0004\u0000st\u0005\u000b\u0000\u0000"+
		"t\u000f\u0001\u0000\u0000\u0000uw\u0005\u0017\u0000\u0000vx\u0003\u0012"+
		"\t\u0000wv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0005"+
		"\u0018\u0000\u0000|\u0011\u0001\u0000\u0000\u0000}~\u0005\"\u0000\u0000"+
		"~\u007f\u0005\u0001\u0000\u0000\u007f\u0080\u0005\u0002\u0000\u0000\u0080"+
		"\u0081\u0005\u0003\u0000\u0000\u0081\u0082\u0005\u0004\u0000\u0000\u0082"+
		"\u0083\u0005$\u0000\u0000\u0083\u0084\u0005\u0005\u0000\u0000\u0084\u0085"+
		"\u0005\u0006\u0000\u0000\u0085\u0086\u0005\u0004\u0000\u0000\u0086\u0087"+
		"\u0005$\u0000\u0000\u0087\u0088\u0005\u0005\u0000\u0000\u0088\u0089\u0005"+
		"\u0019\u0000\u0000\u0089\u008a\u0005\u0004\u0000\u0000\u008a\u008b\u0003"+
		"\b\u0004\u0000\u008b\u008c\u0005\u000b\u0000\u0000\u008c\u0013\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005\u0014\u0000\u0000\u008e\u008f\u0005\u0004"+
		"\u0000\u0000\u008f\u0090\u0005#\u0000\u0000\u0090\u0091\u0005\u0005\u0000"+
		"\u0000\u0091\u0092\u0005\u0015\u0000\u0000\u0092\u0093\u0005\u0004\u0000"+
		"\u0000\u0093\u009b\u0005#\u0000\u0000\u0094\u0095\u0005\u0005\u0000\u0000"+
		"\u0095\u0096\u0005\u001a\u0000\u0000\u0096\u0097\u0005\u0004\u0000\u0000"+
		"\u0097\u0098\u0005\u001b\u0000\u0000\u0098\u0099\u0003\u0016\u000b\u0000"+
		"\u0099\u009a\u0005\u001c\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000"+
		"\u009b\u0094\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u0015\u0001\u0000\u0000\u0000\u009d\u00a2\u0003\u0018\f\u0000\u009e"+
		"\u009f\u0005\u0005\u0000\u0000\u009f\u00a1\u0003\u0018\f\u0000\u00a0\u009e"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u0017"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0005\u0002\u0000\u0000\u00a6\u00a7\u0005\u001d\u0000\u0000\u00a7\u00a8"+
		"\u0005\u0004\u0000\u0000\u00a8\u00a9\u0005\u001e\u0000\u0000\u00a9\u00aa"+
		"\u0005\u0005\u0000\u0000\u00aa\u00ab\u0005\u0014\u0000\u0000\u00ab\u00ac"+
		"\u0005\u0004\u0000\u0000\u00ac\u00ad\u0005#\u0000\u0000\u00ad\u00ae\u0005"+
		"\u0005\u0000\u0000\u00ae\u00af\u0005\u0015\u0000\u0000\u00af\u00b0\u0005"+
		"\u0004\u0000\u0000\u00b0\u00b1\u0005#\u0000\u0000\u00b1\u00b2\u0005\u000b"+
		"\u0000\u0000\u00b2\u0019\u0001\u0000\u0000\u0000\u0006\u001dY_y\u009b"+
		"\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}