package com.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CarFactoryBean.class);
		Car car = applicationContext.getBean("carFactoryBean", Car.class);
		Car car1 = applicationContext.getBean("carFactoryBean", Car.class);

		CarFactoryBean factoryBean = applicationContext.getBean("&carFactoryBean", CarFactoryBean.class);
		Car object = factoryBean.getObject();
		System.out.println();
	}

}
