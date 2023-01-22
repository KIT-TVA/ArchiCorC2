/*
 * generated by Xtext 2.29.0
 */
package edu.kit.archicorc2.edl.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class EventsGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cModelAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cPackageKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameFQNParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cImportsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cImportsImportParserRuleCall_3_0 = (RuleCall)cImportsAssignment_3.eContents().get(0);
		private final Assignment cEventCollectionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cEventCollectionEventTypeParserRuleCall_4_0 = (RuleCall)cEventCollectionAssignment_4.eContents().get(0);
		
		//Model returns Model:
		//    {Model}
		//    'package' name=FQN
		//    (imports+=Import)*
		//    (eventCollection+=EventType)*;
		@Override public ParserRule getRule() { return rule; }
		
		//{Model}
		//'package' name=FQN
		//(imports+=Import)*
		//(eventCollection+=EventType)*
		public Group getGroup() { return cGroup; }
		
		//{Model}
		public Action getModelAction_0() { return cModelAction_0; }
		
		//'package'
		public Keyword getPackageKeyword_1() { return cPackageKeyword_1; }
		
		//name=FQN
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//FQN
		public RuleCall getNameFQNParserRuleCall_2_0() { return cNameFQNParserRuleCall_2_0; }
		
		//(imports+=Import)*
		public Assignment getImportsAssignment_3() { return cImportsAssignment_3; }
		
		//Import
		public RuleCall getImportsImportParserRuleCall_3_0() { return cImportsImportParserRuleCall_3_0; }
		
		//(eventCollection+=EventType)*
		public Assignment getEventCollectionAssignment_4() { return cEventCollectionAssignment_4; }
		
		//EventType
		public RuleCall getEventCollectionEventTypeParserRuleCall_4_0() { return cEventCollectionEventTypeParserRuleCall_4_0; }
	}
	public class EventTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.EventType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEventTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cCommentAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCommentAnnotationBlockParserRuleCall_1_0 = (RuleCall)cCommentAssignment_1.eContents().get(0);
		private final Keyword cEventTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cEventsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cEventsEventParserRuleCall_5_0 = (RuleCall)cEventsAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cCommaKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cEventsAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cEventsEventParserRuleCall_6_1_0 = (RuleCall)cEventsAssignment_6_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//EventType returns EventType:
		//    {EventType}
		//    (comment=AnnotationBlock)?
		//    'EventType' (name=ID)?
		//    '{'
		//        events += Event
		//        (
		//            ',' events += Event
		//        )*
		//    '}';
		@Override public ParserRule getRule() { return rule; }
		
		//{EventType}
		//(comment=AnnotationBlock)?
		//'EventType' (name=ID)?
		//'{'
		//    events += Event
		//    (
		//        ',' events += Event
		//    )*
		//'}'
		public Group getGroup() { return cGroup; }
		
		//{EventType}
		public Action getEventTypeAction_0() { return cEventTypeAction_0; }
		
		//(comment=AnnotationBlock)?
		public Assignment getCommentAssignment_1() { return cCommentAssignment_1; }
		
		//AnnotationBlock
		public RuleCall getCommentAnnotationBlockParserRuleCall_1_0() { return cCommentAnnotationBlockParserRuleCall_1_0; }
		
		//'EventType'
		public Keyword getEventTypeKeyword_2() { return cEventTypeKeyword_2; }
		
		//(name=ID)?
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//events += Event
		public Assignment getEventsAssignment_5() { return cEventsAssignment_5; }
		
		//Event
		public RuleCall getEventsEventParserRuleCall_5_0() { return cEventsEventParserRuleCall_5_0; }
		
		//(
		//    ',' events += Event
		//)*
		public Group getGroup_6() { return cGroup_6; }
		
		//','
		public Keyword getCommaKeyword_6_0() { return cCommaKeyword_6_0; }
		
		//events += Event
		public Assignment getEventsAssignment_6_1() { return cEventsAssignment_6_1; }
		
		//Event
		public RuleCall getEventsEventParserRuleCall_6_1_0() { return cEventsEventParserRuleCall_6_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class EventElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.Event");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cElementAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cElementIDTerminalRuleCall_0_0 = (RuleCall)cElementAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cDefaultAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cDefaultDefaultKeyword_1_1_0 = (Keyword)cDefaultAssignment_1_1.eContents().get(0);
		
		//Event:
		//    element=ID ('=' default?='default')?;
		@Override public ParserRule getRule() { return rule; }
		
		//element=ID ('=' default?='default')?
		public Group getGroup() { return cGroup; }
		
		//element=ID
		public Assignment getElementAssignment_0() { return cElementAssignment_0; }
		
		//ID
		public RuleCall getElementIDTerminalRuleCall_0_0() { return cElementIDTerminalRuleCall_0_0; }
		
		//('=' default?='default')?
		public Group getGroup_1() { return cGroup_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_1_0() { return cEqualsSignKeyword_1_0; }
		
		//default?='default'
		public Assignment getDefaultAssignment_1_1() { return cDefaultAssignment_1_1; }
		
		//'default'
		public Keyword getDefaultDefaultKeyword_1_1_0() { return cDefaultDefaultKeyword_1_1_0; }
	}
	public class AnnotationBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.AnnotationBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSolidusAsteriskKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cElementsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cElementsAnnotationParserRuleCall_1_0 = (RuleCall)cElementsAssignment_1.eContents().get(0);
		private final Keyword cAsteriskSolidusKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//AnnotationBlock returns AnnotationBlock:
		//    '/*' (elements+=Annotation)+ '*/';
		@Override public ParserRule getRule() { return rule; }
		
		//'/*' (elements+=Annotation)+ '*/'
		public Group getGroup() { return cGroup; }
		
		//'/*'
		public Keyword getSolidusAsteriskKeyword_0() { return cSolidusAsteriskKeyword_0; }
		
		//(elements+=Annotation)+
		public Assignment getElementsAssignment_1() { return cElementsAssignment_1; }
		
		//Annotation
		public RuleCall getElementsAnnotationParserRuleCall_1_0() { return cElementsAnnotationParserRuleCall_1_0; }
		
		//'*/'
		public Keyword getAsteriskSolidusKeyword_2() { return cAsteriskSolidusKeyword_2; }
	}
	public class AnnotationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.Annotation");
		private final Assignment cRawTextAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cRawTextANNOTATION_STRINGTerminalRuleCall_0 = (RuleCall)cRawTextAssignment.eContents().get(0);
		
		//Annotation returns Annotation:
		//    rawText=ANNOTATION_STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//rawText=ANNOTATION_STRING
		public Assignment getRawTextAssignment() { return cRawTextAssignment; }
		
		//ANNOTATION_STRING
		public RuleCall getRawTextANNOTATION_STRINGTerminalRuleCall_0() { return cRawTextANNOTATION_STRINGTerminalRuleCall_0; }
	}
	public class ImportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.Import");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cImportedNamespaceAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final RuleCall cImportedNamespaceImportedFQNParserRuleCall_1_0_0_0 = (RuleCall)cImportedNamespaceAssignment_1_0_0.eContents().get(0);
		private final Keyword cFromKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Keyword cModelKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		private final Assignment cImportURIAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cImportURISTRINGTerminalRuleCall_2_0 = (RuleCall)cImportURIAssignment_2.eContents().get(0);
		
		//Import :
		//    'import' (importedNamespace=ImportedFQN 'from' | 'model') importURI=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//'import' (importedNamespace=ImportedFQN 'from' | 'model') importURI=STRING
		public Group getGroup() { return cGroup; }
		
		//'import'
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }
		
		//(importedNamespace=ImportedFQN 'from' | 'model')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//importedNamespace=ImportedFQN 'from'
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//importedNamespace=ImportedFQN
		public Assignment getImportedNamespaceAssignment_1_0_0() { return cImportedNamespaceAssignment_1_0_0; }
		
		//ImportedFQN
		public RuleCall getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0() { return cImportedNamespaceImportedFQNParserRuleCall_1_0_0_0; }
		
		//'from'
		public Keyword getFromKeyword_1_0_1() { return cFromKeyword_1_0_1; }
		
		//'model'
		public Keyword getModelKeyword_1_1() { return cModelKeyword_1_1; }
		
		//importURI=STRING
		public Assignment getImportURIAssignment_2() { return cImportURIAssignment_2; }
		
		//STRING
		public RuleCall getImportURISTRINGTerminalRuleCall_2_0() { return cImportURISTRINGTerminalRuleCall_2_0; }
	}
	public class ImportedFQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.ImportedFQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cFQNParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cAsteriskKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		
		//ImportedFQN:
		//    FQN ('.' '*')?;
		@Override public ParserRule getRule() { return rule; }
		
		//FQN ('.' '*')?
		public Group getGroup() { return cGroup; }
		
		//FQN
		public RuleCall getFQNParserRuleCall_0() { return cFQNParserRuleCall_0; }
		
		//('.' '*')?
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//'*'
		public Keyword getAsteriskKeyword_1_1() { return cAsteriskKeyword_1_1; }
	}
	public class FQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.FQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//FQN:
		//    ID ('.' ID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('.' ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('.' ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	public class ID_WITH_SELECTORElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.ID_WITH_SELECTOR");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//// this is used for overloaded FMethod and FBroadcast
		//ID_WITH_SELECTOR:
		//    ID (':' ID)?;
		@Override public ParserRule getRule() { return rule; }
		
		//ID (':' ID)?
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//(':' ID)?
		public Group getGroup_1() { return cGroup_1; }
		
		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final ModelElements pModel;
	private final EventTypeElements pEventType;
	private final EventElements pEvent;
	private final AnnotationBlockElements pAnnotationBlock;
	private final AnnotationElements pAnnotation;
	private final TerminalRule tANNOTATION_STRING;
	private final ImportElements pImport;
	private final ImportedFQNElements pImportedFQN;
	private final FQNElements pFQN;
	private final ID_WITH_SELECTORElements pID_WITH_SELECTOR;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public EventsGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pModel = new ModelElements();
		this.pEventType = new EventTypeElements();
		this.pEvent = new EventElements();
		this.pAnnotationBlock = new AnnotationBlockElements();
		this.pAnnotation = new AnnotationElements();
		this.tANNOTATION_STRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "edu.kit.archicorc2.edl.Events.ANNOTATION_STRING");
		this.pImport = new ImportElements();
		this.pImportedFQN = new ImportedFQNElements();
		this.pFQN = new FQNElements();
		this.pID_WITH_SELECTOR = new ID_WITH_SELECTORElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("edu.kit.archicorc2.edl.Events".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Model returns Model:
	//    {Model}
	//    'package' name=FQN
	//    (imports+=Import)*
	//    (eventCollection+=EventType)*;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}
	
	//EventType returns EventType:
	//    {EventType}
	//    (comment=AnnotationBlock)?
	//    'EventType' (name=ID)?
	//    '{'
	//        events += Event
	//        (
	//            ',' events += Event
	//        )*
	//    '}';
	public EventTypeElements getEventTypeAccess() {
		return pEventType;
	}
	
	public ParserRule getEventTypeRule() {
		return getEventTypeAccess().getRule();
	}
	
	//Event:
	//    element=ID ('=' default?='default')?;
	public EventElements getEventAccess() {
		return pEvent;
	}
	
	public ParserRule getEventRule() {
		return getEventAccess().getRule();
	}
	
	//AnnotationBlock returns AnnotationBlock:
	//    '/*' (elements+=Annotation)+ '*/';
	public AnnotationBlockElements getAnnotationBlockAccess() {
		return pAnnotationBlock;
	}
	
	public ParserRule getAnnotationBlockRule() {
		return getAnnotationBlockAccess().getRule();
	}
	
	//Annotation returns Annotation:
	//    rawText=ANNOTATION_STRING;
	public AnnotationElements getAnnotationAccess() {
		return pAnnotation;
	}
	
	public ParserRule getAnnotationRule() {
		return getAnnotationAccess().getRule();
	}
	
	//terminal ANNOTATION_STRING returns ecore::EString:
	//    '@' (('a'..'z')|'-')+ (' '|'\t')* ':'
	//    ( ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\')) | ('\\*'|'\\@') | !('\\'|'*'|'@') )*
	//;
	public TerminalRule getANNOTATION_STRINGRule() {
		return tANNOTATION_STRING;
	}
	
	//Import :
	//    'import' (importedNamespace=ImportedFQN 'from' | 'model') importURI=STRING;
	public ImportElements getImportAccess() {
		return pImport;
	}
	
	public ParserRule getImportRule() {
		return getImportAccess().getRule();
	}
	
	//ImportedFQN:
	//    FQN ('.' '*')?;
	public ImportedFQNElements getImportedFQNAccess() {
		return pImportedFQN;
	}
	
	public ParserRule getImportedFQNRule() {
		return getImportedFQNAccess().getRule();
	}
	
	//FQN:
	//    ID ('.' ID)*;
	public FQNElements getFQNAccess() {
		return pFQN;
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}
	
	//// this is used for overloaded FMethod and FBroadcast
	//ID_WITH_SELECTOR:
	//    ID (':' ID)?;
	public ID_WITH_SELECTORElements getID_WITH_SELECTORAccess() {
		return pID_WITH_SELECTOR;
	}
	
	public ParserRule getID_WITH_SELECTORRule() {
		return getID_WITH_SELECTORAccess().getRule();
	}
	
	//terminal ID: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt: ('0'..'9')+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|'"') )* '"' |
	//            "'" ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT : '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT : '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS         : (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}