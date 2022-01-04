package com.mediscreen.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @NotBlank(message = "Veuillez renseigner le niveau de risque.")
    @Size(max=100)
    @Column(name = "risk_level")
    private String riskLevel;

    @NotBlank(message = "Veuillez renseigner le nom complet.")
    @Size(max=100)
    @Column(name = "full_name")
    private String fullName;

    @NotBlank(message = "Veuillez renseigner le sexe.")
    @Size(max=1)
    @Column(name = "gender")
    private String gender;

    @NotNull(message = "Veuillez renseigner le date de naissance.")
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotBlank(message = "Veuillez renseigner le adresse postale.")
    @Size(max=200)
    @Column(name = "address")
    private String address;

    @NotBlank(message = "Veuillez renseigner le numéro de téléphone.")
    @Size(max=12)
    @Column(name = "phone")
    private String phone;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getRiskLevel() { return riskLevel; }

    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName) {
        this.fullName = firstName;
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

    public Patient(String riskLevel, String fullName, String gender,
                   LocalDate birthDate, String address, String phone) {
        this.riskLevel = riskLevel;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId) && Objects.equals(riskLevel, patient.riskLevel)
                && Objects.equals(fullName, patient.fullName) && Objects.equals(gender, patient.gender)
                && Objects.equals(birthDate, patient.birthDate) && Objects.equals(address, patient.address)
                && Objects.equals(phone, patient.phone);
    }
}
