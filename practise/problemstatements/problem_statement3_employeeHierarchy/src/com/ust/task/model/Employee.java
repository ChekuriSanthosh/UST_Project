package com.ust.task.model;

public class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public void displayDetails(){

        System.out.println("name is: "+ this.name+'\n'+"salary is: "+this.salary+'\n'+"id is: "+this.id);
    }
}
