package edu.kit.archicorc2.core.features.guiFeatures;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import edu.kit.archicorc2.core.util.PortTypeManager;
import edu.kit.archicorc2.edl.events.EventType;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import edu.kit.archicorc2.Verification.DirectionType;
import edu.kit.archicorc2.Verification.Module;
import edu.kit.archicorc2.Verification.Ports;
import edu.kit.archicorc2.core.localization.StringTable;
import edu.kit.archicorc2.core.synchronize.mapping.ProjectMapping;
import edu.kit.archicorc2.core.util.CoreUtil;
import edu.kit.archicorc2.idl.CidlPersistenceManager;
import edu.kit.archicorc2.idl.cidl.Interface;
import edu.kit.archicorc2.idl.cidl.Model;
import edu.kit.archicorc2.ui.dialogs.EditConsumerPortFeatureDialog;
import edu.kit.archicorc2.ui.dialogs.EditPortFeatureDialog;
import edu.kit.archicorc2.ui.dialogs.EditProviderPortFeatureDialog;
import edu.kit.archicorc2.edl.EdlPersistenceManager;

public class EditPortFeature extends AbstractCustomFeature {
	private boolean changed = true;

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Ports) {
				Module m = ((Ports) bo).getModule();
				ret = (m.getModule() == null);
			}
		}
		return ret;
	}

	public EditPortFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Object object = getBusinessObjectForPictogramElement(pes[0]);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		// get all interfaces from all models
		List<Interface> interfaces = CidlPersistenceManager.getIdlModels(CoreUtil.getCurrentProject()).stream()
				.map(m -> ((Model) m).getInterfaces()).flatMap(i -> i.stream()).collect(Collectors.toList());

		List<EventType> events = EdlPersistenceManager.getEdlModels(CoreUtil.getCurrentProject()).stream()
				.map(m -> ((edu.kit.archicorc2.edl.events.Model) m).getEventCollection()).flatMap(i -> i.stream())
				.collect(Collectors.toList());

		// get all allowed java types for the ports
		List<String> types = PortTypeManager.getTypes();

		EditPortFeatureDialog dialog;
		if (((Ports) object).getOuterDirection() == DirectionType.INTERNAL)
			dialog = new EditConsumerPortFeatureDialog(shell, types, interfaces, events);
		else
			dialog = new EditProviderPortFeatureDialog(shell, types, interfaces, events);

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
			if (ProjectMapping.getMapPro().get(project).getMappingEntry(((Ports) object).getModule()).size() > 0) {

				MessageBox dialog2 = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
				dialog2.setText(StringTable.COMPONENT_USED);
				dialog2.setMessage(StringTable.EDIT_PORT_WINDOW_TEXT);

				// open dialog and await user selection
				int returnCode = dialog2.open();
				if (returnCode == SWT.OK) {
					dialog.setOldProperties(object);
					dialog.create();
					dialog.open();
					changed = dialog.getReturnCode() == EditPortFeatureDialog.OK;
				}

			} else {
				dialog.setOldProperties(object);
				dialog.create();
				dialog.open();
				changed = dialog.getReturnCode() == EditPortFeatureDialog.OK;
			}
		}

		changed = dialog.getReturnCode() == EditPortFeatureDialog.OK;
	}

	@Override
	public boolean hasDoneChanges() {
		return changed;
	}
}
