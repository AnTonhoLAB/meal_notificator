/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author George
 */
public class CalendarToMatrices {
    
    private int month;
    private int year;
    
    public CalendarToMatrices(){
        this.month = LocalDateTime.now().getMonthValue();
        this.year = LocalDateTime.now().getYear();
    }
    
    public void nextCalender() throws ParseException{
        if(this.month == 12){
            this.month = 1;
            this.year++;
        } else{
            this.month = this.month + 1;
        }
  
    }
    
    public void previousCalendar(){
        
        if(this.month == 1){
            this.month = 12;
            this.year--;
        } else{
            this.month = this.month - 1;
        }
    }
    
    private void calendarInMatrix() throws ParseException{
        int firstDay = getFirstDay();
        int lastDay = getLastDay();
        
 
    }
    
    // get day of week of a first day of month
    private int getFirstDay() throws ParseException{
        Calendar cal = Calendar.getInstance();
        
        SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
        java.sql.Date data = new java.sql.Date(format.parse(this.month + "/01/" + this.year).getTime());
        
        cal.setTime(data);  
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    // get last day of month
    private int getLastDay(){      
        String date = this.month + "/01/" + this.year;
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
        convertedDate = convertedDate.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear()));
        
        return convertedDate.getDayOfMonth();
    }
}

