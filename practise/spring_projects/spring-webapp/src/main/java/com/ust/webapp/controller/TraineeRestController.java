package com.ust.webapp.controller;


import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeRestController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/{id}")
//    @ResponseStatus(code=HttpStatus.OK)
    public ResponseEntity<TraineeDto> getTrainee(@PathVariable("id") int id){
        TraineeDto res=traineeService.searchbyid(id);
        if(res==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
    }

    @ResponseStatus(code=HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<TraineeDto>> getallTrainees(){
        List<TraineeDto>res= traineeService.displaytraineeService();
        if(res.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
    }

    @ResponseStatus(code=HttpStatus.CREATED)
    @PostMapping
    public void saveTraineee(@RequestBody Trainee t){
        traineeService.addtraineeService(t);

    }


    @PutMapping
    public ResponseEntity updateTrainee(@RequestBody Trainee t){
        TraineeDto res=traineeService.searchbyid(t.getId());
        traineeService.updatetraineeService(t);
        if(res!=null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping
//    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public ResponseEntity deleteTrainee(@RequestBody int id){
        TraineeDto res=traineeService.searchbyid(id);
        traineeService.deletebyidService(id);
        if(res!=null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

//    @ResponseStatus(code=HttpStatus.OK)
    @GetMapping("/service")
    public ResponseEntity<TraineeDto> SearchbytheName(@RequestParam("name") String name){
        TraineeDto res= traineeService.searchByName(name);
        if(res==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
