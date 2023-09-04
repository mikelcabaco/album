package com.bcnc.album.infrastructure.album.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.album.application.album.service.AlbumService;
import com.bcnc.album.infrastructure.album.controller.constants.AlbumConstants;
import com.bcnc.album.infrastructure.album.controller.entity.AlbumDto;
import com.bcnc.album.infrastructure.album.controller.entity.PhotoDto;
import com.bcnc.album.infrastructure.album.controller.mapper.AlbumMapper;
import com.bcnc.album.infrastructure.album.controller.mapper.PhotoMapper;
import com.bcnc.album.infrastructure.common.exceptions.CoreException;
import com.bcnc.album.infrastructure.common.exceptions.model.ApiError;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


/**
 * Controller for operations with album module.
 * 
 * @author BCNC
 * @since 1.0.0
 */

@RestController
@RequestMapping(AlbumConstants.CONTROLLER_NAMESPACE)
public class AlbumController {

	@Autowired
	private AlbumService service;
	
	@Autowired
	private AlbumMapper albumMapper;
	
	@Autowired
	private PhotoMapper photoMapper;
	
	
	/**
	 * Get all albums
	 * @return {@link List}<{@link AlbumDto}> list of albums
	 * @throws CoreException in case of error
	 */
	@Operation(
		summary = "Find all albums in application.",
		responses = {
			@ApiResponse(responseCode = "200", description = "Records has been found successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error",
				content = {
					@Content(
						mediaType = MediaType.APPLICATION_JSON_VALUE,
						array = @ArraySchema(schema = @Schema(implementation = ApiError.class)))
				})
		}
	)
	@GetMapping(value = AlbumConstants.CONTROLLER_GET_ALL_ALBUMS, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlbumDto>> getAllAlbums() throws CoreException {
		return new ResponseEntity<>(albumMapper.toListDto(service.findAll()), HttpStatus.OK);
	}
	
	
	/**
	 * Get all photos in an album
	 * 
	 * @param albumId {@link Long} the album id to find photos
	 * @return {@link List}<{@link PhotoDto}> list of photos
	 * @throws CoreException in case of error
	 */
	@Operation(
		summary = "Find all photos in an album.",
		responses = {
			@ApiResponse(responseCode = "200", description = "Record has been found successfully"),
			@ApiResponse(responseCode = "400", description = "Request parameters are invalid.",
				content = {
					@Content(
						mediaType = MediaType.APPLICATION_JSON_VALUE,
						array = @ArraySchema(schema = @Schema(implementation = ApiError.class)))
				}),
			@ApiResponse(responseCode = "500", description = "Internal server error",
				content = {
					@Content(
						mediaType = MediaType.APPLICATION_JSON_VALUE,
						array = @ArraySchema(schema = @Schema(implementation = ApiError.class)))
				})
		}
	)
	@GetMapping(value = AlbumConstants.CONTROLLER_GET_ALL_PHOTOS_BY_ALBUM, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PhotoDto>> getPhotosByAlbum(@PathVariable Long albumId) throws CoreException {
		return new ResponseEntity<>(photoMapper.toListDto(service.findPhotosByAlbumId(albumId)), HttpStatus.OK);
	}
}
