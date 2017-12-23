/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.util;

import com.mealnotificator.model.Week;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author George
 */
public class CalendarToMatrices {
    
    private int month;
    
   
    
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    private int year;
    
    public CalendarToMatrices(){
        this.month = LocalDateTime.now().getMonthValue();
        this.year = LocalDateTime.now().getYear();
    }
    
    public int[][] currentCalendar() throws ParseException{
        this.month = LocalDateTime.now().getMonthValue();
        this.year = LocalDateTime.now().getYear();
        return calendarInMatrix();
    }
    
    public int[][] nextCalendar() throws ParseException{
        if(this.month == 12){
            this.month = 1;
            this.year++;
        } else{
            this.month = this.month + 1;
        }
        return calendarInMatrix();
    }
    
    public int[][] previousCalendar() throws ParseException{
        
        if(this.month == 1){
            this.month = 12;
            this.year--;
        } else{
            this.month = this.month - 1;
        }
        return calendarInMatrix();
    }
    
    private int[][] calendarInMatrix() throws ParseException{
        int firstDay = getFirstDay();
        int lastDay = getLastDay();
        int [][]mCalendar = new int[7][6];
        
        int index = 1;
        boolean trigger = false;
        int day = 1;
        
        for (int s = 0; s < 6; s++) {
            for (int d = 0; d < 7; d++) {
              
                if(index == firstDay)
                    trigger = true;
                  
                if(day == lastDay + 1)
                    trigger = false;
                 
                if (trigger == true){
                    mCalendar[d][s] = day;
                    day++;
                }
              index++;
            }
        }
       return mCalendar;
    }
    
    public ArrayList<Week> getWeeks() throws ParseException{
        int [][] cal = calendarInMatrix();
                
        ArrayList<Week> weeks = new ArrayList<>();
        try {
            System.out.println(cal[0][0]);
            System.out.println(cal[1][0]);
            System.out.println(cal[2][0]);
            System.out.println(cal[3][0]);
            System.out.println(cal[4][0]);
            System.out.println(cal[5][0]);
            System.out.println(cal[6][0]);
            
         weeks.add(new Week(cal[0][0], cal[1][0], cal[2][0], cal[3][0], cal[4][0], cal[5][0], cal[6][0]));
         weeks.add(new Week(cal[0][1], cal[1][1], cal[2][1], cal[3][1], cal[4][1], cal[5][1], cal[6][1]));
         weeks.add(new Week(cal[0][2], cal[1][2], cal[2][2], cal[3][2], cal[4][2], cal[5][2], cal[6][2]));
         weeks.add(new Week(cal[0][3], cal[1][3], cal[2][3], cal[3][3], cal[4][3], cal[5][3], cal[6][3]));
         weeks.add(new Week(cal[0][4], cal[1][4], cal[2][4], cal[3][4], cal[4][4], cal[5][4], cal[6][4]));
         weeks.add(new Week(cal[0][5], cal[1][5], cal[2][5], cal[3][5], cal[4][5], cal[5][5], cal[6][5]));
    
        } catch (Exception e) {
            System.out.println(e);
        }
            
        System.out.println("aqui");
        return weeks;
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