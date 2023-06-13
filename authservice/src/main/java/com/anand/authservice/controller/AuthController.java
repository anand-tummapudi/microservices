package com.anand.authservice.controller;

import com.anand.authservice.entity.UserCredentials;
import com.anand.authservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredentials userCredentials){
        return authService.saveUser(userCredentials);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredentials userCredentials){
        return userCredentials.getName();
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        return "validToken";
    }
}
