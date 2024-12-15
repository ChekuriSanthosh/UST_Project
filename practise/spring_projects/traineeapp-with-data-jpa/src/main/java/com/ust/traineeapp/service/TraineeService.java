package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;

import java.util.List;

public interface TraineeService {

    Trainee saveTrainee(Trainee trainee);
    Trainee getTraineebyId(int id);
    void deleteTrainee(int id);
    List<Trainee> getAllTrainees();
    Trainee updateTrainee(int id,Trainee trainee);
    Trainee findTraineebyName(String name);
    List<Trainee> findBylocation(String location);
}
