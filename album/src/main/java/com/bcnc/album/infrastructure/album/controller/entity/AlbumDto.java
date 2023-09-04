package com.bcnc.album.infrastructure.album.controller.entity;

import com.bcnc.album.domain.Core;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Album controller entity
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AlbumDto extends Core<Long> {
	
	private static final long serialVersionUID = 1L;
	
	
	private Long userId;
	
	private String title;
}
