package com.bcnc.album.application.album.domain;

import com.bcnc.album.domain.Core;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Album application entity
 * 
 * @author BCNC
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Album extends Core<Long> {
	
	private static final long serialVersionUID = 1L;
	
	
	private Long userId;
	
	private String title;
}
