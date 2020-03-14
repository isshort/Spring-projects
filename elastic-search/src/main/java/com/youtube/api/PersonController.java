package com.youtube.api;

import com.youtube.Entity.Person;
import com.youtube.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor //that's for Constructor for PersonController class
@RestController //
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init(){
        Person person=new Person();
        person.setId("K12343");
        person.setName("Hekmatullah");
        person.setSurname("Haris");
        person.setBirthDate(String.valueOf(Calendar.getInstance().getTime()));
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search){
        List<Person> personList=personRepository.getByCustomerQuery(search);
        return   ResponseEntity.ok(personList);
    }
    @GetMapping("/{name}/{surname}")
    public ResponseEntity<List<Person>> getPersonByNameOrSurname(@PathVariable String name, @PathVariable String surname){
        List<Person> personList1=personRepository.findByNameLikeOrSurnameLike(name,surname);
        return ResponseEntity.ok(personList1);
    }
}
