package com.ust.webapp.repository;

import com.ust.webapp.model.Trainee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TraineeRepositoryImpl implements TraineeRepository{
    List<Trainee> traineeList;

    @PostConstruct
    void init(){
        traineeList=new ArrayList<>();
        Trainee t1=new Trainee(1,"Santhosh","Rjy");
        Trainee t2=new Trainee(2, "Pranith","Hyd");
        traineeList.add(t1);
        traineeList.add(t2);
    }

    public void addTrainee(Trainee t) {
        traineeList.add(t);
    }

    public List<Trainee> displayTrainees() {
        return traineeList;
    }

    public boolean traineeexists(int id) {
        for(Trainee trainee:traineeList){
            if(trainee.getId()==id){
                return true;
            }
        }
        return false;
    }

    public Trainee getTrainee(int id) {
        List<Trainee> ans=new ArrayList<>();
        for(Trainee t:traineeList){
            if(t.getId()==id){
                return t;
            }
        }
        return null;
    }

    public void deletebyid(int id) {
        for(Trainee t:traineeList){
            if(t.getId()==id){
                traineeList.remove(t);
                break;
            }
        }
    }

    public void updatetrainee(Trainee t) {
        for(int i=0;i<traineeList.size();i++){
            if(traineeList.get(i).getId()==t.getId()){
                traineeList.set(i,t);
            }
        }
    }

    public Trainee getTraineeName(String name) {
//        List<Trainee> ans=new ArrayList<>();
        for(Trainee t:traineeList){
            if(t.getName().equalsIgnoreCase(name)){
                return t;
            }
        }
        return null;
    }
}
