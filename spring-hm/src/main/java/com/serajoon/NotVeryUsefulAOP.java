package com.serajoon;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class NotVeryUsefulAOP {
	/**
	 * 定义切入点,指哪些方法需要被执行AOP
	 * 这里指定com.serajoon.A.*中的方法进行AOP
	 */
	@Pointcut("execution(* com.serajoon.A.test(..))")
	public void anyPublicMethod() {

	}

	/**
	 * 定义通知,在特定切入点(anyPublicMethod)上指定的动作
	 */
	@Before("anyPublicMethod()")
	public void before() {
		System.out.println("*****aop*****");
	}
	@After("anyPublicMethod()")
	public void after(){

	}
}
