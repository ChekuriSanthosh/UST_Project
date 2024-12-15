package com.ust.webapp.util;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;

public class EntityDtoUtil {

    public static TraineeDto convertToDto(Trainee t){
        TraineeDto traineeDto=new TraineeDto(
                t.getId(),
                t.getName(),
                t.getLocation()
        );
        return traineeDto;
    }

    public static Trainee convertToEntity(TraineeDto traineeDto){
        Trainee t=new Trainee(
                traineeDto.id(),
                traineeDto.name(),
                traineeDto.location()
        );
        return t;
    }
}
