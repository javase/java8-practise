package com.hua.jdk8.newtime;

import static com.hua.jdk8.utils.Print.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * created at 2019-11-11 18:27
 * @author lerry
 */
public class WeekTest {

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now().plusDays(2);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		printlnf("%s是周%s", date.format(DateTimeFormatter.ISO_DATE), dayOfWeek.getValue());
	}
}
