package com.bcnc.album.infrastructure.album.placeholder.resttemplate;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import com.bcnc.album.application.album.domain.Album;
import com.bcnc.album.application.album.domain.Photo;
import com.bcnc.album.infrastructure.album.placeholder.constants.PlaceholderConstants;
import com.bcnc.album.infrastructure.album.placeholder.entity.AlbumPlaceholder;
import com.bcnc.album.infrastructure.album.placeholder.entity.PhotoPlaceholder;
import com.bcnc.album.infrastructure.album.placeholder.mapper.AlbumPlaceholderMapper;
import com.bcnc.album.infrastructure.album.placeholder.mapper.PhotoPlaceholderMapper;
import com.bcnc.album.infrastructure.common.exceptions.CoreException;


@ExtendWith(MockitoExtension.class)
class AlbumRestTemplateTest {

	@InjectMocks
	private AlbumRestTemplate albumRestTemplateTest;
	
	@Mock
	private RestOperations restTemplate;
	
	@Mock
	private AlbumPlaceholderMapper albumMapper;
	
	@Mock
	private PhotoPlaceholderMapper photoMapper;
	
	
	@Test
	void testFindAllAlbums() {
		CoreException ex = null;
		List<Album> result = null;
		
		// Mock to return an response entity without body
		var album = new AlbumPlaceholder();
		album.setId(1L);
		album.setUserId(1L);
		album.setTitle("Album1");
		
		ResponseEntity<List<AlbumPlaceholder>> responseEntity = new ResponseEntity<>(List.of(album), HttpStatus.OK);
		when(restTemplate.exchange(PlaceholderConstants.GET_ALL_ALBUMS, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<AlbumPlaceholder>>() {})).thenReturn(responseEntity);
		
		try {
			result = albumRestTemplateTest.findAll();
		}
		catch (CoreException e) {
			ex = e;
		}
		
		Assertions.assertNull(ex);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isEmpty());
	}
	
	
	@Test
	void testFindAllAlbumsWithoutBody() {
		CoreException ex = null;
		List<Album> result = null;
		
		// Mock to return an response entity without body
		ResponseEntity<List<AlbumPlaceholder>> responseEntity = new ResponseEntity<>(null, HttpStatus.OK);
		when(restTemplate.exchange(PlaceholderConstants.GET_ALL_ALBUMS, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<AlbumPlaceholder>>() {})).thenReturn(responseEntity);
		
		try {
			result = albumRestTemplateTest.findAll();
		}
		catch (CoreException e) {
			ex = e;
		}
		
		Assertions.assertNull(ex);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isEmpty());
	}
	
	
	@Test
	void testFindAllAlbumsWithTimeout() {
		CoreException ex = null;
		List<Album> result = null;
		
		// Mock to return an exception
		when(restTemplate.exchange(PlaceholderConstants.GET_ALL_ALBUMS, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<AlbumPlaceholder>>() {}))
			.thenThrow(new RestClientException("Timeout"));
		
		try {
			result = albumRestTemplateTest.findAll();
		}
		catch (CoreException e) {
			ex = e;
		}
		
		Assertions.assertNotNull(ex);
		Assertions.assertNull(result);
	}
	
	
	@Test
	void testFindAllPhotos() {
		CoreException ex = null;
		List<Photo> result = null;
		var albumId = 1L;
		var photoId = 1L;
		
		// Mock to return an response entity without body
		var photo = new PhotoPlaceholder();
		photo.setId(photoId);
		photo.setAlbumId(albumId);
		photo.setTitle("Photo1");
		photo.setUrl("url1");
		photo.setThumbnailUrl("thumbnailUrl1");
		
		var url = String.format(PlaceholderConstants.GET_ALL_PHOTOS_BY_ALBUM, albumId);
		ResponseEntity<List<PhotoPlaceholder>> responseEntity = new ResponseEntity<>(List.of(photo), HttpStatus.OK);
		when(restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PhotoPlaceholder>>() {})).thenReturn(responseEntity);
		
		try {
			result = albumRestTemplateTest.findPhotosByAlbumId(photoId);
		}
		catch (CoreException e) {
			ex = e;
		}
		
		Assertions.assertNull(ex);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isEmpty());
	}
	
	
	@Test
	void testFindAllPhotosWithoutBody() {
		CoreException ex = null;
		List<Photo> result = null;
		var albumId = 1L;
		
		// Mock to return an response entity without body
		var url = String.format(PlaceholderConstants.GET_ALL_PHOTOS_BY_ALBUM, albumId);
		ResponseEntity<List<PhotoPlaceholder>> responseEntity = new ResponseEntity<>(null, HttpStatus.OK);
		when(restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PhotoPlaceholder>>() {})).thenReturn(responseEntity);
		
		try {
			result = albumRestTemplateTest.findPhotosByAlbumId(albumId);
		}
		catch (CoreException e) {
			ex = e;
		}
		
		Assertions.assertNull(ex);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isEmpty());
	}
	
	
	@Test
	void testFindAllWithTimeout() {
		CoreException ex = null;
		List<Photo> result = null;
		var albumId = 1L;
		
		// Mock to return an exception
		var url = String.format(PlaceholderConstants.GET_ALL_PHOTOS_BY_ALBUM, albumId);
		when(restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<AlbumPlaceholder>>() {}))
		.thenThrow(new RestClientException("Timeout"));
		
		try {
			result = albumRestTemplateTest.findPhotosByAlbumId(albumId);
		}
		catch (CoreException e) {
			ex = e;
		}
		
		Assertions.assertNotNull(ex);
		Assertions.assertNull(result);
	}

}
