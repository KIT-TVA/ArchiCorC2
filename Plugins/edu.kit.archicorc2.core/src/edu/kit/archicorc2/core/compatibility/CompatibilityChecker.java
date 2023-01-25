package edu.kit.archicorc2.core.compatibility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.kit.archicorc2.core.compatibility.KeYCompatibilityProver.ProofResult;
import edu.kit.archicorc2.idl.cidl.Argument;
import edu.kit.archicorc2.idl.cidl.ContractPair;
import edu.kit.archicorc2.idl.cidl.Ensures;
import edu.kit.archicorc2.idl.cidl.Interface;
import edu.kit.archicorc2.idl.cidl.Method;
import edu.kit.archicorc2.idl.cidl.Requires;
import edu.kit.archicorc2.idl.cidl.TypeRef;

public class CompatibilityChecker {
	public static boolean horizontal(Interface provided, Interface required) {
		for (Method m : required.getMethods()) {
			if (!provided.getMethods().stream().map(elem -> elem.getName()).collect(Collectors.toList())
					.contains(m.getName())) {
				return false; // Required method not found
			}
			// Get matching method by name
			Method match = provided.getMethods().stream().filter(elem -> elem.getName().equals(m.getName())).findFirst()
					.get();
			// Check signature
			if (!checkSignature(m, match)) {
				return false;
			}
			// Check liskov
			if (!checkLiskov(m, match))
				return false;
		}
		return true;
	}

	public static boolean checkSignature(Method m1, Method m2) { // very simple check; no covariant/contravariant etc...
																	// signatures have to match exactly!
		if (m1.getInArgs().size() != m2.getInArgs().size() && m1.getOutArgs().size() != m2.getOutArgs().size()) {
			return false;
		}
		for (int i = 0; i < m1.getInArgs().size(); ++i) {
			if (!equalTypes(m1.getInArgs().get(i).getType(), m2.getInArgs().get(i).getType())) {
				return false;
			}
		}
		for (int i = 0; i < m1.getOutArgs().size(); ++i) {
			if (!equalTypes(m1.getOutArgs().get(i).getType(), m2.getOutArgs().get(i).getType())) {
				return false;
			}
		}
		return true;
	}

	public static boolean equalTypes(TypeRef t1, TypeRef t2) {
		if (t1.getDerived() != null) {
			if (t2.getDerived() == null)
				return false;
			return t2.getDerived().getName().equals(t1.getDerived().getName());
		}
		return t1.getPredefined().getName().equals(t2.getPredefined().getName());
	}

	public static boolean checkLiskov(Method m1, Method m2) { // very simple check; no covariant/contravariant etc...
																// signatures have to match exactly!
		//
//		System.out.println(new DummyJavaFileWriter(m1,m2).createJavaFileToText());
//		return false;
		String content = new DummyJavaFileWriter(m1, m2).createJavaFileToText();
		System.out.println(content);
		List<String> parameters = m1.getInArgs().stream().map(arg -> DummyJavaFileWriter.getType(arg.getType()))
				.collect(Collectors.toList());
		// int[] res =
		List<ProofResult> results = KeYCompatibilityProver.proveWithKeYByText(m1.getName() + "_m1",
				parameters.toArray(new String[0]), content);
		boolean result = true;
		for (ProofResult res : results) {
			switch (res.status) {
			case PROVEN: // Proven
				System.out.println(m1.getName() + " is correctly matched.");
				result = result && true;
				break;
			case INTERACTIVE:
				System.out.println(res.name + ": " + "Matching of " + m1.getName() + " and  " + m2.getName()
						+ " is interactively proven.");
				result = result && true;
				break;
			case TIMEOUT:
				System.out.println(res.name + ": " + "Matching of " + m1.getName() + " and  " + m2.getName()
						+ " leads to a timeout.");
				result = false;
				break;
			case OPEN_GOALS:
				System.out.println(res.name + ": " + "Matching of " + m1.getName() + " and  " + m2.getName()
						+ " leads to open goals.");
				result = false;
				break;
			case NOT_PROVEN:
				System.out.println(res.name + ": " + "Matching of " + m1.getName() + " and  " + m2.getName()
						+ " not provable (check syntax?).");
				result = false;
				break;
			case UNKNOWN:
				System.out.println(res.name + ": " + "Matching of " + m1.getName() + " and  " + m2.getName()
						+ " not provable due to unknown reasons.");
				result = false;
			}
		}

		return result;
	}

	static class DummyJavaFileWriter {
		private Method provider, consumer;

		public DummyJavaFileWriter(Method provider, Method consumer) {
			this.provider = provider;
			this.consumer = consumer;
		}

		public String createJavaFileToText() {
			StringBuffer buffer = new StringBuffer();
			buffer.append("package dummy;\n");
			buffer.append("public class Dummy {\n");
			for (Argument res : consumer.getOutArgs()) {
				buffer.append("\tpublic " + getType(res.getType()) + " " + res.getName() + "; // Result \n");
			}
			buffer.append("\n");
			buffer.append("\t/*@\n");

			List<String> args_signature = new ArrayList<String>(), args_input = new ArrayList<String>();
			for (Argument arg : provider.getInArgs()) {
				args_signature.add(getType(arg.getType()) + " " + arg.getName());
				args_input.add(arg.getName());
			}

			List<String> contracts = new ArrayList<String>();
			for (ContractPair contract : provider.getSpec().getContracts()) {
				String spec = "";
				for (Requires req : contract.getReq()) {
					spec += "\t@ requires " + toKeYExpression(req.getExpr().substring(1, req.getExpr().length() - 1))
							+ ";\n";
				}
				for (Ensures ens : contract.getEns()) {
					spec += "\t@ ensures " + toKeYExpression(ens.getExpr().substring(1, ens.getExpr().length() - 1))
							+ ";\n";
				}
				spec += "\t@ assignable \\everything;\n";
				contracts.add(spec);
			}
			buffer.append(String.join("\n  also  \n", contracts));
			buffer.append("\t@*/\n");
			buffer.append("\tpublic void " + provider.getName() + "_m1(" + String.join(",", args_signature) + ") {\n");
			buffer.append("\t\t" + provider.getName() + "_m2(" + String.join(",", args_input) + ");\n");
			buffer.append("\t}\n\n");

			buffer.append("\t/*@\n");
			contracts.clear();
			for (ContractPair contract : consumer.getSpec().getContracts()) {
				String spec = "";
				for (Requires req : contract.getReq()) {
					spec += "\t@ requires " + toKeYExpression(req.getExpr().substring(1, req.getExpr().length() - 1))
							+ ";\n";
				}
				for (Ensures ens : contract.getEns()) {
					spec += "\t@ ensures " + toKeYExpression(ens.getExpr().substring(1, ens.getExpr().length() - 1))
							+ ";\n";
				}
				spec += "\t@ assignable \\everything;\n";
				contracts.add(spec);
			}
			buffer.append(String.join("\n  also  \n", contracts));
			buffer.append("\t@*/\n");
			buffer.append("\tpublic void " + provider.getName() + "_m2(" + String.join(",", args_signature) + ") {\n");
			buffer.append("\t\t//[...]\n");
			buffer.append("\t}\n\n");

			buffer.append("}\n");

			return buffer.toString();
		}

		public static String toKeYExpression(String str) {
			str = str.replaceAll("=>", "==>");
			return str;
		}

		public static String getType(TypeRef typeRef) {
			if (typeRef.getDerived() != null) {
				return typeRef.getDerived().getName();
			}
//			else if(typeRef.getInterval() != null) { {
//				
//			} 
			else {
				switch (typeRef.getPredefined().getName()) {
				case "Int8":
				case "UInt8":
					return "byte";
				case "Int16":
				case "UInt16":
					return "short";
				case "Int32":
				case "UInt32":
					return "int";
				case "Int64":
				case "UInt64":
					return "long";
				case "Boolean":
					return "boolean";
				case "String":
					return "String";
				case "Float":
					return "float";
				case "Double":
					return "double";
				default:
					return "unknown";
				}
			}
		}
	}
}
