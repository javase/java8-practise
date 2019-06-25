package com.hua.jdk8.functional;

import static com.hua.jdk8.utils.Print.*;

import java.util.function.UnaryOperator;

/**
 * 一元操作示例2
 * created at 2019-06-25 19:49
 * @author lerry
 */
public class UnaryOperatorExample2 {
	public static void main(String[] args) {
		UnaryOperator<Integer> operator1 = t -> t + 10;
		UnaryOperator<Integer> operator2 = t -> t * 10;

		// 先 +10 、 再 ×10
		int a = operator1.andThen(operator2).apply(5);
		printlnf("operator1.andThen(operator2).apply(5):%s", a);

		// 返回一个复合函数，该函数首先将before函数应用于其输入，然后将此函数应用于结果
		// 先 ×10、再 +10
		int b = operator1.compose(operator2).apply(5);
		printlnf("operator1.compose(operator2).apply(5):%s", b);
	}
}
