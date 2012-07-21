package br.unicamp.ic.sed.mobilemedia.photo.impl;

import br.unicamp.ic.sed.cosmos.IManager;

public class ComponentFactory {

	private static IManager manager = null;

	public static IManager createInstance(){
	
		if (manager==null)
			manager = new Manager();
		
		return manager;
	}
}



