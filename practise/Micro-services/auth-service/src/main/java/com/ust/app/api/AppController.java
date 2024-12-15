package com.ust.app.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app")
public class AppController {

    @GetMapping("/hello")
    public String sayhello(){
        return "Hello All";
    }

    @GetMapping("/hello/admin")
    public String sayHelloAdmin(){
        return "Hello Admin";
    }

    @GetMapping("hello/user")
    public String sayhelloUser(){
        return "Hello User";
    }

}
