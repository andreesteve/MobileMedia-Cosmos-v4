package br.unicamp.ic.sed.mobilemedia.main.impl;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import br.unicamp.ic.sed.mobilemedia.main.spec.prov.IMobileResources;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IMobilePhone;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req.IAlbum;


//Following are pre-processor statements to include the required
//classes for device specific features. They must be commented out
//if they aren't used, otherwise it will throw exceptions trying to
//load classes that aren't available for a given platform.


/* 
 * 
 *
 * This is the main Midlet class for the core J2ME application
 * It contains all the basic functionality that should be executable
 * in any standard J2ME device that supports MIDP 1.0 or higher. 
 * Any additional J2ME features for this application that are dependent
 * upon a particular device (ie. optional or proprietary library) are
 * de-coupled from the core application so they can be conditionally included
 * depending on the target platform 
 * 
 * This Application provides a basic Photo Album interface that allows a user to view
 * images on their mobile device. 
 * */
 class MainUIMidlet extends MIDlet implements IMobileResources {

	//components
	br.unicamp.ic.sed.cosmos.IManager album;
	br.unicamp.ic.sed.cosmos.IManager filesystem;
	br.unicamp.ic.sed.cosmos.IManager photo;
	br.unicamp.ic.sed.cosmos.IManager mobilePhone;
	br.unicamp.ic.sed.cosmos.IManager exceptionHandler;

	//connectors
	br.unicamp.ic.sed.cosmos.IManager album_mobilePhone;
//	br.unicamp.ic.sed.cosmos.IManager filesystem_mobilePhone;
	br.unicamp.ic.sed.cosmos.IManager photo_mobilePhone;
	br.unicamp.ic.sed.cosmos.IManager mainMidlet_album;
	br.unicamp.ic.sed.cosmos.IManager mainMidlet_photo;
	br.unicamp.ic.sed.cosmos.IManager mainMidlet_mobilePhone;
	br.unicamp.ic.sed.cosmos.IManager filesystemmgr_album;
	br.unicamp.ic.sed.cosmos.IManager filesystemmgr_photo;
	br.unicamp.ic.sed.cosmos.IManager photo_album;
	br.unicamp.ic.sed.cosmos.IManager mainMidlet_exceptionHandler;
	br.unicamp.ic.sed.cosmos.IManager album_exceptionhandler;
	br.unicamp.ic.sed.cosmos.IManager photo_exceptionhandler; 

	public MainUIMidlet() {
		//do nothing
	}

	/**
	 * Start the MIDlet by creating new model and controller classes, and
	 * initialize them as necessary
	 */
	public void startApp() throws MIDletStateChangeException {

		System.out.println("Starting MobileMediaOO - v1");

		
		
		// create all imanagers
		filesystem = br.unicamp.ic.sed.mobilemedia.filesystemmgr.impl.ComponentFactory.createInstance();

		album_mobilePhone = br.unicamp.ic.sed.mobilemedia.album_mobilephonemgr.impl.ComponentFactory.createInstance();

		mobilePhone = br.unicamp.ic.sed.mobilemedia.mobilephonemgr.impl.ComponentFactory.createInstance();

		album = br.unicamp.ic.sed.mobilemedia.album.impl.ComponentFactory.createInstance();

		exceptionHandler = br.unicamp.ic.sed.mobilemedia.exceptionhandler.impl.ComponentFactory.createInstance();
		
//		filesystem_mobilePhone = br.unicamp.ic.sed.mobilemedia.filesystemmgr_mobilephonemgr.impl.ComponentFactory.createInstance();
		
		mainMidlet_album = br.unicamp.ic.sed.mobilemedia.mainuimidlet_album.impl.ComponentFactory.createInstance();
		
		photo = br.unicamp.ic.sed.mobilemedia.photo.impl.ComponentFactory.createInstance();
		
		photo_mobilePhone = br.unicamp.ic.sed.mobilemedia.photo_mobilephonemgr.impl.ComponentFactory.createInstance();
		
		mainMidlet_photo = br.unicamp.ic.sed.mobilemedia.mainuimidlet_photo.impl.ComponentFactory.createInstance();
		
		mainMidlet_mobilePhone = br.unicamp.ic.sed.mobilemedia.mainuimidlet_mobilephonemgr.impl.ComponentFactory.createInstance();
		
		filesystemmgr_album = br.unicamp.ic.sed.mobilemedia.filesystemmgr_album.impl.ComponentFactory.createInstance();
		
		filesystemmgr_photo = br.unicamp.ic.sed.mobilemedia.filesystemmgr_photo.impl.ComponentFactory.createInstance();
		
		photo_album = br.unicamp.ic.sed.mobilemedia.photo_album.impl.ComponentFactory.createInstance();
		
		mainMidlet_exceptionHandler = br.unicamp.ic.sed.mobilemedia.mainuimidlet_exceptionhandler.impl.ComponentFactory.createInstance();
		
		album_exceptionhandler = br.unicamp.ic.sed.mobilemedia.album_exceptionhandler.impl.ComponentFactory.createInstance();
		
		photo_exceptionhandler = br.unicamp.ic.sed.mobilemedia.photo_exceptionhandler.impl.ComponentFactory.createInstance();
		
		/*********************************************************************************************/
		//setting required interfaces
		System.out.println("step 0");
		//component mobilePhoneMgr
//		mobilePhone.setRequiredInterface("IFilesystem", filesystem_mobilePhone.getProvidedInterface("IFilesystem"));
		System.out.println("step 0.1");
		mobilePhone.setRequiredInterface("IPhoto", photo_mobilePhone.getProvidedInterface("IPhoto"));
		System.out.println("step 0.2");
		mobilePhone.setRequiredInterface("IMobileResources", mainMidlet_mobilePhone.getProvidedInterface("IMobileResources"));
		System.out.println("step 0.3");
		br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req.IAlbum ialbum = (IAlbum) album_mobilePhone.getProvidedInterface("IAlbum");
		System.out.println("step 0.4");
		mobilePhone.setRequiredInterface("IAlbum", ialbum );
		System.out.println("step 1");
		
		//component album
//		album.setRequiredInterface("IMobilePhone", album_mobilePhone.getProvidedInterface("IMobilePhone"));

		album.setRequiredInterface("IMobileResources", mainMidlet_album.getProvidedInterface("IMobileResources") );

		album.setRequiredInterface("IPhoto", photo_album.getProvidedInterface("IPhoto"));

		album.setRequiredInterface("IFilesystem",filesystemmgr_album.getProvidedInterface("IFilesystem"));

		album.setRequiredInterface("IExceptionHandler", album_exceptionhandler.getProvidedInterface("IExceptionHandler"));
		System.out.println("step 2");
		
		// component photo
		photo.setRequiredInterface("IMobilePhone", photo_mobilePhone.getProvidedInterface("IMobilePhone"));

		photo.setRequiredInterface("IMobileResources", mainMidlet_photo.getProvidedInterface("IMobileResources") );

		photo.setRequiredInterface("IFilesystem", filesystemmgr_photo.getProvidedInterface("IFilesystem"));

		photo.setRequiredInterface("IExceptionHandler", photo_exceptionhandler.getProvidedInterface("IExceptionHandler"));
		System.out.println("step 3");
		
		// connectors
		mainMidlet_photo.setRequiredInterface("IMobileResources", this );

		mainMidlet_mobilePhone.setRequiredInterface("IMobileResources", this);

		filesystemmgr_album.setRequiredInterface("IFilesystem", filesystem.getProvidedInterface("IFilesystem"));

		filesystemmgr_photo.setRequiredInterface("IFilesystem", filesystem.getProvidedInterface("IFilesystem"));

		photo_album.setRequiredInterface("IPhoto", photo.getProvidedInterface("IPhoto"));

//		filesystem_mobilePhone.setRequiredInterface("IFilesystem", filesystem.getProvidedInterface("IFilesystem"));
		System.out.println("step 4");
		album_mobilePhone.setRequiredInterface("IAlbum", album.getProvidedInterface("IAlbum"));
		
		album_mobilePhone.setRequiredInterface("IMobilePhone", mobilePhone.getProvidedInterface("IMobilePhone"));
		
		photo_mobilePhone.setRequiredInterface("IPhoto", photo.getProvidedInterface("IPhoto"));
		
		photo_mobilePhone.setRequiredInterface("IMobilePhone", mobilePhone.getProvidedInterface("IMobilePhone"));

		mainMidlet_album.setRequiredInterface("IMobileResources", this );

		mainMidlet_exceptionHandler.setRequiredInterface("IMobileResources",  this );
		
		exceptionHandler.setRequiredInterface("IMobileResources", mainMidlet_exceptionHandler.getProvidedInterface("IMobileResources"));
		
		
		album_exceptionhandler.setRequiredInterface("IExceptionHandler", exceptionHandler.getProvidedInterface("IExceptionHandler") );
		
		photo_exceptionhandler.setRequiredInterface("IExceptionHandler", exceptionHandler.getProvidedInterface("IExceptionHandler") );
		System.out.println("step 5");
		
		
		IMobilePhone mobPhone = (IMobilePhone) mobilePhone.getProvidedInterface("IMobilePhone");

		System.out.println("mobPhone.startUp()");

		mobPhone.startUp();
	}

	/**
	 * Pause the MIDlet
	 * This method does nothing at the moment.
	 */
	public void pauseApp() {
		//do nothing
	}

	/**
	 * Destroy the MIDlet
	 */
	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	public MIDlet getMainMIDlet() {
		return this;
	}

	
}