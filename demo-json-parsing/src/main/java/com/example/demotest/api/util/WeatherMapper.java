package com.example.demotest.api.util;

import com.example.demotest.api.model.Currently;
import com.example.demotest.api.model.Weather;
import com.google.gson.JsonObject;

import java.sql.Timestamp;

public class WeatherMapper implements JsonToObject<JsonObject, Weather>{
    
    @Override
    public Weather jsonToDto(JsonObject jsonWeather) {

        Weather weather = new Weather();
        Currently currently = new Currently();
        JsonObject jsonCurrently = jsonWeather.get("currently").getAsJsonObject();

        weather.setLatitude(jsonWeather.get("latitude").getAsFloat());
        weather.setLongitude(jsonWeather.get("longitude").getAsFloat());
        weather.setTimezone(jsonWeather.get("timezone").getAsString());

        currently.setTime(new Timestamp(jsonCurrently.get("time").getAsInt()));
        currently.setTemperature(jsonCurrently.get("temperature").getAsFloat());
        currently.setApparentTemperature(jsonCurrently.get("apparentTemperature").getAsFloat());
        currently.setSummary(jsonCurrently.get("summary").getAsString());
        currently.setIcon(jsonCurrently.get("icon").getAsString());
        currently.setHumidity(jsonCurrently.get("humidity").getAsFloat());

        weather.setCurrently(currently);

        return weather;
    }
}
