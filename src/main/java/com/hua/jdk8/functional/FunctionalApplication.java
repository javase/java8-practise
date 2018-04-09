package com.hua.jdk8.functional;


/**
 * created at 2018-04-09 17:25
 * @author limenghua
 */
public class FunctionalApplication {
	public static void main(String[] args) {
		Defaultable defaultable = DefaultableFactory.create(DefaultableImpl::new);
		System.out.println(defaultable.notRequired());

		defaultable = DefaultableFactory.create(OverrideImpl::new);
		System.out.println(defaultable.notRequired());

	}
}
