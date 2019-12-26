package com.aurel.lms.dto.auth;

import lombok.Data;

@Data
public class UserAuthenticationRequest {

    private String username;
    private String password;
}
