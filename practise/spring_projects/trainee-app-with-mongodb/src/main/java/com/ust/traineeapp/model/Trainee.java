package com.ust.traineeapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.swing.plaf.basic.BasicIconFactory;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Document
public class Trainee {
    @Id
    @JsonProperty("id")
    @Field(name = "id")
    private BigInteger _id;

    private String name;

    private String location;

    @Field(name = "date_joined")
    private LocalDate joinedDate;

    private Project project;

}
