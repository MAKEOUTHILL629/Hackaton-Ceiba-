package com.example.demo.controller;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.IApiService;

@RestController
@RequestMapping("/")

public class ApiController {
	
	
	 @Autowired
	 private IApiService iApiService;
 
	 @GetMapping
	 public @ResponseBody CompletableFuture<ResponseEntity> getAllCars() {
	    return iApiService.getAllCars().<ResponseEntity>thenApply(ResponseEntity::ok)
		                .exceptionally(handleGetCarFailure);
	 }
	 
	 private static Function<Throwable, ResponseEntity<? extends Object>> handleGetCarFailure = throwable -> {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	 };
}
