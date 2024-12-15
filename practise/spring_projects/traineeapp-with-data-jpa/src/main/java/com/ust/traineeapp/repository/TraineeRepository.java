package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface TraineeRepository extends JpaRepository<Trainee,Integer> {

//    @Query("from Trainee where name=:name")
    Optional<Trainee> findByName(String name);

    List<Trainee> findByLocation(String location);
}
