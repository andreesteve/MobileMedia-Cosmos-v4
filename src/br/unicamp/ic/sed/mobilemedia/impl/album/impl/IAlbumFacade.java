/**
 * University of Campinas - Brazil
 * Institute of Computing
 * SED group
 *
 * date: February 2009
 * 
 */ 
package br.unicamp.ic.sed.mobilemedia.impl.album.impl;

import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.impl.album.spec.prov.IAlbum;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IFilesystem;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IMobileResources;


class IAlbumFacade implements IAlbum{

	private AlbumListScreen albumListScreen;
	private AlbumController albumController;
	
	private AlbumListScreen getAlbumListScreen() {
		this.albumListScreen = new AlbumListScreen();
		return albumListScreen;
	}

	private AlbumController getAlbumController() {
		if( this.albumController == null){
			br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
			IMobileResources mobileResources = (IMobileResources) manager.getRequiredInterface("IMobileResources");
			MIDlet midlet = mobileResources.getMainMIDlet();
			AlbumListScreen albumListScreen = this.getAlbumListScreen();
			this.albumController = new AlbumController( midlet ,  albumListScreen );
		}
		return albumController;
	}



	public void initAlbumListScreen ( ){
		
		//initialize all the screens
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem)manager.getRequiredInterface("IFilesystem");
		String[] albumNames = filesystem.getAlbumNames();
		
		AlbumListScreen albumListScr = this.getAlbumListScreen();
		for (int i = 0; i < albumNames.length; i++) {
			if (albumNames[i] != null) {
				//Add album name to menu list
				albumListScr.append(albumNames[i], null);
			}
		}

		albumListScr.initMenu();

		//Set the current screen to the photo album listing
		AlbumController albumCtr = this.getAlbumController();

		albumCtr.setCurrentScreen(albumListScr);

		albumListScr.setCommandListener( albumCtr );
		
	} 
}