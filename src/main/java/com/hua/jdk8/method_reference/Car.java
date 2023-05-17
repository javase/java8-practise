package com.hua.jdk8.method_reference;

import java.util.function.Supplier;

/**
 * created at 2018-04-09 17:35
 * @author lerry
 */
public class Car {
	public static Car create(Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println(String.format("Collided %s", car));
	}

	public void follow(final Car another) {
		System.out.println(String.format("Following the %s", another));
	}

	public void repaire() {
		System.out.println(String.format("Repaired %s", this));
	}
}
