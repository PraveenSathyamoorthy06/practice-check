package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) throws ParseException {
		SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy" );
		Date obj=sd.parse(date);
		return obj;
	}
	
}
