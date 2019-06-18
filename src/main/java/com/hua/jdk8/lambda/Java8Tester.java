package com.hua.jdk8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * java8和java7的风格区别
 * created at 2018-04-24 16:43
 * @author limenghua
 */
public class Java8Tester {

	public static void main(String[] args) {
		List<String> names1 = new ArrayList<String>();
		names1.add("Google ");
		names1.add("Runoob ");
		names1.add("Taobao ");
		names1.add("Alibaba ");
		names1.add("Baidu ");
		names1.add("Sina ");

		List<String> names2 = new ArrayList<String>();
		names2.add("2Google ");
		names2.add("9Runoob ");
		names2.add("5Taobao ");
		names2.add("8Baidu ");
		names2.add("3Sina ");
		names2.add("1Alibaba ");

		Java8Tester tester = new Java8Tester();
		System.out.println("使用 Java 7 语法排序: ");

		tester.sortUsingJava7(names1);
		System.out.println(names1);
		System.out.println("使用 Java 8 语法排序: ");

		tester.sortUsingJava8(names2);
		System.out.println(names2);
	}

	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}
}
