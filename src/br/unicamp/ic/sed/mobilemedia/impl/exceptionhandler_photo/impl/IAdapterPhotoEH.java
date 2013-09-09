package br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler_photo.impl;

import br.unicamp.ic.sed.mobilemedia.impl.photo.spec.req.IExceptionHandler;

 class IAdapterPhotoEH implements IExceptionHandler {

	public void handle(Exception exception) {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.spec.prov.IExceptionHandler handler = (br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.spec.prov.IExceptionHandler)manager.getRequiredInterface("IExceptionHandler");
		handler.handle(exception);

	}

}
