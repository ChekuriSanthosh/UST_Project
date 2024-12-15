package com.ust.tasks.repository;

import com.ust.tasks.model.DeleteStatus;
import com.ust.tasks.model.Status;
import com.ust.tasks.model.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class TaskRepositoryImpl {
    List<Task> alltasks;

    @PostConstruct
    void init(){
        alltasks=new ArrayList<>();
        Task t1=new Task(1,"Pranith","this is my first Task", LocalDate.of(2002,10,1), Status.COMPLETED, DeleteStatus.NOT_DELETED);
        alltasks.add(t1);
    }
    public void addTask(Task t) {
        alltasks.addLast(t);
    }

    public List<Task> displayTasks() {
        return alltasks;
    }

    public boolean Taskexists(int id) {
        for(Task task:alltasks){
            if(task.getId()==id){
                return true;
            }
        }
        return false;
    }

    public Task getTask(int id) {
        List<Task> ans=new ArrayList<>();
        for(Task t:alltasks){
            if(t.getId()==id){
                return t;
            }
        }
        return null;
    }

    public void deletebyid(int id) {
        for(Task t:alltasks){
            if(t.getId()==id){
                alltasks.remove(t);
                break;
            }
        }
    }

    public void updatetask(Task t) {
        for(int i=0;i<alltasks.size();i++){
            if(alltasks.get(i).getId()==t.getId()){
                alltasks.set(i,t);
            }
        }
    }

    public Task getTaskName(String name) {

        for(Task t:alltasks){
            if(t.getName().equalsIgnoreCase(name)){
                return t;
            }
        }
        return null;
    }

}
