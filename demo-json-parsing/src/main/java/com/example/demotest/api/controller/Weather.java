package com.example.demotest.api.controller;

import com.example.demotest.api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Weather {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weathernow")
    public ResponseEntity<?> getWeatherNow(){
        return weatherService.getWeather();
    }
}
