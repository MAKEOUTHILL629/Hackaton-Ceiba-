package com.example.demo.controllers;

import com.example.demo.dominio.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceConsumer {

    @GetMapping("/")
    public ResponseEntity<Response> consumerAPI(@RequestParam int number){
        return new ResponseEntity<Response>(new Response(), HttpStatus.OK);
    }
}
