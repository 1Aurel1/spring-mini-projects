package com.aurel.lms.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ApiResponse {

    private String status;
    private Map<String, ?> data;
}
