package br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler_album.impl;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
class Manager extends br.unicamp.ic.sed.cosmos.AManager{
	Hashtable reqInterfaceMap = new Hashtable();
	Hashtable provInterfaceMap = new Hashtable();
	
	
	public String[] getProvidedInterfaces(){
	   Vector provInterfaceList = new Vector();
	  provInterfaceList.addElement("IAdapterAlbumEH");
	     
	   
	   return convertListToArray(provInterfaceList.elements());
	}
	
	public String[] getRequiredInterfaces(){
	
		return convertListToArray(reqInterfaceMap.keys());
	}
	
	public Object getProvidedInterface(String name){
		return this.provInterfaceMap.get( name );
	  
	}
	
	public void setRequiredInterface(String name, Object adapter){
		reqInterfaceMap.put(name,adapter);
	}
	
	public Object getRequiredInterface(String name){
	   return reqInterfaceMap.get(name);
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
	setProvidedInterface("IExceptionHandler", new IAdapterAlbumEH());
    // required interfaces
	setRequiredInterfaceType("IExceptionHandler", br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.spec.prov.IExceptionHandler.class);
}
}
