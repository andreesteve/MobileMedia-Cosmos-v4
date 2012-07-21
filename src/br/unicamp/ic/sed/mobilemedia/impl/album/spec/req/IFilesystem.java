package br.unicamp.ic.sed.mobilemedia.impl.album.spec.req;

import br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.PersistenceMechanismException;

public interface IFilesystem{

	public void createNewPhotoAlbum ( String albumName ) throws PersistenceMechanismException, InvalidPhotoAlbumNameException; 
	
	public void deletePhotoAlbum ( String albumName ) throws PersistenceMechanismException; 
	
	public String[] getAlbumNames (  ); 
	
	public void resetImageData (  ) throws PersistenceMechanismException;
	
}