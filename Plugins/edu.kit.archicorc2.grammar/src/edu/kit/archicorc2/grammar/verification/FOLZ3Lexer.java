// Generated from FOLZ3.g4 by ANTLR 4.4
package edu.kit.archicorc2.grammar.verification;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOLZ3Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, TYPE=8, TRUE=9, 
		FALSE=10, CODEWORD=11, NULL=12, QUANTIFER=13, OPERATOR=14, COMPONENT=15, 
		STRING=16, IDENTIFIER=17, NUMBER=18, LPAREN=19, NOT=20, RPAREN=21, POWER=22, 
		EQUAL=23, ADD=24, MINUS=25, MULTI=26, DIVISION=27, CHARACTER=28, CONJ=29, 
		DISJ=30, IMPL=31, BICOND=32, GREATER=33, SMALLER=34, SMALLEREQ=35, GREATEREQ=36, 
		WHITESPACE=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "TYPE", "TRUE", 
		"FALSE", "CODEWORD", "NULL", "QUANTIFER", "OPERATOR", "COMPONENT", "STRING", 
		"IDENTIFIER", "NUMBER", "LPAREN", "NOT", "RPAREN", "POWER", "EQUAL", "ADD", 
		"MINUS", "MULTI", "DIVISION", "CHARACTER", "CONJ", "DISJ", "IMPL", "BICOND", 
		"GREATER", "SMALLER", "SMALLEREQ", "GREATEREQ", "WHITESPACE"
	};


	public FOLZ3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOLZ3.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u00f8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\td\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u008a\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00a0\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00ad\n\20\3\21\3\21\6\21\u00b1\n\21\r\21\16\21\u00b2\3\21\3\21\3\22"+
		"\5\22\u00b8\n\22\3\22\3\22\7\22\u00bc\n\22\f\22\16\22\u00bf\13\22\3\23"+
		"\6\23\u00c2\n\23\r\23\16\23\u00c3\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\5\35\u00da"+
		"\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3"+
		"$\3$\3$\3%\3%\3%\3&\6&\u00f3\n&\r&\16&\u00f4\3&\3&\2\2\'\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'\3\2\6\5\2C\\aac|\3\2\62;\6\2\60\60\62;C\\c|\4\2\13\f\"\"\u0102"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5O\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13"+
		"U\3\2\2\2\rW\3\2\2\2\17Y\3\2\2\2\21c\3\2\2\2\23e\3\2\2\2\25k\3\2\2\2\27"+
		"r\3\2\2\2\31u\3\2\2\2\33\u0089\3\2\2\2\35\u009f\3\2\2\2\37\u00ac\3\2\2"+
		"\2!\u00ae\3\2\2\2#\u00b7\3\2\2\2%\u00c1\3\2\2\2\'\u00c5\3\2\2\2)\u00c7"+
		"\3\2\2\2+\u00c9\3\2\2\2-\u00cb\3\2\2\2/\u00cd\3\2\2\2\61\u00d0\3\2\2\2"+
		"\63\u00d2\3\2\2\2\65\u00d4\3\2\2\2\67\u00d6\3\2\2\29\u00d9\3\2\2\2;\u00db"+
		"\3\2\2\2=\u00de\3\2\2\2?\u00e1\3\2\2\2A\u00e4\3\2\2\2C\u00e7\3\2\2\2E"+
		"\u00e9\3\2\2\2G\u00eb\3\2\2\2I\u00ee\3\2\2\2K\u00f2\3\2\2\2MN\7a\2\2N"+
		"\4\3\2\2\2OP\7$\2\2P\6\3\2\2\2QR\7]\2\2R\b\3\2\2\2ST\7=\2\2T\n\3\2\2\2"+
		"UV\7.\2\2V\f\3\2\2\2WX\7_\2\2X\16\3\2\2\2YZ\7\60\2\2Z\20\3\2\2\2[\\\7"+
		"k\2\2\\]\7p\2\2]d\7v\2\2^_\7h\2\2_`\7n\2\2`a\7q\2\2ab\7c\2\2bd\7v\2\2"+
		"c[\3\2\2\2c^\3\2\2\2d\22\3\2\2\2ef\7^\2\2fg\7v\2\2gh\7t\2\2hi\7w\2\2i"+
		"j\7g\2\2j\24\3\2\2\2kl\7^\2\2lm\7h\2\2mn\7c\2\2no\7n\2\2op\7u\2\2pq\7"+
		"g\2\2q\26\3\2\2\2rs\7\60\2\2st\7&\2\2t\30\3\2\2\2uv\7^\2\2vw\7p\2\2wx"+
		"\7w\2\2xy\7n\2\2yz\7n\2\2z\32\3\2\2\2{|\7^\2\2|}\7h\2\2}~\7q\2\2~\177"+
		"\7t\2\2\177\u0080\7c\2\2\u0080\u0081\7n\2\2\u0081\u008a\7n\2\2\u0082\u0083"+
		"\7^\2\2\u0083\u0084\7g\2\2\u0084\u0085\7z\2\2\u0085\u0086\7k\2\2\u0086"+
		"\u0087\7u\2\2\u0087\u0088\7v\2\2\u0088\u008a\7u\2\2\u0089{\3\2\2\2\u0089"+
		"\u0082\3\2\2\2\u008a\34\3\2\2\2\u008b\u008c\7^\2\2\u008c\u008d\7u\2\2"+
		"\u008d\u008e\7w\2\2\u008e\u00a0\7o\2\2\u008f\u0090\7^\2\2\u0090\u0091"+
		"\7r\2\2\u0091\u0092\7t\2\2\u0092\u0093\7q\2\2\u0093\u0094\7f\2\2\u0094"+
		"\u0095\7w\2\2\u0095\u0096\7e\2\2\u0096\u00a0\7v\2\2\u0097\u0098\7^\2\2"+
		"\u0098\u0099\7o\2\2\u0099\u009a\7c\2\2\u009a\u00a0\7z\2\2\u009b\u009c"+
		"\7^\2\2\u009c\u009d\7o\2\2\u009d\u009e\7k\2\2\u009e\u00a0\7p\2\2\u009f"+
		"\u008b\3\2\2\2\u009f\u008f\3\2\2\2\u009f\u0097\3\2\2\2\u009f\u009b\3\2"+
		"\2\2\u00a0\36\3\2\2\2\u00a1\u00a2\7^\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4"+
		"\7w\2\2\u00a4\u00a5\7r\2\2\u00a5\u00a6\7g\2\2\u00a6\u00ad\7t\2\2\u00a7"+
		"\u00a8\7^\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7j\2\2\u00aa\u00ab\7k\2\2"+
		"\u00ab\u00ad\7u\2\2\u00ac\u00a1\3\2\2\2\u00ac\u00a7\3\2\2\2\u00ad \3\2"+
		"\2\2\u00ae\u00b0\7$\2\2\u00af\u00b1\59\35\2\u00b0\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b5\7$\2\2\u00b5\"\3\2\2\2\u00b6\u00b8\t\2\2\2\u00b7\u00b6"+
		"\3\2\2\2\u00b8\u00bd\3\2\2\2\u00b9\u00bc\t\2\2\2\u00ba\u00bc\5%\23\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be$\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2"+
		"\t\3\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4&\3\2\2\2\u00c5\u00c6\7*\2\2\u00c6(\3\2\2\2\u00c7"+
		"\u00c8\7#\2\2\u00c8*\3\2\2\2\u00c9\u00ca\7+\2\2\u00ca,\3\2\2\2\u00cb\u00cc"+
		"\7`\2\2\u00cc.\3\2\2\2\u00cd\u00ce\7?\2\2\u00ce\u00cf\7?\2\2\u00cf\60"+
		"\3\2\2\2\u00d0\u00d1\7-\2\2\u00d1\62\3\2\2\2\u00d2\u00d3\7/\2\2\u00d3"+
		"\64\3\2\2\2\u00d4\u00d5\7,\2\2\u00d5\66\3\2\2\2\u00d6\u00d7\7\61\2\2\u00d7"+
		"8\3\2\2\2\u00d8\u00da\t\4\2\2\u00d9\u00d8\3\2\2\2\u00da:\3\2\2\2\u00db"+
		"\u00dc\7(\2\2\u00dc\u00dd\7(\2\2\u00dd<\3\2\2\2\u00de\u00df\7~\2\2\u00df"+
		"\u00e0\7~\2\2\u00e0>\3\2\2\2\u00e1\u00e2\7?\2\2\u00e2\u00e3\7@\2\2\u00e3"+
		"@\3\2\2\2\u00e4\u00e5\7>\2\2\u00e5\u00e6\7@\2\2\u00e6B\3\2\2\2\u00e7\u00e8"+
		"\7@\2\2\u00e8D\3\2\2\2\u00e9\u00ea\7>\2\2\u00eaF\3\2\2\2\u00eb\u00ec\7"+
		">\2\2\u00ec\u00ed\7?\2\2\u00edH\3\2\2\2\u00ee\u00ef\7@\2\2\u00ef\u00f0"+
		"\7?\2\2\u00f0J\3\2\2\2\u00f1\u00f3\t\5\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\b&\2\2\u00f7L\3\2\2\2\16\2c\u0089\u009f\u00ac\u00b2\u00b7\u00bb"+
		"\u00bd\u00c3\u00d9\u00f4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}