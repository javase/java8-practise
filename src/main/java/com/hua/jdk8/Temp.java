package com.hua.jdk8;

import java.util.ArrayList;

/**
 * created at 2019-11-22 19:21
 * @author lerry
 */
public class Temp {
	static int a = 0;

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
	}
}
