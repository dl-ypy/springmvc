package com.ypy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class DateUtil implements Converter<String, Date>{

	@Override
	public Date convert(String arg0) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sf.parse(arg0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}


}
