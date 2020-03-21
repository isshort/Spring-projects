package com.youtube;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class messageApi {

    @GetMapping
    public String giveMessage(){
        return "That is the giveMessage function";
    }
}
