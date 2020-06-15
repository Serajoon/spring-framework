package com.condition;

import lombok.Data;

@Data
public class Person {
    private  String name;
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}'+System.identityHashCode(this);
    }
}