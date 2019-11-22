package com.hua.jdk8;

import static com.hua.jdk8.utils.Print.*;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * created at 2019-11-22 19:21
 * @author lerry
 */
public class Temp {
	public static void main(String[] args) {


		Arrays.asList(1, 2, 3, 4, 5, 6)
				.stream()
				.map(n -> n * n)
				.forEach(a -> printlnf("%s", a));

		printlnf("-------");
		Arrays.asList("a", "b").forEach(System.out::println);

		Arrays.asList("1", "2", "3", "4", "6")
				.stream()
				.filter(a -> {
					printlnf("filter:%s", a);
					return Integer.parseInt(a) % 2 == 0;
				})
				.map(s -> {
					printlnf("map:%s", s);
					return s.hashCode();
				})
				.forEach(s -> {
					printlnf("print:%s", s);
				});

		Arrays.asList("1", "2", "3", "4", "6").stream()
				.map(String::toUpperCase)
				.map(String::length)
				.collect(Collectors.toList()).forEach(System.out::print);


	}
}
