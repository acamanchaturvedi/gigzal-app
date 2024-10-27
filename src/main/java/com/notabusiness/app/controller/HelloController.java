package com.notabusiness.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "session id: " + request.getSession().getId();
    }

}


