/**
 * generated by Xtext 2.29.0
 */
package edu.kit.archicorc2.edl.events;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.archicorc2.edl.events.EventsFactory
 * @model kind="package"
 * @generated
 */
public interface EventsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "events";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.kit.edu/archicorc2/edl/Events";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "events";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EventsPackage eINSTANCE = edu.kit.archicorc2.edl.events.impl.EventsPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.kit.archicorc2.edl.events.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.kit.archicorc2.edl.events.impl.ModelImpl
   * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Event Collection</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__EVENT_COLLECTION = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.kit.archicorc2.edl.events.impl.EventTypeImpl <em>Event Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.kit.archicorc2.edl.events.impl.EventTypeImpl
   * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getEventType()
   * @generated
   */
  int EVENT_TYPE = 1;

  /**
   * The feature id for the '<em><b>Comment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPE__COMMENT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPE__NAME = 1;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPE__EVENTS = 2;

  /**
   * The number of structural features of the '<em>Event Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_TYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.kit.archicorc2.edl.events.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.kit.archicorc2.edl.events.impl.EventImpl
   * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getEvent()
   * @generated
   */
  int EVENT = 2;

  /**
   * The feature id for the '<em><b>Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__DEFAULT = 1;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.kit.archicorc2.edl.events.impl.AnnotationBlockImpl <em>Annotation Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.kit.archicorc2.edl.events.impl.AnnotationBlockImpl
   * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getAnnotationBlock()
   * @generated
   */
  int ANNOTATION_BLOCK = 3;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_BLOCK__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Annotation Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.kit.archicorc2.edl.events.impl.AnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.kit.archicorc2.edl.events.impl.AnnotationImpl
   * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getAnnotation()
   * @generated
   */
  int ANNOTATION = 4;

  /**
   * The feature id for the '<em><b>Raw Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__RAW_TEXT = 0;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.kit.archicorc2.edl.events.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.kit.archicorc2.edl.events.impl.ImportImpl
   * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 5;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = 1;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link edu.kit.archicorc2.edl.events.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see edu.kit.archicorc2.edl.events.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link edu.kit.archicorc2.edl.events.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.kit.archicorc2.edl.events.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link edu.kit.archicorc2.edl.events.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see edu.kit.archicorc2.edl.events.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link edu.kit.archicorc2.edl.events.Model#getEventCollection <em>Event Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Event Collection</em>'.
   * @see edu.kit.archicorc2.edl.events.Model#getEventCollection()
   * @see #getModel()
   * @generated
   */
  EReference getModel_EventCollection();

  /**
   * Returns the meta object for class '{@link edu.kit.archicorc2.edl.events.EventType <em>Event Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Type</em>'.
   * @see edu.kit.archicorc2.edl.events.EventType
   * @generated
   */
  EClass getEventType();

  /**
   * Returns the meta object for the containment reference '{@link edu.kit.archicorc2.edl.events.EventType#getComment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Comment</em>'.
   * @see edu.kit.archicorc2.edl.events.EventType#getComment()
   * @see #getEventType()
   * @generated
   */
  EReference getEventType_Comment();

  /**
   * Returns the meta object for the attribute '{@link edu.kit.archicorc2.edl.events.EventType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.kit.archicorc2.edl.events.EventType#getName()
   * @see #getEventType()
   * @generated
   */
  EAttribute getEventType_Name();

  /**
   * Returns the meta object for the containment reference list '{@link edu.kit.archicorc2.edl.events.EventType#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see edu.kit.archicorc2.edl.events.EventType#getEvents()
   * @see #getEventType()
   * @generated
   */
  EReference getEventType_Events();

  /**
   * Returns the meta object for class '{@link edu.kit.archicorc2.edl.events.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see edu.kit.archicorc2.edl.events.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for the attribute '{@link edu.kit.archicorc2.edl.events.Event#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Element</em>'.
   * @see edu.kit.archicorc2.edl.events.Event#getElement()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Element();

  /**
   * Returns the meta object for the attribute '{@link edu.kit.archicorc2.edl.events.Event#isDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default</em>'.
   * @see edu.kit.archicorc2.edl.events.Event#isDefault()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Default();

  /**
   * Returns the meta object for class '{@link edu.kit.archicorc2.edl.events.AnnotationBlock <em>Annotation Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Block</em>'.
   * @see edu.kit.archicorc2.edl.events.AnnotationBlock
   * @generated
   */
  EClass getAnnotationBlock();

  /**
   * Returns the meta object for the containment reference list '{@link edu.kit.archicorc2.edl.events.AnnotationBlock#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see edu.kit.archicorc2.edl.events.AnnotationBlock#getElements()
   * @see #getAnnotationBlock()
   * @generated
   */
  EReference getAnnotationBlock_Elements();

  /**
   * Returns the meta object for class '{@link edu.kit.archicorc2.edl.events.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see edu.kit.archicorc2.edl.events.Annotation
   * @generated
   */
  EClass getAnnotation();

  /**
   * Returns the meta object for the attribute '{@link edu.kit.archicorc2.edl.events.Annotation#getRawText <em>Raw Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Raw Text</em>'.
   * @see edu.kit.archicorc2.edl.events.Annotation#getRawText()
   * @see #getAnnotation()
   * @generated
   */
  EAttribute getAnnotation_RawText();

  /**
   * Returns the meta object for class '{@link edu.kit.archicorc2.edl.events.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see edu.kit.archicorc2.edl.events.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link edu.kit.archicorc2.edl.events.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see edu.kit.archicorc2.edl.events.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for the attribute '{@link edu.kit.archicorc2.edl.events.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see edu.kit.archicorc2.edl.events.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EventsFactory getEventsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link edu.kit.archicorc2.edl.events.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.archicorc2.edl.events.impl.ModelImpl
     * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

    /**
     * The meta object literal for the '<em><b>Event Collection</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__EVENT_COLLECTION = eINSTANCE.getModel_EventCollection();

    /**
     * The meta object literal for the '{@link edu.kit.archicorc2.edl.events.impl.EventTypeImpl <em>Event Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.archicorc2.edl.events.impl.EventTypeImpl
     * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getEventType()
     * @generated
     */
    EClass EVENT_TYPE = eINSTANCE.getEventType();

    /**
     * The meta object literal for the '<em><b>Comment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_TYPE__COMMENT = eINSTANCE.getEventType_Comment();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_TYPE__NAME = eINSTANCE.getEventType_Name();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_TYPE__EVENTS = eINSTANCE.getEventType_Events();

    /**
     * The meta object literal for the '{@link edu.kit.archicorc2.edl.events.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.archicorc2.edl.events.impl.EventImpl
     * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__ELEMENT = eINSTANCE.getEvent_Element();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__DEFAULT = eINSTANCE.getEvent_Default();

    /**
     * The meta object literal for the '{@link edu.kit.archicorc2.edl.events.impl.AnnotationBlockImpl <em>Annotation Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.archicorc2.edl.events.impl.AnnotationBlockImpl
     * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getAnnotationBlock()
     * @generated
     */
    EClass ANNOTATION_BLOCK = eINSTANCE.getAnnotationBlock();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_BLOCK__ELEMENTS = eINSTANCE.getAnnotationBlock_Elements();

    /**
     * The meta object literal for the '{@link edu.kit.archicorc2.edl.events.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.archicorc2.edl.events.impl.AnnotationImpl
     * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getAnnotation()
     * @generated
     */
    EClass ANNOTATION = eINSTANCE.getAnnotation();

    /**
     * The meta object literal for the '<em><b>Raw Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION__RAW_TEXT = eINSTANCE.getAnnotation_RawText();

    /**
     * The meta object literal for the '{@link edu.kit.archicorc2.edl.events.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.archicorc2.edl.events.impl.ImportImpl
     * @see edu.kit.archicorc2.edl.events.impl.EventsPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

  }

} //EventsPackage
