package com.wsf.customview;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class DateTest {

    public static void main(String[] args) {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//        Date date = simpleDateFormat.parse("2020-12-19T12:00:00.000+0000");
//        System.out.println(simpleDateFormat.format(date));


//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        Date date = simpleDateFormat.parse(time);

        try {
            String time = "2020-12-29T12:00:00.000+0000";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            simpleDateFormat1.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = simpleDateFormat.parse(time);
            String time2 = simpleDateFormat1.format(date);
            Date datefinal = simpleDateFormat3.parse(time2);
            System.out.println(datefinal);
        } catch (Exception e) {


        }
    }
}
