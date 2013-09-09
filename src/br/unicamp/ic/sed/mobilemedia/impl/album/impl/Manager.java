package br.unicamp.ic.sed.mobilemedia.impl.album.impl;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.ControllerInterface;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IExceptionHandler;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IMobilePhone;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IMobileResources;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IPhoto;
class Manager extends br.unicamp.ic.sed.cosmos.AManager{
	private Hashtable requiredInterfaces = new Hashtable();
	private Hashtable providedInterfaces = new Hashtable();
	
	private IAlbumFacade facade;
	
	public Object getProvidedInterface(String name){
	   if (name.equals("IAlbum")){
		   if( facade == null )
			   facade =  new IAlbumFacade( );
		   return facade;
	   }
	   
	   return null;
	}
	
	public void setRequiredInterface(String name, Object facade){
		this.requiredInterfaces.put(name,facade);
	}
	
	public Object getRequiredInterface(String name){
	   return this.requiredInterfaces.get(name);
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
public Manager()
{
    // provided interfaces
    setProvidedInterface("IAlbum", new IAlbumFacade());

    // required interfaces
    setRequiredInterfaceType("ControllerInterface", ControllerInterface.class);
    setRequiredInterfaceType("IExceptionHandler", IExceptionHandler.class);
    setRequiredInterfaceType("IFilesystem", IFilesystem.class);
    setRequiredInterfaceType("IMobilePhone", IMobilePhone.class);
    setRequiredInterfaceType("IMobileResources", IMobileResources.class);
    setRequiredInterfaceType("IPhoto", IPhoto.class);
}
}