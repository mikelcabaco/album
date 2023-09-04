package com.bcnc.album.application.album.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.bcnc.album.application.album.domain.Album;
import com.bcnc.album.application.album.domain.Photo;
import com.bcnc.album.application.album.repository.AlbumRepository;
import com.bcnc.album.infrastructure.album.controller.entity.AlbumDto;
import com.bcnc.album.infrastructure.common.exceptions.BadRequestException;
import com.bcnc.album.infrastructure.common.exceptions.CoreException;


/**
 * Album service.
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Service
public class AlbumService {

	@Autowired
	private AlbumRepository repository;
	
	
	/**
	 * Get all albums
	 * @return {@link List}<{@link Album}> Album's list.
	 */
	public List<Album> findAll() {
		return repository.findAll();
	}
	
	
	/**
	 * Get all photos in an album.
	 * @param albumId {@link Long} album id
	 * @return {@link List}<{@link Photo}> Photo's list in an album.
	 */
	public List<Photo> findPhotosByAlbumId(Long albumId) throws CoreException {
		validateAlbumId(albumId);
		return repository.findPhotosByAlbumId(albumId);
	}
	
	private void validateAlbumId(Long albumId) throws BadRequestException {
		if (null == albumId) {
			var albumDto = new AlbumDto();
			BindingResult bindingResult = new BeanPropertyBindingResult(albumDto, "albumDto");
			bindingResult.rejectValue("id", "required", new Object[] {"albumId"}, null);
			throw new BadRequestException(bindingResult);
		}
	}
}
