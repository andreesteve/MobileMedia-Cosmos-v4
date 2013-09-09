package br.unicamp.ic.sed.mobilemedia.impl.photo.impl;

import br.unicamp.ic.sed.mobilemedia.impl.photo.spec.req.IExceptionHandler;

class Handler {
	
	protected void handle(Exception e){
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		IExceptionHandler handler = (IExceptionHandler) manager.getRequiredInterface("IExceptionHandler");
		handler.handle(e);
	}

}
