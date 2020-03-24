package com.youtube.api;

import com.youtube.model.personDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {
    private static final String urladdr = "http://localhost:8083/person";


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<personDto>> getPersonList() {

        ResponseEntity<List> result = restTemplate.getForEntity(urladdr, List.class);
        List<personDto> dtos=result.getBody();
//        System.out.println(result);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<personDto> kaydet(@RequestBody personDto dto) {

        ResponseEntity<personDto> result = restTemplate.postForEntity(urladdr,dto,personDto.class);
        personDto dtos=result.getBody();
//        System.out.println(result);
        return ResponseEntity.ok(dtos);
    }

}
