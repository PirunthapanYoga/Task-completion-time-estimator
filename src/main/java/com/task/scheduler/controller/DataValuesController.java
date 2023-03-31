package com.task.scheduler.controller;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.scheduler.entities.Employee;
import com.task.scheduler.entities.Task;
import com.task.scheduler.services.Holidays;

// this is teh con
@RestController
public class DataValuesController {
    public ArrayList<Task> tasks = new ArrayList<>();
    public ArrayList<Employee> employees =  new ArrayList<>();
    public Holidays holidays2023;
    
    public DataValuesController() {
        setEmployees();
        setTasks();
        assignTaskToEmployees(); 
    }

    // Add user information
    public void setEmployees(){
        this.employees.add(new Employee("Pirunthapan Yogatahsan" , 1000000000));
        this.employees.add(new Employee("Prince Rex" , 1000000001));
        this.employees.add(new Employee("Tony Stark" , 1000000003));
        this.employees.add(new Employee("Rocket Raccoon" , 1000000004));
        this.employees.add(new Employee("Groot" , 1000000004));
        this.employees.add(new Employee("Stephan Strange" , 1000000005));
    }
    
    //Add tasks
    public void setTasks(){
        // april have many holidays so I alligned the date of assignemnt according to that.
        this.tasks.add(new Task(200000000,"Sample Task 1","Integrate Service Chat bot with LLM phase 1",LocalDate.of(2023, 3, 31)));
        this.tasks.add(new Task(200000001,"Sample Task 2","Integrate Service Chat bot with LLM phase 2",LocalDate.of(2023, 4, 1)));
        this.tasks.add(new Task(200000002,"Sample Task 3","Integrate Service Chat bot with LLM phase 3",LocalDate.of(2023, 4, 3)));
        this.tasks.add(new Task(200000003,"Sample Task 4","Integrate Service Chat bot with LLM phase 4",LocalDate.of(2023, 4, 7)));
        this.tasks.add(new Task(200000004,"Sample Task 5","Integrate Service Chat bot with LLM phase 5",LocalDate.of(2023, 4, 10)));
        this.tasks.add(new Task(200000005,"Sample Task 6","Integrate Service Chat bot with LLM phase 6",LocalDate.of(2023, 4, 15)));

    }

    //Add task assignment
    public void assignTaskToEmployees(){
        this.employees.get(0).setAssignedTask(tasks.get(0));
        this.employees.get(0).getAssignedTask().get(0).setRequireWorkDays(7);

        this.employees.get(1).setAssignedTask(tasks.get(1));
        this.employees.get(1).getAssignedTask().get(0).setRequireWorkDays(10);

        this.employees.get(2).setAssignedTask(tasks.get(2));
        this.employees.get(2).getAssignedTask().get(0).setRequireWorkDays(12);
        
        this.employees.get(3).setAssignedTask(tasks.get(3));
        this.employees.get(3).getAssignedTask().get(0).setRequireWorkDays(8);
        
        this.employees.get(4).setAssignedTask(tasks.get(4));
        this.employees.get(4).getAssignedTask().get(0).setRequireWorkDays(25);

        this.employees.get(0).setAssignedTask(tasks.get(5));
        this.employees.get(0).getAssignedTask().get(1).setRequireWorkDays(25);
    }

    @GetMapping("/Tasks")
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    // to get the expected the ompletion of the task use this localhost route to access 
    @GetMapping("/Employees")
    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    @GetMapping("/Holidays")
    public Holidays getHolidays2023() {
        return this.holidays2023;
    }

}

