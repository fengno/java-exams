package com.demo.jdk8;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateApiExams {

	public static void main(String[] args) {
		// Clock能够提供访问当前日期和时间，Clock有一个systemDefaultZone方法可以作为System.currentTimeMillis()替代，返回当前时间的毫秒.。
		System.out.println("------------返回当前时间的毫秒数-------------");
		System.out.println("System.currentTimeMillis(): " + System.currentTimeMillis());
		System.out.println("Clock.systemDefaultZone().millis(): " + Clock.systemDefaultZone().millis());
		System.out.println("------------返回日期类型Date-------------");
		System.out.println(Date.from(Clock.systemDefaultZone().instant()));
		System.out.println(Calendar.getInstance().getTime());

		// Timezone 是用一个ZoneId表示.
		System.out.println(ZoneId.getAvailableZoneIds()); // [Asia/Aden, America/Cuiaba, Etc/GMT+9, Etc/GMT+8, ...
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		System.out.println(zone1.getRules());
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone2.getRules());

		// LocalTime 表示一个没有timezone的时间
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		System.out.println(now1.isBefore(now2)); // false
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
		System.out.println(hoursBetween); // -4
		System.out.println(minutesBetween); // -299

		// LocalTime带有各种工厂提供简单的实例创建，包括分析时间字符串：
		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late); // 23:59:59
		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
				.withLocale(Locale.GERMAN);
		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime); // 13:37

		// LocalDate表示一个日期如 2014-03-11. 它是不可变的，能够和LocalTime.配合
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		System.out.println(yesterday);
		System.out.println(today);
		System.out.println(tomorrow);
		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek); // FRIDAY
		// 分析一个字符串日也很简单：
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
		LocalDate xmas = LocalDate.parse("24.12.2014", formatter);
		System.out.println(xmas); // 2014-12-24

		// LocalDateTime表示日期时间组合. 是将日期和时间捆绑在一起，是不可变的。
		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		DayOfWeek dayOfWeek2 = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek2); // WEDNESDAY
		Month month = sylvester.getMonth();
		System.out.println(month); // DECEMBER
		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay); // 1439
		// Instants转为传统的 java.util.Date：
		Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
		Date legacyDate = Date.from(instant);
		System.out.println(legacyDate); // Wed Dec 31 23:59:59 CET 2014
		// 格式化日期时间如下：
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
		LocalDateTime parsed = LocalDateTime.parse("2014 11 03 07:13", formatter2);
		String string = formatter2.format(parsed);
		System.out.println(string); // Nov 03, 2014 - 07:13
		// 不同于老的java.text.NumberFormat，新的DateTimeFormatter是不可变和线程安全的。
	}

}
