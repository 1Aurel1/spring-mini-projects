package com.example.demotest.api.util;

public interface JsonToObject<Json, Dto> {

    public Dto jsonToDto(Json json);

}
