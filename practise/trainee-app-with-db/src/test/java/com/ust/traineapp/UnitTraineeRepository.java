package com.ust.traineapp;

import com.ust.traineapp.model.Trainee;
import com.ust.traineapp.repositiory.TraineeRepository;
import com.ust.traineapp.repositiory.TraineeRepositoryImpl;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Slf4j
public class UnitTraineeRepository extends TestCase {

    private TraineeRepository repo;
    @BeforeEach
    void setup(){
        repo=new TraineeRepositoryImpl();
    }

    @AfterEach
    void delete(){
        repo=null;
    }


    @Test
    void UnitTestSave() throws RuntimeException{
        Trainee trainee=new Trainee(1,"Santhosh","Rjy", LocalDate.of(2024,9,15));
        repo.save(trainee);
        Assertions.assertEquals(1,repo.getAllTrainees().size());
        repo.deleteTrainee(trainee.id());

    }

    @Test
    void UnitGetById() throws RuntimeException{
        Trainee trainee=new Trainee(2,"Santhosh","Rjy", LocalDate.of(2024,9,15));
        repo.save(trainee);
        Assertions.assertEquals(trainee.name(),repo.getTrainee(trainee.id()).name());
        Assertions.assertEquals(1,repo.getAllTrainees().size());
        repo.deleteTrainee(trainee.id());
    }
}
