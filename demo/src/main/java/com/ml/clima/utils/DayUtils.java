package com.ml.clima.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DayUtils {

	private static DayUtils INSTANCE;

	private DayUtils() {
	}

	public static DayUtils getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DayUtils();
		}

		return INSTANCE;
	}

	public Long getQDaysBetweenDateAndYears(LocalDateTime date, Long years) {
		LocalDateTime tenSecondsLater = date.plusYears(years);
		return (date == null || years == null) ?  0 : ChronoUnit.DAYS.between(date, tenSecondsLater);	
	}
	
	
	

}
