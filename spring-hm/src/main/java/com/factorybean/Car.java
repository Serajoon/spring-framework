package com.factorybean;

import lombok.Data;

@Data
class Car {
    private int maxSpeed;
    private String brand;
    private double price;

	public Car() {
		System.out.println("init car");
	}
}
