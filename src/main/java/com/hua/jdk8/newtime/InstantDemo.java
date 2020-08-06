package com.hua.jdk8.newtime;

import static com.hua.jdk8.utils.Print.*;

import java.time.Instant;

/**
 * created at 2019-12-21 15:24
 * @author lerry
 */
public class InstantDemo {
	public static void main(String[] args) {

		Instant instant0 = Instant.ofEpochSecond(0);
		printlnf("Instant.ofEpochSecond(0):%s",instant0);


	}
}
