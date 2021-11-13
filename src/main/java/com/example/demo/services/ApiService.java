package com.example.demo.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;


@Service
@Log
public class ApiService implements IApiService{
	
	@Async
	@Cacheable(value = "books", unless = "#result == null")
    public CompletableFuture<Object> getAllCars() {
			RestTemplate restTemplate = new RestTemplate();
			Object foo = restTemplate.getForObject("http://api-9.hack.local/?number=2", Object.class);
			log.info("ejecutando la API");
	        return CompletableFuture.completedFuture(foo);
		
		
    }
}
