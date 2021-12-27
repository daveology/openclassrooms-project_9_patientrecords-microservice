package com.mediscreen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @NotBlank(message = "Veuillez renseigner votre prénom.")
    @Size(max=100)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Veuillez renseigner votre nom de famille.")
    @Size(max=100)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Veuillez renseigner votre sexe.")
    @Size(max=1)
    @Column(name = "gender")
    private String gender;

    @NotBlank(message = "Veuillez renseigner votre date de naissance.")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotBlank(message = "Veuillez renseigner votre adresse postale.")
    @Size(max=200)
    @Column(name = "address")
    private String address;

    @NotBlank(message = "Veuillez renseigner votre numéro de téléphone.")
    @Size(max=12)
    @Column(name = "phone")
    private String phone;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Patient() {}

    public Patient(Long patientId, String firstName, String lastName, String gender,
                   LocalDate birthDate, String address, String phone) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
    }
}
