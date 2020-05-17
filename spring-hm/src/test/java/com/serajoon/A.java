package com.serajoon;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("a")
@Data
public class A {
	@Autowired
    private B b;
	public B getB() {
		return b;
	}
}