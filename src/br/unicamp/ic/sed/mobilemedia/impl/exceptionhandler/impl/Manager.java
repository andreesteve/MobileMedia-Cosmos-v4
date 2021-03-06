package br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.impl;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.spec.req.IMobileResources;
class Manager extends br.unicamp.ic.sed.cosmos.AManager{
	Hashtable providedInterfaces;
	Hashtable requiredInterfaces;

	
	
	private String[] convertEnumerationToArray(Enumeration stringEnum){
		Vector stringVector = new Vector();
		for (Enumeration iter = stringEnum; iter.hasMoreElements();) {
			String element = (String) iter.nextElement();
			stringVector.addElement(element);
		}
		
		String[] stringArray = new String[stringVector.size()];
		for (int i=0; i < stringVector.size(); i++){
			stringArray[i] = (String) stringVector.elementAt(i);
		}
		return stringArray;
	}
	
	public String[] getProvidedInterfaces() {
		Enumeration keys = this.providedInterfaces.keys();
		return this.convertEnumerationToArray(keys); 
	}
	public String[] getRequiredInterfaces() {
		Enumeration keys = this.requiredInterfaces.keys();
		return this.convertEnumerationToArray(keys);
	}
	
	
	
	public Object getProvidedInterface(String name){
		return this.providedInterfaces.get(name);
	}
	
	public Object getRequiredInterface(String name){
		return this.requiredInterfaces.get(name);
	}
	public void setProvidedInterface(String name, Object facade){
		this.providedInterfaces.put(name, facade);
	}
	public void setRequiredInterface(String name,Object facade){
		this.requiredInterfaces.put(name, facade);
	}
	
	
public Manager()
{
    // provided interfaces
    setProvidedInterface("IExceptionHandler", new IExceptionHandlerFacade());

    // required interfaces
    setRequiredInterfaceType("IMobileResources", IMobileResources.class);
}
}