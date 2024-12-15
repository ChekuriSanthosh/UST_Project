package java.com.ust.traineapp.service;

import java.com.ust.traineapp.model.Trainee;
import java.com.ust.traineapp.repositiory.TraineeRepository;
import java.com.ust.traineapp.repositiory.TraineeRepositoryImpl;

import java.util.List;

public class TraineeServiceImpl implements TraineeService{
    @Override
    public Trainee saveservice(Trainee trainee) {
        return null;
    }

    @Override
    public Trainee getTraineeservice(int id) {
        return null;
    }

    @Override
    public List<Trainee> getAllTraineesservice() {
        return List.of();
    }

    @Override
    public void deleteTraineeservice(int id) {

    }
//    TraineeRepository traineeRepository=new TraineeRepositoryImpl();
//    public Trainee saveservice(Trainee trainee) {
//        return traineeRepository.save(trainee);
//    }
//
//    public Trainee getTraineeservice(int id) {
//        return traineeRepository.getTrainee(id);
//    }
//
//    public List<Trainee> getAllTraineesservice() {
//        return traineeRepository.getAllTrainees();
//    }
//
//    @Override
//    public void deleteTraineeservice(int id) {
//        traineeRepository.deleteTrainee(id);
//
//    }
}
