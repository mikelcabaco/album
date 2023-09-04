package com.bcnc.album.infrastructure.album.placeholder.resttemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.bcnc.album.application.album.domain.Album;
import com.bcnc.album.application.album.domain.Photo;
import com.bcnc.album.application.album.repository.AlbumRepository;
import com.bcnc.album.infrastructure.album.placeholder.constants.PlaceholderConstants;
import com.bcnc.album.infrastructure.album.placeholder.entity.AlbumPlaceholder;
import com.bcnc.album.infrastructure.album.placeholder.entity.PhotoPlaceholder;
import com.bcnc.album.infrastructure.album.placeholder.mapper.AlbumPlaceholderMapper;
import com.bcnc.album.infrastructure.album.placeholder.mapper.PhotoPlaceholderMapper;
import com.bcnc.album.infrastructure.common.exceptions.CoreException;


/**
 * Album repository implementation. Get data from <code>https://jsonplaceholder.typicode.com</code>.
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Service
public class AlbumRestTemplate implements AlbumRepository {

	@Autowired
	private RestOperations restTemplate;
	
	@Autowired
	private AlbumPlaceholderMapper albumMapper;
	
	@Autowired
	private PhotoPlaceholderMapper photoMapper;
	
	@Override
	public List<Album> findAll() throws CoreException {
		HttpEntity<List<AlbumPlaceholder>> response;
		try {
			response = restTemplate.exchange(PlaceholderConstants.GET_ALL_ALBUMS, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<AlbumPlaceholder>>() {});
		}
		catch (Exception e) {
			throw new CoreException(e.getMessage());
		}
		
		List<AlbumPlaceholder> list = new ArrayList<>();
		if (null != response.getBody()) {
			list = response.getBody();
		}
		
		return albumMapper.toListDomain(list);
	}

	@Override
	public List<Photo> findPhotosByAlbumId(Long albumId) throws CoreException {
		HttpEntity<List<PhotoPlaceholder>> response;
		try {
			var url = String.format(PlaceholderConstants.GET_ALL_PHOTOS_BY_ALBUM, albumId);
			response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PhotoPlaceholder>>() {});
		}
		catch (Exception e) {
			throw new CoreException(e.getMessage());
		}
		
		List<PhotoPlaceholder> list = new ArrayList<>();
		if (null != response.getBody()) {
			list = response.getBody();
		}
		
		return photoMapper.toListDomain(list);
	}

}
