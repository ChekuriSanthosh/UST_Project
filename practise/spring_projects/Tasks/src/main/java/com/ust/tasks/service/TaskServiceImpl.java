package com.ust.tasks.service;

//import com.ust.tasks.dto.TaskDto;
//import com.ust.tasks.model.Task;
import com.ust.tasks.Exceptions.RecordAlreadyExists;
import com.ust.tasks.Exceptions.RecordNotFound;
import com.ust.tasks.dto.TaskDto;
import com.ust.tasks.model.DeleteStatus;
import com.ust.tasks.model.Status;
import com.ust.tasks.model.Task;
import com.ust.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.ust.tasks.util.converterutil.DtoconvertToTask;
import static com.ust.tasks.util.converterutil.taskconvertToDto;

//import static com.ust.tasks.util.converterutil.DtoconvertToTask;
//import static com.ust.tasks.util.converterutil.taskconvertToDto;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;
    public void addtaskService(TaskDto t) {
        if(taskRepository.existsById(t.id())){
            throw new RecordAlreadyExists("This record Already Exists with id "+t.id());
        }

        Task task=DtoconvertToTask(t);
        task.setDeleteStatus(DeleteStatus.NOT_DELETED);
        taskRepository.save(task);
    }

    public List<TaskDto> displaytaskService() {
        List<Task> res=taskRepository.findAll();
        List<TaskDto> ans=new ArrayList<>();
        for(Task t:res){
            if(t.getDeleteStatus()==DeleteStatus.NOT_DELETED){
                ans.add(taskconvertToDto(t));
            }
        }
        return ans;
    }

    public boolean alreadyexists(int id) {
        return taskRepository.existsById(id);
    }

    public TaskDto searchbyid(int id) {
        Task task=taskRepository.getById(id);
        if(task.getDeleteStatus()==DeleteStatus.NOT_DELETED){
            return taskconvertToDto(task);
        }
        return null;
    }

    public void deletebyidService(int id) {
        Task task=taskRepository.getById(id);
        if(task==null){
            throw new RecordNotFound("This record is not found");
        }
        task.setDeleteStatus(DeleteStatus.DELETED);
        taskRepository.save(task);
    }

    public void updatetaskService(TaskDto t) {
        Task task=taskRepository.getById(t.id());
        if(task==null){
            throw new RecordNotFound("This record is not Found");
        }
        Task task1=DtoconvertToTask(t);
        task1.setDeleteStatus(DeleteStatus.NOT_DELETED);
        taskRepository.save(task1);
    }


    public List<TaskDto> searchByName(String name) {
        List<Task>res=taskRepository.findByName(name);
        List<TaskDto> ans=new ArrayList<>();
        for(Task t:res){
            if(t.getDeleteStatus()==DeleteStatus.NOT_DELETED){
                ans.add(taskconvertToDto(t));
            }
        }
        return ans;
    }

    public List<TaskDto> getbyStatus(Status s) {

        List<Task>res= taskRepository.findByStatus(s);
        List<TaskDto> ans=new ArrayList<>();
        for(Task t:res){
            if(t.getDeleteStatus()==DeleteStatus.NOT_DELETED){
                ans.add(taskconvertToDto(t));
            }
        }
        return ans;

    }

    public List<TaskDto> getoverduetasks() {
        List<Task>res=taskRepository.overDueTasks();
        List<TaskDto> ans=new ArrayList<>();
        for(Task t:res){
            if(t.getDeleteStatus()==DeleteStatus.NOT_DELETED){
                ans.add(taskconvertToDto(t));
            }
        }
        return ans;
    }

    public List<TaskDto> sortbyduedate() {
        List<Task>res=taskRepository.sortByDueDate();
        List<TaskDto> ans=new ArrayList<>();
        for(Task t:res){
            if(t.getDeleteStatus()==DeleteStatus.NOT_DELETED){
                ans.add(taskconvertToDto(t));
            }
        }
        return ans;
    }

    public List<TaskDto> getdeletedtasks() {
        List<Task> res=taskRepository.retrivedeletetasks();
        List<TaskDto> ans=new ArrayList<>();
        for(Task t:res){
                ans.add(taskconvertToDto(t));
        }
        return ans;
    }

    public void retrivedeleted(int id) {
        Task t=taskRepository.getById(id);
        t.setDeleteStatus(DeleteStatus.NOT_DELETED);
        taskRepository.save(t);
    }

    public List<TaskDto> getbyyearandmonth(int month, int year) {
        List<Task> res=taskRepository.getallbyMonthandYear(month,year);
        List<TaskDto> ans=new ArrayList<>();
        for(Task t:res){
            ans.add(taskconvertToDto(t));
        }
        return ans;
    }


}
