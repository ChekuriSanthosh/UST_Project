package com.ust.task.model;

public class Manager extends Employee{
    protected int teamSize;

    public Manager(String name, double salary, int id, int teamSize) {
        super(name, salary, id);
        this.teamSize = teamSize;
    }

    public void displayDetails(){
        System.out.println(this.getClass().getSimpleName());
        super.displayDetails();
        System.out.println("the team size is: "+ this.teamSize+'\n');
    }

}
