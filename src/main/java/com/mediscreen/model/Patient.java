package com.mediscreen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long patientId;

    @NotBlank(message = "Username is mandatory")
    @Size(max=100)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Username is mandatory")
    @Size(max=100)
    @Column(name = "last_name")
    private String lastName;
}
