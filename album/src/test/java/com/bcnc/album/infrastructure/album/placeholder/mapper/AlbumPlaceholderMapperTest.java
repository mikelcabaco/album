package com.bcnc.album.infrastructure.album.placeholder.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bcnc.album.infrastructure.album.placeholder.entity.AlbumPlaceholder;


@ExtendWith(MockitoExtension.class)
class AlbumPlaceholderMapperTest {

	@InjectMocks
	private AlbumPlaceholderMapper mapper = new AlbumPlaceholderMapperImpl();
	
	
	@Test
	void testToListDomain() {
		var album = new AlbumPlaceholder();
		album.setId(1L);
		album.setUserId(1L);
		album.setTitle("Album1");
		
		var list = mapper.toListDomain(List.of(album));
		Assertions.assertNotNull(list);
		Assertions.assertFalse(list.isEmpty());
		Assertions.assertEquals(1, list.size());
		var record = list.get(0);
		Assertions.assertEquals(1L, record.getId());
		Assertions.assertEquals(1L, record.getUserId());
		Assertions.assertEquals("Album1", record.getTitle());
	}

}
