package com.bcnc.album.infrastructure.album.placeholder.entity;

import com.bcnc.album.domain.Core;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Album placeholder entity
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AlbumPlaceholder extends Core<Long> {
	
	private static final long serialVersionUID = 1L;
	
	
	private Long userId;
	
	private String title;

}
