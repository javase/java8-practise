package com.hua.jdk8.utils;

import static com.hua.jdk8.utils.Print.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.paukov.combinatorics3.Generator;

/**
 * 排列组合
 * created at 2020-01-14 18:54
 * @author lerry
 */
public class Combinatorics {


	public static void main(String[] args) {
		Set<String> sets = new TreeSet<>();
		char beginLetter = 'a';

		// 添加0-10
		for (int i = 0; i < 10; i++) {
//			printlnf((char) i);
			sets.add(String.valueOf(i));
		}


		for (int i = (int) beginLetter; i < beginLetter + 26; i++) {
//			printlnf((char) i);
			sets.add(String.valueOf((char) i));
		}

		beginLetter = 'A';
		for (int i = (int) beginLetter; i < beginLetter + 26; i++) {
//			printlnf((char) i);
			sets.add(String.valueOf((char) i));
		}

		printlnf("集合为：%s，集合大小为：%s", sets, sets.size());
		Print.printALine();


		Stream comStream = Generator.combination(sets)
				.simple(6)
				.stream();

		// 保存的是ArrayList
		// comStream.forEach(var -> System.out.println(var.getClass()));

		comStream.map(var -> getStrFromArrayList(var))
				.forEach(System.out::println);


//		long size = comStream.count();
//		printlnf("组合总数为：%d", size);


	}

	public static String getStrFromArrayList(Object list) {
		StringBuilder builder = new StringBuilder();
		for (Object o : (ArrayList) list) {
			builder.append(o);
		}
		return builder.toString();
	}
}
