package edu.kit.archicorc2.core.features.loading;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import edu.kit.archicorc2.Verification.Abstract;
import edu.kit.archicorc2.Verification.Component;
import edu.kit.archicorc2.Verification.Compound;
import edu.kit.archicorc2.Verification.Module;
import edu.kit.archicorc2.Verification.Ports;
import edu.kit.archicorc2.core.localization.StringTable;
import edu.kit.archicorc2.core.util.CoreUtil;
import edu.kit.archicorc2.core.util.ModuleFilter;
import edu.kit.archicorc2.ui.dialogs.LoadModuleDialog;
import edu.kit.archicorc2.ui.provider.LoadModuleLabelProvider;

public class AssignAbstractFeature extends AbstractCreateFeature {

	public AssignAbstractFeature(IFeatureProvider fp) {
		super(fp, StringTable.ASSIGN_ABSTRACT_SHORT, StringTable.ASSIGN_ABSTRACT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {

				return false;
			}

			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1 && (businessObjects.get(0) instanceof Component || // TODO also allowing
																									// components to
																									// dereive from
																									// abstract
																									// components
					businessObjects.get(0) instanceof Compound);
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {

		List<Module> modules = (List<Module>) CoreUtil.getRootModules(CoreUtil.getCurrentProject(), m -> {
			PictogramElement pict = context.getTargetContainer();
			Module x = (Module) getBusinessObjectForPictogramElement(pict);

			boolean result = m instanceof Abstract;

			for (Module realization : x.getRealizedBy()) {
				result = result
						&& !realization.eResource().getURI().toString().equals(m.eResource().getURI().toString());
			}

			return result;
		});

		final LoadModuleDialog dialog = new LoadModuleDialog(null, new LoadModuleLabelProvider(),
				"Choose a realized abstract component from the following list", "Assign Abstract Component", modules);

		if (dialog.open() == LoadModuleDialog.CANCEL) {
			return null;
		}

		for (Object obj : dialog.getResult()) {
			Module c = (Module) obj;
			Abstract i = (Abstract) c;
			PictogramElement pict = context.getTargetContainer();
			Module x = (Module) getBusinessObjectForPictogramElement(pict);

			x.getRealizedBy().add(i);

			List<Ports> add = i.getPorts().stream()
					.filter(e1 -> x.getPorts().stream()
							.anyMatch(e2 -> !e1.getName().equals(e2.getName())))
					.collect(Collectors.toList());

			for (Ports p : add) {
				addGraphicalRepresentation(context, p);
			}
			for (Ports p : add) {
				p.setIsDerived(true);
			}
			x.getPorts().addAll(add);
		}
		PictogramElement pict = context.getTargetContainer();
		updatePictogramElement(pict);
		return null;
	}
}
