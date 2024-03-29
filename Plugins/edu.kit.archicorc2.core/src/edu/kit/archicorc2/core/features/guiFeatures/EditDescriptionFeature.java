package edu.kit.archicorc2.core.features.guiFeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;

import edu.kit.archicorc2.Verification.Module;
import edu.kit.archicorc2.core.localization.StringTable;
import edu.kit.archicorc2.ui.dialogs.ChangeDescriptionDialog;

public class EditDescriptionFeature extends AbstractCustomFeature {

	public EditDescriptionFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Module) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public String getName() {
		return StringTable.EDIT_DESCRIPTION_NAME;
	}

	@Override
	public String getDescription() {
		return StringTable.EDIT_ABSTRACT_DESC;
	}

	@Override
	public String getImageId() {
		return IPlatformImageConstants.IMG_ECLIPSE_INFORMATION;
	}

	@Override
	public boolean isAvailable(IContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		String description = "";

		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			description = ((Module) bo).getDescription();
			if (description == null)
				description = "";

			final ChangeDescriptionDialog dialog = new ChangeDescriptionDialog(null, "Description",
					"Please enter a description for '" + ((Module) bo).getName() + " " + ((Module) bo).getVersion()
							+ "'",
					description);
			dialog.open();
			final String descriptemp = dialog.getValue();
			if (!description.equals(descriptemp.trim())) {
				((Module) bo).setDescription(descriptemp.trim());
			}
		}

	}
}
