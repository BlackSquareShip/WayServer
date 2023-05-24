package ru.wayproj.wayserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.wayproj.wayserver.Repositoryes.UserRepository;
import ru.wayproj.wayserver.models.User;

@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void register(User user){
        userRepository.save(user);
    }
}
