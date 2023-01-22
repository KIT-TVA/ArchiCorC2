package edu.kit.archicorc2.core.features.createFeatures;

import org.eclipse.emf.common.util.EList;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import edu.kit.archicorc2.Verification.DirectionType;
import edu.kit.archicorc2.Verification.MmFactory;
import edu.kit.archicorc2.Verification.Module;
import edu.kit.archicorc2.Verification.PortType;
import edu.kit.archicorc2.Verification.Ports;
import edu.kit.archicorc2.Verification.ProviderType;
import edu.kit.archicorc2.core.util.PortTypeManager;
import edu.kit.archicorc2.core.localization.StringTable;
import edu.kit.archicorc2.core.synchronize.mapping.ProjectMapping;

public class CreatePortFeature extends AbstractCreateFeature implements ICreateFeature {
	public static final PortType pt = PortType.DATA;

	public CreatePortFeature(IFeatureProvider fp) {
		super(fp, StringTable.CREATE_PORT_NAME, StringTable.CREATE_PORT_DESC);
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
			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Module;
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {
		Ports addedObject = MmFactory.eINSTANCE.createPorts();

		addedObject.setType(pt);
		addedObject.setService(PortTypeManager.getTypes().get(0)); // use first element as default one
		
		PictogramElement pict = context.getTargetContainer();
		EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
		if (businessObjects.get(0) instanceof Module) {
			Module m = (Module) businessObjects.get(0);
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage activePage = window.getActivePage();

			IEditorPart activeEditor = activePage.getActiveEditor();

			if (activeEditor != null) {
				IEditorInput input = activeEditor.getEditorInput();

				IProject project = input.getAdapter(IProject.class);
				if (project == null) {
					IResource resource = input.getAdapter(IResource.class);
					if (resource != null) {
						project = resource.getProject();
					}
				}
				if (ProjectMapping.getMapPro().get(project).getMappingEntry(m).size() != 0) {
//					ProjectMapping.getMapPro().get(project).deleteMappingEntry(m);
//					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//					MessageDialog dialog = new MessageDialog(shell, StringTable.COMPONENT_USED, null,
//							StringTable.CREATE_PORT_NOT, MessageDialog.INFORMATION,
//							new String[] { "OK" }, 0);
//					dialog.open();
//					return null;
				}

			}
		}

		addedObject.setType(pt);
		Module expandWithPort = ((Module) businessObjects.get(0));
		String classname = StringTable.CREATE_PORT_DEFAULT_NAME + expandWithPort.getPorts().size();
		addedObject.setName(classname);

		addedObject.setLabel("");
		addedObject.setFunction("");
		addedObject.setFilter("");
		addedObject.setProviderType(ProviderType.NATIVE);
		addedObject.setMaxClients(-1);

		expandWithPort.getPorts().add(addedObject);
		AddContext contextAdd = new AddContext(context, addedObject);
		contextAdd.setTargetContainer(context.getTargetContainer());
		

		int widthContainer = (context.getTargetContainer().getGraphicsAlgorithm().getWidth());
		int calcPosX = context.getX();
		calcPosX = calcPosX - (widthContainer / 2);

		if (calcPosX < 0) {
			addedObject.setOuterDirection(DirectionType.INTERNAL);
		} else {
			addedObject.setOuterDirection(DirectionType.EXTERNAL);
		}

		addGraphicalRepresentation(contextAdd, addedObject);

		return new Object[] { addedObject };
	}


}
