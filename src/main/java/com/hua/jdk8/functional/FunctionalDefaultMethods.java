package com.hua.jdk8.functional;

/**
 * created at 2018-04-09 17:09
 * @author limenghua
 */
@FunctionalInterface
public interface FunctionalDefaultMethods {
	void method();

	/**
	 * 默认方法  java8之后才有
	 * 默认方法和抽象方法之间的区别在于抽象方法需要实现，而默认方法不需要
	 */
	default void defaultMethod() {

	}

}
