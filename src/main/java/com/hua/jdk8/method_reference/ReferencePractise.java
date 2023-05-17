package com.hua.jdk8.method_reference;

import java.util.function.BiFunction;

/**
 * <pre>
 * 程序目的：练习方法引用
 * 假设有一个名为 `Person` 的类，包含属性 `name`（字符串类型）和 `age`（整数类型）。请使用构造器引用实现一个函数式接口 `PersonFactory`，它具有一个抽象方法 `createPerson`，用于创建 `Person` 对象。
 * 现在，编写一个方法 `generatePerson`，该方法接收一个 `PersonFactory` 参数，并使用该参数创建一个新的 `Person` 对象并返回。
 * 你的任务是使用构造器引用实现 `PersonFactory` 接口，并在 `generatePerson` 方法中使用它。
 * 注意：你需要根据 `Person` 类的构造函数参数来选择正确的构造器引用形式。
 * </pre>
 * created at 2023/5/17 10:37
 * @author lerry
 */
public class ReferencePractise {

	public static void main(String[] args) {
		// 使用方法引用，创建PersonFactory对象
		PersonFactory personFactory = Person::new;
		Person person = generatePerson(personFactory);
		System.out.println(person);

		// 使用方法引用，引用静态方法，来实现传参
		BiFunction<String, Integer, Person> function = PersonFactory::createPerson;
		Person person02 = function.apply("张三", 20);
		System.out.println(person02);
	}

	public static Person generatePerson(PersonFactory personFactory) {
		return personFactory.createPerson();
	}
}

class Person {
	private String name;

	private Integer age;

	public Person() {
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}


@FunctionalInterface
interface PersonFactory {

	/**
	 * 创建无参数的Person对象
	 * @return
	 */
	Person createPerson();

	/**
	 * 使用静态方法，创建有参数的Person对象
	 * @param name
	 * @param age
	 * @return
	 */
	static Person createPerson(String name, Integer age) {
		return new Person(name, age);
	}
}

