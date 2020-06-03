package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Y implements ApplicationContextAware {
	@Autowired
	private X x;

	public Y() {
		System.out.println("Y的构造方法, "+this);
	}

	//	@PostConstruct
	public void init(){
		System.out.println("init");
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext");
	}
}
