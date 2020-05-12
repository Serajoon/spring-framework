package com.serajoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("a")
public class A {
	@Autowired
    private B b;
	public B getB() {
		return b;
	}
}