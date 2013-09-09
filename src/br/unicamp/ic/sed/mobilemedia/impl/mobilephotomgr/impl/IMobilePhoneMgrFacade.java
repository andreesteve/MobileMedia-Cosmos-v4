/**
 * University of Campinas - Brazil
 * Institute of Computing
 * SED group
 *
 * date: February 2009
 * 
 */
package br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.impl;

import javax.microedition.lcdui.Command;
import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.spec.prov.IMobilePhone;
import br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.spec.req.IMobileResources;

class IMobilePhoneMgrFacade implements IMobilePhone{


	
	private BaseController baseController;
	
	public boolean postCommand ( Command command ){
		if( command == null){
			System.err.println("You must call IMobilePhoneMgrFacade.startUp() before this method");
			return false;
		}
		else{
			System.out.println("[IMobilePhoneMgrFacade]COMMAND:"+command.getLabel());
			return baseController.postCommand( command );
		}
	}



	public void startUp() {

		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();

		IMobileResources mobileResources = (IMobileResources) manager.getRequiredInterface("IMobileResources");

		MIDlet midlet = mobileResources.getMainMIDlet();
		
		this.baseController = new BaseController( midlet );

		this.baseController.init();

		System.out.println("[IMobilePhoneMgrFacade.startUp()] ending...");
	}

	











}