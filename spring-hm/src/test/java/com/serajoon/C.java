package com.serajoon;

import org.springframework.beans.factory.annotation.Autowired;

//@Component("c")
public class C {
	@Autowired
	private C c;
	public C getC() {
		return c;
	}
}
