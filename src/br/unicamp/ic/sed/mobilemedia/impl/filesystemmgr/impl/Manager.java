package br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.impl;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
class Manager extends br.unicamp.ic.sed.cosmos.AManager{
	Hashtable requiredInterfaces = new Hashtable();
	Hashtable providedInterfaces = new Hashtable();

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
		/* if (name.equals("IFilesystem")){
	   		return new IFilesystemFacade();
	   }
	   return null;*/
		return this.providedInterfaces.get(name);
	}
	public void setRequiredInterface(String name, Object facade){
		requiredInterfaces.put(name,facade);
	}
	public Object getRequiredInterface(String name){
		return requiredInterfaces.get(name);
	}
	private String[] convertListToArray(Enumeration stringEnum){
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
public Manager()
{
    // provided interfaces
    setProvidedInterface("IFilesystem", new IFilesystemFacade());

    // required interfaces
}
}