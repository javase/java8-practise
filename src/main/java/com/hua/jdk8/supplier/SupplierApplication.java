package com.hua.jdk8.supplier;

import java.util.Arrays;
import java.util.List;

/**
 * 方法引用使得开发者可以直接引用现存的方法、Java类的构造方法或者实例对象
 * created at 2018-04-09 17:40
 * @author lerry
 */
public class SupplierApplication {

	public static void main(String[] args) {

		// 构造器引用
		final Car car = Car.create(Car::new);
		final List<Car> cars = Arrays.asList(car);

		// 静态方法引用
		cars.forEach(Car::collide);

		// 类的成员方法的引用
		cars.forEach(Car::repaire);

		// 实例对象的成员方法的引用
		Car police = Car.create(Car::new);
		cars.forEach(police::follow);
	}
}
