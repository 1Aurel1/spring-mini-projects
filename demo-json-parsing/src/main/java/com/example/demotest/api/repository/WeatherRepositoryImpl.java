package com.example.demotest.api.repository;

import com.example.demotest.api.model.Weather;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

    @Override
    public JsonObject getWeatherNow(float latitude, float longitude) {
        String sUrl = "https://api.darksky.net/forecast/99560cae9c1d3befc99bd0a78c085e2f/"+latitude+"%2C"+longitude+"?exclude=minutely,daily,flags,hourly";
        URL url = null;
        URLConnection request = null;
        JsonParser jp = new JsonParser();
        JsonElement root= null;
        JsonObject rootobj =null;
        try {
            url = new URL  (sUrl);
            request = url.openConnection();
            request.connect();
            root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            rootobj = root.getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*System.out.println(rootobj);*/
        return rootobj;
    }

}
