package com.sahoora.fuse.demo.util;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	@Override
	public String marshal(Date date) throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return DatatypeConverter.printDate(c);
	}

	@Override
	public Date unmarshal(String strDate) throws Exception {
		return DatatypeConverter.parseDate(strDate).getTime();
	}
}
