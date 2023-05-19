package com.hua.jdk8.delay;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamIterateExample {
	public static void main(String[] args) {
		System.out.println(sumBigNumber());
		System.out.println(sumBigNumberV2());

		Stream stream = generateEvenNumbers(19);
		stream.forEach(System.out::println);

		int result = factorialTail(5, 1);
		System.out.println("阶乘计算结果：" + result);

	}


	public static void delayDemo() {
		Stream<Integer> naturalNumbers = Stream.iterate(1, n -> n + 1);

		// 输出自然数序列的前10个数
		naturalNumbers.limit(10).forEach(System.out::println);
	}

	/**
	 * 假设你有一个函数，它接受一个整数参数n，并返回一个延迟求值的流（Stream），
	 * 该流包含从1到n的所有偶数。请编写这个函数的代码。
	 * @param n
	 * @return
	 */
	public static Stream evenNum(int n) {
		return Stream.iterate(1, i -> ++i)
				.filter(i -> i % 2 == 0)
				.limit(n / 2);
	}

	/**
	 * evenNum的优化升级版
	 * 假设你有一个函数，它接受一个整数参数n，并返回一个延迟求值的流（Stream），
	 * 该流包含从1到n的所有偶数。请编写这个函数的代码。
	 * @param n
	 * @return
	 */
	public static Stream<Integer> generateEvenNumbers(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("n需要是正整数");
		}
		return Stream.iterate(2, i -> i + 2)
				.limit(n / 2);
	}

	/**
	 * 假设有一个包含一百万个整数的列表，编写一个并发程序，使用多线程对该列表进行求和，
	 * 并返回求和结果。要求使用线程池和合适的并发技术来优化性能。
	 * @return
	 */
	public static Long sumBigNumber() {
		return Stream.iterate(1, i -> i + 1)
				.limit(1_000_000)
				.parallel()
				.mapToLong(Long::valueOf)
				.sum();
	}

	/**
	 * 假设有一个包含一百万个整数的列表，编写一个并发程序，使用多线程对该列表进行求和，
	 * 并返回求和结果。要求使用线程池和合适的并发技术来优化性能。
	 * @return
	 */
	public static long sumBigNumberV2() {
		return LongStream.rangeClosed(1, 1_000_000)
				.parallel()
				.sum();
	}

	public static int factorialTail(int n, int accumulator) {
		if (n == 0) {
			return accumulator;
		}
		else {
			int result = factorialTail(n - 1, n * accumulator);
			return result;
		}
	}

}