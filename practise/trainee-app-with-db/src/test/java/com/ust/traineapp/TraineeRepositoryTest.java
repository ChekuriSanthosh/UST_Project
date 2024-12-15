package com.ust.traineapp;


import com.ust.traineapp.model.Trainee;
import com.ust.traineapp.repositiory.TraineeRepository;
import com.ust.traineapp.repositiory.TraineeRepositoryImpl;
import com.ust.traineapp.service.TraineeService;
import com.ust.traineapp.service.TraineeServiceImpl;
import com.ust.traineapp.util.jdbcConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)


public class TraineeRepositoryTest{


    @Mock
    TraineeRepositoryImpl traineeRepository;

    @InjectMocks
    TraineeServiceImpl traineeService;

    @Test
    void saveTrainee() throws RuntimeException {
        Trainee trainee=new Trainee(1,"Santhosh","Rjy", LocalDate.of(2024,9,15));
        Mockito.when(traineeRepository.save(trainee)).thenReturn(trainee);
//        traineeRepository.save(trainee);
        traineeService.saveservice(trainee);
        traineeService.saveservice(trainee);
//        Assertions.assertDoesNotThrow(()->traineeService.getTraineeservice(trainee.id()));
        Mockito.verify(traineeRepository,Mockito.times(2)).save(trainee);

    }

    @Test

    void TestGetBYID() throws RuntimeException{
        Trainee trainee=new Trainee(1,"Santhosh","Rjy", LocalDate.of(2024,9,15));
        Mockito.when(traineeRepository.getTrainee(1)).thenReturn(trainee);

        Assertions.assertDoesNotThrow(()->traineeService.getTraineeservice(1));

        Mockito.verify(traineeRepository,Mockito.times(1)).getTrainee(1);
    }
    @Test
    void TestDeleteById() throws RuntimeException{
        Trainee trainee=new Trainee(1,"Santhosh","Rjy", LocalDate.of(2024,9,15));
        Mockito.doNothing().when(traineeRepository).deleteTrainee(1);
        Assertions.assertDoesNotThrow(()->traineeService.deleteTraineeservice(1));
        Mockito.verify(traineeRepository,Mockito.times(1)).deleteTrainee(1);

    }



}
