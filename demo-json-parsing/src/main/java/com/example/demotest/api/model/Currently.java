package com.example.demotest.api.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public
class Currently {
    private Timestamp time;
    private String summary;
    private String icon;
    private float temperature;
    private float apparentTemperature;
    private float humidity;
}
