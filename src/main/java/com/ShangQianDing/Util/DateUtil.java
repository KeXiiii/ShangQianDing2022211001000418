package com.ShangQianDing.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dabing
 */
public class DateUtil {
	/**
	 * Convert java.util.Date to java.sql.Date
	 * @author dabing
	 * @param uDate
	 * @return java.sql.Date
	 */
	public static java.sql.Date convertUtilToSql(Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

	/**
	 *  Convert java.util.sql to java.sql.util
	 *  @author dabing
	 * @param uDate
	 * @return java.util.Date
	 */
	public static Date convertSQLToUtil(java.sql.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	/**
	 *  Convert String to java.util.Date
	 *  @author dabing
	 * @param sDate
	 * @return java.util.Date
	 */
	public static Date convertStringToUtil(String sDate) {
		    Date date1 = null;
			try {
				date1 = new SimpleDateFormat("yyyy-mm-dd").parse(sDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date1;  
		
	}
	/**
	 *  Convert java.util.Date to String
	 *  @author dabing
	 * @param uDate
	 * @return String
	 */
	public static String convertUtiltoString(Date  uDate) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String strDate = dateFormat.format(uDate);  
        return strDate;
	}
@SuppressWarnings("deprecation")
public static void main(String a[]){
	System.out.println(DateUtil.convertUtilToSql(new Date()));
	System.out.println(DateUtil.convertSQLToUtil(new java.sql.Date(1999, 9, 9)));
	
	System.out.println(DateUtil.convertStringToUtil("1999-09-09"));
	
	System.out.println(DateUtil.convertUtiltoString(new Date()));
}
}
