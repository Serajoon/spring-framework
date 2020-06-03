package com.beaninit;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

@Data
public class MyTestBean implements InitializingBean, BeanNameAware {

    private String beanName;

    private String testStr = "testStr";

    public MyTestBean() {
        System.out.println("默认构造方法");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean afterPropertiesSet");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct");
    }

    private void initMethod() {
        System.out.println("initMethod");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}