package com.hua.jdk8.newtime;

import static com.hua.jdk8.utils.Print.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 计算两个LocalDateTime的间隔
 * created at 2019-07-16 16:10
 * @author lerry
 */
public class DurationDemo {


	public static void main(String[] args) {
		getTaskExpireTime();
	}

	/**
	 * <pre>
	 * 计算间隔秒数
	 * 如：
	 * 当前时间：2019-07-18 11:13:01
	 * 截止时间：2019-07-19 08:00:00
	 * 间隔toNanos：74818659000000
	 * 间隔毫秒数：74818659
	 * 间隔秒数：74818
	 * 间隔分钟数：1246
	 * 间隔小时数：20
	 * </pre>
	 * @return
	 */
	public static long getTaskExpireTime() {
		LocalDateTime nowTime = LocalDateTime.now();
		String end = nowTime.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " 08:00:00";
		printlnf("当前时间：%s", nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		printlnf("截止时间：%s", end);
		LocalDateTime endTime = LocalDateTime.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Duration duration = Duration.between(nowTime, endTime);
		printlnf("间隔toNanos：%s", duration.toNanos());
		printlnf("间隔毫秒数：%s", duration.toMillis());
		printlnf("间隔秒数：%s", duration.getSeconds());
		printlnf("间隔分钟数：%s", duration.toMinutes());
		printlnf("间隔小时数：%s", duration.toHours());
		return duration.getSeconds();
	}
}
