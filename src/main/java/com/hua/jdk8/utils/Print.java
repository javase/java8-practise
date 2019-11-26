//: net/mindview/util/Print.java
// Print methods that can be used without
// qualifiers, using Java SE5 static imports:
package com.hua.jdk8.utils;

import java.io.PrintStream;

public class Print {
	/**
	 * Print with a newline:
	 * @param obj
	 */
	public static void print(Object obj) {
		System.out.println(obj);
	}

	/**
	 * Print a newline by itself:
	 * @param s
	 * @param obj
	 */
	public static void print(String s, int obj) {
		System.out.println();
	}

	/**
	 * Print with no line break:
	 * @param obj
	 */
	public static void printnb(Object obj) {
		System.out.print(obj);
	}

	/**
	 * The new Java SE5 printf() (from C):
	 * @param format
	 * @param args
	 * @return
	 */
	public static PrintStream printf(String format, Object... args) {
		return System.out.printf(format, args);
	}

	/**
	 * 格式化输出后，进行换行
	 * @param format
	 * @param args
	 */
	public static void printlnf(String format, Object... args) {
		System.out.printf(format, args);
		System.out.println();
	}

	/**
	 * 打印Object类型，会调用obj.toString()进行类型转换
	 * @param obj
	 * @param args
	 */
	public static void printlnf(Object obj, Object... args) {
		System.out.printf(obj.toString(), args);
		System.out.println();
	}

	/**
	 * 默认为75的宽度
	 * 打印指定宽度的分隔线
	 * eg. ---------------------------------------------------------------------------
	 */
	public static void printALine() {
		printALine(75, "-");
	}

	/**
	 * 默认为75的宽度
	 * 打印指定宽度的分隔线，使用的分隔符是"="
	 * eg. ---------------------------------------------------------------------------
	 */
	public static void printALineDouble() {
		printALine(75, "=");
	}

	/**
	 * 打印指定宽度的分隔线
	 * eg. ===========================================================================
	 * @param width
	 */
	public static void printALine(int width, String separator) {
		StringBuffer sbuf = new StringBuffer();
		for (int i = 0; i < width; i++) {
			sbuf.append(separator);
		}
		printlnf(sbuf);
	}

	public static void main(String[] args) {
		printALineDouble();
	}
} ///:~
