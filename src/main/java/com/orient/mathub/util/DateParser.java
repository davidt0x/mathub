package com.orient.mathub.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	
	Format formatter;
	
	public Date convertDate(String s){
		Date date = null;
		try {
	        date = (Date)((DateFormat) formatter).parse(s);
	        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        String s = formatter.format(date);
//	        System.out.println(s);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		return date;
	}
}
