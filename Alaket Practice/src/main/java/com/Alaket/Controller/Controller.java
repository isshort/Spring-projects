package com.Alaket.Controller;

import com.Alaket.Dto.ProfileDto;
import com.Alaket.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@AllArgsConstructor
public class Controller {

    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<ProfileDto> kaydet(@RequestBody ProfileDto profileDto){
        return ResponseEntity.ok(profileService.save(profileDto));
    }

    @GetMapping
    public ResponseEntity<List<ProfileDto>>tumuntulistele(){
        return ResponseEntity.ok(profileService.getAll());
    }
}
