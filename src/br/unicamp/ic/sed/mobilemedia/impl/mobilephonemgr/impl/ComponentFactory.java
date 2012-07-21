/**
 * University of Campinas - Brazil
 * Institute of Computing
 * SED group
 *
 * date: February 2009
 * 
 */
package br.unicamp.ic.sed.mobilemedia.impl.mobilephonemgr.impl;

import br.unicamp.ic.sed.cosmos.IManager;


public class ComponentFactory {

	static br.unicamp.ic.sed.cosmos.IManager manager = null;

	public static br.unicamp.ic.sed.cosmos.IManager createInstance(){
		if(manager == null)
			manager = new Manager();
		
		return manager;
	}
}



