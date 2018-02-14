package com.pizza.order.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/**
 * @author pdevaraj
 */
public class DateUtil {
	/**
	 * @param epochDate
	 * @return
	 */
	public static String convertEpochToUTC(Long epochDate) {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedDate = null;
		if (epochDate != null) {
			Date date = new Date(epochDate);
			formattedDate = sdf.format(date);
		}
		return formattedDate;
	}
}
