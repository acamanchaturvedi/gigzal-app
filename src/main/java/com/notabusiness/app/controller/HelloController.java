package com.notabusiness.app.controller;

import com.notabusiness.app.repo.CategoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "Hello Gigzal! " + request.getSession().getId();
    }

}

