package yintai.test.zsw.common;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author Jonathan Qin
 */
public class DateUtils {

    // private static final String defaultPattern = "yyyy/MM/dd HH:mm:ss";

    // private static final String segmentDefaultPattern = "yyyy/MM/dd";

	public static final String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	public static final String FORMAT_MONTH = "yyyy-MM";
	public static final String FORMAT_SITE_LETTER = "yyyy-MM-dd HH:mm";

    public static final String FORMAT_NBT_LOG = "yyyyMMddHHmmssss";
    
    
    public static boolean checkDate(String dateStr,String formatStr){
    	
    	boolean result = false;
    	
    	if(dateStr==null || formatStr == null){
    		return false;
    	}
    	
    	try {
			new SimpleDateFormat(formatStr).parse(dateStr);
			result = true;
		} catch (ParseException e) {
			
		}
    	return result;
    }
    
    public static Date addSeconds(Date date,Long seconds) {
		long expireDate = date.getTime() + seconds*1000;
		return new Date(expireDate);
	}
    
    public static int getTodayRemainSeconds(){
    	try {
			 Date now = new Date();
			
			 Calendar calendar = new GregorianCalendar();
			 calendar.setTime(now);
			 calendar.add(Calendar.DATE,1);
			 Date tomorrow = calendar.getTime(); 
			 
			 String dateString = new SimpleDateFormat("yyyy-MM-dd").format(tomorrow);
			 Date tbegainDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString + " 00:00:00");
			 
			 int second = (int) ((tbegainDate.getTime() - now.getTime()) / 1000);
			 
			 return second;
			 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return 0;
    }

	
    /*
     * public static java.util.Date stringToDate(String strDate) { if (strDate ==
     * null || strDate.trim().length() <= 0) return null; try { SimpleDateFormat
     * sdf = new SimpleDateFormat(defaultPattern); return sdf.parse(strDate); }
     * catch (ParseException e) { return null; } }
     */

    public static java.util.Date stringToDate(String strDate, String pattern) {
        if (strDate == null || strDate.trim().length() <= 0)
            return null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /*
     * public static String dateToString(java.util.Date date) { if (date ==
     * null) return null; SimpleDateFormat sdf = new
     * SimpleDateFormat(defaultPattern); return sdf.format(date); }
     */

    public static String dateToString(java.util.Date date, String pattern) {
        if (date == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date dateAddMinutes(Date date, int minutes) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static Date dateAddHours(Date date, int hours) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);
        return cal.getTime();
    }

    public static Date dateAddDays(Date date, int addDays) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, addDays);
        return cal.getTime();
    }

    public static Date dateAddMonths(Date date, int addMonths) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, addMonths);
        return cal.getTime();
    }

    public static Date dateAddMonths(Date date, double months) {
        if (date == null)
            return null;
        int addMonths = (int) Math.ceil(months);
        int addDays = (int) Math.round((months - addMonths) * 31);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, addMonths);
        cal.add(Calendar.DATE, addDays);
        return cal.getTime();
    }

    public static Date dateAddYears(Date date, int addYears) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, addYears);
        return cal.getTime();
    }

    public static boolean isDate(String strDate, String pattern) {
        if (strDate == null || strDate.trim().length() <= 0)
            return false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.parse(strDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static int getIntervalOfDay(Date d1, Date d2) {
        int elapsed = 0;
        boolean isAfter = false;
        Date temp;
        if (d1.after(d2)) {
            temp = d1;
            d1 = d2;
            d2 = temp;
            isAfter = true;
        }

        while (d1.before(d2)) {
            d1 = dateAddDays(d1, 1);
            elapsed++;
        }
        if (isAfter)
            elapsed = 0 - elapsed;
        return elapsed;
    }

    /**
     * Elapsed days based on current time
     * 
     * @param date
     *            Date
     * 
     * @return int number of days
     */
    public static int getElapsedDays(Date date) {
        return elapsed(date, Calendar.DATE);
    }

    /**
     * Elapsed days based on two Date objects
     * 
     * @param d1
     *            Date
     * @param d2
     *            Date
     * 
     * @return int number of days
     */
    public static int getElapsedDays(Date d1, Date d2) {
        return elapsed(d1, d2, Calendar.DATE);
    }

    /**
     * Elapsed months based on current time
     * 
     * @param date
     *            Date
     * 
     * @return int number of months
     */
    public static int getElapsedMonths(Date date) {
        return elapsed(date, Calendar.MONTH);
    }

    /**
     * Elapsed months based on two Date objects
     * 
     * @param d1
     *            Date
     * @param d2
     *            Date
     * 
     * @return int number of months
     */
    public static int getElapsedMonths(Date d1, Date d2) {
        return elapsed(d1, d2, Calendar.MONTH);
    }

    /**
     * Elapsed years based on current time
     * 
     * @param date
     *            Date
     * 
     * @return int number of years
     */
    public static int getElapsedYears(Date date) {
        return elapsed(date, Calendar.YEAR);
    }

    /**
     * Elapsed years based on two Date objects
     * 
     * @param d1
     *            Date
     * @param d2
     *            Date
     * 
     * @return int number of years
     */
    public static int getElapsedYears(Date d1, Date d2) {
        return elapsed(d1, d2, Calendar.YEAR);
    }

    /**
     * All elaspsed types
     * 
     * @param g1
     *            GregorianCalendar
     * @param g2
     *            GregorianCalendar
     * @param type
     *            int (Calendar.FIELD_NAME)
     * 
     * @return int number of elapsed "type"
     */
    private static int elapsed(GregorianCalendar g1, GregorianCalendar g2, int type) {
        GregorianCalendar gc1, gc2;
        int elapsed = 0;
        // Create copies since we will be clearing/adding
        if (g2.after(g1)) {
            gc2 = (GregorianCalendar) g2.clone();
            gc1 = (GregorianCalendar) g1.clone();
        } else {
            gc2 = (GregorianCalendar) g1.clone();
            gc1 = (GregorianCalendar) g2.clone();
        }
        if (type == Calendar.MONTH || type == Calendar.YEAR) {
            gc1.clear(Calendar.DATE);
            gc2.clear(Calendar.DATE);
        }
        if (type == Calendar.YEAR) {
            gc1.clear(Calendar.MONTH);
            gc2.clear(Calendar.MONTH);
        }
        while (gc1.before(gc2)) {
            gc1.add(type, 1);
            elapsed++;
        }
        return elapsed;
    }

    /**
     * All elaspsed types based on date and current Date
     * 
     * @param date
     *            Date
     * @param type
     *            int (Calendar.FIELD_NAME)
     * 
     * @return int number of elapsed "type"
     */
    private static int elapsed(Date date, int type) {
        return elapsed(date, new Date(), type);
    }

    /**
     * All elaspsed types
     * 
     * @param d1
     *            Date
     * @param d2
     *            Date
     * @param type
     *            int (Calendar.FIELD_NAME)
     * 
     * @return int number of elapsed "type"
     */
    private static int elapsed(Date d1, Date d2, int type) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        GregorianCalendar g1 = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
        cal.setTime(d2);
        GregorianCalendar g2 = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
        return elapsed(g1, g2, type);
    }
    
    public static int getDaysOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getMonthDateCount(cal);
    }
    

	public static Date getFormatDate() {
		Date now = new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = bartDateFormat.format(now);
		try {
			now = bartDateFormat.parse(strDate);
		} catch (ParseException e) {
			////e.printStackTrace();
		}
		return now;
	}

    
    /**
     * 閿熺煫纰夋嫹鎸囬敓鏂ゆ嫹閿熼摪浠界鎷烽敓鏂ゆ嫹閿熸枻鎷�
     * 
     * @param cal
     * @return
     */
    protected static int getMonthDateCount(Calendar cal) {
        Calendar cal2 = (Calendar) cal.clone();
        cal2.add(Calendar.MONTH, 1);
        cal2.set(Calendar.DAY_OF_MONTH, 1);
        cal2.add(Calendar.DAY_OF_MONTH, -1);
        return cal2.get(Calendar.DAY_OF_MONTH);
    }

	public Date getRandomDate(String beginDate, String endDate) {

		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date start = format.parse(beginDate);
			Date end = format.parse(endDate);
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());
			return new Date(date);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return null;
	}
	private static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}


    /**
     * 获何止时间获取从该时间到目前为止过了多长时间。
     * @param date
     * @return //例如“1天2小时1分”
     */
    public static String getAfterString(Date date)
    {
        java.util.Date begin=date;
        Calendar c1=Calendar.getInstance();
        c1.setTime(date);
        java.util.Date end =new Date();
        long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
        long day1=between/(24*3600);
        long hour1=between%(24*3600)/3600;
        long minute1=between%3600/60;
        if(day1>2)
        	{
        		DateFormat dFormat=new SimpleDateFormat("yyyy年MM月dd日");
        		return dFormat.format(date);
        	}
            //return c1.get(Calendar.YEAR)+"年"+c1.get(Calendar.MONTH)+"月"+c1.get(Calendar.DAY_OF_YEAR)+"日";
        else if(day1>1)
            return "前天";
        else
            if(hour1>1)
                return hour1+"小时"+minute1+"分前";
            else if (minute1>1)
                return minute1+"分前";
            else
                return "刚刚";
    }
    
    
    /**
     * 获何止时间获取从该时间到目前为止过了多长时间。
     * @param date
     * @return //例如“1天2小时1分”
     */
    public static String getWeekDay(Date date)
    {
        java.util.Date begin=date;
        Calendar c1=Calendar.getInstance();
        c1.setTime(date);
        java.util.Date end =new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
        long day1=between/(24*3600);
        if(day1==0)
        	return "今日推荐";
        else
        {
        	int day= c1.get(Calendar.DAY_OF_WEEK);
        	if(day==0)
        	{
        		day=7;
        		return dateFormat.format(date)+"礼拜天";
        	}
        	else
            return dateFormat.format(date)+"礼拜"+day;
        }
    }
    
    public static String todayDate(){
    	Date now = new Date();
    	DateFormat df = new SimpleDateFormat(FORMAT_DATE);
    	return df.format(now);
    }
    
    public static String todayTime(){
    	Date now = new Date();
    	DateFormat df = new SimpleDateFormat(FORMAT_DEFAULT);
    	return df.format(now);
    }
    
    public static String currentMonth(){
    	Date now = new Date();
    	DateFormat df = new SimpleDateFormat(FORMAT_MONTH);
    	return df.format(now);
    }
    /**
     * 获取和今天附近的某天
     * @param format
     * @param diff
     * @return
     */
    static public String getADay(String format,int diff) {
        SimpleDateFormat df=new SimpleDateFormat(format);

        Calendar now = Calendar.getInstance();
        int beforeM=now.get(Calendar.MONTH);
        now.roll(Calendar.DAY_OF_YEAR,diff);//
        int nowM=now.get(Calendar.MONTH);
        //必须进行日期处理，否则2009-01-04日前七天是2009-12-28
        if(nowM>beforeM)
        {
            now.roll(Calendar.YEAR,-1);
        }
        return df.format(now.getTime());
    }
    static public String getTomorrow(String format) {
        SimpleDateFormat df=new SimpleDateFormat(format);

        Calendar now = Calendar.getInstance();
        now.roll(Calendar.DAY_OF_YEAR, 1);//明天
        return df.format(now.getTime());
    }
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(dateToString(calendar.getTime(), "yyyy/MM/dd"));
//        System.out.println(dateToString(calendar.getTime(), "HH"));
//        System.out.println(dateToString(calendar.getTime(), "mm"));
    	System.out.println(currentMonth());
    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	System.out.println( new Date().getTime()>24*60*60 );
    	
    	try {
			System.out.println( elapsed(new Date(),dateFormat.parse("2015-10-19"),3) ); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
