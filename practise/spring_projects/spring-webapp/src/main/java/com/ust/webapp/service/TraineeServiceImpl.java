package com.ust.webapp.service;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;
import com.ust.webapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ust.webapp.util.EntityDtoUtil.convertToDto;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepository;
    public void addtraineeService(Trainee t) {
        traineeRepository.addTrainee(t);
    }

    public List<TraineeDto> displaytraineeService() {
        List<TraineeDto>res=new ArrayList<>();
        List<Trainee>all=traineeRepository.displayTrainees();
        for(Trainee t:all){
            res.add(convertToDto(t));
        }
        return res;
    }

    public boolean alreadyexists(int id) {
        return traineeRepository.traineeexists(id);
    }

    public TraineeDto searchbyid(int id) {
        Trainee res=traineeRepository.getTrainee(id);
        return convertToDto(res);
    }

    public void deletebyidService(int id) {
        traineeRepository.deletebyid(id);
    }

    public void updatetraineeService(Trainee t) {
        traineeRepository.updatetrainee(t);
    }

    public TraineeDto searchByName(String name) {
        Trainee t=traineeRepository.getTraineeName(name);
        return convertToDto(t);
    }

}
