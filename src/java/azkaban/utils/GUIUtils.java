package azkaban.utils;

import org.joda.time.format.DateTimeFormat;

public class GUIUtils {
	public static final String DATE_TIME_STRING = "YYYY-MM-dd HH:MM:ss";
	
	public String formatDate(long timeMS) {
		if (timeMS == -1) {
			return "-";
		}
		
		return DateTimeFormat.forPattern(DATE_TIME_STRING).print(timeMS);
	}
	
	public String formatDuration(long startTime, long endTime) {
		if (startTime == -1) {
			return "-";
		}
		
		long durationMS;
		if (endTime == -1) {
			durationMS = System.currentTimeMillis() - startTime;
		}
		else {
			durationMS = endTime - startTime;
		}
		
		long seconds = durationMS/1000;
		if (seconds < 60) {
			return seconds + " sec";
		}
		
		long minutes = seconds / 60;
		seconds %= 60;
		if (minutes < 60) {
			return minutes + "m " + seconds + "s";
		}
		
		long hours = minutes / 60;
		minutes %= 60;
		if (hours < 24) {
			return hours + "h " + minutes + "m " + seconds + "s";
		}
		
		long days = hours / 24;
		hours %= 24;
		return days + "d " + hours + "h " + minutes + "m";
	}
}
