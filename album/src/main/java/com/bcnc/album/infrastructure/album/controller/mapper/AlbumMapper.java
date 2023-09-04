package com.bcnc.album.infrastructure.album.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bcnc.album.application.album.domain.Album;
import com.bcnc.album.infrastructure.album.controller.entity.AlbumDto;
import com.bcnc.album.infrastructure.common.constants.CommonConstants;


/**
 * Album controller mapper.
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Mapper(componentModel = CommonConstants.COMPONENT_MODEL_SPRING)
public interface AlbumMapper {
	
	/**
	 * Convert album placeholder entity to album application entity
	 * @param album {@link Album} - Album application entity.
	 * @return {@link AlbumDto} - Album controller entity.
	 */
	List<AlbumDto> toListDto(List<Album> album);
	
	
	/**
	 * Convert album placeholder entity to album application entity
	 * @param album {@link Album} - Album application entity.
	 * @return {@link AlbumDto} - Album controller entity.
	 */
	AlbumDto toDto(Album album);
}
