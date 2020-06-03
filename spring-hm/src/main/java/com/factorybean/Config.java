package com.factorybean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config{
    public CarFactoryBean carFactoryBean(){
        return new CarFactoryBean();
    }
}