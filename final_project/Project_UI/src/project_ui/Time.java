/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ui;

/**
 *
 * @author faynch
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Time {
    private LocalDate myTime;
    private LocalDate newTime;
    private String day;
    private String date;
    private String month;
    private String year;

    //Set The current Time
    public Time() {
        myTime = LocalDate.now();
        newTime = LocalDate.now();
    }

    public LocalDate getMyTime() {
        return myTime;
    }

    public LocalDate getNewTime() {
        return newTime;
    }
    
    //return Time in Format(E dd MMM)
    public String getFormattedDateForMemo() {
        String formattedDate = newTime.format(DateTimeFormatter.ofPattern("E dd MMM"));
        return formattedDate;
    }
    
    public String getFormattedDateForBackend() {
        String formatForBackend = newTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        return formatForBackend;
    }
    
    public String getFormattedDateForDaily() {
        String formatForDaily = newTime.format(DateTimeFormatter.ofPattern("EEEE dd MMMM YYYY "));
        return formatForDaily.toUpperCase();
    }

    //Go to The Previous Time
    public void decreaseTime(){
        newTime = newTime.minusDays(1);
    }

    //Go to The Next Time
    public void increaseTime(){
        newTime = newTime.plusDays(1);
    }
    
    public static void main(String args[]) {
        Time t = new Time();
        System.out.println(t.getFormattedDateForMemo());
        System.out.println(t.getFormattedDateForBackend());
        System.out.println(t.getFormattedDateForDaily());
        t.decreaseTime();
        System.out.println(t.getFormattedDateForMemo());
        System.out.println(t.getFormattedDateForBackend());
        System.out.println(t.getFormattedDateForDaily());
        t.increaseTime();
        System.out.println(t.getFormattedDateForMemo());
        System.out.println(t.getFormattedDateForBackend());
        System.out.println(t.getFormattedDateForDaily());
    }
}
