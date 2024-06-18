package com.example.microservice_transaction.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;



@RestController
public class Demo {
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String defaultEndpoint() {
        return "Welcome to GitPods Demo!";
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/hello-service")
    public String callOtherService(@RequestParam(value = "name", defaultValue = "World") String name) {
        // Call the other service running on localhost:9090
        String url = "http://localhost:9090/hello";
        String response = restTemplate.getForObject(url, String.class);

        return String.format("Hello, %s! Response from other service: %s", name, response);
    }
}