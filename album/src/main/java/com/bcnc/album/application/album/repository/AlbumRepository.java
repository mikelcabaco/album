package com.bcnc.album.application.album.repository;

import java.util.List;

import com.bcnc.album.application.album.domain.Album;
import com.bcnc.album.application.album.domain.Photo;
import com.bcnc.album.infrastructure.common.exceptions.CoreException;


/**
 * Interface repository to get all albums and photos in an album.
 * 
 * @author BCNC
 * @since 1.0.0
 */
public interface AlbumRepository {

	/**
	 * Get all albums
	 * @return {@link List}<{@link Album}> Album's list.
	 * @throws CoreException 
	 */
	List<Album> findAll() throws CoreException;
	
	
	/**
	 * Get all photos in an album.
	 * @param albumId {@link Long} album id
	 * @return {@link List}<{@link Photo}> Photo's list in an album.
	 * @throws CoreException 
	 */
	List<Photo> findPhotosByAlbumId(Long albumId) throws CoreException;

}
