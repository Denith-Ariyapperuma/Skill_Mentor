package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class SubjectDTO {

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 50 characters" )
    private String subjectName;

    @Size(max = 100, message = "Description must not exceed 100 characters")
    private String description;

    private Date createdAt;

    private Date updatedAt;

}
