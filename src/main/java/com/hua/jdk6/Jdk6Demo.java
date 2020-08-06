package com.hua.jdk6;

import java.io.Console;

/**
 * created at 2020-01-16 17:56
 * @author lerry
 */
public class Jdk6Demo {

	public static void main(String[] args) {
		Console console = System.console();
		if (console != null) {
			// 读取整行字符和密码，密码输入时不会显示
			String user = new String(console.readLine("请输入用户名:"));
			String pwd = new String(console.readPassword("再输入密码:"));
			console.printf("用户名是:" + user + "\n");
			console.printf("密码是:" + pwd + "\n");
		}
		else {
			System.out.println("Console不可用!");
		}
	}
}
