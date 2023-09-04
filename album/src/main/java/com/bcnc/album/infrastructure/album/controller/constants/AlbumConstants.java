package com.bcnc.album.infrastructure.album.controller.constants;

import com.bcnc.album.infrastructure.common.constants.CommonConstants;


/**
 * Constants for album module
 * 
 * @author BCNC
 * @since 1.0.0
 */
public final class AlbumConstants {

	/** Controller request for all requests */
	public static final String CONTROLLER_NAMESPACE = CommonConstants.API_BASE + "/album";
		
	/** CONTROLLER_GET_ALL_ALBUMS */
	public static final String CONTROLLER_GET_ALL_ALBUMS = "/all";
	
	/** CONTROLLER_GET_ALL_PHOTOS_BY_ALBUM */
	public static final String CONTROLLER_GET_ALL_PHOTOS_BY_ALBUM = "/{albumId}/photos";
	
	
	/**
	 * Default constructor<br>
	 */
	private AlbumConstants() {
	}
}