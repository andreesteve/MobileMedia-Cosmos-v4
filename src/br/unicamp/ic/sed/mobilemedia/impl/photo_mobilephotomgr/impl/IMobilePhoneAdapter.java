   
package br.unicamp.ic.sed.mobilemedia.impl.photo_mobilephotomgr.impl;

import javax.microedition.lcdui.Command;

import br.unicamp.ic.sed.mobilemedia.impl.photo.spec.req.IMobilePhone;

class IMobilePhoneAdapter implements IMobilePhone{
	
	public boolean postCommand ( Command comand ){
		br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.spec.prov.IMobilePhone mobilePhone;
		
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		mobilePhone = (br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.spec.prov.IMobilePhone)manager.getRequiredInterface("IMobilePhone");
		return mobilePhone.postCommand(comand);
	} 

}