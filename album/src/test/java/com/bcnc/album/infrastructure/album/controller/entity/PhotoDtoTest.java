package com.bcnc.album.infrastructure.album.controller.entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;


class PhotoDtoTest {

	/**
	 * Test method with library equalsVerifier.
	 */
	@Test
	void testPhotoDto() {
		var photo = new PhotoDto();
		photo.setId(1L);
		photo.setAlbumId(1L);
		photo.setTitle("Photo1");
		photo.setUrl("url1");
		photo.setThumbnailUrl("thumbnailUrl1");
		
		
		var photo2 = new PhotoDto();
		photo2.setId(2L);
		photo2.setAlbumId(2L);
		photo2.setTitle("Photo2");
		photo2.setUrl("url2");
		photo2.setThumbnailUrl("thumbnailUrl2");
		
		EqualsVerifier.forClass(PhotoDto.class)
			.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
			.withRedefinedSuperclass()
			.withPrefabValues(Object.class, photo, photo2)
			.verify();
	}

}
