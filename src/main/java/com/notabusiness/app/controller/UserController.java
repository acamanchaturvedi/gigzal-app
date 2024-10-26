package com.notabusiness.app.controller;

import com.notabusiness.app.entity.Users;
import com.notabusiness.app.exception.ApplicationException;
import com.notabusiness.app.gigzal.generated.controller.AuthenticationApi;
import com.notabusiness.app.gigzal.generated.model.LoginResponse;
import com.notabusiness.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements AuthenticationApi {

    private final UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        if (user.getUsername() == null) {
            throw new ApplicationException("error code", "username is null", HttpStatus.BAD_REQUEST);
        }
        return userService.register(user);
    }

    @Override
    public LoginResponse login(String username, String password) {
        return userService.verify(username, password);
    }

}
