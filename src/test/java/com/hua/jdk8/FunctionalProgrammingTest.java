package com.hua.jdk8;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
/**
 * <pre>
 * 程序目的：演示函数式编程的测试
 * </pre>
 * created at 2023/5/19 09:42
 * @author lerry
 */
public class FunctionalProgrammingTest {

	public List<Integer> filterEvenNumbers(List<Integer> numbers) {
		return numbers.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
	}

	/**
	 * 请编写一个函数，接受一个字符串列表作为输入，返回所有长度大于等于5的字符串，并将它们按字母顺序排序。
	 * @param strings
	 * @return
	 */
	public List<String> filterAndSortStrings(List<String> strings) {
		// 实现函数体
		// 返回所有长度大于等于5的字符串，并按字母顺序排序
		if (strings != null) {
			List<String> result = strings.parallelStream()
					.filter(str -> str.length() >= 5)
					.sorted()
					.collect(Collectors.toList());
			return result;
		}
		else {
			return Collections.emptyList();
		}
	}


	@Test
	public void testFilterEvenNumbers() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);

		List<Integer> result = filterEvenNumbers(numbers);

		assertEquals(expected, result);
	}

	@Test
	public void testFilterAndSortStrings() {
		List<String> strings = Arrays.asList("abc", "abcds", "ecdse", "", "cssedcss");
		List<String> expected = Arrays.asList("abcds", "cssedcss", "ecdse");

		List<String> result = filterAndSortStrings(strings);
		assertEquals(expected, result);
	}
}