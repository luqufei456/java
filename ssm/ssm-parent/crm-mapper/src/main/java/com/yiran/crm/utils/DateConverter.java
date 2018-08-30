package com.yiran.crm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * springmvc - java.util.Date  - 自定义日期类型转换器
 * Converter<S, T>
		S:source,�?要转换的源的类型
		T:target,�?要转换的目标类型
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			// 把字符串转换为日期类�?
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = simpleDateFormat.parse(source);
			return date;
		} catch (ParseException e) {
//			e.printStackTrace();
		}
		// 如果转换异常则返回空
		return null;
	}

}
