package com.ust.task.service;

import com.ust.task.model.Employee;

public class Employeemanagementimpl implements Employeemanagement{

    @Override
    public void registerEmployee(Employee employee) {
        System.out.println("employee "+employee.getName()+"Registered!");
    }

    @Override
    public void removeEmployee(int id) {

    }
}
