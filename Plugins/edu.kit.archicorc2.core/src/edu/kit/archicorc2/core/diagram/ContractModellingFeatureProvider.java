package edu.kit.archicorc2.core.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import edu.kit.archicorc2.Verification.Contract;
import edu.kit.archicorc2.Verification.Module;
import edu.kit.archicorc2.Verification.Ports;
import edu.kit.archicorc2.Verification.System;
import edu.kit.archicorc2.core.features.addFeature.AddComponentFeature;
import edu.kit.archicorc2.core.features.addFeature.AddContractConnectionFeature;
import edu.kit.archicorc2.core.features.addFeature.AddContractFeature;
import edu.kit.archicorc2.core.features.addFeature.AddPortConnetion;
import edu.kit.archicorc2.core.features.addFeature.AddPortFeature;
import edu.kit.archicorc2.core.features.addFeature.AddSystemFeature;
import edu.kit.archicorc2.core.features.connections.ReconnectionFeature;
import edu.kit.archicorc2.core.features.createFeatures.CreateContractFeature;
import edu.kit.archicorc2.core.features.createFeatures.CreatePortConnection;
import edu.kit.archicorc2.core.features.createFeatures.CreatePortFeature;
import edu.kit.archicorc2.core.features.deleteFeature.DeleteModuleFeature;
import edu.kit.archicorc2.core.features.deleteFeature.DeletePortConnectionFeature;
import edu.kit.archicorc2.core.features.deleteFeature.DeletePortFeature;
import edu.kit.archicorc2.core.features.guiFeatures.CollapseFeature;
import edu.kit.archicorc2.core.features.guiFeatures.EditAbstractFeature;
import edu.kit.archicorc2.core.features.guiFeatures.LayoutFeature;
import edu.kit.archicorc2.core.features.guiFeatures.ViewpointVerificationFeature;
import edu.kit.archicorc2.core.features.layout.LayoutDiagramFeature;
import edu.kit.archicorc2.core.features.layout.LayoutPortFeature;
import edu.kit.archicorc2.core.features.loading.AssignAbstractFeature;
import edu.kit.archicorc2.core.features.loading.LoadModuleFeature;
import edu.kit.archicorc2.core.features.move.MovePortFeature;
import edu.kit.archicorc2.core.features.resize.ResizeModuleFeature;
import edu.kit.archicorc2.core.features.update.UpdateContractFeature;
import edu.kit.archicorc2.core.features.update.UpdateModuleFeature;
import edu.kit.archicorc2.core.features.update.UpdatePortFeature;
import edu.kit.archicorc2.core.propertyFeature.CreateProperty;
import edu.kit.archicorc2.core.synchronize.SynchronizeFeature;

public class ContractModellingFeatureProvider extends DefaultFeatureProvider {

	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return new ReconnectionFeature(this);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { // new VerifyCustomFeature(this),
				new ViewpointVerificationFeature(this), new CollapseFeature(this), new EditAbstractFeature(this),
				new LayoutDiagramFeature(this), new SynchronizeFeature(this) };
	}

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		PictogramElement pes = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pes);

		if (context.getPictogramElement() instanceof Connection) {
			Connection con = (Connection) context.getPictogramElement();
			if ((getBusinessObjectForPictogramElement(con.getStart().getParent()) instanceof Ports)
					&& (getBusinessObjectForPictogramElement(con.getEnd().getParent()) instanceof Ports)) {

				return new DeletePortConnectionFeature(this);
			}

		}

		else if (bo instanceof Module) {
			Module m = (Module) bo;
			if (m.getModule() != null) {
				return new DeleteModuleFeature(this);
			}
		} else if (bo instanceof Ports) {

			return new DeletePortFeature(this);

		}

		return super.getDeleteFeature(context);
	}

	public ContractModellingFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {

		return new ICreateFeature[] {
				// new CreateComponentFeature(this),
				new CreateContractFeature(this),
				// new CreateAbstractFeature(this),
				new CreatePortFeature(this), new LoadModuleFeature(this), new CreateProperty(this, true),
				new CreateProperty(this, false), new AssignAbstractFeature(this) };
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new CreatePortConnection(this) };
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		Object obj = context.getNewObject();
		if (obj instanceof System) {
			return new AddSystemFeature(this);
		} else if (obj instanceof Contract) {
			return new AddContractFeature(this);
		} else if (obj instanceof Module) {
			return new AddComponentFeature(this);
		} else if (obj instanceof Ports) {
			return new AddPortFeature(this);
		} else if (context instanceof IAddConnectionContext && (getBusinessObjectForPictogramElement(
				((IAddConnectionContext) context).getSourceAnchor().getParent()) instanceof Ports)) {
			return new AddPortConnetion(this);
		} else if (context instanceof IAddConnectionContext) {
			return new AddContractConnectionFeature(this);
		}

		return super.getAddFeature(context);
	}

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		// TODO: check for right domain object instances below
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Module || bo instanceof Contract || bo instanceof System) {
			return new LayoutFeature(this);
		} else if (bo instanceof Ports) {
			return new LayoutPortFeature(this);
		}
		return super.getLayoutFeature(context);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Ports) {
				return new UpdatePortFeature(this);
			} else if (bo instanceof Contract) {
				return new UpdateContractFeature(this);

			} else if (bo instanceof Module) {
				return new UpdateModuleFeature(this);

			}
		}
		return super.getUpdateFeature(context);

	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Ports) {
				return new MovePortFeature(this);
			}

		}
		return super.getMoveShapeFeature(context);

	}

	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Module) {
				return new ResizeModuleFeature(this);
			}
		}
		return super.getResizeShapeFeature(context);
	}

}
