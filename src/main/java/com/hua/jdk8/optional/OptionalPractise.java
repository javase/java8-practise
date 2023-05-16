package com.hua.jdk8.optional;

import java.util.Optional;

import lombok.Data;

/**
 * 假设有一个 Person 类，其中包含 name、age 和 address 字段。
 * 请编写一个方法，接收一个 Person 对象，判断其是否有非空的 address 字段，并返回其值。
 * 如果 address 为空，则返回字符串 "Unknown"。
 * created at 2023-05-16 12:46
 * @author lerry
 */
public class OptionalPractise {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("张三");
		person.setAge(20);
		person.setAddress("浦东新区");
		person.setAddress(null);
		System.out.println(getAddress(person));
	}

	public static String getAddress(Person person) {
		Optional<String> addressOpt = Optional.ofNullable(person.getAddress());

		/** 这段代码可以使用orElse来替代 */
//		if (addressOpt.isPresent()) {
//			return addressOpt.get();
//		}
//		else {
//			return "Unknown";
//		}
		return addressOpt.orElse("Unknown");
	}
}

@Data
class Person {
	private String name;

	private Integer age;

	private String address;
}
