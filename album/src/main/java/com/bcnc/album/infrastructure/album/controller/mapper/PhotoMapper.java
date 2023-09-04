package com.bcnc.album.infrastructure.album.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bcnc.album.application.album.domain.Photo;
import com.bcnc.album.infrastructure.album.controller.entity.PhotoDto;
import com.bcnc.album.infrastructure.common.constants.CommonConstants;


/**
 * Photo controller mapper.
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Mapper(componentModel = CommonConstants.COMPONENT_MODEL_SPRING)
public interface PhotoMapper {
	
	/**
	 * Convert photo placeholder entity to photo application entity
	 * @param photo {@link Photo} - Photo application entity.
	 * @return {@link PhotoDto} - Photo controller entity.
	 */
	List<PhotoDto> toListDto(List<Photo> photo);
	
	
	/**
	 * Convert photo placeholder entity to photo application entity
	 * @param photo {@link Photo} - Photo application entity.
	 * @return {@link PhotoDto} - Photo controller entity.
	 */
	PhotoDto toDto(Photo photo);
}
