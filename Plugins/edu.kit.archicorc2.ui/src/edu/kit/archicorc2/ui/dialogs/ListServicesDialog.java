package edu.kit.archicorc2.ui.dialogs;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import edu.kit.archicorc2.idl.cidl.Interface;

public class ListServicesDialog extends ElementListSelectionDialog {

	public ListServicesDialog(Shell parent, ILabelProvider renderer, String dialogTitle, String dialogMessage, List<Interface> services) {
		super(parent, renderer);
		
		setTitle(dialogTitle);
		setMessage(dialogMessage);
		setMultipleSelection(false);
		setElements(services.toArray());
	}

}
