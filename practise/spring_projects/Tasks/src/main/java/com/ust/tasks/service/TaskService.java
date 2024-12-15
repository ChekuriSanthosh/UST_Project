package com.ust.tasks.service;

import com.ust.tasks.dto.TaskDto;
import com.ust.tasks.model.Status;

import java.util.List;

public interface TaskService {
    void addtaskService(TaskDto t);
    List<TaskDto> displaytaskService();
    boolean alreadyexists(int id);
    TaskDto searchbyid(int id);
    void deletebyidService(int id);
    void updatetaskService(TaskDto t);
    List<TaskDto> searchByName(String name);
    List<TaskDto> getbyStatus(Status s);
    List<TaskDto> getoverduetasks();
    List<TaskDto> sortbyduedate();
    List<TaskDto> getdeletedtasks();
    void retrivedeleted(int id);
    List<TaskDto> getbyyearandmonth(int month,int year);
}
