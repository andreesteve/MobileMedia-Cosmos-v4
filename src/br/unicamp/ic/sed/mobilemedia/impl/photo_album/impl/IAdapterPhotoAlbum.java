package br.unicamp.ic.sed.mobilemedia.impl.photo_album.impl;

import javax.microedition.lcdui.Command;

import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IPhoto;

 class IAdapterPhotoAlbum implements IPhoto {

	public boolean postCommand(Command c) {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.impl.photo.spec.prov.IPhoto photo = (br.unicamp.ic.sed.mobilemedia.impl.photo.spec.prov.IPhoto)manager.getRequiredInterface("IPhoto");
		return photo.postCommand(c);
	}

}
