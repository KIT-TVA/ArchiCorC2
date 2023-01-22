/*
 * generated by Xtext 2.29.0
 */
package edu.kit.archicorc2.edl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.kit.archicorc2.edl.ide.contentassist.antlr.internal.InternalEventsParser;
import edu.kit.archicorc2.edl.services.EventsGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class EventsParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(EventsGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, EventsGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getImportAccess().getAlternatives_1(), "rule__Import__Alternatives_1");
			builder.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			builder.put(grammarAccess.getEventTypeAccess().getGroup(), "rule__EventType__Group__0");
			builder.put(grammarAccess.getEventTypeAccess().getGroup_6(), "rule__EventType__Group_6__0");
			builder.put(grammarAccess.getEventAccess().getGroup(), "rule__Event__Group__0");
			builder.put(grammarAccess.getEventAccess().getGroup_1(), "rule__Event__Group_1__0");
			builder.put(grammarAccess.getAnnotationBlockAccess().getGroup(), "rule__AnnotationBlock__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup_1_0(), "rule__Import__Group_1_0__0");
			builder.put(grammarAccess.getImportedFQNAccess().getGroup(), "rule__ImportedFQN__Group__0");
			builder.put(grammarAccess.getImportedFQNAccess().getGroup_1(), "rule__ImportedFQN__Group_1__0");
			builder.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			builder.put(grammarAccess.getID_WITH_SELECTORAccess().getGroup(), "rule__ID_WITH_SELECTOR__Group__0");
			builder.put(grammarAccess.getID_WITH_SELECTORAccess().getGroup_1(), "rule__ID_WITH_SELECTOR__Group_1__0");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_2(), "rule__Model__NameAssignment_2");
			builder.put(grammarAccess.getModelAccess().getImportsAssignment_3(), "rule__Model__ImportsAssignment_3");
			builder.put(grammarAccess.getModelAccess().getEventCollectionAssignment_4(), "rule__Model__EventCollectionAssignment_4");
			builder.put(grammarAccess.getEventTypeAccess().getCommentAssignment_1(), "rule__EventType__CommentAssignment_1");
			builder.put(grammarAccess.getEventTypeAccess().getNameAssignment_3(), "rule__EventType__NameAssignment_3");
			builder.put(grammarAccess.getEventTypeAccess().getEventsAssignment_5(), "rule__EventType__EventsAssignment_5");
			builder.put(grammarAccess.getEventTypeAccess().getEventsAssignment_6_1(), "rule__EventType__EventsAssignment_6_1");
			builder.put(grammarAccess.getEventAccess().getElementAssignment_0(), "rule__Event__ElementAssignment_0");
			builder.put(grammarAccess.getEventAccess().getDefaultAssignment_1_1(), "rule__Event__DefaultAssignment_1_1");
			builder.put(grammarAccess.getAnnotationBlockAccess().getElementsAssignment_1(), "rule__AnnotationBlock__ElementsAssignment_1");
			builder.put(grammarAccess.getAnnotationAccess().getRawTextAssignment(), "rule__Annotation__RawTextAssignment");
			builder.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0(), "rule__Import__ImportedNamespaceAssignment_1_0_0");
			builder.put(grammarAccess.getImportAccess().getImportURIAssignment_2(), "rule__Import__ImportURIAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private EventsGrammarAccess grammarAccess;

	@Override
	protected InternalEventsParser createParser() {
		InternalEventsParser result = new InternalEventsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public EventsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(EventsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
