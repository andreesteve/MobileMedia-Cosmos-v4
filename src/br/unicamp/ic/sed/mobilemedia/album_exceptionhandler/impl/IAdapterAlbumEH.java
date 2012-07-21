package br.unicamp.ic.sed.mobilemedia.album_exceptionhandler.impl;

import br.unicamp.ic.sed.mobilemedia.album.spec.req.IExceptionHandler;

class IAdapterAlbumEH implements IExceptionHandler {

	public void handle(Exception exception) {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.exceptionhandler.spec.prov.IExceptionHandler handler = (br.unicamp.ic.sed.mobilemedia.exceptionhandler.spec.prov.IExceptionHandler)manager.getProvidedInterface("IExceptionHandler");
		handler.handle(exception);

	}

}
