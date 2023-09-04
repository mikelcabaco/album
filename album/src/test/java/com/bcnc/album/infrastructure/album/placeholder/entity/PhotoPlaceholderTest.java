package com.bcnc.album.infrastructure.album.placeholder.entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

class PhotoPlaceholderTest {

	/**
	 * Test method with library equalsVerifier.
	 */
	@Test
	void testPhotoPlaceholder() {
		var photo = new PhotoPlaceholder();
		photo.setId(1L);
		photo.setAlbumId(1L);
		photo.setTitle("Photo1");
		photo.setUrl("url1");
		photo.setThumbnailUrl("thumbnailUrl1");
		
		
		var photo2 = new PhotoPlaceholder();
		photo2.setId(2L);
		photo2.setAlbumId(2L);
		photo2.setTitle("Photo2");
		photo2.setUrl("url2");
		photo2.setThumbnailUrl("thumbnailUrl2");
		
		EqualsVerifier.forClass(PhotoPlaceholder.class)
			.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
			.withRedefinedSuperclass()
			.withPrefabValues(Object.class, photo, photo2)
			.verify();
	}

}
