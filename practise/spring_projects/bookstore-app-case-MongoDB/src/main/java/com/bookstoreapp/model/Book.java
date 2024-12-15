package com.bookstoreapp.model;

import jakarta.validation.constraints.*;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private int id;
    // The title should not be empty and should not exceed 100 characters
    @NotBlank
    @Size(max = 100,message = "Validation failed")
    private String title;

    // The author should not be empty and should not exceed 200 characters

    @NotBlank
    @Size(max = 200,message = "Validation failed")
    private String author;

    // The publication year should be a valid year
    @Min(1500)
    @Max(value = 2500, message = "Validation failed")
    private int publicationYear;

    // The ISBN should be a valid 10- or 13-digit number.
//    @Pattern(regexp = "\\d{10}\\d{13}")
    @Positive
    private long isbn;

    // The price should be a positive decimal value.
    @Positive(message = "Validation failed")
    private double price;

}
