/*
 * generated by Xtext 2.29.0
 */
package tu_bs.cs.isf.mapping.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MappingAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("tu_bs/cs/isf/mapping/parser/antlr/internal/InternalMapping.tokens");
	}
}
