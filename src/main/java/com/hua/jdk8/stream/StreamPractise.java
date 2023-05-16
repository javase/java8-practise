package com.hua.jdk8.stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * 程序目的：联系java 8 stream的使用
 * </pre>
 * created at 2023/5/16 09:26
 * @author lerry
 */
public class StreamPractise {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println(square(list));
	}

	/**
	 * 假设有一个整数列表，现在需要对列表中的偶数进行平方并返回一个新的列表。
	 * 使用 Stream API 实现这个功能。请尝试编写代码解决这个问题。
	 * @param list
	 * @return
	 */
	public static List<Integer> square(List<Integer> list) {
		if (list != null && list.size() > 0) {
			List<Integer> result = list.stream()
					.filter(i -> i % 2 == 0)
					.map(i -> i * i)
					.collect(toList());
			return result;
		}
		else {
			return Collections.emptyList();
		}
	}
}
