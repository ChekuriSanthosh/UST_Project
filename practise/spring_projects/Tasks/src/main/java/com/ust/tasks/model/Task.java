package com.ust.tasks.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    private int id;
    private String name;
    private String description;
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Status completed;
    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;
}
