package com.condition;

import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("com.condition")
public class ConditionMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionMain.class);
		MySys bean = context.getBean(MySys.class);
		System.out.println(bean);
		System.out.println(context.getBean("person", Person.class));
		System.out.println(context.getBean("person", Person.class));
		System.out.println(context.getBean("person", Person.class));

	}

	@Bean
	@Conditional(LinuxCondition.class)// 使用@Conditional注解，符合Linux条件就实例化
	public MySys linuxService() {
		System.out.println("linux");
		return new MySys("Linux");
	}

	@Bean
	@Conditional(WindowsCondition.class)// 使用@Conditional注解，符合Windows条件就实例化
	public MySys windowsService() {
		System.out.println("windows");
		return new MySys("Windows");
	}

	@Bean
	@Conditional(MacCondition.class)// 使用@Conditional注解，符合Windows条件就实例化
	public MySys macService() {
		System.out.println("mac");
		return new MySys("Mac");
	}

	private static class A{}
}
