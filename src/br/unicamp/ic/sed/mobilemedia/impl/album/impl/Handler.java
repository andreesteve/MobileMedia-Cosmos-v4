package br.unicamp.ic.sed.mobilemedia.impl.album.impl;

import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IExceptionHandler;



class Handler {
	
	protected void handle(Exception e){
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		IExceptionHandler handler = (IExceptionHandler) manager.getProvidedInterface("IExceptionHandler");
		handler.handle(e);
	}

}
