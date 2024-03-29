package edu.kit.archicorc2.grammar.verification;

import java.util.BitSet;

import javax.xml.transform.ErrorListener;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class GrammarSolver {
	FOLZ3VisitorImpl visitor = new FOLZ3VisitorImpl();
	public FOLZ3VisitorImpl getVisitor() {
		return visitor;
	}

	public void setVisitor(FOLZ3VisitorImpl visitor) {
		this.visitor = visitor;
	}

	public static void main(String[] args) throws Exception {

		String input = "atomic.port0==12";
		
			FOLZ3Lexer lexer = new FOLZ3Lexer(CharStreams.fromString(input));
			//lexer.removeErrorListeners();

			//lexer.addErrorListener(new CustomErrorListener());
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			FOLZ3Parser parser = new FOLZ3Parser(tokens);
			parser.getBuildParseTree();
			FOLZ3VisitorImpl xx = new FOLZ3VisitorImpl();
			String traverseResult = xx.visitCondition(parser.condition());
			System.out.println(traverseResult);

		

	}

	public String parseString(String x) {
		String input = x;
System.out.println("parser: "+x);
		FOLZ3Lexer lexer = new FOLZ3Lexer(CharStreams.fromString(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FOLZ3Parser parser = new FOLZ3Parser(tokens);
		parser.getBuildParseTree();
		
		String traverseResult = visitor.visitCondition(parser.condition());
		return traverseResult;

	}

}
