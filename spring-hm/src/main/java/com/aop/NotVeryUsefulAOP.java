package com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAOP {

	@Pointcut("execution(* com.serajoon.A.*(..))")
	public void anyPublicMethod() {

	}

	@Before("anyPublicMethod()")
	public void before() {
		System.out.println("*****aop*****");
	}
}
