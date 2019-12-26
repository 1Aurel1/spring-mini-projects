package com.aurel.lms.service;

import com.aurel.lms.dto.ApiResponse;
import com.aurel.lms.exeption.ResourceNotFoundException;
import com.aurel.lms.model.authority.AuthorityName;
import com.aurel.lms.repository.AuthorityRepository;
import com.aurel.lms.security.JWTProvider;
import com.aurel.lms.dto.auth.UserAuthenticationRequest;
import com.aurel.lms.dto.auth.UserRegistrationRequest;
import com.aurel.lms.model.User;
import com.aurel.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private AuthenticationManager authenticationManager;
    private JWTProvider jwtProvider;
    private PasswordEncoder passwordEncoder;
    private JWTUserDetailsService jwtUserDetailsService;


    @Autowired
    public AuthService(UserRepository userRepository, AuthorityRepository authorityRepository, AuthenticationManager authenticationManager, JWTProvider jwtProvider, PasswordEncoder passwordEncoder, JWTUserDetailsService jwtUserDetailsService) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    public ResponseEntity<?> registerUser(UserRegistrationRequest newUser){

        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));

        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);

        user.addAuthority(authorityRepository.findByName(AuthorityName.AUTHORITY_STUDENT).orElseThrow(() -> new ResourceNotFoundException("Authority", "name", AuthorityName.AUTHORITY_STUDENT.toString())));

        System.out.println(newUser);

        user = userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<?> authenticateUser(UserAuthenticationRequest authRequest) throws Exception {

        System.out.println(authRequest);

        authenticate(authRequest.getUsername(), authRequest.getPassword());

        System.out.println("Here i am");

        String jwt = jwtProvider.generateToken(jwtUserDetailsService.loadUserByUsername(authRequest.getUsername()));

        ApiResponse appResponse = new ApiResponse();
        appResponse.setStatus("success");
        Map<String, String> map = new HashMap<>();
        map.put("Token Type", "Bearer");
        map.put("JWT", jwt);
        appResponse.setData(map);

        return new ResponseEntity<>(appResponse, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
