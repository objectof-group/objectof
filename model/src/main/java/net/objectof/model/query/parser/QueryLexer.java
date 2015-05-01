// Generated from QueryLexer.g4 by ANTLR 4.3
package net.objectof.model.query.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QueryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EQUAL=1, BANG=2, DASH=3, AND=4, OR=5, CONTAINS=6, DIGIT=7, OPENBRACKET=8, 
		CLOSEBRACKET=9, GT=10, LT=11, DOT=12, POUND=13, STRING=14, LETTER=15, 
		LETTERS=16, WS=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'"
	};
	public static final String[] ruleNames = {
		"EQUAL", "BANG", "DASH", "AND", "OR", "CONTAINS", "DIGIT", "OPENBRACKET", 
		"CLOSEBRACKET", "GT", "LT", "DOT", "POUND", "STRING", "LETTER", "LETTERS", 
		"WS"
	};


	public QueryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QueryLexer.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23b\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\7\17N\n\17\f\17\16\17Q\13\17\3\17\3\17\3"+
		"\20\3\20\3\21\6\21X\n\21\r\21\16\21Y\3\22\6\22]\n\22\r\22\16\22^\3\22"+
		"\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23\3\2\6\3\2\62;\4\2$$^^\4\2C\\c|\5\2\13\f\17"+
		"\17\"\"e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13/\3\2\2\2"+
		"\r\62\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25A\3\2\2\2\27C\3\2"+
		"\2\2\31E\3\2\2\2\33G\3\2\2\2\35I\3\2\2\2\37T\3\2\2\2!W\3\2\2\2#\\\3\2"+
		"\2\2%&\7?\2\2&\4\3\2\2\2\'(\7#\2\2(\6\3\2\2\2)*\7/\2\2*\b\3\2\2\2+,\7"+
		"c\2\2,-\7p\2\2-.\7f\2\2.\n\3\2\2\2/\60\7q\2\2\60\61\7t\2\2\61\f\3\2\2"+
		"\2\62\63\7e\2\2\63\64\7q\2\2\64\65\7p\2\2\65\66\7v\2\2\66\67\7c\2\2\67"+
		"8\7k\2\289\7p\2\29:\7u\2\2:\16\3\2\2\2;<\t\2\2\2<\20\3\2\2\2=>\7*\2\2"+
		">\22\3\2\2\2?@\7+\2\2@\24\3\2\2\2AB\7@\2\2B\26\3\2\2\2CD\7>\2\2D\30\3"+
		"\2\2\2EF\7\60\2\2F\32\3\2\2\2GH\7%\2\2H\34\3\2\2\2IO\7$\2\2JN\n\3\2\2"+
		"KL\7^\2\2LN\t\3\2\2MJ\3\2\2\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2"+
		"PR\3\2\2\2QO\3\2\2\2RS\7$\2\2S\36\3\2\2\2TU\t\4\2\2U \3\2\2\2VX\5\37\20"+
		"\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\"\3\2\2\2[]\t\5\2\2\\[\3\2"+
		"\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\b\22\2\2a$\3\2\2\2\7\2"+
		"MOY^\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}