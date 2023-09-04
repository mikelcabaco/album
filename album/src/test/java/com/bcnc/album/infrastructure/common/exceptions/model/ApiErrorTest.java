package com.bcnc.album.infrastructure.common.exceptions.model;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

class ApiErrorTest {

	/**
	 * Test method with library equalsVerifier.
	 */
	@Test
	void testApiError() {
		var apiError = new ApiError();
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setMessage(HttpStatus.BAD_REQUEST.name());
		var errors = new HashMap<String, List<Object>>();
		errors.put("required", List.of("albumId"));
		apiError.setErrors(List.of(errors));
		
		
		var apiError2 = new ApiError();
		apiError2.setStatus(HttpStatus.OK);
		apiError2.setMessage(HttpStatus.OK.name());
		apiError2.setErrors(null);
		
		EqualsVerifier.forClass(ApiError.class)
			.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
			.withRedefinedSuperclass()
			.withPrefabValues(Object.class, apiError, apiError2)
			.verify();
	}

}
