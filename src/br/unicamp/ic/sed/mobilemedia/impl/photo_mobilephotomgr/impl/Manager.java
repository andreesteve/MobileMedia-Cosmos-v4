package br.unicamp.ic.sed.mobilemedia.impl.photo_mobilephotomgr.impl;
import java.util.*;
class Manager extends br.unicamp.ic.sed.cosmos.AManager{
	Hashtable requiredInterfaces = new Hashtable();
	Hashtable providedInterfaces = new Hashtable();
	public Manager() {
		setProvidedInterface("IPhoto", new IPhotoAdapter());
		setProvidedInterface("IMobilePhone", new IMobilePhoneAdapter());
		setRequiredInterfaceType("IPhoto", br.unicamp.ic.sed.mobilemedia.impl.photo.spec.prov.IPhoto.class);
		setRequiredInterfaceType("IMobilePhone", br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.spec.prov.IMobilePhone.class);
	}
	
	public Object getProvidedInterface(String name){
	   return this.providedInterfaces.get(name);
	}
	
	public void setRequiredInterface(String name, Object adapter){
		requiredInterfaces.put(name,adapter);
	}
	
	public Object getRequiredInterface(String name){
	   return requiredInterfaces.get(name);
	}
	public String[] getProvidedInterfaces() {
		Enumeration keys = this.providedInterfaces.keys();
		return this.convertEnumerationToArray(keys); 
	}
	public String[] getRequiredInterfaces() {
		Enumeration keys = this.requiredInterfaces.keys();
		return this.convertEnumerationToArray(keys);
	}
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
}