package com.Youtube.api;

import com.Youtube.Entity.User;
import com.Youtube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {
        @Autowired
        private UserRepository userRepository;
        @PostConstruct
        public void init(){
            User user=new User();
            user.setName("Namatullah");
            user.setSurname("wahidi");
            userRepository.save(user);
        }

        @PostMapping
        public ResponseEntity<User> add(@RequestBody User user){
            return ResponseEntity.ok(userRepository.save(user));
        }
        @GetMapping
        public ResponseEntity<List<User>> whole_to_list(){
            return ResponseEntity.ok(userRepository.findAll());
        }
}
