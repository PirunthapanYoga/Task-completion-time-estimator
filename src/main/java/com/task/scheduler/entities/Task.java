package com.task.scheduler.entities;
import java.time.LocalDate;

import com.task.scheduler.services.Holidays;

public class Task {
    private final int taskID;
    private final String taskName;
    private final String description;
    private final LocalDate assignedDate;
    private int requireWorkDays;
    private LocalDate expectedCompleteDate;

    public Task(int taskID, String description , String taskName, LocalDate assignedDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.description = description;
        this.assignedDate = assignedDate; 
    }

    public int getID(){
        return this.taskID;
    }

    public int getTaskID() {
        return this.taskID;
    }

    public String getTaskName(){
        return this.taskName;
    }

    public String getDescription(){
        return this.description;
    }
    
    public LocalDate getAssignedDate(){
        return this.assignedDate;
    }

    public int getRequireWorkDays() {
        return requireWorkDays;
    }

    public void setRequireWorkDays(int requireWorkDays) {
        this.requireWorkDays = requireWorkDays;
        setExpectedCompleteDate();
    }

    public LocalDate getExpectedCompleteDate() {
        return this.expectedCompleteDate;
    }

    public void setExpectedCompleteDate(){
        this.expectedCompleteDate = assignedDate;

        Holidays holidays = new Holidays("LK",2023,"6af66274cc4e66b3850cd2cb91608d25eb519b87");
  
        // Counter used to find the working days in the dates
        int counter = 0;
        while(counter<=requireWorkDays){
            
            if (!(expectedCompleteDate.getDayOfWeek().toString().equals("SATURDAY") || expectedCompleteDate.getDayOfWeek().toString().equals("SUNDAY"))) {
                
                if(!holidays.isHoliday(expectedCompleteDate)){
                    counter++;
                }
                
            }

            if( counter > requireWorkDays){
                break;
            }

            expectedCompleteDate = expectedCompleteDate.plusDays(1);
        }
    }

    public Object getTaskDescription() {
        return null;
    }
}
