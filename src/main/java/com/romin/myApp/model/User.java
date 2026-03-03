package com.romin.myApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates Getters/Setters
@NoArgsConstructor // Required for Jackson (JSON)
@AllArgsConstructor // For easy creation
@Entity
@Table(name = "Users")
public class User {

    @Id // This makes 'id' the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Database will auto-increment the ID
    private Long id;

    private String email;

    private String name;

    private Double contactNo;
    
}
