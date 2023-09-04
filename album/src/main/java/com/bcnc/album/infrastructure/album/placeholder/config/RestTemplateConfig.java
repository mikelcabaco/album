package com.bcnc.album.infrastructure.album.placeholder.config;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Configuration class to Rest template
 * 
 * @author BCNC
 * @since 2.0.0
 */
@Configuration
public class RestTemplateConfig {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
				.messageConverters(getJackson2MessageConverterFor(List.of(MediaType.APPLICATION_JSON)))
				.build();
	}
	
	
	/**
	 * Add a JSON converter to rest template.
	 * @return
	 */
	private HttpMessageConverter<?> getJackson2MessageConverterFor(List<MediaType> types) {
		var converter = new MappingJackson2HttpMessageConverter(objectMapper);
		converter.setSupportedMediaTypes(types);
		
		return converter;
	}

}
