package com.example.duraitask.controller;

import com.example.duraitask.model.Form;
import com.example.duraitask.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v1/forms")
public class AppController {

    @Autowired
    FormService formService;
    @GetMapping("/{id}")
    public ResponseEntity<Form> getformbyid(@PathVariable("id") int id){
        Form res=formService.searchbyid(id);
        if(res==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }

    }

    @ResponseStatus(code=HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<Form>> getallforms(){
        List<Form>res= formService.displaytaskService();
        if(res.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
    }

    @ResponseStatus(code=HttpStatus.CREATED)
    @PostMapping
    public void saveform(@RequestBody Form t){
        formService.addtaskService(t);

    }
}
