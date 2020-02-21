package com.landry.aws.lambda.common.util;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MyDateUtil
{

	static final DateTimeZone zone = DateTimeZone.forID("America/New_York");

	public static boolean isPastCutOffTime( LocalTime cutOffTime )
	{
		DateTime startDate = DateTime.now();
		if (cutOffTime != null)
		{
			DateTime dateOnCutOffime = new DateTime().withTime(cutOffTime.getHourOfDay(), cutOffTime.getMinuteOfHour(),
					0, 0).withZoneRetainFields(zone);
			if (startDate.isAfter(dateOnCutOffime))
				return true;
			else
				return false;
		}
		return false;
	}

	public static String toStringDate( DateTime date, String format )
	{
		return  date.toString(format);
	}

	public static DateTime toDateTime( String date, String format )
	{
		DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
    	DateTime dateTime = DateTime.parse(date, formatter);
		return dateTime;
	}

	public static DateTime addDayToNowIfPastCutOffTime( LocalTime cutOffTime )
	{
		DateTime startDate = DateTime.now();
		if (cutOffTime != null)
		{
			DateTime dateOnCutOffime = new DateTime().withTime(cutOffTime.getHourOfDay(), cutOffTime.getMinuteOfHour(),
					0, 0).withZoneRetainFields(zone);
			if (startDate.isAfter(dateOnCutOffime))
				startDate = startDate.plusDays(1);
		}

		return startDate;
	}
}
