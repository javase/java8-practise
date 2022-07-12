package lambdasinaction.chap12;

import static java.time.temporal.TemporalAdjusters.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 程序目的：探究Java8中新的日期、时间类
 * </pre>
 * created at 2020/8/26 18:49
 * @author lerry
 */
@Slf4j
public class DateTimeExamples {

	private static final ThreadLocal<DateFormat> formatters = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("dd-MMM-yyyy");
		}
	};

	public static void main(String[] args) {
		useOldDate();
		useLocalDate();
		useTemporalAdjuster();
		useDateFormatter();
	}

	/**
	 * 使用Java8之前的写法
	 */
	private static void useOldDate() {
		Date date = new Date(114, 2, 18);
		log.info("date is :[{}] 可以看到，打印出来的格式，不那么直观", date);

		log.info("使用SimpleDateFormat进行格式化后：[{}]", formatters.get().format(date));

		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.FEBRUARY, 18);
		log.info("calendar对象打印:[{}]", calendar);

	}

	/**
	 * 使用LocalDate类
	 */
	private static void useLocalDate() {
		LocalDate localDate = LocalDate.of(2014, 3, 18);
		int year = localDate.getYear(); // 2014
		Month month = localDate.getMonth(); // MARCH
		int day = localDate.getDayOfMonth(); // 18
		DayOfWeek dow = localDate.getDayOfWeek(); // TUESDAY
		int len = localDate.lengthOfMonth(); // 31 (days in March)
		boolean leap = localDate.isLeapYear(); // false (not a leap year)
		log.info("localDate is :[{}] 这种格式看上去舒服多了", localDate);
		// LocalDate和LocalTime都可以通过解析代表它们的字符串创建
		log.info("默认格式为：ISO_LOCAL_DATE 示例：2020-10-10 是横杠的方式来区分的");
		log.info("{}",LocalDate.parse("2020-10-10"));

		int y = localDate.get(ChronoField.YEAR);
		int m = localDate.get(ChronoField.MONTH_OF_YEAR);
		int d = localDate.get(ChronoField.DAY_OF_MONTH);

		LocalTime localTime = LocalTime.of(13, 45, 20); // 13:45:20
		int hour = localTime.getHour(); // 13
		int minute = localTime.getMinute(); // 45
		int second = localTime.getSecond(); // 20
		log.info("localTime is :[{}]", localTime);

		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20); // 2014-03-18T13:45
		LocalDateTime dt2 = LocalDateTime.of(localDate, localTime);
		LocalDateTime dt3 = localDate.atTime(13, 45, 20);
		LocalDateTime dt4 = localDate.atTime(localTime);
		LocalDateTime dt5 = localTime.atDate(localDate);
		log.info("dt1 is :[{}]", dt1);

		LocalDate date1 = dt1.toLocalDate();
		log.info("date1 is :[{}]", date1);
		LocalTime time1 = dt1.toLocalTime();
		log.info("time1 is :[{}]", time1);

		Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
		Instant now = Instant.now();

		Duration d1 = Duration.between(LocalTime.of(13, 45, 10), localTime);
		Duration d2 = Duration.between(instant, now);
		log.info("d1.getSeconds() is :[{}]", d1.getSeconds());
		log.info("d2.getSeconds() is :[{}]", d2.getSeconds());

		Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
		log.info("threeMinutes is :[{}]", threeMinutes);

		JapaneseDate japaneseDate = JapaneseDate.from(localDate);
		log.info("japaneseDate is :[{}]", japaneseDate);
	}

	/**
	 * TemporalAdjuster类的用法展示
	 */
	private static void useTemporalAdjuster() {
		LocalDate date = LocalDate.of(2014, 3, 18);
		date = date.with(nextOrSame(DayOfWeek.SUNDAY));
		System.out.println(date);
		date = date.with(lastDayOfMonth());
		System.out.println(date);

		date = date.with(new NextWorkingDay());
		System.out.println(date);
		date = date.with(nextOrSame(DayOfWeek.FRIDAY));
		System.out.println(date);
		date = date.with(new NextWorkingDay());
		System.out.println(date);

		date = date.with(nextOrSame(DayOfWeek.FRIDAY));
		System.out.println(date);
		date = date.with(temporal -> {
			DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int dayToAdd = 1;
			if (dow == DayOfWeek.FRIDAY) {
				dayToAdd = 3;
			}
			if (dow == DayOfWeek.SATURDAY) {
				dayToAdd = 2;
			}
			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		});
		System.out.println(date);
	}

	private static class NextWorkingDay implements TemporalAdjuster {
		@Override
		public Temporal adjustInto(Temporal temporal) {
			DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int dayToAdd = 1;
			if (dow == DayOfWeek.FRIDAY) {
				dayToAdd = 3;
			}
			if (dow == DayOfWeek.SATURDAY) {
				dayToAdd = 2;
			}
			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		}
	}

	/**
	 * DateTimeFormatter使用示例
	 */
	private static void useDateFormatter() {
		LocalDate date = LocalDate.of(2014, 3, 18);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);

		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(date.format(formatter));
		System.out.println(date.format(italianFormatter));

		DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
				.appendText(ChronoField.DAY_OF_MONTH)
				.appendLiteral(". ")
				.appendText(ChronoField.MONTH_OF_YEAR)
				.appendLiteral(" ")
				.appendText(ChronoField.YEAR)
				.parseCaseInsensitive()
				.toFormatter(Locale.ITALIAN);

		System.out.println(date.format(complexFormatter));
	}

}
