   
package br.unicamp.ic.sed.mobilemedia.impl.album_mobilephotomgr.impl;

import br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.spec.req.IAlbum;


class IAlbumAdapter implements IAlbum{
	
	private br.unicamp.ic.sed.cosmos.IManager manager;
	
	public IAlbumAdapter(br.unicamp.ic.sed.cosmos.IManager mgr) {
		System.out.println(this.getClass().getName()+" constructor");
		this.manager = mgr;
	}
		
	public void initAlbumListScreen ( ){
		
		br.unicamp.ic.sed.mobilemedia.impl.album.spec.prov.IAlbum iAlbum;
		iAlbum = (br.unicamp.ic.sed.mobilemedia.impl.album.spec.prov.IAlbum) manager.getRequiredInterface("IAlbum");
		iAlbum.initAlbumListScreen();
	}	
}