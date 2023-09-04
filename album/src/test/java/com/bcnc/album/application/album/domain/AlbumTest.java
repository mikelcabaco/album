package com.bcnc.album.application.album.domain;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;


class AlbumTest {

	/**
	 * Test method with library equalsVerifier.
	 */
	@Test
	void testAlbum() {
		var album = new Album();
		album.setId(1L);
		album.setUserId(1L);
		album.setTitle("Album1");
		
		
		var album2 = new Album();
		album2.setId(2L);
		album2.setUserId(2L);
		album2.setTitle("Album2");
		
		EqualsVerifier.forClass(Album.class)
			.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
			.withRedefinedSuperclass()
			.withPrefabValues(Object.class, album, album2)
			.verify();
	}

}
