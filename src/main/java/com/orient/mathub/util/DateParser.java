package com.orient.mathub.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	
	private DateFormat dateFormat;
	
	public String convertDate(Date d){
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a z");
		String s = dateFormat.format(d);
		System.out.println(s);
		if(s!=null) return s;
		return null;
	}
}
