package com.aurel.lms.dto.auth;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String username;
    private String password;
}
