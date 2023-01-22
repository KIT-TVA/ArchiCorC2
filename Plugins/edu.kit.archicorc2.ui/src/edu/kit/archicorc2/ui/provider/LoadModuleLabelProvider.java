package edu.kit.archicorc2.ui.provider;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import edu.kit.archicorc2.Verification.Component;
import edu.kit.archicorc2.Verification.Compound;
import edu.kit.archicorc2.Verification.Module;
import edu.kit.archicorc2.ui.ImageProvider;

public class LoadModuleLabelProvider extends LabelProvider {

	private Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose();
		return scaled;
	}

	@Override
	public Image getImage(Object element) {
		Module m = (Module) element;
		String filename = "";

		if (m instanceof Compound) {
			filename = ImageProvider.IMG_ICON_COMPOUND_COMPONENT;
		} else if (m instanceof Component) {
			filename = ImageProvider.IMG_ICON_ATOMIC_COMPONENT;
		} else {
			return null;
		}

		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		URL url = FileLocator.find(bundle, new Path(filename), null);

		return resize(ImageDescriptor.createFromURL(url).createImage(), 16, 16);
	}

	@Override
	public String getText(Object element) {
		Module m = (Module) element;
		return m.getName() + " (" + m.getVersion() + ")";
	}
}
