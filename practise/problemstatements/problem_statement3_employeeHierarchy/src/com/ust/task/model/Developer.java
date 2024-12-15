package com.ust.task.model;

public class Developer extends Employee{
    protected String language;

    public Developer(String name, double salary, int id, String language){
        super(name,salary,id);
        this.language = language;
    }

    public void displayDetails(){
        System.out.println(this.getClass().getSimpleName());
        super.displayDetails();
        System.out.println("the develeopment launguage is: "+ this.language);
    }
}
