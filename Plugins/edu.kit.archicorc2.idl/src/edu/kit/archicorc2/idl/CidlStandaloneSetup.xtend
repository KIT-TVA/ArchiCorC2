/*
 * generated by Xtext 2.15.0
 */
package edu.kit.archicorc2.idl


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class CidlStandaloneSetup extends CidlStandaloneSetupGenerated {

	def static void doSetup() {
		new CidlStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}