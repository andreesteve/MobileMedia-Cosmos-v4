package br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr_album.impl;

import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.excep.PersistenceMechanismException;


 class IAdapterFilesystemAlbum implements IFilesystem {


	public void createNewPhotoAlbum(String albumName) throws br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.InvalidPhotoAlbumNameException, br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.PersistenceMechanismException {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try{
		filesystem.createNewPhotoAlbum(albumName);
		}catch(InvalidPhotoAlbumNameException e){
			throw new br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.InvalidPhotoAlbumNameException();
		}catch(PersistenceMechanismException e){
			throw new br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.PersistenceMechanismException(e);
		}
	}

	public void deletePhotoAlbum(String albumName) throws br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.PersistenceMechanismException
	 {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.deletePhotoAlbum(albumName);
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.PersistenceMechanismException(e);
		}
	}

	public String[] getAlbumNames() {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		return filesystem.getAlbumNames();
	}

	public void resetImageData() throws br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.PersistenceMechanismException  {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem filesystem = (br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.resetImageData();
		} catch (PersistenceMechanismException e) {
			throw new br.unicamp.ic.sed.mobilemedia.impl.album.spec.excep.PersistenceMechanismException(e);
		}
	}
}
