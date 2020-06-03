package com.lifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Person {
	public Person() {
		System.out.println("Person构造方法");
	}
}
