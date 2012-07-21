/**
 * University of Campinas - Brazil
 * Institute of Computing
 * SED group
 *
 * date: February 2009
 * 
 */
package br.unicamp.ic.sed.mobilemedia.impl.photo.impl;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import br.unicamp.ic.sed.cosmos.IManager;
import br.unicamp.ic.sed.mobilemedia.impl.photo.spec.req.IExceptionHandler;
import br.unicamp.ic.sed.mobilemedia.impl.photo.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.impl.photo.spec.req.IMobilePhone;
import br.unicamp.ic.sed.mobilemedia.impl.photo.spec.req.IMobileResources;
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
	  return this.providedInterfaces.get(name);
	}
	
	public void setRequiredInterface(String name, Object facade){
		this.requiredInterfaces.put(name,facade);
	}
	
	public Object getRequiredInterface(String name){
	   return this.requiredInterfaces.get(name);
	}
	
	
public Manager()
{
    // provided interfaces
    setProvidedInterface("IPhoto", new IPhotoFacade());

    // required interfaces
    setRequiredInterfaceType("IExceptionHandler", IExceptionHandler.class);
    setRequiredInterfaceType("IFilesystem", IFilesystem.class);
    setRequiredInterfaceType("IMobilePhone", IMobilePhone.class);
    setRequiredInterfaceType("IMobileResources", IMobileResources.class);
}
}
