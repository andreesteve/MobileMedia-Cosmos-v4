package br.unicamp.ic.sed.mobilemedia.photo_exceptionhandler.impl;



public class ComponentFactory {

	private static IManager manager = null;

	public static IManager createInstance(){
	
		if (manager==null)
			manager = new Manager();
		
		return manager;
	}
}



