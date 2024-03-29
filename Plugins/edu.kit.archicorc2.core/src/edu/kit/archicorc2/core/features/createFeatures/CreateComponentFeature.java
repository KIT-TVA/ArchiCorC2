package edu.kit.archicorc2.core.features.createFeatures;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import general.SaveDomainModel;
import edu.kit.archicorc2.Verification.Component;
import edu.kit.archicorc2.Verification.Compound;
import edu.kit.archicorc2.Verification.MmFactory;
import edu.kit.archicorc2.core.localization.StringTable;

public class CreateComponentFeature extends AbstractCreateFeature implements ICreateFeature {

	private static final String TITLE = "Create class";

	private static final String USER_QUESTION = "Enter new class name";

	public CreateComponentFeature(IFeatureProvider fp) {
		// set name and description of the creation feature
		super(fp, StringTable.CREATE_COMPONENT_NAME, StringTable.CREATE_COMPONENT_DESC);
	}

	public boolean canCreate(ICreateContext context) {
		if (context.getTargetContainer() instanceof Diagram) {
			return true;
		}
		if (context.getTargetContainer() instanceof ContainerShape) {
			PictogramElement pict = context.getTargetContainer();
			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Compound;
		}
		return false;
	}

	public Object[] create(ICreateContext context) {
		
//		String classname = JOptionPane.showInputDialog(null, "Name the Component");
//		String description = JOptionPane.showInputDialog(null, "Set the Descritption");
		// Frame frame = null;
		// FileDialog dialog = new FileDialog(frame, "Ressource", FileDialog.LOAD);
		// dialog.show();
		//
		// String result = dialog.getFile();
		Component newClass = MmFactory.eINSTANCE.createComponent();
		newClass.setName(StringTable.CREATE_COMPONENT_DEFAULT_NAME);
		newClass.setDescription(StringTable.CREATE_COMPONENT_DEFAULT_DESC);
		try {
			SaveDomainModel.saveToModelFile(newClass, getDiagram());
		} catch (CoreException | IOException e) {
			JOptionPane.showConfirmDialog(null, "Fehler");
		}

		// newClass.setName(newClassName);

		// do the add
		addGraphicalRepresentation(context, newClass);

		// return newly created business object(s)
		return new Object[] { newClass };
	}
}