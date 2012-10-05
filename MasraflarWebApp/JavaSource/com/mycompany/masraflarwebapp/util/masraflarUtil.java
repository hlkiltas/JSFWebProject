package com.mycompany.masraflarwebapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class masraflarUtil {
	
	public static Date dateToMysolFormat(Date date) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return (Date)formatter.parse(formatter.format(date));
	}

}
