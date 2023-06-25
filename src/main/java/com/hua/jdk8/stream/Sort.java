package com.hua.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created at 2023-06-25 10:49
 * @author lerry
 */
public class Sort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(5);
		list.add(9);
		list.add(1);
		list.add(3);
		list = list.stream().sorted().collect(Collectors.toList());
//		list.stream().sorted();
		System.out.println(list);
	}
}
