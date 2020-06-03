package com.factorybean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.FactoryBean;
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() {
        Car car = new Car();
        car.setMaxSpeed(260);
        car.setBrand("宝马");
        car.setPrice(500000);
        return car;
    }
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
    @Override
    public boolean isSingleton() {
        return true;
    }
}

