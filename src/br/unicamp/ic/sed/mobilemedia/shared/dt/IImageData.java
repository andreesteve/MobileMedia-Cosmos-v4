package br.unicamp.ic.sed.mobilemedia.shared.dt;

public interface IImageData {

	/**
	 * @return Returns the recordId.
	 */
	public int getRecordId() ;
	
	
	/**
	 * @return Returns the foreignRecordId.
	 */
	public int getForeignRecordId() ;
	
	
	/**
	 * @return Returns the imageLabel.
	 */
	public String getImageLabel() ;
	
	
	/**
	 * @return Returns the parentAlbumName.
	 */
	public String getParentAlbumName() ;
	
	/**
	 * [EF] Added in the scenario 03
	 */
	public void getToggleFavorite() ;
	
	/**
	 * [EF] Added in the scenario 03
	 * @return the favorite
	 */
	public boolean getIsFavorite() ;

	/**
	 * [EF] Added in the scenario 02 
	 */
	public void getIncreaseNumberOfViews() ;

	/**
	 * [EF] Added in the scenario 02 
	 * @return the numberOfViews
	 */
	public int getNumberOfViews() ;

	
}
