package com.sxit.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 日期工具类
 */
public final class DateHelper {

	/**
	 * 时间范围：年
	 */
	public static final int YEAR = 1;

	/**
	 * 时间范围：季度
	 */
	public static final int QUARTER = 2;

	/**
	 * 时间范围：月
	 */
	public static final int MONTH = 3;

	/**
	 * 时间范围：旬
	 */
	public static final int TENDAYS = 4;

	/**
	 * 时间范围：周
	 */
	public static final int WEEK = 5;

	/**
	 * 时间范围：日
	 */
	public static final int DAY = 6;

	public static final String YEAR_MONTH_DAY_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/** 日期格式为：yyyy-MM-dd HH:mm */
	public static final String YEAR_MONTH_DAY_HH_MM = "yyyy-MM-dd HH:mm";

	public static final String YEAR_MONTH = "yyyy-MM";
	public static final String YEARMONTH = "yyyyMM";

	/** 日期格式为：yyyy-MM-dd */
	public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";

	/** 日期格式为：yyyy年MM月dd日 */
	public static final String C_YEAR_MONTH_DAY = "yyyy年MM月dd日";

	public static final String MONTH_DAY = "MM-dd";
	public static final String MONTHDAY = "MMdd";
	
	public static final String YEARMONTHDAYHOURSMINUTE = "yyyyMMddHHmmss";

	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	/* 基准时间 */
	private Date fiducialDate = null;
	private Calendar cal = null;

	public DateHelper() {
		super();
		// TODO Auto-generated constructor stub
	}

	private DateHelper(Date fiducialDate) {
		if (fiducialDate != null) {
			this.fiducialDate = fiducialDate;
		} else {
			this.fiducialDate = new Date(System.currentTimeMillis());
		}

		this.cal = Calendar.getInstance();
		this.cal.setTime(this.fiducialDate);
		this.cal.set(Calendar.HOUR_OF_DAY, 0);
		this.cal.set(Calendar.MINUTE, 0);
		this.cal.set(Calendar.SECOND, 0);
		this.cal.set(Calendar.MILLISECOND, 0);

		this.fiducialDate = this.cal.getTime();
	}

	/**
	 * 获取DateHelper实例
	 * 
	 * @param fiducialDate
	 *            基准时间
	 * @return
	 */
	public static DateHelper getInstance(Date fiducialDate) {
		return new DateHelper(fiducialDate);
	}

	/**
	 * 获取DateHelper实例, 使用当前时间作为基准时间
	 * 
	 * @return
	 */
	public static DateHelper getInstance() {
		return new DateHelper(null);
	}

	/**
	 * 获取年的第一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getFirstDayOfYear(int offset) {
		cal.setTime(this.fiducialDate);
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + offset);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 获取年的最后一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getLastDayOfYear(int offset) {
		cal.setTime(this.fiducialDate);
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + offset);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		return cal.getTime();
	}

	/**
	 * 获取季度的第一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getFirstDayOfQuarter(int offset) {
		cal.setTime(this.fiducialDate);
		cal.add(Calendar.MONTH, offset * 3);
		int mon = cal.get(Calendar.MONTH);
		if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {
			cal.set(Calendar.MONTH, Calendar.JANUARY);
			cal.set(Calendar.DAY_OF_MONTH, 1);
		}
		if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {
			cal.set(Calendar.MONTH, Calendar.APRIL);
			cal.set(Calendar.DAY_OF_MONTH, 1);
		}
		if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {
			cal.set(Calendar.MONTH, Calendar.JULY);
			cal.set(Calendar.DAY_OF_MONTH, 1);
		}
		if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {
			cal.set(Calendar.MONTH, Calendar.OCTOBER);
			cal.set(Calendar.DAY_OF_MONTH, 1);
		}
		return cal.getTime();
	}

	/**
	 * 获取季度的最后一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getLastDayOfQuarter(int offset) {
		cal.setTime(this.fiducialDate);
		cal.add(Calendar.MONTH, offset * 3);

		int mon = cal.get(Calendar.MONTH);
		if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {
			cal.set(Calendar.MONTH, Calendar.MARCH);
			cal.set(Calendar.DAY_OF_MONTH, 31);
		}
		if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {
			cal.set(Calendar.MONTH, Calendar.JUNE);
			cal.set(Calendar.DAY_OF_MONTH, 30);
		}
		if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {
			cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
			cal.set(Calendar.DAY_OF_MONTH, 30);
		}
		if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {
			cal.set(Calendar.MONTH, Calendar.DECEMBER);
			cal.set(Calendar.DAY_OF_MONTH, 31);
		}
		return cal.getTime();
	}

	/**
	 * 获取月的最后一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getFirstDayOfMonth(int offset) {
		cal.setTime(this.fiducialDate);
		cal.add(Calendar.MONTH, offset);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 获取当前月的第一天
	 * 
	 * @param format
	 *            日期格式
	 * @return String
	 */
	public static String getFirstDayOfMonth(String format) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		ca.set(Calendar.DAY_OF_MONTH, 1);
		String firstDate = dateToStr(ca.getTime(), format);
		return firstDate;
	}

	/**
	 * 获取月的最后一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getLastDayOfMonth(int offset) {
		cal.setTime(this.fiducialDate);
		cal.add(Calendar.MONTH, offset + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}
	
	/**
	 * 获取某月的第一天
	 * @param date 日期
	 * @param format 日期格式
	 * @return String
	 */
	public static String getFirstDayOfMonth(Date date, String format) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_MONTH, 1);
		String firstDate = dateToStr(ca.getTime(), format);
		return firstDate;
	}
	
	/**
	 * 获取某月的最后一天
	 * @param date 日期
	 * @param format 日期格式
	 * @return String
	 */
	public static String getLastDayOfMonth(Date date, String format) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String lastDate = dateToStr(ca.getTime(), format);
        return lastDate;
	}

	/**
	 * 获取旬的第一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getFirstDayOfTendays(int offset) {
		cal.setTime(this.fiducialDate);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if (day >= 21) {
			day = 21;
		} else if (day >= 11) {
			day = 11;
		} else {
			day = 1;
		}

		if (offset > 0) {
			day = day + 10 * offset;
			int monOffset = day / 30;
			day = day % 30;
			cal.add(Calendar.MONTH, monOffset);
			cal.set(Calendar.DAY_OF_MONTH, day);
		} else {
			int monOffset = 10 * offset / 30;
			int dayOffset = 10 * offset % 30;
			if ((day + dayOffset) > 0) {
				day = day + dayOffset;
			} else {
				monOffset = monOffset - 1;
				day = day - dayOffset - 10;
			}
			cal.add(Calendar.MONTH, monOffset);
			cal.set(Calendar.DAY_OF_MONTH, day);
		}
		return cal.getTime();
	}

	/**
	 * 获取旬的最后一天
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getLastDayOfTendays(int offset) {
		Date date = getFirstDayOfTendays(offset + 1);
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 获取周的第一天(MONDAY)
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getFirstDayOfWeek(int offset) {
		cal.setTime(this.fiducialDate);
		cal.add(Calendar.DAY_OF_MONTH, offset * 7);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}

	/**
	 * 获取周的最后一天(SUNDAY)
	 * 
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date getLastDayOfWeek(int offset) {
		cal.setTime(this.fiducialDate);
		cal.add(Calendar.DAY_OF_MONTH, offset * 7);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DAY_OF_MONTH, 6);
		return cal.getTime();
	}

	/**
	 * 根据日历的规则，为基准时间添加指定日历字段的时间量
	 * 
	 * @param field
	 *            日历字段, 使用Calendar类定义的日历字段常量
	 * @param offset
	 *            偏移量
	 * @return
	 */
	public Date add(int field, int offset) {
		cal.setTime(this.fiducialDate);
		cal.add(field, offset);
		return cal.getTime();
	}

	/**
	 * 根据日历的规则，为基准时间添加指定日历字段的单个时间单元
	 * 
	 * @param field
	 *            日历字段, 使用Calendar类定义的日历字段常量
	 * @param up
	 *            指定日历字段的值的滚动方向。true:向上滚动 / false:向下滚动
	 * @return
	 */
	public Date roll(int field, boolean up) {
		cal.setTime(this.fiducialDate);
		cal.roll(field, up);
		return cal.getTime();
	}

	/**
	 * 把字符串转换为日期
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Date strToDate(String dateStr, String format) {
		Date date = null;
		if (dateStr != null && (!dateStr.equals(""))) {
			DateFormat df = new SimpleDateFormat(format);
			try {
				date = df.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return date;
	}
	
	/**
	 * 获取指定日期的前n天
	 * @param specifiedDay
	 * @return
	 * @throws ParseException 
	 */
	public static String getDayBefore(String specifiedDay,int n){
		
		Calendar c=Calendar.getInstance();
		Date date=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
			date=sdf.parse(specifiedDay);
		}catch (Exception e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day=c.get(Calendar.DATE);
		c.set(Calendar.DATE,day-n);
		
		String daybefore=sdf.format(c.getTime());
		
		return daybefore;
	}
	
	/**
	 * 获取间隔上次时间
	 * @param startTime
	 * @param endTime
	 * @param format
	 * @return String
	 */
	public static String getLastTimeInterval(String startTime, String endTime, String format){
		Date start = strToDate2(startTime);
		Date end = strToDate2(endTime);
		long l = end.getTime() - start.getTime();
		Date ltiDate = new Date(start.getTime() - l);
		return dateToStr(ltiDate, format);
	}
	   
	public String getMonthBefore(String date,int i){
		Calendar cal=Calendar.getInstance();
		Date newdate=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
			newdate=sdf.parse(date);
		}catch (Exception e) {
			e.printStackTrace();
		}
		cal.setTime(newdate);
		cal.add(Calendar.MONTH, -i);
		return (new SimpleDateFormat("yyyy-MM-01").format(cal.getTime()));
	}
	
	public String getBeforeMonth(String date,int i){
		Calendar cal=Calendar.getInstance();
		Date newdate=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
			newdate=sdf.parse(date);
		}catch (Exception e) {
			e.printStackTrace();
		}
		cal.setTime(newdate);
		cal.add(Calendar.MONTH, -i);
		return sdf.format(cal.getTime());
	}
	
	    // 获得当前日期与本周一相差的天数
	    private int getMondayPlus() {
	        Calendar cd = Calendar.getInstance();
	        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
	        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
	        if (dayOfWeek == 1) {
	            return -6;
	        } else {
	            return 2 - dayOfWeek;
	        }
	    }
	    private static int weeks = 0;
	    // 获得本周星期一的日期
	    public String getCurrentMonday() {
	        weeks = 0;
	        int mondayPlus = this.getMondayPlus();
	        GregorianCalendar currentDate = new GregorianCalendar();
	        currentDate.add(GregorianCalendar.DATE, mondayPlus);
	        Date monday = currentDate.getTime();
	        DateFormat df = DateFormat.getDateInstance();
	        String preMonday = df.format(monday);
	        return preMonday;
	    }
	//获取本周星期天的日期
	 public String getSunday(String formatString) {
	        int mondayPlus = this.getMondayPlus();
	        GregorianCalendar currentDate = new GregorianCalendar();
	        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
	        Date monday = currentDate.getTime();
	        SimpleDateFormat df = new SimpleDateFormat(formatString);
	        String preMonday = df.format(monday);
	        return preMonday;
	    }
	 /**
	  * 获取今天是星期几
	  * @param date
	  * @return
	  */
	 public String getWeekDay() {
		 int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		 String day = "";
		 if(Calendar.SUNDAY == weekDay){
			 day = "星期天";
		 } else if(Calendar.MONDAY == weekDay){
			 day = "星期一";
		 } else if(Calendar.TUESDAY == weekDay){
			 day = "星期二";
		 } else if(Calendar.WEDNESDAY == weekDay){
			 day = "星期三";
		 } else if(Calendar.THURSDAY == weekDay){
			 day = "星期四";
		 } else if(Calendar.FRIDAY == weekDay){
			 day = "星期五";
		 } else if(Calendar.SATURDAY == weekDay){
			 day = "星期六";
		 }
		 return day;
	 }
	
	/**
	 * 把字符串转换为日期，日期的格式为yyyy-MM-dd HH:ss
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return
	 */
	public static Date strToDate(String dateStr) {
		Date date = null;
		if (dateStr != null && (!dateStr.equals(""))) {
			if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
				dateStr = dateStr + " 00:00";
			} else if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}")) {
				dateStr = dateStr + ":00";
			} else {
				System.out.println(dateStr + " 格式不正确");
				return null;
			}
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss");
			try {
				date = df.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return date;
	}

	/**
	 * 把字符串转换为日期，日期的格式为: yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd HH:mm: 或 yyyy-MM-dd
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return
	 */
	public static Date strToDate2(String dateStr) {
		Date date = null;
		DateFormat df = null;
		if (null != dateStr && !"".equals(dateStr)) {
			if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
				df = new SimpleDateFormat(YEAR_MONTH_DAY);

			} else if (dateStr
					.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}")) {
				df = new SimpleDateFormat(YEAR_MONTH_DAY_HH_MM);
			}

			else if (dateStr
					.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
				df = new SimpleDateFormat(YEAR_MONTH_DAY_HH_MM_SS);
			} else {
				df = new SimpleDateFormat(YEAR_MONTH_DAY);
			}
			try {
				date = df.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	/**
	 * 把日期转换为字符串
	 * 
	 * @param date
	 *            日期实例
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String dateToStr(Date date, String format) {
		return (date == null) ? "" : new SimpleDateFormat(format).format(date);
	}

	/**
	 * 取得当前日期 年-月-日
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(Calendar.getInstance().getTime());
	}

	/**
	 * 取得当前日期字符串格式 自定义日期格式
	 * 
	 * @return
	 */
	public static String getCurrentDateFormat(String format) {
		DateFormat f = new SimpleDateFormat(format);
		return f.format(Calendar.getInstance().getTime());
	}

	/**
	 * 获取当前日期
	 * 
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Date getCurrentDate(String format) {
		DateFormat df = new SimpleDateFormat(format);
		return strToDate(df.format(Calendar.getInstance().getTime()), format);
	}

	/**
	 * 获取日期集合
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束格式
	 * @return List<String>
	 */
	public static List<String> getDateList(String startDate, String endDate) {
		String date = null;
		int offset = 0;
		List<String> dateList = new ArrayList<String>();
		if (startDate.equals(endDate)) {
			dateList.add(startDate);
			return dateList;
		} else {
			dateList.add(endDate);
			do {
				offset = offset - 1;
				date = getOffsetDate(endDate, offset);
				dateList.add(date);
			} while (!NullUtil.isNull(date) && !date.equals(startDate));
		}

		return dateList;
	}

	/**
	 * 获取指定时间的偏移量日期
	 * 
	 * @param endDate
	 *            字符串日期
	 * @param format
	 *            偏移量
	 * @return String
	 */
	@SuppressWarnings("static-access")
	public static String getOffsetDate(String endDate, int offset) {
		Date date = getDateStringToDate(endDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, offset);
		date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(YEAR_MONTH_DAY);
		return sdf.format(date);
	}

	/**
	 * 根据参数转换为java.util.Date类型
	 * 
	 * @param date
	 *            - (格式为：yyyy-MM-dd)
	 * @return java.util.Date
	 */
	public static java.util.Date getDateStringToDate(String date) {
		java.util.Date d = null;
		try {
			String[] temp = date.split("-");
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) - 1,
					Integer.parseInt(temp[2]));
			d = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 获取当前时间的偏移量日期
	 * 
	 * @param format
	 *            日期格式
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String getOffsetDate(int offset, String... format) {
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, offset);
		date = calendar.getTime();
		SimpleDateFormat sdf = null;
		if (NullUtil.isNull(format)) {
			sdf = new SimpleDateFormat(YEAR_MONTH_DAY_HH_MM_SS);
		} else {
			sdf = new SimpleDateFormat(format[0]);
		}

		return sdf.format(date);
	}

	/**
	 * 获取当前日期
	 * 
	 * @param format
	 *            日期格式
	 * @return String
	 */
	public static String now(String... format) {
		GregorianCalendar gerCalendar = new GregorianCalendar();
		Date date = gerCalendar.getTime();
		SimpleDateFormat sdf = null;
		if (NullUtil.isNull(format)) {
			sdf = new SimpleDateFormat(YEAR_MONTH_DAY_HH_MM_SS);
		} else {
			sdf = new SimpleDateFormat(format[0]);
		}

		return sdf.format(date);
	}

	public static Timestamp stringToTime(String str) {
		if (str == null) {
			return null;
		}
		try {
			java.util.Date date = df.parse(str);

			return Timestamp.valueOf(df.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	// //////////////////////////added by 王红燕 /////////////////////////////
	// 农历节日
	public final static int FESTIVAL_CHUNJIE = 1;
	public final static int FESTIVAL_YUANXIAOJIE = 2;
	public final static int FESTIVAL_DUANWU = 3;
	public final static int FESTIVAL_ZHONGQIU = 4;
	public final static int FESTIVAL_QIXI = 5;

	// 阳历节日
	public static final int FESTIVAL_YUANDAN = 14;
	public static final int FESTIVAL_GUOQING = 15;
	public static final int FESTIVAL_LAODONGJIE = 16;
	public static final int FESTIVAL_ERTONGJIE = 17;

	/**
	 * 当前时间对应的阳历节日
	 * 
	 * @return 当前时间对应阳历节日，不是节日返回-1
	 */
	public int getCurrentFestival() {
		return getCurrentFestival(Calendar.getInstance());
	}

	/**
	 * 指定日历时间对应的阳历节日
	 * 
	 * @return 指定日历时间对应阳历节日，不是节日返回-1
	 */
	public int getCurrentFestival(Calendar today) {
		// Calendar today = Calendar.getInstance();
		switch (today.get(Calendar.MONTH) + 1) {
		case 1:
			switch (today.get(Calendar.DAY_OF_MONTH)) {
			case 1:
				return FESTIVAL_YUANDAN;
			}
		case 5:
			switch (today.get(Calendar.DAY_OF_MONTH)) {
			case 1:
				return FESTIVAL_LAODONGJIE;
			}
		case 6:
			switch (today.get(Calendar.DAY_OF_MONTH)) {
			case 1:
				return FESTIVAL_ERTONGJIE;
			}
		case 10:
			switch (today.get(Calendar.DAY_OF_MONTH)) {
			case 1:
				return FESTIVAL_GUOQING;
			}
		}
		return -1;
	}

	/**
	 * 转换日期格式
	 */
	public static String formatDate(Date date) {
		if(date == null) return null ;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEAR_MONTH_DAY_HH_MM_SS) ;
		return simpleDateFormat.format(date) ;
	}

	/**
	 * 转换日期格式
	 */
	public static String formatDate(Date date, String format) {
		if(date == null) return null ;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format) ;
		return simpleDateFormat.format(date) ;
	}
	
	
	/**
     * 在当前时间加减指定字段时间值
     * @param calendarField 加减字段
     * @param value 加减值
     * @param format 返回日期字符串格式
     * @return 返回日期字符串
     */
	public static String nowAdd(int calendarField, int value, String format) {
		GregorianCalendar gerCalendar = new GregorianCalendar();
		gerCalendar.add(calendarField, value);
		Date date = gerCalendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	
	// ///////////////////////end added by 王红燕 /////////////////////////////
	
	
	/**
	 * 计算出指定时间与当前时间的间隔
	 * @param time 时间
	 * @return
	 */
	public static String getInterval(Date time){
		String timeString = "";
		Date curTime = new Date();
		Long interval = curTime.getTime() - time.getTime();
		Long d = interval / (1000 * 60 * 60 * 24);
		if(d > 0){
			timeString += d + "天";
			interval -=(1000 * 60 * 60 * 24 * d);
		}
		Long h =  interval / (1000 * 60 * 60);
		if(h > 0){
			timeString += h + "小时";
			interval -= (1000 * 60 * 60 * h);
		}
		Long m =  interval / (1000 * 60) ;
		if(m > 0){
			timeString += m + "分钟";
			interval -= (1000 * 60 * m);
		}
		Long s =  interval / (1000) ;
		if(s > 0){
			timeString += s + "秒";
		}
		return timeString;
	}
} 
