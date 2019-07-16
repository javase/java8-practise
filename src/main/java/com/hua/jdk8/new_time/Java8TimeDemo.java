package com.hua.jdk8.new_time;

import static com.hua.jdk8.utils.Print.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 新的时间类
 * created at 2019-06-18 15:44
 * @author lerry
 */
public class Java8TimeDemo {

	public static void main(String[] args) {
		LocalDate todayDate = LocalDate.now();
		LocalDate oneday = todayDate;
		System.out.println("今天的日期：" + todayDate);

		//取当前月的第1天
		LocalDate firstDay = todayDate.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDay);

		//取当前月的第1天，另外一种写法
		LocalDate firstDay2 = todayDate.withDayOfMonth(1);
		printlnf("当前月的第一天是：%s", firstDay2);

		LocalDate lastDay = oneday.with(TemporalAdjusters.lastDayOfMonth());
		printlnf("当前月的最后一天是：%s", lastDay);

		//当前日期＋1天
		LocalDate tomorrow = oneday.plusDays(1);
		printlnf("当前日期＋1天：%s", tomorrow);

		boolean isLeapYear = tomorrow.isLeapYear();
		printlnf("判断是否为闰年：%s", isLeapYear);

		LocalDate birthday = LocalDate.of(1990, 10, 12);
		printlnf("指定日期构造LocalDate对象：%s", birthday);
		MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
		MonthDay today = MonthDay.from(LocalDate.of(2016, 10, 12));
		printlnf("MonthDay不包含年份信息：%s", birthdayMd.equals(today));


		printlnf("----------------------------");
		LocalDateTime ldt1 = LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52);
		printlnf("手动构建LocalDateTime:%s", ldt1);
		LocalDate localDate = LocalDate.of(2017, Month.JANUARY, 4);
		LocalTime localTime = LocalTime.of(17, 23, 52);
		LocalDateTime ldt2 = localDate.atTime(localTime);
		printlnf("LocalDate+LocalTime合成LocalDateTime:%s", ldt2);
		printlnf("----------------------------");
		printlnf("格式化时间[ISO_DATE]：%s", ldt1.format(DateTimeFormatter.ISO_DATE));
		printlnf("格式化时间[ISO_DATE]：%s", ldt1.format(DateTimeFormatter.ISO_DATE_TIME));
		printlnf("格式化时间[yyyy-MM-dd HH:mm:ss]：%s", ldt1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		printlnf("格式化时间[BASIC_ISO_DATE]：%s", ldt1.format(DateTimeFormatter.BASIC_ISO_DATE));
		printlnf("格式化时间[ISO_ORDINAL_DATE]：%s", ldt1.format(DateTimeFormatter.ISO_ORDINAL_DATE));

		printlnf("获取当前日期早8点到晚8点: %s  %s",
				todayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " 07:59:59",
				todayDate.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " 08:00:01");
	}
}
