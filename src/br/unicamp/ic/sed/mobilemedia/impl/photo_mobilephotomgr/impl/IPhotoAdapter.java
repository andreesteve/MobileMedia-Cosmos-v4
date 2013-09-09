
package br.unicamp.ic.sed.mobilemedia.impl.photo_mobilephotomgr.impl;

import javax.microedition.lcdui.Command;


import br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.spec.req.IPhoto;


class IPhotoAdapter implements IPhoto{

	public boolean postCommand(Command c) {
		br.unicamp.ic.sed.cosmos.IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		return photo.postCommand(c);
	}
}