package com.serajoon;

import org.springframework.context.annotation.*;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Component;

@ComponentScan("com.serajoon")
//@EnableAspectJAutoProxy(proxyTargetClass = false)
public class Main {
	public static void main(String[] args) {
//		StandardAnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(Main.class);
//		System.out.println(annotationMetadata.isAnnotated("org.springframework.context.annotation.ComponentScan"));
//		System.out.println(annotationMetadata.isAnnotated("org.springframework.stereotype.Component"));
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
		System.out.println(applicationContext.getBean(C.class));
		System.out.println(applicationContext.getBean(C.class));
	}
}
