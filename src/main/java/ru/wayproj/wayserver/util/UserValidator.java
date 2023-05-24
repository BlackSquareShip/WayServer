package ru.wayproj.wayserver.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.wayproj.wayserver.models.User;
import ru.wayproj.wayserver.services.UserDetailsServiceImpl;

@Component
public class UserValidator implements Validator {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        try {
            userDetailsService.loadUserByUsername(user.getEmail());
        } catch (UsernameNotFoundException e){
            return;
        }

        errors.rejectValue("email", "", "Человек с такой почтой уже существует");
    }
}
