package com.aurel.lms.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class JWTResponse implements Serializable {

    private final String JWToken;
}
