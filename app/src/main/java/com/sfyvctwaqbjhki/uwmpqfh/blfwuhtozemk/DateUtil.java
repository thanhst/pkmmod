package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class DateUtil {
    private static final ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DateUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    private static final ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() { // from class: com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DateUtil.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static Calendar getCalendarByNumDay(Calendar calendar, int i2) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(calendar.getTimeInMillis() + (i2 * 24 * 3600 * 1000));
        return calendar2;
    }

    public static Calendar getCalendarByString(String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(str2).parse(str));
            return calendar;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getCurrentTimeFormat() {
        return new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static String getCurrentTimeString() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static Date getDateByString(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getDefaultTimeStringFormat(String str) {
        return getTimeStringFormat(new Date(), str);
    }

    public static String getSimpleHhMmDateString(String str) {
        return str == null ? "" : str.substring(11, 16);
    }

    public static String getTimeStringFormat(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static boolean isToday(String str) {
        Date date = toDate(str);
        Date date2 = new Date();
        if (date != null) {
            ThreadLocal<SimpleDateFormat> threadLocal = dateFormater2;
            if (threadLocal.get().format(date2).equals(threadLocal.get().format(date))) {
                return true;
            }
        }
        return false;
    }

    public static Date operationDate(Date date, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (i2 * 24 * 3600 * 1000));
        return calendar.getTime();
    }

    public static Date toDate(String str) {
        try {
            return dateFormater.get().parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getTimeStringFormat(Calendar calendar, String str) {
        return getTimeStringFormat(calendar.getTime(), str);
    }
}
