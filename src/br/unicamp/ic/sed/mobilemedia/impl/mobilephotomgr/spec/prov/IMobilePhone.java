package br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.spec.prov;

import javax.microedition.lcdui.Command;

public interface IMobilePhone{

	public boolean postCommand ( Command comand ); 
	
	public void startUp();
}