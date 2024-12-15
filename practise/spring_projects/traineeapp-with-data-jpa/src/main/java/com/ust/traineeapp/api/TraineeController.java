package com.ust.traineeapp.api;


import com.ust.traineeapp.model.Project;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Trainee saveTrainee(@RequestBody Trainee trainee){
        return traineeService.saveTrainee(trainee);
    }

    @PutMapping("/traineepost/{id}")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Trainee saveIndividuallyTrainee(@PathVariable int id, @RequestBody Project p){
        Trainee t=traineeService.getTraineebyId(id);
        t.setProject(p);
        return traineeService.updateTrainee(id,t);
//        return traineeService.saveTrainee(trainee);
    }

    @GetMapping
    @ResponseStatus(code=HttpStatus.OK)
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }


    @GetMapping("/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public Trainee getTrainee(@PathVariable int id){
//        return ResponseEntity.status(HttpStatus.OK).body(traineeService.getTraineebyId(id));
        return traineeService.getTraineebyId(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee getTraineeName(@PathVariable("name") String name){
        return traineeService.findTraineebyName(name);
    }

    @GetMapping("location/{location}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Trainee> getTraineebylocations(@PathVariable("location") String location){
        return traineeService.findBylocation(location);
    }




    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Trainee updateTrainee(@PathVariable int id,@RequestBody Trainee trainee){
        return traineeService.updateTrainee(id,trainee);
    }




    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable int id) {
        traineeService.deleteTrainee(id);
    }



}
