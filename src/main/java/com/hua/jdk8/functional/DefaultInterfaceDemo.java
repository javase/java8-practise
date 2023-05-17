package com.hua.jdk8.functional;

/**
 * <pre>
 * 程序目的：演示默认方法和静态方法的使用
 * </pre>
 * created at 2023/5/17 09:22
 * @author lerry
 */
public class DefaultInterfaceDemo {
	public static void main(String[] args) {
		Calculator calculator = new MyCalculator();
		int result1 = calculator.add(5, 3);
		int result2 = calculator.subtract(10, 4);
		int result3 = calculator.multiply(2, 6);
		int result4 = Calculator.divide(10, 2);

		System.out.println(result1); // 8
		System.out.println(result2); // 6
		System.out.println(result3); // 12
		System.out.println(result4); // 5
	}
}

class MyCalculator implements Calculator {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}
}

interface Calculator {
	int add(int a, int b);

	int subtract(int a, int b);

	default int multiply(int a, int b) {
		return a * b;
	}

	static int divide(int a, int b) {
		return a / b;
	}
}

