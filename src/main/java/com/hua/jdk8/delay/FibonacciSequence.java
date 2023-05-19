package com.hua.jdk8.delay;

import java.util.stream.Stream;

/**
 * <pre>
 * 程序目的：演示函数式编程中的延迟求值
 * </pre>
 * created at 2023/5/19 10:39
 * @author lerry
 */
public class FibonacciSequence {
	public static void main(String[] args) {
		Stream<Long> fibonacciSequence = Stream
				.iterate(new long[] {0, 1}, fib -> new long[] {fib[1], fib[0] + fib[1]})
				.map(fib -> fib[0]);

		// 输出斐波那契数列的前20个数
		fibonacciSequence.limit(20).forEach(System.out::println);
	}
}