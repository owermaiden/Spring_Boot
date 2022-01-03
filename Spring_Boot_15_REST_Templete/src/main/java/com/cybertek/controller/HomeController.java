package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class HomeController {

    final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers(){

        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);

        return responseEntity.getBody();
    }

    @GetMapping(value = "/{id}")
    public User readUser(@PathVariable("id") Integer id){
        String URL = URI + "/{id}";

        return restTemplate.getForEntity(URL,User.class,id).getBody();
    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostsFromDummyApi(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","61c2e109f58bec8104ea759d");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // if we want to send some headers.. we use exchange

        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

        return response;

    }
}
