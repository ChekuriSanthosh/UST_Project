package com.ust.traineapp;

import com.ust.traineapp.configuration.TraineeAppConfig;
import com.ust.traineapp.model.Trainee;
import com.ust.traineapp.repositiory.TraineeRepository;
import com.ust.traineapp.repositiory.TraineeRepositoryImpl;
import com.ust.traineapp.service.TraineeService;
import com.ust.traineapp.service.TraineeServiceImpl;
import com.ust.traineapp.util.jdbcConnectionUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(TraineeAppConfig.class);
        TraineeService service=context.getBean(TraineeServiceImpl.class);
//        Trainee trainee=new Trainee(2,"pranith","Rjy", LocalDate.of(2024,9,15));
//        service.saveservice(trainee);



        service.getAllTraineesservice().forEach(System.out::println);

    }
}