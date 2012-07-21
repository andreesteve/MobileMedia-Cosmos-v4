package br.unicamp.ic.sed.mobilemedia.impl.mainuimidlet_mobilephonemgr.impl;

import javax.microedition.midlet.MIDlet;


import br.unicamp.ic.sed.mobilemedia.impl.mobilephonemgr.spec.req.IMobileResources;

 class IAdapterMobilePhoneMgrMainMidlet implements IMobileResources {

	private br.unicamp.ic.sed.cosmos.IManager manager;
	
	IAdapterMobilePhoneMgrMainMidlet(br.unicamp.ic.sed.cosmos.IManager mgr) {
		this.manager = mgr;
	}
	
	public MIDlet getMainMIDlet() {
		
		br.unicamp.ic.sed.mobilemedia.impl.main.spec.prov.IMobileResources mobileResources = (br.unicamp.ic.sed.mobilemedia.impl.main.spec.prov.IMobileResources) manager.getRequiredInterface("IMobileResources");
		return mobileResources.getMainMIDlet();
		
	}

	public void destroyApp(boolean unconditional) {
	
		br.unicamp.ic.sed.mobilemedia.impl.main.spec.prov.IMobileResources iMobileResources = (br.unicamp.ic.sed.mobilemedia.impl.main.spec.prov.IMobileResources)manager.getRequiredInterface("IMobileResources");
		iMobileResources.destroyApp(unconditional);
		
	}	
	
}
