package br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr_photo.impl;
import java.util.*;

class Manager extends br.unicamp.ic.sed.cosmos.AManager{
	Hashtable reqInterfaceMap = new Hashtable();
	public String[] getProvidedInterfaces(){
		Vector provInterfaceList = new Vector();
		provInterfaceList.addElement("IFilesystem");
	     
	   
	   return convertListToArray(provInterfaceList.elements());
	}
	
	public String[] getRequiredInterfaces(){
	
		return convertListToArray(reqInterfaceMap.keys());
	}
	
	public Object getProvidedInterface(String name){
	   if (name.equals("IFilesystem")){
	   		return new IAdapterFilesystemPhoto();
	   }
	   
	   return null;
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
	setProvidedInterface("IFilesystem", new IAdapterFilesystemPhoto());
    // required interfaces
	setRequiredInterfaceType("IFilesystem", br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem.class);
}
}