package br.unicamp.ic.sed.mobilemedia.impl.mobilephonemgr.spec.prov;

import javax.microedition.lcdui.Command;

public interface IMobilePhone{

	public boolean postCommand ( Command comand ); 
	
	public void startUp();
}