package ru.wayproj.wayserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.wayproj.wayserver.Repositoryes.UserRepository;
import ru.wayproj.wayserver.models.User;

import java.net.http.HttpResponse;

@RestController()
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    final
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createNewUser(@RequestBody User user){
        System.out.println(user.getFio());
        userRepository.save(user);

        return ResponseEntity.ok("");
    }
}
