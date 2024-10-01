package com.notabusiness.app.controller;

import com.notabusiness.app.entity.TempUser;
import com.notabusiness.app.service.TempUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private TempUserService tempUserService;

    @PostMapping("/register")
    public TempUser register(@RequestBody TempUser tempUser) {
        return tempUserService.register(tempUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody TempUser tempUser) {
        return tempUserService.verify(tempUser);
    }

}
