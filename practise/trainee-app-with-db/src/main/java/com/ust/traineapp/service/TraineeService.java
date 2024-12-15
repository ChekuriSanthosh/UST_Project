package com.ust.traineapp.service;

import com.ust.traineapp.model.Trainee;

import java.util.List;

public interface TraineeService {
    public Trainee saveservice(Trainee trainee);
    public Trainee getTraineeservice(int id);
    public List<Trainee> getAllTraineesservice();

    public void deleteTraineeservice(int id);
}
