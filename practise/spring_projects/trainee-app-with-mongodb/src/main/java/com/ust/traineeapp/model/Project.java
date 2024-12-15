package com.ust.traineeapp.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Project {
    private String title;
    private Status status;
}
