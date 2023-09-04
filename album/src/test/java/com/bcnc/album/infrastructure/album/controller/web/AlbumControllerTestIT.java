package com.bcnc.album.infrastructure.album.controller.web;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.bcnc.album.BaseTest;
import com.bcnc.album.application.album.service.AlbumService;
import com.bcnc.album.infrastructure.album.controller.constants.AlbumConstants;
import com.bcnc.album.infrastructure.album.controller.entity.AlbumDto;
import com.bcnc.album.infrastructure.album.controller.entity.PhotoDto;
import com.bcnc.album.infrastructure.common.exceptions.BadRequestException;
import com.bcnc.album.infrastructure.common.exceptions.model.ApiError;
import com.fasterxml.jackson.core.type.TypeReference;

class AlbumControllerTestIT extends BaseTest {
	
	@SpyBean
	private AlbumService albumService;
	
	
	@Test
	void testGetAllAlbums() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				AlbumConstants.CONTROLLER_NAMESPACE + AlbumConstants.CONTROLLER_GET_ALL_ALBUMS);
		
		ResultActions ra = mockMvc.perform(requestBuilder);
		
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		var data = mapper.readValue(ra.andReturn().getResponse().getContentAsString(), new TypeReference<List<AlbumDto>>() {});
		Assertions.assertNotNull(data);
		Assertions.assertFalse(data.isEmpty());
		Assertions.assertEquals(1, data.size());
		var album = data.get(0);
		Assertions.assertEquals(1L, album.getId());
		Assertions.assertEquals(1L, album.getUserId());
		Assertions.assertEquals("Album1", album.getTitle());
	}
	
	
	@Test
	void testGetAllPhotosInAlbum() throws Exception {
		var albumId = 1L;
		var allPhotosApi = AlbumConstants.CONTROLLER_GET_ALL_PHOTOS_BY_ALBUM.replace("{albumId}", String.valueOf(albumId));
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				AlbumConstants.CONTROLLER_NAMESPACE + allPhotosApi);
		
		ResultActions ra = mockMvc.perform(requestBuilder);
		
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		var data = mapper.readValue(ra.andReturn().getResponse().getContentAsString(), new TypeReference<List<PhotoDto>>() {});
		Assertions.assertNotNull(data);
		Assertions.assertFalse(data.isEmpty());
		Assertions.assertEquals(1, data.size());
		var photo = data.get(0);
		Assertions.assertEquals(3L, photo.getId());
		Assertions.assertEquals(albumId, photo.getAlbumId());
		Assertions.assertEquals("officia porro iure quia iusto qui ipsa ut modi", photo.getTitle());
		Assertions.assertEquals("https://via.placeholder.com/600/24f355", photo.getUrl());
		Assertions.assertEquals("https://via.placeholder.com/150/24f355", photo.getThumbnailUrl());
	}
	
	
	@Test
	void testGetAllPhotosWithAlbumNull() throws Exception {
		var albumId = 1L;
		var allPhotosApi = AlbumConstants.CONTROLLER_GET_ALL_PHOTOS_BY_ALBUM.replace("{albumId}", String.valueOf(albumId));
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				AlbumConstants.CONTROLLER_NAMESPACE + allPhotosApi);
		
		// Mock to throw a BadRequestException
		var albumDto = new AlbumDto();
		BindingResult bindingResult = new BeanPropertyBindingResult(albumDto, "albumDto");
		bindingResult.rejectValue("id", "required", new Object[] {"albumId"}, null);
		var ex = new BadRequestException(bindingResult);
		when(albumService.findPhotosByAlbumId(albumId)).thenThrow(ex);
		
		ResultActions ra = mockMvc.perform(requestBuilder);
		
		ra.andExpect(MockMvcResultMatchers.status().isBadRequest());
		var apiError = mapper.readValue(ra.andReturn().getResponse().getContentAsString(), new TypeReference<ApiError>() {});
		Assertions.assertNotNull(apiError);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, apiError.getStatus());
		var errors = apiError.getErrors();
		Assertions.assertFalse(errors.isEmpty());
		var error = errors.get(0);
		Assertions.assertTrue(error.get("required").contains("albumId"));
	}

}
