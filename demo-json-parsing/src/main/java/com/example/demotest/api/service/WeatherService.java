package com.example.demotest.api.service;

import com.example.demotest.api.model.Currently;
import com.example.demotest.api.model.Weather;
import com.example.demotest.api.model.Weather;
import com.example.demotest.api.repository.WeatherRepository;
import com.example.demotest.api.repository.WeatherRepositoryImpl;
import com.example.demotest.api.util.WeatherMapper;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class WeatherService {

    private WeatherRepositoryImpl weatherRepository;
    private WeatherMapper weatherMapper = new WeatherMapper();

    @Autowired
    public WeatherService(WeatherRepositoryImpl weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public ResponseEntity<?> getWeather(){
        Weather weather = weatherMapper.jsonToDto(weatherRepository.getWeatherNow((float)42.3601, (float)-71.0589));
        /*Currently currently = new Currently();
        JsonObject object = weatherRepository.getWeatherNow((float)42.3601, (float)-71.0589);*/
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

}
