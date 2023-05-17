package com.hua.jdk8.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用使得开发者可以直接引用现存的方法、Java类的构造方法或者实例对象
 * created at 2018-04-09 17:40
 * @author lerry
 */
public class ReferenceDemo {

	public static void main(String[] args) {
		demo();
	}


	public static void demo01() {
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

	public static void demo() {
		// 引用静态方法
		Arrays.asList("a", "b", "c").forEach(System.out::println);

		// 引用实例方法
		List<String> strings = Arrays.asList("a", "b", "c");
		System.out.println("-----------");
		strings.stream()
				.map(String::toUpperCase)
				.forEach(System.out::println);


		// 引用构造函数
		Supplier<List<String>> listSupplier = ArrayList::new;
		List<String> newList = listSupplier.get();

		// 引用数组构造函数
		Function<Integer, int[]> arrayFunction = int[]::new;
		int[] newArray = arrayFunction.apply(10);
	}
}
