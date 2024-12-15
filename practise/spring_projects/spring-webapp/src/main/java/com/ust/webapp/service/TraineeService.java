package com.ust.webapp.service;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;

import java.util.List;

public interface TraineeService {
    void addtraineeService(Trainee t);
    List<TraineeDto> displaytraineeService();
    boolean alreadyexists(int id);
    TraineeDto searchbyid(int id);
    void deletebyidService(int id);
    void updatetraineeService(Trainee t);
    TraineeDto searchByName(String name);

}
