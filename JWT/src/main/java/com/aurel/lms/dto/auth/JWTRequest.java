package com.aurel.lms.dto.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class JWTRequest implements Serializable {

    private String username;
    private String password;
}
