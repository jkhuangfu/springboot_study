package com.jk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
public class Beans {
    @Bean
    public Calendar calendar(){
        return  Calendar.getInstance();
    }
}
