package com.hua.jdk7;

import static com.hua.jdk8.utils.Print.*;

/**
 * <pre>
 *     数字文字绝对是对眼睛的一种考验。我相信，如果你给了一个数字，比如说，十个零，你就会像我一样数零。
 *     如果不计算从右到左的位置，识别一个文字的话，就很容易出错，而且很麻烦。
 *     Not anymore。Java在识别位置时引入了下划线。
 * </pre>
 * created at 2020-01-16 17:48
 * @author lerry
 */
public class NumbersInJdk7 {
	public static void main(String[] args) {
		int number = 61_474_519;
		printlnf("java7的写法为61_474_519：%d", number);

		int number02 = 1_2_3;
		printlnf("java7的写法为1_2_3：%d", number02);
	}
}
