package com.notabusiness.app.controller;

import com.notabusiness.app.entity.Users;
import com.notabusiness.app.exception.ApplicationException;
import com.notabusiness.app.gigzal.generated.controller.AuthenticationApi;
import com.notabusiness.app.gigzal.generated.model.LoginResponse;
import com.notabusiness.app.gigzal.generated.model.RegisterRequest;
import com.notabusiness.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements AuthenticationApi {

    private final UserService userService;

    private final ModelMapper modelMapper;

    private static final String RESPONSE_BAD_REQUEST = "username or password can not be empty";

    @Override
    public RegisterRequest register(RegisterRequest registerRequest) {
        log.info("call register() " + registerRequest);
        Users user = modelMapper.map(registerRequest, Users.class);
        if (user.getUsername() == null || user.getUsername().isBlank()
                || user.getPassword() == null || user.getPassword().isBlank()) {
            log.error(RESPONSE_BAD_REQUEST);
            throw new ApplicationException(RESPONSE_BAD_REQUEST);
        }
        return modelMapper.map(userService.register(user), RegisterRequest.class);
    }

    @Override
    public LoginResponse login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            log.error(RESPONSE_BAD_REQUEST);
            throw new ApplicationException(RESPONSE_BAD_REQUEST);
        }
        return userService.verify(username, password);
    }

}
