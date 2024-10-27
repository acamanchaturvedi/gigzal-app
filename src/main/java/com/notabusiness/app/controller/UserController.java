package com.notabusiness.app.controller;

import com.notabusiness.app.entity.Users;
import com.notabusiness.app.exception.ApplicationException;
import com.notabusiness.app.gigzal.generated.controller.AuthenticationApi;
import com.notabusiness.app.gigzal.generated.model.LoginResponse;
import com.notabusiness.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements AuthenticationApi {

    private final UserService userService;

    private static final String RESPONSE_BAD_REQUEST = "username or password can not be empty";

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        if (user.getUsername() == null || user.getUsername().isBlank() || user.getPassword() == null || user.getPassword().isBlank()) {
            throw new ApplicationException(RESPONSE_BAD_REQUEST);
        }
        return userService.register(user);
    }

    @Override
    public LoginResponse login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            throw new ApplicationException(RESPONSE_BAD_REQUEST);
        }
        return userService.verify(username, password);
    }

}
