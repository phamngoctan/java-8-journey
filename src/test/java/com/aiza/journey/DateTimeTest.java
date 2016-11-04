package com.aiza.journey;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.junit.Test;

public class DateTimeTest {

	@Test
	public void test_dateTime() {

//		LocalDate lcDate = LocalDate.parse("2012-04-23T18:25:43Z", DateTimeFormatter.ISO_ZONED_DATE_TIME);
//		System.out.println(lcDate);
//		LocalDateTime lcDateTime = LocalDateTime.parse("2012-04-23T18:25:43+01:00", DateTimeFormatter.ISO_ZONED_DATE_TIME);
//		System.out.println(lcDateTime);

		String value = "1969-04-11T00:32:32+07:00";

		ZonedDateTime dateTimeWithZone = ZonedDateTime.parse(value);
		System.out.println(dateTimeWithZone);
		dateTimeWithZone = dateTimeWithZone.withZoneSameInstant(ZoneId.of("+00:00"));
		System.out.println(dateTimeWithZone);
		System.out.println(LocalDate.from(dateTimeWithZone));
//		OffsetDateTime o = OffsetDateTime.of(lcDateTime, ZoneOffset.UTC);
//		System.out.println(o);
		
		LocalDate date = LocalDate.of(2016, 1, 1);
		LocalDateTime localDateTime = LocalDateTime.of(date, LocalTime.of(0, 0, 0));
		ZonedDateTime dateTimeWithZone2 = localDateTime.atZone(ZoneId.of("+00:00"));
    	System.out.println(dateTimeWithZone2.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    	
    	String param = "1969-04-11T00:32:32+07:00";
    	LocalDate date3 = LocalDate.parse(param, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    	System.out.println(date3);
	}

	@Test
	public void should_parse_with_iso_instant() throws Exception {
		String value = "1969-04-11T04:32:32Z";

		OffsetDateTime d = OffsetDateTime.parse(value);

		// Test time zone independent
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("+00:00")));

		assertThat("abc", is(equalTo("abc")));
		assertThat(d.toLocalDateTime(),
				is(equalTo(LocalDateTime.of(LocalDate.of(1969, 4, 11), LocalTime.of(04, 32).plusSeconds(32)))));
	}

	@Test
	public void isStringEmptyOfNull() {
		String stringToTest = "";
		assertThat(stringToTest, isEmptyOrNullString());

		// all statements test the same
		// assertThat(a, equalTo(b));
		assertThat(a, is(equalTo(b)));
		assertThat(a, is(b));
	}

	boolean a;
	boolean b;

}
