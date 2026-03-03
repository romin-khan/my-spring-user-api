package com.romin.myApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates Getters/Setters
@NoArgsConstructor // Required for Jackson (JSON)
@AllArgsConstructor // For easy creation
public class User {
    private Long id;
    private String email;
    private String name;
    private Double contactNo;
}
