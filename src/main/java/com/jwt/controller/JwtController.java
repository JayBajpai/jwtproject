package com.jwt.controller;

import com.jwt.entity.JwtRequest;
import com.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtService jwtService;
    @PostMapping({"/authenticate"})
    public void createJwtToken(@RequestBody JwtRequest jwtRequest){

    }
}
