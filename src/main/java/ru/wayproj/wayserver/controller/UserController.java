package ru.wayproj.wayserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.wayproj.wayserver.Repositoryes.UserRepository;
import ru.wayproj.wayserver.models.User;

@RestController("/users")
public class UserController {

    final
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/createUser")
    public void createNewUser(@RequestBody User user){
        userRepository.save(user);
    }
}
