package com.andres.curso.java.springboot.backend.controllers;

import com.andres.curso.java.springboot.backend.entities.AuthRequest;
import com.andres.curso.java.springboot.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/Authenticate")
    public String createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
        return authService.authenticate(authRequest.getUsername(), authRequest.getPassword());
    }
}