package com.example.demotest.api.model;

import lombok.Data;

@Data
public class Weather {
    private double latitude;
    private double longitude;
    private String timezone;

    private Currently currently;
}
