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

public class time {
    private String day;
    private String date;
    private String month;
    private String formattedDate;

    //Set The current Time
    public time() {
        LocalDate myTime = LocalDate.now();
        this.day = myTime.format(DateTimeFormatter.ofPattern("E "));
        this.date = myTime.format(DateTimeFormatter.ofPattern("d"));
        this.month = myTime.format(DateTimeFormatter.ofPattern(" MMM"));
    }

    //return Time in Format(E dd MMM)
    public String getFormattedDate() {
        formattedDate = this.day + this.date + this.month;
        return formattedDate;
    }

    //Go to The Previous Time
    public String decreaseTime(){
        //change day
        String[] dayList = {"Sun ", "Mon ", "Tue ", "Wed ", "Thu ", "Fri ", "Sat "};
        if (Objects.equals(this.day, dayList[0])){
            this.day = "Sat ";
        }
        else {
            for (int i = 1; i < dayList.length; i++) {
                if (Objects.equals(this.day, dayList[i])){
                    this.day = dayList[--i];
                    break;
                }
            }
        }

        //change date
        if (Objects.equals(this.date, "1")) {
            //change month
            String[] monthList = {" Jan", " Feb", " Mar", " Apr", " May", " Jun", " Jul", " Aug", " Sep", " Oct", " Nov", " Dec"};
            if (Objects.equals(this.month, monthList[0])) {
                this.month = " Dec";
            } else {
                for (int j = 1; j < monthList.length; j++) {
                    if (Objects.equals(this.month, monthList[j])) {
                        this.month = monthList[--j];
                        break;
                    }
                }
            }

            String[] monthOf30thList = {" Apr", " Jun", " Sep", " Nov"};
            if (Objects.equals(this.month, " Feb")) {
                this.date = "28";
            } else if (Arrays.asList(monthOf30thList).contains(this.month)) {
                this.date = "30";
            } else {
                this.date = "30";
            }
        }
        else {this.date = String.valueOf(Integer.parseInt(this.date)-1);}

        return getFormattedDate();
    }

    //Go to The Next Time
    public String increaseTime(){
        //change day
        String[] dayList = {"Sun ", "Mon ", "Tue ", "Wed ", "Thu ", "Fri ", "Sat "};
        if (Objects.equals(this.day, dayList[6])){
            this.day = "Sun ";
        }
        else {
            for (int i = 0; i < dayList.length; i++) {
                if (Objects.equals(this.day, dayList[i])){
                    this.day = dayList[++i];
                    break;
                }
            }
        }

        //change date & month
        String[] monthList = {" Jan", " Feb", " Mar", " Apr", " May", " Jun", " Jul", " Aug", " Sep", " Oct", " Nov", " Dec"};
        String[] monthOf30thList = {" Apr", " Jun", " Sep", " Nov"};
        if ((Objects.equals(this.date, "28")) && (Objects.equals(this.month, " Feb"))) {
            this.month = " Mar";
            this.date = "1";
        }
        else if (((Objects.equals(this.date, "30")) && (Arrays.asList(monthOf30thList).contains(this.month))) ||
                ((Objects.equals(this.date, "31")) && (!Arrays.asList(monthOf30thList).contains(this.month)))) {
            this.date = "1";
            if (Objects.equals(this.month, monthList[11])) {
                this.month = " Jan";
            } else {
                for (int j = 0; j < monthList.length; j++) {
                    if (Objects.equals(this.month, monthList[j])) {
                        this.month = monthList[++j];
                        break;
                    }
                }
            }
        }
        else {this.date = String.valueOf(Integer.parseInt(this.date)+1);}

        return getFormattedDate();
    }
}
