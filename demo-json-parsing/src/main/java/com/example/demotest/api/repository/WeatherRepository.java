package com.example.demotest.api.repository;

import com.example.demotest.api.model.Weather;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository {
    public JsonObject getWeatherNow(float latitude, float longitude);
}
