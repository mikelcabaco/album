package com.bcnc.album.infrastructure.album.controller.entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;


class AlbumDtoTest {

	/**
	 * Test method with library equalsVerifier.
	 */
	@Test
	void testAlbumDto() {
		var album = new AlbumDto();
		album.setId(1L);
		album.setUserId(1L);
		album.setTitle("Album1");
		
		
		var album2 = new AlbumDto();
		album2.setId(2L);
		album2.setUserId(2L);
		album2.setTitle("Album2");
		
		EqualsVerifier.forClass(AlbumDto.class)
			.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
			.withRedefinedSuperclass()
			.withPrefabValues(Object.class, album, album2)
			.verify();
	}

}
