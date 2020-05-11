package com.serajoon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.serajoon")
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
		A bean = applicationContext.getBean(A.class);
		System.err.println(bean);
		System.err.println(applicationContext);
	}
}
