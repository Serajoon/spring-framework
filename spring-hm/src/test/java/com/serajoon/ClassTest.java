package com.serajoon;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;

public class ClassTest {

    /**
     * 1、Class.getEnclosingClass
     * 获取对应类的直接外部类Class对象
     * 2、Class.getDeclaringClass
     * 获取对应类的声明类Class对象
     * 3、两者的区别
     * getEnclosingClass与getDeclaringClass很相近
     * 两者的区别在于匿名内部类、getEnclosingClass对匿名内部类也有效
     */
    public static void main(String[] args) {
		Class<?> enclosingClass = InnerClass.class.getEnclosingClass();
        Assert.assertEquals("com.serajoon.ClassTest", enclosingClass.getName());

        Class<?> declaringClass = InnerClass.class.getDeclaringClass();
        Assert.assertEquals("com.serajoon.ClassTest", declaringClass.getName());

        //注意：GetEnclosingClass获取的是直接定义该类的外部类Class实例、这点和getDeclaringClass一致
        Class<?> enclosingClass1 = InnerClass.InnerInnerClass.class.getEnclosingClass();
        Assert.assertEquals("com.serajoon.ClassTest$InnerClass", enclosingClass1.getName());

        Class<?> declaringClass1 = InnerClass.InnerInnerClass.class.getDeclaringClass();
        Assert.assertEquals("com.serajoon.ClassTest$InnerClass", declaringClass1.getName());

        //针对匿名内部类的测试
        DifferentBetweenClassGetEnclosingClassAndDeclaringClass s = new DifferentBetweenClassGetEnclosingClassAndDeclaringClass();
        HelloService inst = s.getHelloService();
        inst.sayHello();
    }
    private class InnerClass {
        private class InnerInnerClass {
        }
    }
    public interface HelloService {
        void sayHello();
    }
    public static class DifferentBetweenClassGetEnclosingClassAndDeclaringClass {
        HelloService getHelloService() {
            //匿名内部类
            return new HelloService() {
                @Override
                public void sayHello() {
                    System.out.println(this.getClass().getEnclosingClass());
                    System.out.println(this.getClass().getDeclaringClass());
                }
            };
        }
    }
}