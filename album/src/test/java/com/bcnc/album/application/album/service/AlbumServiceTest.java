package com.bcnc.album.application.album.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bcnc.album.application.album.repository.AlbumRepository;
import com.bcnc.album.infrastructure.common.exceptions.BadRequestException;
import com.bcnc.album.infrastructure.common.exceptions.CoreException;


@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {

	@InjectMocks
	private AlbumService service;
	
	@Mock
	private AlbumRepository repository;
	
	@Test
	void testFindPhotosByAlbumIdNull() {
		CoreException exception = null;
		
		try {
			service.findPhotosByAlbumId(null);
		}
		catch (CoreException e) {
			exception = e;
		}
		
		Assertions.assertEquals(BadRequestException.class, exception.getClass());
	}

}
