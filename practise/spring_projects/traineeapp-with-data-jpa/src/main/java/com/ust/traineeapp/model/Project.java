package com.ust.traineeapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Project {
    @Id
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Status status;


    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Trainee> trainee;

}
