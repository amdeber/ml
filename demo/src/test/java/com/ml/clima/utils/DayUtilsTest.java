package com.ml.clima.utils;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

public class DayUtilsTest {

	@Test
	public void day_Between_Date_And_Years() {
		LocalDateTime aDateTime = LocalDateTime.of(2019, Month.AUGUST, 01, 00, 00, 00);
		long result = DayUtils.getInstance().getQDaysBetweenDateAndYears(aDateTime, Long.valueOf(1));	
		assertEquals(366, result);
	}
	
	public void day_Between_null_Date_And_Years() {
		long result = DayUtils.getInstance().getQDaysBetweenDateAndYears(null, Long.valueOf(1));	
		assertEquals(result, 0);
	}
	
	
	public void day_Between_Date_And_Null_Years() {
		long result = DayUtils.getInstance().getQDaysBetweenDateAndYears(LocalDateTime.of(2019, Month.AUGUST, 01, 00, 00, 00), null);	
		assertEquals(result, 0);
	}
	
	
	public void day_Between_null_Date_And_null_Years() {
		long result = DayUtils.getInstance().getQDaysBetweenDateAndYears(null, null);	
		assertEquals(result, 0);
	}

}
