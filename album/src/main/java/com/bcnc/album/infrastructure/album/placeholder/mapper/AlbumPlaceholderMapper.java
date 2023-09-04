package com.bcnc.album.infrastructure.album.placeholder.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bcnc.album.application.album.domain.Album;
import com.bcnc.album.infrastructure.album.placeholder.entity.AlbumPlaceholder;
import com.bcnc.album.infrastructure.common.constants.CommonConstants;


/**
 * Album placeholder mapper.
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Mapper(componentModel = CommonConstants.COMPONENT_MODEL_SPRING)
public interface AlbumPlaceholderMapper {
	
	/**
	 * Convert album placeholder entity list to album application entity list
	 * @param albumPlaceholder {@link List}<{@link AlbumPlaceholder}> - Album placeholder entity list.
	 * @return {@link List}<{@link Album}> - Album application entity.
	 */
	List<Album> toListDomain(List<AlbumPlaceholder> albumPlaceholder);
	
	
	/**
	 * Convert album placeholder entity to album application entity
	 * @param albumPlaceholder {@link AlbumPlaceholder} - Album placeholder entity.
	 * @return {@link Album} - Album application entity.
	 */
	Album toDomain(AlbumPlaceholder albumPlaceholder);
}
