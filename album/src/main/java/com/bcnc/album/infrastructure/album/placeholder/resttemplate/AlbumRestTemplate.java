package com.bcnc.album.infrastructure.album.placeholder.resttemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcnc.album.application.album.domain.Album;
import com.bcnc.album.application.album.domain.Photo;
import com.bcnc.album.application.album.repository.AlbumRepository;
import com.bcnc.album.infrastructure.album.placeholder.mapper.AlbumPlaceholderMapper;
import com.bcnc.album.infrastructure.album.placeholder.mapper.PhotoPlaceholderMapper;


/**
 * Album repository implementation. Get data from <code>https://jsonplaceholder.typicode.com</code>.
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Service
public class AlbumRestTemplate implements AlbumRepository {

	@Autowired
	private AlbumPlaceholderMapper albumMapper;
	
	@Autowired
	private PhotoPlaceholderMapper photoMapper;
	
	@Override
	public List<Album> findAll() {
		return albumMapper.toListDomain(List.of());
	}

	@Override
	public List<Photo> findPhotosByAlbumId(Long albumId) {
		return photoMapper.toListDomain(List.of());
	}

}
