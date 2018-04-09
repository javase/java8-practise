package com.hua.jdk8.functional;

/**
 * created at 2018-04-09 17:13
 * @author limenghua
 */
public interface Defaultable {
	default String notRequired() {
		return "Default implementation";
	}
}

class DefaultableImpl implements Defaultable {

}

class OverrideImpl implements Defaultable {
	@Override
	public String notRequired() {
		return "Overrided implementation";
	}

	public static void main(String[] args) {
		DefaultableImpl defaultable = new DefaultableImpl();
		System.out.println(defaultable.notRequired());

		OverrideImpl override = new OverrideImpl();
		System.out.println(override.notRequired());
	}
}
