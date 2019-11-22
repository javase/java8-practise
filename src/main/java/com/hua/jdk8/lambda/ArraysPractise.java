package com.hua.jdk8.lambda;

import static com.hua.jdk8.utils.Print.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created at 2018-04-02 17:26
 * @author lerry
 */
public class ArraysPractise {

	public static final String separator = ",";

	public static void main(String[] args) {
		// e 的参数类型是编译器推测出来的
		Arrays.asList("a", "b", "c").forEach(e -> System.out.print(e));

		System.out.println("\n-------------------------------");

		Arrays.asList("b", "c", "d").forEach((String e) -> System.out.print(e));

		System.out.println("\n-------------------------------");

		// 复杂一点儿的，放在花括号中
		Arrays.asList(1, 2, 3).forEach(e -> {
			System.out.print(e);
			System.out.print(e * 10);
		});

		System.out.println("\n-------------------------------");

		// 引用局部变量
		Arrays.asList("tom", "jerry", "jack").forEach(e -> {
			System.out.print(e.concat(separator));
		});
		System.out.println("\n-------------------------------");

		// 如果lambda的函数体只有一行的话，那么没有必要显式使用return语句
		// Lambda表达式有返回值，返回值的类型也由编译器推理得出
		Arrays.asList("a", "f", "d").sort((e1, e2) -> e1.compareTo(e2));

		Arrays.asList("a", "f", "d").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});

		printlnf("List为空时的forEach，会报错：NullPointerException");
		List<String> nullList = null;
		try {
			nullList.forEach(e -> {
				System.out.println(e);
			});
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}

		printlnf("List.size()为0时的forEach，不报错，无输出");
		List<String> zeroList = new ArrayList<>();
		zeroList.forEach(e -> {
			System.out.println(e);
		});


	}
}
