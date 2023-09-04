package com.bcnc.album.infrastructure.album.placeholder.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bcnc.album.infrastructure.album.placeholder.entity.PhotoPlaceholder;


@ExtendWith(MockitoExtension.class)
class PhotoPlaceholderMapperTest {

	@InjectMocks
	private PhotoPlaceholderMapper mapper = new PhotoPlaceholderMapperImpl();
	
	
	@Test
	void testToListDomain() {
		var photo = new PhotoPlaceholder();
		photo.setId(1L);
		photo.setAlbumId(1L);
		photo.setTitle("Photo1");
		photo.setUrl("url1");
		photo.setThumbnailUrl("thumbnailUrl1");
		
		var list = mapper.toListDomain(List.of(photo));
		Assertions.assertNotNull(list);
		Assertions.assertFalse(list.isEmpty());
		Assertions.assertEquals(1, list.size());
		var record = list.get(0);
		Assertions.assertEquals(1L, record.getId());
		Assertions.assertEquals(1L, record.getAlbumId());
		Assertions.assertEquals("Photo1", record.getTitle());
		Assertions.assertEquals("url1", record.getUrl());
		Assertions.assertEquals("thumbnailUrl1", record.getThumbnailUrl());
	}

}
