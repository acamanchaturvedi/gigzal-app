package com.notabusiness.app.service;

import org.springframework.stereotype.Service;

@Service
public class JwtService {


    public String generateToken() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkFtYW4iLCJpYXQiOjE1MTYyMzkwMjJ9.P-8FS0HIYo1N8bQK4IA7IuAD5YcEoAhcNE26LWcvUmM";
    }
}
