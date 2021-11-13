package com.example.demo.services;

import java.util.concurrent.CompletableFuture;

public interface IApiService {
	 public CompletableFuture<Object> getApi(Integer number);
}
