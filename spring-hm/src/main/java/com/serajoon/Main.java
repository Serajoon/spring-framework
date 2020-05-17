package com.serajoon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com")
//@EnableAspectJAutoProxy
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
		System.out.println(applicationContext.getBean(A.class).getB());
//		applicationContext.getBean(B.class).getA().getB();
	}
}
