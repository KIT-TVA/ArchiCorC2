package edu.kit.archicorc2.ui.views;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;

import edu.kit.archicorc2.Verification.Module;
import edu.kit.archicorc2.Verification.Ports;
import edu.kit.archicorc2.ui.views.enviromentalView.EnviromentalView;
import edu.kit.archicorc2.ui.views.verification.VerificationTopElement;
import edu.kit.archicorc2.ui.views.verification.VerificationView;
import edu.kit.archicorc2.ui.views.verification.VerificationViewElement;

public class ViewUtil {
	public static void updateViews(EObject obj) {
		IViewReference[] ref = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (IViewReference iViewReference : ref) {
			if (iViewReference.getId().equals("archicorc2.views.moduleproperties")) {// TODO rework, bit too hacky
				TreeViewer view = ((ModulePropertiesView) iViewReference.getView(true)).getViewer();
				if (view.getInput() == null || !view.getInput().equals(obj)) {
					view.setInput(obj);
				}
				view.refresh();
			} else if (iViewReference.getId().equals("archicorc2.views.envprops")) {
				TableViewer view = ((EnviromentalView) iViewReference.getView(true)).getViewer();
				if (view.getInput() == null || !view.getInput().equals(obj)&&obj instanceof Module) {
					view.setInput(obj);
				}
				else if (view.getInput() == null || !view.getInput().equals(obj)&&obj instanceof Ports) {
					view.setInput(((Ports) obj).getModule());
				}
				view.refresh();
			}
		}
	}

	public static void updateVerificationView(List<VerificationTopElement> obj) {
		IViewReference[] ref = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (IViewReference iViewReference : ref) {
			if (iViewReference.getId().equals("archicorc2.views.verification")) {// TODO rework, bit too hacky
				TreeViewer view = ((VerificationView) iViewReference.getView(true)).getViewer();
				if (view.getInput() == null || !view.getInput().equals(obj)) {
					view.setInput(obj);
				}
				view.refresh();
			}
		}
	}
}
