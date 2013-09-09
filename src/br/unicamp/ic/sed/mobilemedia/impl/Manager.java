package br.unicamp.ic.sed.mobilemedia.impl;
import br.unicamp.ic.sed.mobilemedia.impl.album.spec.req.IMobilePhone;
class Manager extends br.unicamp.ic.sed.cosmos.AManager{
		
	public Manager()
	{
	
		// create all imanagers
		br.unicamp.ic.sed.cosmos.IManager mainMidlet = br.unicamp.ic.sed.mobilemedia.impl.mainuimidlet.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager filesystem = br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr.impl.ComponentFactory.createInstance();

		br.unicamp.ic.sed.cosmos.IManager album_mobilePhone = br.unicamp.ic.sed.mobilemedia.impl.album_mobilephotomgr.impl.ComponentFactory.createInstance();

		br.unicamp.ic.sed.cosmos.IManager mobilePhone = br.unicamp.ic.sed.mobilemedia.impl.mobilephotomgr.impl.ComponentFactory.createInstance();

		br.unicamp.ic.sed.cosmos.IManager album = br.unicamp.ic.sed.mobilemedia.impl.album.impl.ComponentFactory.createInstance();

		br.unicamp.ic.sed.cosmos.IManager exceptionHandler = br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager mainMidlet_album = br.unicamp.ic.sed.mobilemedia.impl.mainuimidlet_album.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager photo = br.unicamp.ic.sed.mobilemedia.impl.photo.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager photo_mobilePhone = br.unicamp.ic.sed.mobilemedia.impl.photo_mobilephotomgr.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager mainMidlet_photo = br.unicamp.ic.sed.mobilemedia.impl.mainuimidlet_photo.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager mainMidlet_mobilePhone = br.unicamp.ic.sed.mobilemedia.impl.mainuimidlet_mobilephotomgr.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager filesystemmgr_album = br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr_album.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager filesystemmgr_photo = br.unicamp.ic.sed.mobilemedia.impl.filesystemmgr_photo.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager photo_album = br.unicamp.ic.sed.mobilemedia.impl.photo_album.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager mainMidlet_exceptionHandler = br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler_mainuimidlet.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager album_exceptionhandler = br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler_album.impl.ComponentFactory.createInstance();
		
		br.unicamp.ic.sed.cosmos.IManager photo_exceptionhandler = br.unicamp.ic.sed.mobilemedia.impl.exceptionhandler_photo.impl.ComponentFactory.createInstance();
		
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
		
		
		System.out.println("step 0.4");
		
		
		mobilePhone.setRequiredInterface("IAlbum", album_mobilePhone.getProvidedInterface("IAlbum") );
		
		
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
		mainMidlet_photo.setRequiredInterface("IMobileResources", mainMidlet.getProvidedInterface("IMobileResources") );

		mainMidlet_mobilePhone.setRequiredInterface("IMobileResources", mainMidlet.getProvidedInterface("IMobileResources"));

		filesystemmgr_album.setRequiredInterface("IFilesystem", filesystem.getProvidedInterface("IFilesystem"));

		filesystemmgr_photo.setRequiredInterface("IFilesystem", filesystem.getProvidedInterface("IFilesystem"));

		photo_album.setRequiredInterface("IPhoto", photo.getProvidedInterface("IPhoto"));

//		filesystem_mobilePhone.setRequiredInterface("IFilesystem", filesystem.getProvidedInterface("IFilesystem"));
		System.out.println("step 4");
		album_mobilePhone.setRequiredInterface("IAlbum", album.getProvidedInterface("IAlbum"));
		
		album_mobilePhone.setRequiredInterface("IMobilePhone", mobilePhone.getProvidedInterface("IMobilePhone"));
		
		photo_mobilePhone.setRequiredInterface("IPhoto", photo.getProvidedInterface("IPhoto"));
		
		photo_mobilePhone.setRequiredInterface("IMobilePhone", mobilePhone.getProvidedInterface("IMobilePhone"));

		mainMidlet_album.setRequiredInterface("IMobileResources", mainMidlet.getProvidedInterface("IMobileResources") );

		mainMidlet_exceptionHandler.setRequiredInterface("IMobileResources",  mainMidlet.getProvidedInterface("IMobileResources") );
		
		exceptionHandler.setRequiredInterface("IMobileResources", mainMidlet_exceptionHandler.getProvidedInterface("IMobileResources"));
		
		
		album_exceptionhandler.setRequiredInterface("IExceptionHandler", exceptionHandler.getProvidedInterface("IExceptionHandler") );
		
		photo_exceptionhandler.setRequiredInterface("IExceptionHandler", exceptionHandler.getProvidedInterface("IExceptionHandler") );
		System.out.println("step 5");
		
		
		IMobilePhone mobPhone = (IMobilePhone) mobilePhone.getProvidedInterface("IMobilePhone");

		System.out.println("mobPhone.startUp()");
	}
}