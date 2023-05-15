package com.hua.jdk8.functional;

@FunctionalInterface
interface MyFunction {
	int apply(int x, int y);
}


@FunctionalInterface
interface StringTransformer {
	String transform(String str);
}

/**
 * <pre>
 * 程序目的：演示自定义函数式接口
 * </pre>
 * created at 2023/5/15 17:40
 * @author lerry
 */
public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunction add = (x, y) -> x + y;
		MyFunction multiply = (x, y) -> x * y;

		int result1 = calculate(2, 3, add);
		int result2 = calculate(2, 3, multiply);

		System.out.println(result1); // 输出 5
		System.out.println(result2); // 输出 6

		StringTransformer stringTransformer = x -> x.toUpperCase();
		System.out.println(stringTransformer.transform("hello"));
	}

	public static int calculate(int x, int y, MyFunction function) {
		return function.apply(x, y);
	}
}