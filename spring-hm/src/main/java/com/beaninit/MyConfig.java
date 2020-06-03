package com.beaninit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean(initMethod = "initMethod")
    public MyTestBean myTestBean() {
        return new MyTestBean();
    }


    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}