/*
 * generated by Xtext 2.29.0
 */
package edu.kit.archicorc2.edl.serializer;

import com.google.inject.Inject;
import edu.kit.archicorc2.edl.events.Annotation;
import edu.kit.archicorc2.edl.events.AnnotationBlock;
import edu.kit.archicorc2.edl.events.Event;
import edu.kit.archicorc2.edl.events.EventType;
import edu.kit.archicorc2.edl.events.EventsPackage;
import edu.kit.archicorc2.edl.events.Import;
import edu.kit.archicorc2.edl.events.Model;
import edu.kit.archicorc2.edl.services.EventsGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class EventsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private EventsGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == EventsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case EventsPackage.ANNOTATION:
				sequence_Annotation(context, (Annotation) semanticObject); 
				return; 
			case EventsPackage.ANNOTATION_BLOCK:
				sequence_AnnotationBlock(context, (AnnotationBlock) semanticObject); 
				return; 
			case EventsPackage.EVENT:
				sequence_Event(context, (Event) semanticObject); 
				return; 
			case EventsPackage.EVENT_TYPE:
				sequence_EventType(context, (EventType) semanticObject); 
				return; 
			case EventsPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case EventsPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     AnnotationBlock returns AnnotationBlock
	 *
	 * Constraint:
	 *     elements+=Annotation+
	 * </pre>
	 */
	protected void sequence_AnnotationBlock(ISerializationContext context, AnnotationBlock semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Annotation returns Annotation
	 *
	 * Constraint:
	 *     rawText=ANNOTATION_STRING
	 * </pre>
	 */
	protected void sequence_Annotation(ISerializationContext context, Annotation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EventsPackage.Literals.ANNOTATION__RAW_TEXT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EventsPackage.Literals.ANNOTATION__RAW_TEXT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAnnotationAccess().getRawTextANNOTATION_STRINGTerminalRuleCall_0(), semanticObject.getRawText());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EventType returns EventType
	 *
	 * Constraint:
	 *     (comment=AnnotationBlock? name=ID? events+=Event events+=Event*)
	 * </pre>
	 */
	protected void sequence_EventType(ISerializationContext context, EventType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Event returns Event
	 *
	 * Constraint:
	 *     (element=ID default?='default'?)
	 * </pre>
	 */
	protected void sequence_Event(ISerializationContext context, Event semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     (importedNamespace=ImportedFQN? importURI=STRING)
	 * </pre>
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (name=FQN imports+=Import* eventCollection+=EventType*)
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
