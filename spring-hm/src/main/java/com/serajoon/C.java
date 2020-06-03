package com.serajoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("c")
public class C {
	//	@Autowired
	private C c;

	public C() {
		System.out.println("init c");
	}

	public C getC() {
		return c;
	}
}
