package com.hua.jdk8.functional;

import java.util.function.Supplier;

/**
 * created at 2018-04-09 17:24
 * @author lerry
 */
public interface DefaultableFactory {
	static Defaultable create(Supplier<Defaultable> supplier) {
		return supplier.get();
	}
}
