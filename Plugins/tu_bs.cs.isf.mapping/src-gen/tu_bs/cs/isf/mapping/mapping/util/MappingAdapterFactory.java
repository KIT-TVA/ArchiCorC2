/**
 * generated by Xtext 2.29.0
 */
package tu_bs.cs.isf.mapping.mapping.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tu_bs.cs.isf.mapping.mapping.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tu_bs.cs.isf.mapping.mapping.MappingPackage
 * @generated
 */
public class MappingAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MappingPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = MappingPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MappingSwitch<Adapter> modelSwitch =
    new MappingSwitch<Adapter>()
    {
      @Override
      public Adapter caseMappingModel(MappingModel object)
      {
        return createMappingModelAdapter();
      }
      @Override
      public Adapter caseAnnotation(Annotation object)
      {
        return createAnnotationAdapter();
      }
      @Override
      public Adapter caseVersion(Version object)
      {
        return createVersionAdapter();
      }
      @Override
      public Adapter caseBundle(Bundle object)
      {
        return createBundleAdapter();
      }
      @Override
      public Adapter caseDate(Date object)
      {
        return createDateAdapter();
      }
      @Override
      public Adapter caseAuthor(Author object)
      {
        return createAuthorAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseMapping(Mapping object)
      {
        return createMappingAdapter();
      }
      @Override
      public Adapter caseComponent(Component object)
      {
        return createComponentAdapter();
      }
      @Override
      public Adapter caseMappingPair(MappingPair object)
      {
        return createMappingPairAdapter();
      }
      @Override
      public Adapter caseServiceMethod(ServiceMethod object)
      {
        return createServiceMethodAdapter();
      }
      @Override
      public Adapter caseCbcDiagram(CbcDiagram object)
      {
        return createCbcDiagramAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.MappingModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.MappingModel
   * @generated
   */
  public Adapter createMappingModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.Annotation
   * @generated
   */
  public Adapter createAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.Version <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.Version
   * @generated
   */
  public Adapter createVersionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.Bundle <em>Bundle</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.Bundle
   * @generated
   */
  public Adapter createBundleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.Date <em>Date</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.Date
   * @generated
   */
  public Adapter createDateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.Author <em>Author</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.Author
   * @generated
   */
  public Adapter createAuthorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.Mapping
   * @generated
   */
  public Adapter createMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.Component
   * @generated
   */
  public Adapter createComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.MappingPair <em>Pair</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.MappingPair
   * @generated
   */
  public Adapter createMappingPairAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.ServiceMethod <em>Service Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.ServiceMethod
   * @generated
   */
  public Adapter createServiceMethodAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link tu_bs.cs.isf.mapping.mapping.CbcDiagram <em>Cbc Diagram</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see tu_bs.cs.isf.mapping.mapping.CbcDiagram
   * @generated
   */
  public Adapter createCbcDiagramAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //MappingAdapterFactory
