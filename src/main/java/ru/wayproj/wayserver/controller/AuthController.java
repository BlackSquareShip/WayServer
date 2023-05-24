package ru.wayproj.wayserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.wayproj.wayserver.Repositoryes.UserRepository;
import ru.wayproj.wayserver.models.User;
import ru.wayproj.wayserver.services.RegistrationService;
import ru.wayproj.wayserver.util.UserValidator;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    UserValidator userValidator;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/registration")
    public ResponseEntity<User> createNewUser(@RequestBody User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(user);
        registrationService.register(user);

        return ResponseEntity.ok(user);
    }
}
