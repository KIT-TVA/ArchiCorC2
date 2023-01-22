package edu.kit.archicorc2.core.features.createFeatures;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import edu.kit.archicorc2.Verification.Ports;
import edu.kit.archicorc2.core.compatibility.CompatibilityChecker;
import edu.kit.archicorc2.core.localization.StringTable;
import edu.kit.archicorc2.core.util.CoreUtil;
import edu.kit.archicorc2.idl.CidlPersistenceManager;
import edu.kit.archicorc2.idl.cidl.Interface;
import edu.kit.archicorc2.idl.cidl.Model;

public class CreatePortConnection extends AbstractCreateConnectionFeature {

	public CreatePortConnection(IFeatureProvider fp) {
		super(fp, StringTable.CREATE_PORT_CONNECTION_NAME, StringTable.CREATE_PORT_CONNECTION_DESC);
		// TODO Auto-generated constructor stub
	}

	private EClass getEClass(Anchor anchor) {
		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor.getParent());
			if (object instanceof EClass) {
				return (EClass) object;
			}
		}
		return null;
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		// System.out.println("hallo");
		EClass source = getEClass(context.getSourceAnchor());
		EClass target = getEClass(context.getTargetAnchor());

//		if(context.getSourceAnchor() != null && context.getTargetAnchor() != null && context.getSourceAnchor() != context.getTargetAnchor())
//			System.out.println("Source: " + context.getSourceAnchor() + "; Target: " + context.getTargetAnchor());

		if (!(context.getSourcePictogramElement() instanceof Diagram
				|| context.getTargetPictogramElement() instanceof Diagram)) {
			PictogramElement pictSource = context.getSourcePictogramElement();
			PictogramElement pictTarget = context.getTargetPictogramElement();
			if (!(pictSource instanceof ContainerShape && pictTarget instanceof ContainerShape)) {

				return false;
			}
			EList<EObject> businessObjectsSource = pictSource.getLink().getBusinessObjects();
			EList<EObject> businessObjectsTarget = pictTarget.getLink().getBusinessObjects();
			ContainerShape cs1 = (ContainerShape) context.getSourcePictogramElement();
			ContainerShape cs2 = (ContainerShape) context.getTargetPictogramElement();
			if (businessObjectsSource.size() == 1 && businessObjectsSource.get(0) instanceof Ports
					&& businessObjectsTarget.size() == 1 && businessObjectsTarget.get(0) instanceof Ports
					&& cs1.getContainer() != cs2.getContainer()) {
				Ports port1 = (Ports) businessObjectsSource.get(0);
				Ports port2 = (Ports) businessObjectsTarget.get(0);

				// TODO: if equal type -> OK
				if(port1.getService() != null)
					return port2.getService() != null;
				else
					return port1.getType().equals(port2.getType());
			}
		} else {
			return false;
		}
		return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Anchor sourceAnchor = context.getSourceAnchor();
		Anchor targetAnchor = context.getTargetAnchor();

		EList<EObject> businessObjects = context.getSourcePictogramElement().getLink().getBusinessObjects();
		EList<EObject> businessObjects2 = context.getTargetPictogramElement().getLink().getBusinessObjects();
		ContainerShape cs1 = (ContainerShape) context.getSourcePictogramElement();
		ContainerShape cs2 = (ContainerShape) context.getTargetPictogramElement();
		Ports source = (Ports) businessObjects.get(0);

		Ports target = (Ports) businessObjects2.get(0);

		if (cs1.getContainer().getContainer() == cs2.getContainer().getContainer()) {

			source.getPorts().add(target);
			target.setPortseOpposite(source);
		} else if (cs1.getContainer() == cs2.getContainer().getContainer()
				|| cs2.getContainer() == cs1.getContainer().getContainer()) {
			source.getInsidePorts().add(target);
			target.setInsidePortseOpposite(source);

		}

//		AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
//		getFeatureProvider().addIfPossible(addContext);

		if (source.getService() != null && target.getService() != null) {
			if (source.getService().equals(target.getService())) {
				AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
				getFeatureProvider().addIfPossible(addContext);
			} else {
				// Check liskov!!
				// #1 Check method inclusion
				List<Interface> interfaces = CidlPersistenceManager.getIdlModels(CoreUtil.getCurrentProject()).stream()
						.map(m -> ((Model) m).getInterfaces()).flatMap(i -> i.stream()).collect(Collectors.toList());
				Interface provided = interfaces.stream().filter(i -> i.getName().equals(source.getService()))
						.findFirst().get();
				Interface required = interfaces.stream().filter(i -> i.getName().equals(target.getService()))
						.findFirst().get();
				// if()
				if (CompatibilityChecker.horizontal(provided, required)) {
					AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
					getFeatureProvider().addIfPossible(addContext);
				}
			}
		}

		return null;

	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if (!(context.getSourcePictogramElement() instanceof Diagram)) {
			PictogramElement pict = context.getSourcePictogramElement();
			if (!(pict instanceof ContainerShape)) {

				return false;
			}
			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.get(0) instanceof Ports;
		} else {
			return false;
		}
	}

}
