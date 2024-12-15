package com.ust.tasks.controller;


import com.ust.tasks.dto.TaskDto;
import com.ust.tasks.model.Status;
import com.ust.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5501"})
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskRestController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
//    @ResponseStatus(code=HttpStatus.OK)
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") int id){
        TaskDto res=taskService.searchbyid(id);
        if(res==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
    }

    @ResponseStatus(code=HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<TaskDto>> getallTasks(){
        List<TaskDto>res= taskService.displaytaskService();
        if(res.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
    }

    @ResponseStatus(code=HttpStatus.CREATED)
    @PostMapping
    public void saveTaskss(@RequestBody TaskDto t){
        taskService.addtaskService(t);

    }


    @PutMapping
    public ResponseEntity updateTasks(@RequestBody TaskDto t){
        TaskDto res=taskService.searchbyid(t.id());
        taskService.updatetaskService(t);
        if(res!=null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTasks(@PathVariable int id) {
        TaskDto res = taskService.searchbyid(id);
        taskService.deletebyidService(id);
        if (res != null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    //    @ResponseStatus(code=HttpStatus.OK)
    @GetMapping("/service")
    public ResponseEntity<List<TaskDto>> SearchbytheName(@RequestParam("name") String name){
        List<TaskDto> res= taskService.searchByName(name);
        if(res==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(code = HttpStatus.OK)
    public  List<TaskDto> getbasedonstatus(@PathVariable("status") Status status){
        List<TaskDto> res= taskService.getbyStatus(status);
        return res;
    }

    @GetMapping("/overdue")
    @ResponseStatus(code = HttpStatus.OK)
    public  List<TaskDto> getoverduetasks(){
        List<TaskDto> res= taskService.getoverduetasks();
        return res;
    }

    @GetMapping("/getsortedbydate")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDto> getsorteddatetasks(){
        List<TaskDto> res=taskService.sortbyduedate();
        return res;
    }

    @GetMapping("/retrivedeleted")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDto> getretriveddelete(){
        List<TaskDto> res=taskService.getdeletedtasks();
        return res;
    }

    @PutMapping("/retrive/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void retrivetooriginal(@PathVariable int id){
        taskService.retrivedeleted(id);
    }

    @GetMapping("/month/{month}/year/{year}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDto> getallbythemonthandyear(@PathVariable int month, @PathVariable int year){
        List<TaskDto>res=taskService.getbyyearandmonth(month, year);
        return res;
    }


}
