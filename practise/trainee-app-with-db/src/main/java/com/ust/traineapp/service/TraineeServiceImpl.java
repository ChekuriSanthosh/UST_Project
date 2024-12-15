package com.ust.traineapp.service;

import com.ust.traineapp.model.Trainee;
import com.ust.traineapp.repositiory.TraineeRepository;
import com.ust.traineapp.repositiory.TraineeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepository;
    public Trainee saveservice(Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    public Trainee getTraineeservice(int id) {
        return traineeRepository.getTrainee(id);
    }

    public List<Trainee> getAllTraineesservice() {
        return traineeRepository.getAllTrainees();
    }

    @Override
    public void deleteTraineeservice(int id) {
        traineeRepository.deleteTrainee(id);

    }
}
