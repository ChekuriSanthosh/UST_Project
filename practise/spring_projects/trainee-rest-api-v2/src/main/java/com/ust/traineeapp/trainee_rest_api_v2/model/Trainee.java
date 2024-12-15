package com.ust.traineeapp.trainee_rest_api_v2.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "trainee_db")
public class Trainee {
    @Id
    @Column(name = "trainee_id")
    private int id;
    @Column(name = "trainee_name",length = 50)
    private String name;
    @Column(length = 100)
    private String location;
    @Column(name = "joined_date")
    private LocalDate joinedDate;


    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;

}

