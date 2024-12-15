package com.ust.traineeapp.controller;


import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.service.TraineeService;
import com.ust.traineeapp.service.TraineeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeController {

    @Autowired
    TraineeService traineeService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Trainee saveTrainee(@RequestBody Trainee t){
        return traineeService.saveTrainee(t);
    }

    @GetMapping("/search")
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee getTraineebyid(@RequestBody BigInteger id){
        return traineeService.findTraineeById(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Trainee> getall(){
        return traineeService.getAllTrainees();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTraineebyid(@PathVariable BigInteger id){
         traineeService.removeTrainee(id);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public Trainee getTraineebyid(@RequestBody BigInteger id,@RequestBody Trainee t){
        return traineeService.updateTrainee(id,t);
    }






}
