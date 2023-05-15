package com.hua.jdk8.lambda;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

/**
 * 把lambda 赋值给一个变量的尝试
 * created at 2023-05-12 18:00
 * @author lerry
 */
public class LambdaDemo {
	public static void main(String[] args) {
		// Lambda表达式没有参数，返回一个整数
		Supplier s = () -> 42;

// Lambda表达式有一个整数参数，返回该整数的平方
		IntFunction f = (x) -> x * x;

// Lambda表达式有两个整数参数，返回它们的和
		IntBinaryOperator b = (x, y) -> x + y;

// Lambda表达式有一个整数参数，返回该整数是否为偶数
		IntPredicate p = (x) -> x % 2 == 0;

// Lambda表达式有一个整数参数，打印该整数并返回它的平方
		IntFunction f2 = (x) -> {
			System.out.println(x); return x * x;
		};
		run();

	}


	/**
	 * 闭包的概念
	 * 闭包是一个重要的概念，它是指`一个函数与其相关的引用环境组合而成的实体`。
	 * 闭包可以在函数内部定义另一个函数，并访问该函数所在的环境的变量和参数，形成一个`封闭的作用域`，
	 * 从而保护内部的变量不被外界访问和修改。
	 * 闭包的作用在于可以保存函数的状态，并且可以在之后的调用中使用这些状态，
	 * 从而实现更加灵活和高效的编程。
	 */
	public static void run() {
		final int count = 0;
		Thread t = new Thread(() -> {
			// 在lambda作用域内，局部变量是可以被修改的
			int tmp = count;
			while (tmp < 10) {
				System.out.println(tmp++);
			}
		});
		t.start();
	}
}
