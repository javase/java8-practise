package com.hua.jdk8.lambda;

import static com.hua.jdk8.utils.Print.printlnf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在forEach中如何使用continue
 * created at 2019-07-04 11:03
 * @author lerry
 */
public class ForeachContinue {

	public static void main(String[] args) {
		ArrayList<String> stringList = new ArrayList<>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");

		stringList.stream().forEach(str -> {
			if (str.equals("b")) {
				return; // only skips this iteration.
			}
			System.out.println(str);
		});

		System.out.println("demo2:==========================================");
		List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
		list.forEach(e -> {
			if (e.length() >= 5) {
				// 相当于是continue
				return;
			}
			printlnf(e);
		});

	}
}
