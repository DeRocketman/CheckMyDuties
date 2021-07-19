package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public  class TimeCalculator {
    public static String calculateDuration(String beginn, String ende) throws ParseException {
        String begin = beginn;
        String end = ende;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = format.parse(begin);
        Date date2 = format.parse(end);
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

    public static void main(String[] args) throws ParseException {
        //calculateDuration("2:19", "9:45");

    }
}
