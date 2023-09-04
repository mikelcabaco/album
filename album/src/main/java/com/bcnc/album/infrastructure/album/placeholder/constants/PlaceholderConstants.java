package com.bcnc.album.infrastructure.album.placeholder.constants;


/**
 * Placeholder constants for infrastructure
 * 
 * @author BCNC
 * @since 2.0.0
 */
public final class PlaceholderConstants {
	
	/** The base path for all placeholder endpoints */
	public static final String API_URL = "https://jsonplaceholder.typicode.com";
	
	
	/** GET_ALL_ALBUMS */
	public static final String GET_ALL_ALBUMS = API_URL + "/albums";
	
	/** GET_ALL_PHOTOS_BY_ALBUM */
	public static final String GET_ALL_PHOTOS_BY_ALBUM = API_URL + "/photos?albumId=%s";
	
	
	/**
	 * Default constructor<br>
	 */
	private PlaceholderConstants() {
	}
}