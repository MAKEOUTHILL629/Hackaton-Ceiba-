package com.example.demo.controllers;

import com.example.demo.dominio.Response;

import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
public class ServiceConsumer {

    private ReactiveCircuitBreakerFactory factoryCircuitBreaker;


    private WebClient.Builder webClient;

    public ServiceConsumer(WebClient.Builder webClient,
                            ReactiveCircuitBreakerFactory circuitBreakerFactory) {
        this.webClient = webClient;
        this.factoryCircuitBreaker = circuitBreakerFactory;
    }

    @GetMapping("/")
    public ResponseEntity<Object> consumerAPI(@RequestParam int number) {

        Mono<Object> response = webClient.build().get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("api-9.hack.local").path("/").queryParam("number", number)
                        .build())
                .retrieve().bodyToMono(Object.class)
                .transform(it -> {
                    ReactiveCircuitBreaker rcb = factoryCircuitBreaker.create("api-service");
                    return rcb.run(it, throwable -> Mono.just(new Response()));
                });






                /*.uri("http://api-9.hack.local/?number=" + number)
                .retrieve()
                .bodyToMono(Response.class)
                .transform(
                        it -> factoryCircuitBreaker.create("api-service")
                                .run(it,
                                        throwable -> {
                                            return Mono.just(new Response());
                                        }
                                )
                );*/

        return new ResponseEntity<>(response.block(), HttpStatus.OK);
    }
}
