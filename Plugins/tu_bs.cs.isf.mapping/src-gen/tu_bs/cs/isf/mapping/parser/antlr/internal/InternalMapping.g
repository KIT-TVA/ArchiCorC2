/*
 * generated by Xtext 2.29.0
 */
grammar InternalMapping;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package tu_bs.cs.isf.mapping.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package tu_bs.cs.isf.mapping.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import tu_bs.cs.isf.mapping.services.MappingGrammarAccess;

}

@parser::members {

 	private MappingGrammarAccess grammarAccess;

    public InternalMappingParser(TokenStream input, MappingGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "MappingModel";
   	}

   	@Override
   	protected MappingGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleMappingModel
entryRuleMappingModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingModelRule()); }
	iv_ruleMappingModel=ruleMappingModel
	{ $current=$iv_ruleMappingModel.current; }
	EOF;

// Rule MappingModel
ruleMappingModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getMappingModelAccess().getMappingModelAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingModelAccess().getAnnotationsAnnotationParserRuleCall_1_0());
				}
				lv_annotations_1_0=ruleAnnotation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingModelRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_1_0,
						"tu_bs.cs.isf.mapping.Mapping.Annotation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_2_0());
				}
				lv_imports_2_0=ruleImport
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingModelRule());
					}
					add(
						$current,
						"imports",
						lv_imports_2_0,
						"tu_bs.cs.isf.mapping.Mapping.Import");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingModelAccess().getMappingsMappingParserRuleCall_3_0());
				}
				lv_mappings_3_0=ruleMapping
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingModelRule());
					}
					add(
						$current,
						"mappings",
						lv_mappings_3_0,
						"tu_bs.cs.isf.mapping.Mapping.Mapping");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleAnnotation
entryRuleAnnotation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationRule()); }
	iv_ruleAnnotation=ruleAnnotation
	{ $current=$iv_ruleAnnotation.current; }
	EOF;

// Rule Annotation
ruleAnnotation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAnnotationAccess().getAnnotationAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAnnotationAccess().getAnnotationVersionParserRuleCall_0_1_0());
					}
					lv_annotation_1_0=ruleVersion
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAnnotationRule());
						}
						set(
							$current,
							"annotation",
							lv_annotation_1_0,
							"tu_bs.cs.isf.mapping.Mapping.Version");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		{
			newCompositeNode(grammarAccess.getAnnotationAccess().getBundleParserRuleCall_1());
		}
		this_Bundle_2=ruleBundle
		{
			$current = $this_Bundle_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAnnotationAccess().getDateParserRuleCall_2());
		}
		this_Date_3=ruleDate
		{
			$current = $this_Date_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAnnotationAccess().getAuthorParserRuleCall_3());
		}
		this_Author_4=ruleAuthor
		{
			$current = $this_Author_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleVersion
entryRuleVersion returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVersionRule()); }
	iv_ruleVersion=ruleVersion
	{ $current=$iv_ruleVersion.current; }
	EOF;

// Rule Version
ruleVersion returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='version:'
		{
			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getVersionAccess().getNameEStringParserRuleCall_1_0());
				}
				lv_name_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVersionRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"tu_bs.cs.isf.mapping.Mapping.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBundle
entryRuleBundle returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBundleRule()); }
	iv_ruleBundle=ruleBundle
	{ $current=$iv_ruleBundle.current; }
	EOF;

// Rule Bundle
ruleBundle returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='bundle:'
		{
			newLeafNode(otherlv_0, grammarAccess.getBundleAccess().getBundleKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getBundleAccess().getNameEStringParserRuleCall_1_0());
				}
				lv_name_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBundleRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"tu_bs.cs.isf.mapping.Mapping.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleDate
entryRuleDate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDateRule()); }
	iv_ruleDate=ruleDate
	{ $current=$iv_ruleDate.current; }
	EOF;

// Rule Date
ruleDate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='date:'
		{
			newLeafNode(otherlv_0, grammarAccess.getDateAccess().getDateKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDateAccess().getNameEStringParserRuleCall_1_0());
				}
				lv_name_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDateRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"tu_bs.cs.isf.mapping.Mapping.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleAuthor
entryRuleAuthor returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAuthorRule()); }
	iv_ruleAuthor=ruleAuthor
	{ $current=$iv_ruleAuthor.current; }
	EOF;

// Rule Author
ruleAuthor returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='author:'
		{
			newLeafNode(otherlv_0, grammarAccess.getAuthorAccess().getAuthorKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAuthorAccess().getNameEStringParserRuleCall_1_0());
				}
				lv_name_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAuthorRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"tu_bs.cs.isf.mapping.Mapping.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getImportRule()); }
	iv_ruleImport=ruleImport
	{ $current=$iv_ruleImport.current; }
	EOF;

// Rule Import
ruleImport returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getImportAccess().getImportAction_0(),
					$current);
			}
		)
		otherlv_1='import'
		{
			newLeafNode(otherlv_1, grammarAccess.getImportAccess().getImportKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getImportAccess().getNameEStringParserRuleCall_2_0());
				}
				lv_name_2_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getImportRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"tu_bs.cs.isf.mapping.Mapping.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleMapping
entryRuleMapping returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingRule()); }
	iv_ruleMapping=ruleMapping
	{ $current=$iv_ruleMapping.current; }
	EOF;

// Rule Mapping
ruleMapping returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getMappingAccess().getMappingAction_0(),
					$current);
			}
		)
		otherlv_1='map'
		{
			newLeafNode(otherlv_1, grammarAccess.getMappingAccess().getMapKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingAccess().getNameEStringParserRuleCall_2_0());
				}
				lv_name_2_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"tu_bs.cs.isf.mapping.Mapping.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			otherlv_4='export'
			{
				newLeafNode(otherlv_4, grammarAccess.getMappingAccess().getExportKeyword_4());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingAccess().getComponentComponentParserRuleCall_5_0());
				}
				lv_component_5_0=ruleComponent
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingRule());
					}
					set(
						$current,
						"component",
						lv_component_5_0,
						"tu_bs.cs.isf.mapping.Mapping.Component");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getMappingAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleComponent
entryRuleComponent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComponentRule()); }
	iv_ruleComponent=ruleComponent
	{ $current=$iv_ruleComponent.current; }
	EOF;

// Rule Component
ruleComponent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getComponentAccess().getComponentAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getComponentAccess().getNameEStringParserRuleCall_1_0());
				}
				lv_name_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComponentRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"tu_bs.cs.isf.mapping.Mapping.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getComponentAccess().getMappingPairMappingPairParserRuleCall_3_0());
				}
				lv_mappingPair_3_0=ruleMappingPair
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComponentRule());
					}
					add(
						$current,
						"mappingPair",
						lv_mappingPair_3_0,
						"tu_bs.cs.isf.mapping.Mapping.MappingPair");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleMappingPair
entryRuleMappingPair returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingPairRule()); }
	iv_ruleMappingPair=ruleMappingPair
	{ $current=$iv_ruleMappingPair.current; }
	EOF;

// Rule MappingPair
ruleMappingPair returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getMappingPairAccess().getMappingPairAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingPairAccess().getPortServiceMethodParserRuleCall_1_0());
				}
				lv_port_1_0=ruleServiceMethod
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingPairRule());
					}
					set(
						$current,
						"port",
						lv_port_1_0,
						"tu_bs.cs.isf.mapping.Mapping.ServiceMethod");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='->'
		{
			newLeafNode(otherlv_2, grammarAccess.getMappingPairAccess().getHyphenMinusGreaterThanSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingPairAccess().getDiagramCbcDiagramParserRuleCall_3_0());
				}
				lv_diagram_3_0=ruleCbcDiagram
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingPairRule());
					}
					set(
						$current,
						"diagram",
						lv_diagram_3_0,
						"tu_bs.cs.isf.mapping.Mapping.CbcDiagram");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getMappingPairAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleServiceMethod
entryRuleServiceMethod returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getServiceMethodRule()); }
	iv_ruleServiceMethod=ruleServiceMethod
	{ $current=$iv_ruleServiceMethod.current; }
	EOF;

// Rule ServiceMethod
ruleServiceMethod returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getServiceMethodAccess().getServiceMethodAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getServiceMethodAccess().getNameFQNParserRuleCall_1_0());
				}
				lv_name_1_0=ruleFQN
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getServiceMethodRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"tu_bs.cs.isf.mapping.Mapping.FQN");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleCbcDiagram
entryRuleCbcDiagram returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCbcDiagramRule()); }
	iv_ruleCbcDiagram=ruleCbcDiagram
	{ $current=$iv_ruleCbcDiagram.current; }
	EOF;

// Rule CbcDiagram
ruleCbcDiagram returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getCbcDiagramAccess().getCbcDiagramAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getCbcDiagramAccess().getNameEStringParserRuleCall_0_1_0());
					}
					lv_name_1_0=ruleEString
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCbcDiagramRule());
						}
						set(
							$current,
							"name",
							lv_name_1_0,
							"tu_bs.cs.isf.mapping.Mapping.EString");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		otherlv_2='null'
		{
			newLeafNode(otherlv_2, grammarAccess.getCbcDiagramAccess().getNullKeyword_1());
		}
	)
;

// Entry rule entryRuleFQN
entryRuleFQN returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFQNRule()); }
	iv_ruleFQN=ruleFQN
	{ $current=$iv_ruleFQN.current.getText(); }
	EOF;

// Rule FQN
ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

// Entry rule entryRuleEString
entryRuleEString returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEStringRule()); }
	iv_ruleEString=ruleEString
	{ $current=$iv_ruleEString.current.getText(); }
	EOF;

// Rule EString
ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_STRING_0=RULE_STRING
		{
			$current.merge(this_STRING_0);
		}
		{
			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
		}
		    |
		(
			this_ID_1=RULE_ID
			{
				$current.merge(this_ID_1);
			}
			{
				newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1_0());
			}
			(
				kw='/'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEStringAccess().getSolidusKeyword_1_1_0());
				}
				this_ID_3=RULE_ID
				{
					$current.merge(this_ID_3);
				}
				{
					newLeafNode(this_ID_3, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1_1_1());
				}
			)*
			(
				kw='.'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEStringAccess().getFullStopKeyword_1_2_0());
				}
				this_ID_5=RULE_ID
				{
					$current.merge(this_ID_5);
				}
				{
					newLeafNode(this_ID_5, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1_2_1());
				}
			)*
		)
		    |
		(
			this_INT_6=RULE_INT
			{
				$current.merge(this_INT_6);
			}
			{
				newLeafNode(this_INT_6, grammarAccess.getEStringAccess().getINTTerminalRuleCall_2_0());
			}
			(
				kw='.'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEStringAccess().getFullStopKeyword_2_1_0());
				}
				this_INT_8=RULE_INT
				{
					$current.merge(this_INT_8);
				}
				{
					newLeafNode(this_INT_8, grammarAccess.getEStringAccess().getINTTerminalRuleCall_2_1_1());
				}
			)*
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;