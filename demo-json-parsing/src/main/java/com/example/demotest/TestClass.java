package com.example.demotest;

import com.example.demotest.api.repository.WeatherRepository;
import com.example.demotest.api.repository.WeatherRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class TestClass {
    public static void main(String[] args) {
        WeatherRepositoryImpl weatherRepository = new WeatherRepositoryImpl();
        weatherRepository.getWeatherNow(42.3601f, (float) 71.0589);
    }
}
