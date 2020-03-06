package com.example.Youtube;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class HelloAPI {

    @GetMapping
    public String Hello(){
        return "Hello";
    }


}
