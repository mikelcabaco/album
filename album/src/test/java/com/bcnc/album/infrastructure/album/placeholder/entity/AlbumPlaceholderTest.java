package com.bcnc.album.infrastructure.album.placeholder.entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;


class AlbumPlaceholderTest {
	
	/**
	 * Test method with library equalsVerifier.
	 */
	@Test
	void testAlbumPlaceholder() {
		var album = new AlbumPlaceholder();
		album.setId(1L);
		album.setUserId(1L);
		album.setTitle("Album1");
		
		
		var album2 = new AlbumPlaceholder();
		album2.setId(2L);
		album2.setUserId(2L);
		album2.setTitle("Album2");
		
		EqualsVerifier.forClass(AlbumPlaceholder.class)
			.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
			.withRedefinedSuperclass()
			.withPrefabValues(Object.class, album, album2)
			.verify();
	}
}