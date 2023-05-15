package com.hua.jdk8.functional.student;

import java.util.ArrayList;
import java.util.List;

class Student {
	private final String name;

	private final int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

class StudentManager {
	private final List<Student> students;

	public StudentManager() {
		this.students = new ArrayList<>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public Student findStudent(String name) {
		for (Student student : students) {
			if (student.getName().equals(name)) {
				return student;
			}
		}
		return null;
	}

	public void deleteStudent(String name) {
		for (Student student : students) {
			if (student.getName().equals(name)) {
				students.remove(student);
				break;
			}
		}
	}
}
/**
 * <pre>
 * 程序目的：演示函数式编程和面向对象编程方式的区别
 * </pre>
 * created at 2023/5/15 18:43
 * @author lerry
 */
public class ObjectOrientedProgrammingExample {
	public static void main(String[] args) {
		StudentManager studentManager = new StudentManager();

		// 添加学生
		studentManager.addStudent(new Student("Alice", 20));
		studentManager.addStudent(new Student("Bob", 22));

		// 查找学生
		Student student = studentManager.findStudent("Alice");
		if (student != null) {
			System.out.println("找到学生：" + student.getName() + "，年龄：" + student.getAge());
		}
		else { System.out.println("未找到学生"); }

		// 删除学生
		studentManager.deleteStudent("Bob");
		System.out.println("学生删除成功");
	}
}