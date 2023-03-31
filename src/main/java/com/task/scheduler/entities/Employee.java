package com.task.scheduler.entities;
import java.util.ArrayList;

public class Employee {
    private final String Name;
    private final int EmpID;
    private ArrayList<Task> assignedTask;

    public Employee(String Name, int EmpID) {
        this.Name = Name;
        this.EmpID = EmpID;
        this.assignedTask = new ArrayList<Task>();
    }

    public String getName() {
        return Name;
    }

    public int getEmpID() {
        return EmpID;
    }

    public ArrayList<Task> getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(Task newTask) {
        this.assignedTask.add(newTask);
    }

    public Object getEmployeeName() {
        return null;
    }
}
