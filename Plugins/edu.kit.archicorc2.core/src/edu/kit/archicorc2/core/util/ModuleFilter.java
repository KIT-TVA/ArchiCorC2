package edu.kit.archicorc2.core.util;

import edu.kit.archicorc2.Verification.Module;

public interface ModuleFilter {
	public boolean keep(Module m);
}
