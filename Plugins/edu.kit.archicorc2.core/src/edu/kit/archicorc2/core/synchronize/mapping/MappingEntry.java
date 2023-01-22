package edu.kit.archicorc2.core.synchronize.mapping;

import edu.kit.archicorc2.Verification.Module;

public class MappingEntry {
	public MappingEntry(Module instance, Module original) {
		this.instance=instance;
		this.original=original;
	}

	Module instance;
	public Module getInstance() {
		return instance;
	}
	public void setInstance(Module instance) {
		this.instance = instance;
	}
	public Module getOriginal() {
		return original;
	}
	public void setOriginal(Module original) {
		this.original = original;
	}

	Module original;

}
