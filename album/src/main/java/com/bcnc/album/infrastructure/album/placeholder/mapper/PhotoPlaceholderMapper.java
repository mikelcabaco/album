package com.bcnc.album.infrastructure.album.placeholder.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bcnc.album.application.album.domain.Photo;
import com.bcnc.album.infrastructure.album.placeholder.entity.PhotoPlaceholder;
import com.bcnc.album.infrastructure.common.constants.CommonConstants;


/**
 * Photo placeholder mapper.
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Mapper(componentModel = CommonConstants.COMPONENT_MODEL_SPRING)
public interface PhotoPlaceholderMapper {
	
	/**
	 * Convert photo placeholder entity list to photo application entity list
	 * @param photoPlaceholder {@link List}<{@link PhotoPlaceholder}> - Photo placeholder entity list.
	 * @return {@link List}<{@link Photo}> - Photo application entity.
	 */
	List<Photo> toListDomain(List<PhotoPlaceholder> photoPlaceholder);
	
	
	/**
	 * Convert photo placeholder entity to photo application entity
	 * @param photoPlaceholder {@link PhotoPlaceholder} - Photo placeholder entity.
	 * @return {@link Photo} - Photo application entity.
	 */
	Photo toDomain(PhotoPlaceholder photoPlaceholder);
}
