package br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler_album.impl;

import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IExceptionHandler;

class IAdapterAlbumEH implements IExceptionHandler {

	public void handle(Exception exception) {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.spec.prov.IExceptionHandler handler = (br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.spec.prov.IExceptionHandler)manager.getProvidedInterface("IExceptionHandler");
		handler.handle(exception);

	}

}
