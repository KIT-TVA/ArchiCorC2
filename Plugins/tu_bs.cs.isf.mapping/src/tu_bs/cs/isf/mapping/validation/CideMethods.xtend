package tu_bs.cs.isf.mapping.validation;

import edu.kit.archicorc2.Verification.Module
import edu.kit.archicorc2.Verification.Ports
import edu.kit.archicorc2.core.localization.StringTable
import edu.kit.archicorc2.core.util.CoreUtil
import edu.kit.archicorc2.idl.CidlPersistenceManager
import edu.kit.archicorc2.idl.cidl.ContractPair
import edu.kit.archicorc2.idl.cidl.Interface
import edu.kit.archicorc2.idl.cidl.Method
import edu.kit.archicorc2.idl.cidl.Model
import edu.kit.archicorc2.idl.cidl.impl.ModelImpl
import java.util.ArrayList
import java.util.Collection
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspace
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import tu_bs.cs.isf.mapping.mapping.Component
import tu_bs.cs.isf.mapping.mapping.ServiceMethod
import tu_bs.cs.isf.mapping.mapping.impl.ComponentImpl

class CideMethods {
	
	def static getInterfaces(IProject p){
		val Collection<EObject> objects = CidlPersistenceManager.getIdlModels(p)
		var List<Model> modelList = new ArrayList<Model>
		
		for (i : 0 ..< objects.size){
			val Model m = ModelImpl.cast(objects.get(i))
			modelList.add(m)

		}
		var List<Interface> interfaceList = new ArrayList<Interface>
		
		for (i : 0 ..< modelList.size){
			for(j : 0 ..< modelList.get(i).interfaces.size){
				val Interface in = modelList.get(i).interfaces.get(j)
				interfaceList.add(in)
			}
		}
		return interfaceList
	}
	
	
	def static List<ContractPair> getContractPair(ServiceMethod sm, String root, IWorkspace w){			
	if (sm.name.contains(".")){
			val String[] smParts = sm.name.split("\\.")
			val String portName = smParts.get(0)
			val String methodName = smParts.get(1)
			val EObject smComponent = sm.eContainer.eContainer
			val Component c = ComponentImpl.cast(smComponent)
			val String componentPath = FileFinder.path(c, c.name, root)
			val IFile f = FileFinder.file(componentPath, w)
		
			if (f.exists){
				val IProject p = f.project
				val Collection<Module> cm = CoreUtil.getRootModules(p)
			
				for	(i : 0 ..< cm.size){
					if (c.name.endsWith(StringTable.DIAGRAM_FILE_EXTENSION)){
						val String[] parts = c.name.split("\\.")
						//componentName without ".cide"
						var String name = parts.get(parts.size-2)
					
						if (name.contains("/")){
							val String[] parts2= name.split("/")
							name = parts2.get(parts2.size-1)
						}
					
						//current Module
						if(name.equals(cm.get(i).name)){
							val EList<Ports> ports = cm.get(i).ports
						
							for (j : 0 ..< ports.size){
								if ((portName.equals(ports.get(j).name)) && (ports.get(j).type.getName.equals("SERVICE"))){
									val List<Interface> interfaces = getInterfaces(p)
								
									for	(k : 0 ..< interfaces.size){
										if (interfaces.get(k).name.equals(ports.get(j).service)){
											val EList<Method> methods = interfaces.get(k).methods
										
											for (l : 0 ..< methods.size){
												if (methods.get(l).name.equals(methodName)){
													var List<ContractPair> contractPairs = new ArrayList<ContractPair>
													for (m : 0 ..< methods.get(l).spec.contracts.size) {
														val ContractPair contractPair = methods.get(l).spec.contracts.get(m)
														contractPairs.add(contractPair)
														
														//for (n : 0 ..< contractPair.req.size) {
														//	val String require = contractPair.req.get(n).expr
														//	val String ensure = contractPair.ens.get(n).expr
														//	Console.println(require+"#"+ensure)
														//
														//}
													}
													return contractPairs
												}
											}
										}	
									
									}
								} 
							}
							
						}
					}
				}
			}
		}
	}
}