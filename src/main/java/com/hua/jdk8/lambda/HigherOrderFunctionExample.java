package com.hua.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;

/**
 * 使用高阶函数
 */
public class HigherOrderFunctionExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> filter = filter(numbers, x -> x % 2 == 0);
		System.out.println(filter);
	}

	public static void demo01() {
		// 定义一个接受一个整数作为参数的函数
		Function<Integer, Integer> addOne = x -> x + 1;

		// 定义一个接受一个函数和一个整数作为参数的函数，并返回一个整数
		Function<Function<Integer, Integer>, Integer> apply = f -> f.apply(2);


		// 将addOne函数作为参数传递给apply函数
		int result = apply.apply(addOne);

		System.out.println(result); // 输出 3
	}

	/**
	 * 假设我们有一个函数filter，它接受一个整数列表和一个函数作为参数，并返回一个新的整数列表，其中包含原列表中所有使得函数返回值为true的元素。
	 * 请使用Lambda表达式和函数式接口实现这个函数。例如，filter([1, 2, 3, 4], x -> x % 2 == 0)应该返回[2, 4]。
	 * @param list
	 * @param p
	 * @return
	 */
	public static List<Integer> filter(List<Integer> list, IntPredicate p) {
		List<Integer> result = new ArrayList<>();
		for (Integer integer : list) {
			if (p.test(integer)) {
				result.add(integer);
			}
		}
		return result;
	}
}