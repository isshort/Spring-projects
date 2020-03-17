package com.Youtube;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/pet")
@Api(value = "My first and Pet Api Documentation") // you can add dependency for this from https://springfox.github.io  and for Maven Projects
public class PetController {

    private List<Pet> petList=new ArrayList<>();

    @PostConstruct // for constructor this function will be work firstly
    public void init(){
        petList.add(new Pet(1,"Namatullah",new Date()));
    }

    @PostMapping
    @ApiOperation(value = "New Pet save method",notes = "bu metodu dikkatli kullan")
    public ResponseEntity<Pet> Save(@RequestBody @ApiParam(value = "Enimals") Pet pet){
       petList.add(pet);
       return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Pet lists Method",notes = "This method gets all the animals")
    public ResponseEntity<List<Pet>> ListAll(){
        return ResponseEntity.ok(petList);
    }
}
