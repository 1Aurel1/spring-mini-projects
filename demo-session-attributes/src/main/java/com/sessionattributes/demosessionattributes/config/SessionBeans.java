package com.sessionattributes.demosessionattributes.config;

import com.sessionattributes.demosessionattributes.model.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SessionBeans {

    @Bean
    @Scope(
            value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public List<Todo> todos(){
        return new ArrayList<>();
    }
}
