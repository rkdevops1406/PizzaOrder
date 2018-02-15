package com.pizza.order.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.pizza.order.constants.OrderConstants;

/**
 * @author pdevaraj
 */
public class DateUtil {
	/**
	 * @param epochDate
	 * @return
	 */
	public static String convertEpochToUTC(Long epochDate) {
		final SimpleDateFormat sdf = new SimpleDateFormat(OrderConstants.DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone(OrderConstants.UTC));
		String formattedDate = null;
		if (epochDate != null) {
			Date date = new Date(epochDate);
			formattedDate = sdf.format(date);
		}
		return formattedDate;
	}
}
