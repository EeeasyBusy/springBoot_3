package com.example.springBootdemo_3.service;

import com.example.springBootdemo_3.controller.Authorities;
import com.example.springBootdemo_3.domain.UserRepository;
import com.example.springBootdemo_3.exception.InvalidCredentials;
import com.example.springBootdemo_3.exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping
public class AuthorizationService {
    UserRepository userRepository;
    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty", HttpStatus.BAD_REQUEST);
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user, HttpStatus.UNAUTHORIZED);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
