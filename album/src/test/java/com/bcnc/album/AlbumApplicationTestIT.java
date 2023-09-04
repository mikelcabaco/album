package com.bcnc.album;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.WebApplicationContext;

/**
 * Test class for {@link WebApplicationContext}
 * 
 * @author BCNC
 * @since 1.0.0
 */
class AlbumApplicationTestIT extends BaseTest {

	/**
	 * Test method getApplicationContext.
	 * Expect to be not null.
	 */
	@Test
	void testGetApplicationContext() throws Throwable {
		Assertions.assertNotNull(context);
		
	}

}
