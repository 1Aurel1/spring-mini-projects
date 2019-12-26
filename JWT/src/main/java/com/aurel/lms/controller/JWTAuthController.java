package com.aurel.lms.controller;

import com.aurel.lms.dto.auth.UserAuthenticationRequest;
import com.aurel.lms.dto.auth.UserRegistrationRequest;
import com.aurel.lms.security.CurrentUser;
import com.aurel.lms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class JWTAuthController {

    private AuthService authService;

    @Autowired
    public JWTAuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> postAuth(@Valid @RequestBody UserAuthenticationRequest userAuthenticationRequest) throws Exception {
        return authService.authenticateUser(userAuthenticationRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> postRegister(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest){
        return authService.registerUser(userRegistrationRequest);
    }

    @GetMapping("/test")
    public String test(@CurrentUser UserDetails userDetails){
        return userDetails.getUsername();
    }

}
