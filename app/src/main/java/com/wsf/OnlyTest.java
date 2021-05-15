package com.wsf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.sql.StatementEvent;

class OnlyTest {

    public static void main(String args[]) {
        System.out.println(GMTTime());
    }

    public static String GMTTime() {
        long current = System.currentTimeMillis();
        Date currentD = new Date(current);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String dateString = df.format(currentD);
        return dateString;
    }

    //格林威治时间转成本地时间
    public static Date GMTStringToLocalDate(String GMTString) {
        try {
            long current = System.currentTimeMillis();
            Date currentD = new Date(current);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            SimpleDateFormat dfLocal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dfFinal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("GMT"));
            dfLocal.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date gmtDate = df.parse(GMTString);
            String timeStr = dfLocal.format(gmtDate);
            Date loadDate = dfFinal.parse(timeStr);
            return loadDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
