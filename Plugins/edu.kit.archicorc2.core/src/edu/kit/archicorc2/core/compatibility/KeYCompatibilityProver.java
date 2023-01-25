package edu.kit.archicorc2.core.compatibility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.key_project.util.collection.ImmutableArray;
import org.key_project.util.collection.ImmutableSet;

import de.uka.ilkd.key.control.KeYEnvironment;
import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.logic.op.IObserverFunction;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.init.ProofInputException;
import de.uka.ilkd.key.proof.io.ProblemLoaderException;
import de.uka.ilkd.key.proof.mgt.SpecificationRepository;
import de.uka.ilkd.key.settings.ChoiceSettings;
import de.uka.ilkd.key.settings.ProofSettings;
import de.uka.ilkd.key.speclang.Contract;
import de.uka.ilkd.key.strategy.StrategyProperties;
import de.uka.ilkd.key.util.MiscTools;

public class KeYCompatibilityProver {
	static int maxSteps = 20000;

//	
//	public int[] provePreCideCorc() {
//		File location = createProvePreCideCorcWithKey(method, cidePre, corcPre, corcVars, corcConds, corcRenaming, uri, 0, true);
//		return proveWithKey(location);
//	}
//
//	@Override
//	public int[] provePostCorcCide() {
//		File location = createProvePostCorcCideWithKey(method, cidePost, corcPost, corcVars, corcConds, corcRenaming, uri, 1, true);
//		return proveWithKey(location);
//	}

	// status: 0 - proven, 1 - interactively proven, 2 - Timeout, 3 - OpenGoals, 4 -
	// not proven (doesn't exists in KeY), 5 - unknown

	public static class ProofResult {
		public enum Status {
			PROVEN, INTERACTIVE, TIMEOUT, OPEN_GOALS, NOT_PROVEN, UNKNOWN
		}

		public String name;
		public Status status;
		public int steps;
		public long time;

		public ProofResult(String name, Status status, int steps, long l) {
			this.name = name;
			this.status = status;
			this.steps = steps;
			this.time = l;
		}
	}

	public static List<ProofResult> proveWithKeYByText(String name, String[] parameters, String content) {
//		final long timeStart = System.currentTimeMillis();
//		long timeEnd = System.currentTimeMillis();
//		List<ProofResult> proofresults = new ArrayList<ProofResult>();

		final String PREF = "DummyFile";
		final String SUFF = ".java";
		File tmpfile = null;
		try {
			tmpfile = File.createTempFile(PREF, SUFF);
			tmpfile.deleteOnExit();

			FileWriter writer = new FileWriter(tmpfile);
			writer.write(content);

			writer.close();

			System.out.println("Java file created: " + tmpfile.getAbsolutePath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//List<ProofResult> proofs = createKeYProofInstanceByText(name, parameters, tmpfile);
		return createKeYProofInstanceByText(name, parameters, tmpfile);
//		for (ProofResult pres : proofs) {
//
//			// results[0] = status, results[1] = steps, results[2] = time
//			int[] results = { 5, 0, 0 };
//			// ProofResult pres = new ProofResult(proof.name().toString(),
//			// ProofResult.Status.UNKNOWN, 0, 0);
//			if (proof != null) {
//				boolean closed = proof.openGoals().isEmpty();
//				if (!closed) {
//					int steps = proof.countNodes();
//					if (steps >= maxSteps) {
//						pres.status = ProofResult.Status.TIMEOUT;
//						pres.steps = steps;
//						timeEnd = System.currentTimeMillis();
//					} else {
//						MainWindow.getInstance().loadProblem(tmpfile);
//						MainWindow.getInstance().setVisible(true);
//						while (MainWindow.getInstance().isShowing()) {
//							try {
//								Thread.sleep(1000);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//						}
//						if (proof.openGoals().isEmpty()) {
//							pres.status = ProofResult.Status.INTERACTIVE;
//							pres.steps = steps;
//							timeEnd = System.currentTimeMillis();
//						} else {
//							pres.status = ProofResult.Status.OPEN_GOALS;
//							pres.steps = steps;
//							timeEnd = System.currentTimeMillis();
//						}
//
//					}
//
//				} else {
//					pres.status = ProofResult.Status.PROVEN;
//					int steps = proof.countNodes();
//					pres.steps = steps;
//					timeEnd = System.currentTimeMillis();
//				}
//
//			}
//
//			final long timeLong = timeEnd - timeStart;
//			int time = (int) timeLong;
//			pres.time = time;
//
//			proofresults.add(pres);
//		}
//		return proofresults;
	}

	private static IProject getProject(URI uri) {
		uri = uri.trimFragment();
		String uriPath = uri.toPlatformString(true);
		uriPath = uriPath.substring(1, uriPath.length());
		int positionOfSlash = uriPath.indexOf('/') + 1;
		uriPath = uriPath.substring(positionOfSlash, uriPath.length());
		IProject thisProject = null;
		for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (p.getFile(new Path(uriPath)).exists()) {
				thisProject = p;
			}
		}
		return thisProject;
	}

	private static List<ProofResult> createKeYProofInstanceByText(String name, String[] parameters, File tmpfile) {
		Proof proof = null;
		List<File> classPaths = null; // Optionally: Additional specifications
										// for API classes
		File bootClassPath = null; // Optionally: Different default
									// specifications for Java API
		List<File> includes = null; // Optionally: Additional includes to
									// consider

		List<ProofResult> proofresultss = new ArrayList<ProofResult>();

		// Ensure that Taclets are parsed
		if (!ProofSettings.isChoiceSettingInitialised()) {
			KeYEnvironment<?> env = null;
			try {
				env = KeYEnvironment.load(tmpfile, classPaths, bootClassPath, includes);
			} catch (ProblemLoaderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			env.dispose();
		}
		// Set Taclet options
		ChoiceSettings choiceSettings = ProofSettings.DEFAULT_SETTINGS.getChoiceSettings();
		HashMap<String, String> oldSettings = choiceSettings.getDefaultChoices();
		HashMap<String, String> newSettings = new HashMap<String, String>(oldSettings);
		newSettings.putAll(MiscTools.getDefaultTacletOptions());
		newSettings.put("runtimeExceptions", "runtimeExceptions:ban");
		choiceSettings.setDefaultChoices(newSettings);
		// Load source code
		KeYEnvironment<?> env;

		try {

			env = KeYEnvironment.load(tmpfile, classPaths, bootClassPath, includes);

			try {
				KeYJavaType type = env.getJavaInfo().getKeYJavaType("dummy.Dummy");
				// Set<KeYJavaType> allTypes = env.getJavaInfo().getAllKeYJavaTypes();
				final List<Contract> proofContracts = getCorrectContract(name, parameters,
						env.getSpecificationRepository(), type);
				for (Contract contract : proofContracts) {
					// currentResults.add(getResult(env, contract, so));

					proofresultss.add(generateProofResult(env, contract, tmpfile));

				}
			} catch (ProofInputException e) {
				e.printStackTrace();
			} finally {
				env.dispose();
			}

//				final List<Contract> proofContracts = new LinkedList<Contract>();
//				Set<KeYJavaType> kjts = env.getJavaInfo().getAllKeYJavaTypes();
//
//				for (KeYJavaType type : kjts) {
//					if (!KeYTypeUtil.isLibraryClass(type)) {
//						ImmutableSet<IObserverFunction> targets = env.getSpecificationRepository()
//								.getContractTargets(type);
//						for (IObserverFunction target : targets) {
//							ImmutableSet<Contract> contracts = env.getSpecificationRepository().getContracts(type,
//									target);
//							for (Contract contract : contracts) {
//								proofContracts.add(contract);
//							}
//						}
//					}
//				}
//				
//				SpecificationRepository spec = env.getSpecificationRepository();
//
//				for (Contract contract : proofContracts) {
//					proof = null;
//					try {
//						// Create proof
//						proof = env.createProof(contract.createProofObl(env.getInitConfig(), contract));
//						// Set proof strategy options
//						StrategyProperties sp = proof.getSettings().getStrategySettings().getActiveStrategyProperties();
//						sp.setProperty(StrategyProperties.METHOD_OPTIONS_KEY, StrategyProperties.METHOD_CONTRACT);
//						sp.setProperty(StrategyProperties.DEP_OPTIONS_KEY, StrategyProperties.DEP_ON);
//						sp.setProperty(StrategyProperties.QUERY_OPTIONS_KEY, StrategyProperties.QUERY_ON);
//						sp.setProperty(StrategyProperties.NON_LIN_ARITH_OPTIONS_KEY,
//								StrategyProperties.NON_LIN_ARITH_DEF_OPS);
//						sp.setProperty(StrategyProperties.STOPMODE_OPTIONS_KEY, StrategyProperties.STOPMODE_NONCLOSE);
//						proof.getSettings().getStrategySettings().setActiveStrategyProperties(sp);
//						// Make sure that the new options are used
//						int maxSteps = 10000;
//						ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setMaxSteps(maxSteps);
//						ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setActiveStrategyProperties(sp);
//						proof.getSettings().getStrategySettings().setMaxSteps(maxSteps);
//						proof.setActiveStrategy(
//								proof.getServices().getProfile().getDefaultStrategyFactory().create(proof, sp));
//						// Start auto mode
//						env.getUi().getProofControl().startAndWaitForAutoMode(proof);
//						// Show proof result
//						boolean closed = proof.openGoals().isEmpty();
//						System.out.println("Contract '" + contract.getDisplayName() + "' of " + contract.getTarget()
//								+ " is " + (closed ? "verified" : "still open") + ".");
//					} catch (ProofInputException e) {
//						System.out.println(
//								"Exception at '" + contract.getDisplayName() + "' of " + contract.getTarget() + ":");
//						e.printStackTrace();
//					} finally {
//						if (proof != null) {
//							proof.dispose(); // Ensure always that all instances of Proof are disposed
//						}
//					}
//				}
//			} finally {
//				env.dispose(); // Ensure always that all instances of KeYEnvironment are disposed
//			}
		} catch (ProblemLoaderException e) {
			System.out.println("Exception at '" + tmpfile + "':");
			e.printStackTrace();
		}

		return proofresultss;

	}

	// TODO remove proof instance -> create results...
	public static ProofResult generateProofResult(KeYEnvironment<?> env, Contract c, File tmpfile)
			throws ProofInputException {
		final long timeStart = System.currentTimeMillis();
		long timeEnd = System.currentTimeMillis();
		Proof proof = null;
		try {
			proof = env.createProof(c.createProofObl(env.getInitConfig(), c));

			// applySettings(proof, so);
			StrategyProperties sp = proof.getSettings().getStrategySettings().getActiveStrategyProperties();
			sp.setProperty(StrategyProperties.METHOD_OPTIONS_KEY, StrategyProperties.METHOD_CONTRACT);
			sp.setProperty(StrategyProperties.DEP_OPTIONS_KEY, StrategyProperties.DEP_ON);
			sp.setProperty(StrategyProperties.QUERY_OPTIONS_KEY, StrategyProperties.QUERY_ON);
			sp.setProperty(StrategyProperties.NON_LIN_ARITH_OPTIONS_KEY, StrategyProperties.NON_LIN_ARITH_DEF_OPS);
			sp.setProperty(StrategyProperties.STOPMODE_OPTIONS_KEY, StrategyProperties.STOPMODE_NONCLOSE);
			proof.getSettings().getStrategySettings().setActiveStrategyProperties(sp);
			// Make sure that the new options are used
			int maxSteps = 10000;
			ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setMaxSteps(maxSteps);
			ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setActiveStrategyProperties(sp);
			proof.getSettings().getStrategySettings().setMaxSteps(maxSteps);
			proof.setActiveStrategy(proof.getServices().getProfile().getDefaultStrategyFactory().create(proof, sp));
			// Start auto mode

			env.getUi().getProofControl().startAndWaitForAutoMode(proof);
			ProofResult pres = new ProofResult(proof.name().toString(), ProofResult.Status.UNKNOWN, 0, 0);
			if (proof != null) {
				boolean closed = proof.openGoals().isEmpty();
				System.out.println("Contract '" + c.getDisplayName() + "' of " + c.getTarget() + " is "
						+ (closed ? "verified" : "still open") + ".");

				if (!closed) {
					int steps = proof.countNodes();
					if (steps >= maxSteps) {
						pres.status = ProofResult.Status.TIMEOUT;
						pres.steps = steps;
						timeEnd = System.currentTimeMillis();
					} else {
						final String PREF = "DummyPartialProof";
						final String SUFF = ".key";
						File tmpfile2 = null;
						try {
							tmpfile2 = File.createTempFile(PREF, SUFF);

							proof.saveToFile(tmpfile2);

							System.out.println("Saved partial proof for interactive session: " + tmpfile2.getAbsolutePath());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// MainWindow.getInstance().loadProblem(tmpfile2); //--> partial proof
						MainWindow.getInstance().loadProblem(tmpfile); //--> new proof
						MainWindow.getInstance().setVisible(true);
						while (MainWindow.getInstance().isShowing()) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						proof = MainWindow.getInstance().getMediator().getSelectedProof();
						//proof.setProofFile(tmpfile2);

						if (proof.openGoals().isEmpty()) {
							pres.status = ProofResult.Status.INTERACTIVE;
							pres.steps = steps;
							timeEnd = System.currentTimeMillis();
						} else {
							pres.status = ProofResult.Status.OPEN_GOALS;
							pres.steps = steps;
							timeEnd = System.currentTimeMillis();
						}

					}

				} else {
					pres.status = ProofResult.Status.PROVEN;
					int steps = proof.countNodes();
					pres.steps = steps;
					timeEnd = System.currentTimeMillis();
				}

			}

			final long timeLong = timeEnd - timeStart;
			int time = (int) timeLong;
			pres.time = time;

			//proofresults.add(pres);

			if (pres.status != ProofResult.Status.PROVEN) {
				final String PREF = "DummyProof";
				final String SUFF = ".key";
				File tmpfile2 = null;
				try {
					tmpfile2 = File.createTempFile(PREF, SUFF);

					proof.saveToFile(tmpfile2);

					System.out.println("Saved unclosed proof: " + tmpfile2.getAbsolutePath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

//			// Show proof result
////		try {
////			proof.saveToFile(tmpfile);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}

			return pres;
		} finally {
			if (proof != null) {
				proof.dispose(); // Ensure always that all instances of Proof
									// are disposed
			}
		}
	}

	private static List<Contract> getCorrectContract(String methodName, String[] parameter,
			SpecificationRepository specRepo, KeYJavaType kjt) {

		List<Contract> proofContracts = new LinkedList<Contract>();
		IObserverFunction function = getCorrectIObserverFunction(methodName, parameter, specRepo, kjt);
		ImmutableSet<Contract> contracts = specRepo.getContracts(kjt, function);
		for (Contract contract : contracts) {
			proofContracts.add(contract);
		}
		return proofContracts;
	}

	private static IObserverFunction getCorrectIObserverFunction(String methodName, String[] parameter,
			SpecificationRepository specRepo, KeYJavaType kjt) {
		ImmutableSet<IObserverFunction> targets = specRepo.getContractTargets(kjt);
		top: for (IObserverFunction iObserverFunction : targets) {
			boolean b = iObserverFunction.name().toString().endsWith("::" + methodName);
			if (b) {
				if (parameter == null) {
					return iObserverFunction;
				} else {
					ImmutableArray<KeYJavaType> kjts = iObserverFunction.getParamTypes();
					if (kjts.size() == parameter.length) {
						for (int i = 0; i < parameter.length; i++) {
							if (!kjts.get(i).getFullName().equals(parameter[i]))
								continue top;
						}
						return iObserverFunction;
					}
				}
			}
		}
		throw new IllegalArgumentException("Could not find contract for method " + methodName);
	}
//		proof = env.getLoadedProof();
//		// Set proof strategy options
//		StrategyProperties sp = proof.getSettings().getStrategySettings().getActiveStrategyProperties();
//		sp.setProperty(StrategyProperties.METHOD_OPTIONS_KEY, StrategyProperties.METHOD_CONTRACT);
//		sp.setProperty(StrategyProperties.LOOP_OPTIONS_KEY, StrategyProperties.LOOP_EXPAND);
//		sp.setProperty(StrategyProperties.DEP_OPTIONS_KEY, StrategyProperties.DEP_ON);
//		sp.setProperty(StrategyProperties.QUERY_OPTIONS_KEY, StrategyProperties.QUERY_RESTRICTED);// StrategyProperties.QUERY_ON
//		sp.setProperty(StrategyProperties.NON_LIN_ARITH_OPTIONS_KEY, StrategyProperties.NON_LIN_ARITH_DEF_OPS);
//		sp.setProperty(StrategyProperties.STOPMODE_OPTIONS_KEY, StrategyProperties.STOPMODE_NONCLOSE);
//		proof.getSettings().getStrategySettings().setActiveStrategyProperties(sp);
//		// Make sure that the new options are used
//
//		ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setMaxSteps(maxSteps);
//		ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setActiveStrategyProperties(sp);
//		proof.getSettings().getStrategySettings().setMaxSteps(maxSteps);
//		proof.setActiveStrategy(proof.getServices().getProfile().getDefaultStrategyFactory().create(proof, sp));
//		// Start auto mode
//		final long timeStart = System.currentTimeMillis();
//		env.getUi().getProofControl().startAndWaitForAutoMode(proof);
//		final long timeEnd = System.currentTimeMillis();
//		long time = timeEnd - timeStart;
//		// Console.println(time);
//		// Show proof result
////			try {
////				proof.saveToFile(tmpfile);
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
//	}catch(
//
//	ProblemLoaderException e)
//	{
//			e.printStackTrace();
//		}return proof;
//}

}
