package com.v33rh0ra.algorithms.codingconstructs.calendar;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarDateTimeDemo {
    public void getDateTime7(){
        System.out.println("Java 7");
        Calendar cal = Calendar.getInstance();
//                TimeZone.getTimeZone("EST")
//        );
        System.out.println("Current Time: "+cal.getTime());
        cal.add(Calendar.HOUR, 8);
        System.out.println("After 8 hours:"+cal.getTime());
    }
    public void getDateTime8(){
        System.out.println("Java 8");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Time: "+now);

        LocalDateTime later = now.plus(8, ChronoUnit.HOURS);
        System.out.println("After 8 hours:"+later);
    }

    public static void main(String[] args) {
        CalendarDateTimeDemo cld = new CalendarDateTimeDemo();
        cld.getDateTime7();
        cld.getDateTime8();
    }
}
