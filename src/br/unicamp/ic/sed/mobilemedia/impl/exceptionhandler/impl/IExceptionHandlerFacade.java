   
package br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.impl;

import br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.spec.prov.IExceptionHandler;



class IExceptionHandlerFacade implements IExceptionHandler{

		
	public void handle(Exception exception) {
		WarningExceptionHandler handler = new WarningExceptionHandler();
		handler.handle(exception);		
	}
}