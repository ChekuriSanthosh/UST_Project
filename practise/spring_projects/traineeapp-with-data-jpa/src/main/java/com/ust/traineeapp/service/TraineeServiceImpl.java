package com.ust.traineeapp.service;

import com.ust.traineeapp.exception.RecordAlreadyExistsException;
import com.ust.traineeapp.exception.RecordNotFoundException;
import com.ust.traineeapp.model.Project;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.ProjectRepository;
import com.ust.traineeapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Trainee saveTrainee(Trainee trainee) {
        if(traineeRepository.existsById(trainee.getId())){
            throw new RecordAlreadyExistsException("Trainee with ID "+trainee.getId()+" Already Present");
        }

        Project project=trainee.getProject();
        Trainee saved=null;
        if(project!=null){
            List<Trainee> res=project.getTrainee();
            if(res==null){
                res=new ArrayList<>();
            }
            res.add(trainee);
            project.setTrainee(res);
            projectRepository.save(project);
        }else{
            trainee.setProject(null);
        }



        return traineeRepository.save(trainee);
    }

    public Trainee getTraineebyId(int id) {
        if (!traineeRepository.existsById(id)){
            throw new RecordNotFoundException("Trainee with ID "+id+" Not Found");
        }
        return traineeRepository.findById(id).orElse(null);
    }

    public void deleteTrainee(int id) {
        if (!traineeRepository.existsById(id)){
            throw new RecordNotFoundException("Trainee with ID "+id+" Not Found");
        }
        traineeRepository.deleteById(id);
    }

    public List<Trainee> getAllTrainees() {
        return traineeRepository.findAll();
    }

    public Trainee updateTrainee(int id,Trainee trainee) {
        if (!traineeRepository.existsById(id)){
            throw new RecordNotFoundException("Trainee with ID "+id+" Not Found");
        }
        Trainee traineeToUpdate = getTraineebyId(id);
        if(trainee.getName()!=null){
            traineeToUpdate.setName(trainee.getName());
        }
        if(trainee.getLocation()!=null){
            traineeToUpdate.setLocation(trainee.getLocation());
        }
        if(trainee.getJoinedDate()!=null){
            traineeToUpdate.setJoinedDate(trainee.getJoinedDate());
        }
        return traineeRepository.save(traineeToUpdate);

    }

    public Trainee findTraineebyName(String name) {
        return  traineeRepository.findByName(name).orElse(null);
    }

    public List<Trainee> findBylocation(String location) {
        return traineeRepository.findByLocation(location);
    }
}
