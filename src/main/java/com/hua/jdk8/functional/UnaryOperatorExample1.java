package com.hua.jdk8.functional;

import static com.hua.jdk8.utils.Print.*;

import java.util.function.UnaryOperator;

/**
 * 一元操作的示例
 * created at 2019-06-25 19:46
 * @author lerry
 */
public class UnaryOperatorExample1 {
	public static void main(String[] args) {
		UnaryOperator<Integer> operator = t -> t * 2;
		printlnf("operator.apply(5):%s", operator.apply(5));
		printlnf("operator.apply(10):%s", operator.apply(10));
		printlnf("operator.apply(15):%s", operator.apply(15));
	}
}
