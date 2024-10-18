package com.notabusiness.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OneMoreController {

    private List<String> students = new ArrayList<>(List.of("a", "b"));

    @GetMapping("/students")
    public List<String> getUsers() {
        return students;
    }

    @PostMapping("/students")
    public String addStudent(@RequestParam String student) {
        students.add(student);
        return student;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
