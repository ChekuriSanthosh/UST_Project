package com.ust.webapp.repository;

import com.ust.webapp.model.Trainee;

import java.util.List;

public interface TraineeRepository {
    void addTrainee(Trainee t);

    List<Trainee> displayTrainees();

    boolean traineeexists(int id);

    Trainee getTrainee(int id);

    void deletebyid(int id);

    void updatetrainee(Trainee t);

    Trainee getTraineeName(String name);
}
