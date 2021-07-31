package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public  class TimeCalculator {
    public static String calculateDuration(String beginn, String ende) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = format.parse(beginn);
        Date date2 = format.parse(ende);
        long difference = date2.getTime() - date1.getTime();
        int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(difference);
        if(minutes<0){
            minutes += 1440;
        }
        int hour = minutes/60;
        int minute = minutes%60;

        return hour +":"+ minute;
    }
    public String calculateBreak(List<CsvRow> csvRows) throws ParseException {
        List<String> timestampsList = new ArrayList<>();
        for (CsvRow row: csvRows) {
            if (!row.getBreakTime().equals("00:00")){
                timestampsList.add(row.getBreakTime());
            }
        }
        final DateFormat dt = new SimpleDateFormat("HH:mm");
        final Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        long milliseconds = 0;
        c.clear();
        long startingMS = c.getTimeInMillis();
        for (final String t : timestampsList) {
            milliseconds = milliseconds + (dt.parse(t).getTime() - startingMS);
        }
        int minute = (int) TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        return "0:" + minute;
    }

    public static String calculateDifference(String regular, String deviation) throws ParseException {
        String description;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date regularDate = format.parse(regular);
        Date deviationDate = format.parse(deviation);
        long difference = regularDate.getTime() - deviationDate.getTime();

        if (difference<0) {
            description = " später";
            difference= difference*-1;
        } else {
            description = " früher";
        }
        int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(difference);

        int hour = minutes/60;
        int minute = minutes%60;
        if (hour<10) {
            if (minute<10) {
                return "0"+hour+":0"+minute+ description;
            } else {
                return "0" + hour + ":"+ minute + description;
            }
        } else {
            if (minute<10) {
                return hour+":0"+minute+ description;
            } else {
                return hour + ":" + minute + description;
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        //calculateDuration("2:19", "9:45");
        System.out.println(calculateDifference("02:20", "2:25"));
        System.out.println(calculateDifference("2:20", "2:10"));
        System.out.println(calculateDifference("2:20", "24:45"));
        System.out.println(calculateDifference("2:20", "0:45"));
        System.out.println(calculateDifference("13:50", "21:45"));
        System.out.println(calculateDifference("2:20", "25:45"));
    }
}
