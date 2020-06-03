package com.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.lifecycle")
public class LifeCycleMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleMain.class);
		Person person = applicationContext.getBean("person",Person.class);
	}
}
