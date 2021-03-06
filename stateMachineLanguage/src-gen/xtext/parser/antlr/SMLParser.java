/*
 * generated by Xtext 2.26.0
 */
package xtext.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import xtext.parser.antlr.internal.InternalSMLParser;
import xtext.services.SMLGrammarAccess;

public class SMLParser extends AbstractAntlrParser {

	@Inject
	private SMLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalSMLParser createParser(XtextTokenStream stream) {
		return new InternalSMLParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "SML";
	}

	public SMLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(SMLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
