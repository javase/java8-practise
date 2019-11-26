package com.hua.jdk8;

import static com.hua.jdk8.utils.Print.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created at 2019-11-22 19:21
 * @author lerry
 */
public class Temp {
	public static void main(String[] args) {
		Stream.iterate(0, n -> n + 2)
				.forEach(System.out::println);
	}
}
