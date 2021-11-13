package com.example.demo.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;

@Service
@Log
public class ApiService implements IApiService{
	
	@Value("${application.url}")
    private String serverURL;
	
	@Value("${application.port}")
    private String serverPort;
	
	@Async
	@Cacheable(value = "books", unless = "#result == null")
    public CompletableFuture<Object> getApi(Integer number) {
			RestTemplate restTemplate = new RestTemplate();
			Object foo = restTemplate.getForObject(serverURL+":"+serverPort+"number="+number, Object.class);
			log.info("ejecutando la API");
	        return CompletableFuture.completedFuture(foo);
		
		
    }
}
