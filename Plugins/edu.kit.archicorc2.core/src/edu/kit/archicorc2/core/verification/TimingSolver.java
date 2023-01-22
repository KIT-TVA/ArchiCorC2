package edu.kit.archicorc2.core.verification;

import java.util.ArrayList;

import edu.kit.archicorc2.Verification.Module;
import edu.kit.archicorc2.ui.views.verification.VerificationViewElement;

public class TimingSolver implements IViewpointSolver {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Timing Viewpoint";
	}

	@Override
	public boolean checkRealizability(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkConsistency(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkWellFormedness(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkSubstitutability(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<VerificationViewElement> getSummary() {
		// TODO Auto-generated method stub
		return null;
	}

}
