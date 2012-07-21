package br.unicamp.ic.sed.mobilemedia.impl.mainuimidlet_exceptionhandler.impl;

import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.spec.req.IMobileResources;

class IMobileResourcesAdapter implements IMobileResources{

	public MIDlet getMainMIDlet() {
		br.unicamp.ic.sed.cosmos.IManager manager = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.impl.main.spec.prov.IMobileResources iMobileResources = (br.unicamp.ic.sed.mobilemedia.impl.main.spec.prov.IMobileResources)manager.getRequiredInterface("IMobileResources");
		return iMobileResources.getMainMIDlet();
	}
	
	public void destroyApp(boolean unconditional) {
		throw new RuntimeException("This connector isn't able to connect this method!");
	}	
}