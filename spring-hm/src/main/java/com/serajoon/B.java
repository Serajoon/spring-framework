package com.serajoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component("b")
public class B {
//	@Autowired
    private A a;
	public A getA() {
		return a;
	}
}