package com.notabusiness.app.controller;

import com.notabusiness.app.entity.Users;
import com.notabusiness.app.exception.ApplicationException;
import com.notabusiness.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        if(user.getUsername()==null) {
            throw new ApplicationException("error code","username is null", HttpStatus.BAD_REQUEST);
        }
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.verify(user);
    }

}
