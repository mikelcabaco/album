package com.bcnc.album;

import static org.mockito.Mockito.when;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.bcnc.album.application.album.domain.Album;
import com.bcnc.album.application.album.domain.Photo;
import com.bcnc.album.application.album.repository.AlbumRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

/**
 * Base test for all application tests 
 * 
 * @author BCNC
 * @since 1.0.0
 */
@AutoConfigureMockMvc
@SpringBootTest
public abstract class BaseTest {
	
	/** The mockMvc to call endpoints */
	@Autowired
	protected MockMvc mockMvc;

	/** Injected web application context */
	@Autowired
	protected WebApplicationContext context;
	
	@MockBean
	private AlbumRepository albumRepository;
	
	protected ObjectMapper mapper = new ObjectMapper();
	
	
	
	/** Mock calls to JSON Placeholder rest template. */
	@PostConstruct
	private void initMocks() {
		var album = new Album();
		album.setId(1L);
		album.setUserId(1L);
		album.setTitle("Album1");
		when(albumRepository.findAll()).thenReturn(List.of(album));
		
		var photo = new Photo();
		photo.setId(3L);
		photo.setAlbumId(1L);
		photo.setTitle("officia porro iure quia iusto qui ipsa ut modi");
		photo.setUrl("https://via.placeholder.com/600/24f355");
		photo.setThumbnailUrl("https://via.placeholder.com/150/24f355");
		when(albumRepository.findPhotosByAlbumId(1L)).thenReturn(List.of(photo));
	}
	
}
