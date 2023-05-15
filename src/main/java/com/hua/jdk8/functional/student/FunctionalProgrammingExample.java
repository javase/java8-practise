//package com.hua.jdk8.functional.student;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Student {
//	private String name;
//
//	private int age;
//
//	public Student(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//}
///**
// * <pre>
// * 程序目的：演示函数式编程和面向对象编程方式的区别
// * </pre>
// * created at 2023/5/15 18:42
// * @author lerry
// */
//public class FunctionalProgrammingExample {
//	public static void main(String[] args) {
//		List<Student> students = new ArrayList<>();
//
//		// 添加学生
//		addStudent(students, new Student("Alice", 20));
//		addStudent(students, new Student("Bob", 22));
//
//		// 查找学生
//		Student student = findStudent(students, "Alice");
//		if (student != null) {
//			System.out.println("找到学生：" + student.getName() + "，年龄：" + student.getAge());
//		}
//		else {
//			System.out.println("未找到学生");
//		}
//
//		// 删除学生
//		deleteStudent(students, "Bob");
//		System.out.println("学生删除成功");
//	}
//
//	private static void addStudent(List<Student> students, Student student) {
//		students.add(student);
//	}
//
//	private static Student findStudent(List<Student> students, String name) {
//		return students.stream()
//				.filter(s -> s.getName().equals(name))
//				.findFirst()
//				.orElse(null);
//	}
//
//	private static void deleteStudent(List<Student> students, String name) {
//		students.removeIf(s -> s.getName().equals(name));
//	}
//}