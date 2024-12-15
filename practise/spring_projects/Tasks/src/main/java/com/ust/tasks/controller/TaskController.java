package com.ust.tasks.controller;

import com.ust.tasks.dto.TaskDto;
import com.ust.tasks.model.DeleteStatus;
import com.ust.tasks.model.Status;
import com.ust.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping("/")
    public String gethome(){
        return "home.jsp";
    }

    @GetMapping("/addtasks")
    public  String getaddpage(){
        return "addtasks.jsp";
    }

    @GetMapping("/viewtasks")
    public String toviewtasks(Model m){
        List<TaskDto> res=taskService.displaytaskService();
        m.addAttribute("tasks",res);
        return "viewTasks.jsp";
    }

    @GetMapping("/getTask")
    public String getTaskdetails(Model m, @RequestParam("searchId") int searchId){
        TaskDto taskDto=taskService.searchbyid(searchId);
        List<TaskDto> res=new ArrayList<>();
        if(taskDto!=null){
            res.add(taskDto);
        }
        m.addAttribute("tasks",res);
        return "viewTasks.jsp";
    }

    @GetMapping("/delete-task")
    public String deleteTaskdetails(Model m, @RequestParam("id") int id){
        taskService.deletebyidService(id);
        List<TaskDto> res=taskService.displaytaskService();
        m.addAttribute("tasks",res);
        return "viewTasks.jsp";
    }

    @PostMapping("/addingtasks")
    public String toaddTasks(Model m,
                             @RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("date") LocalDate date,
                             @RequestParam("completed") String completed) {
        TaskDto taskDto = new TaskDto(id, name, description, date, Status.COMPLETED, DeleteStatus.NOT_DELETED);
        taskService.addtaskService(taskDto);
        List<TaskDto> res = taskService.displaytaskService();
        m.addAttribute("tasks", res);
        return "viewTasks.jsp";
    }

    @GetMapping("/api")
    public String getSwaggerApi(){
        return "/swagger-ui.html";
    }

}
