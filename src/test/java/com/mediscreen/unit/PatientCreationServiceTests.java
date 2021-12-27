package com.mediscreen.unit;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import com.mediscreen.service.PatientCreationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PatientCreationServiceTests {

    @Autowired
    PatientCreationService patientCreationService;
    @Autowired
    PatientRepository patientRepository;

    @Test
    public void shouldCreatePatient() {

        Patient patient = new Patient();
        patient.setFirstName("Harry");
        patient.setLastName("Potter");
        patient.setGender("M");
        patient.setBirthDate(LocalDate.now().minusYears(12));
        patient.setAddress("4, Privet Drive, Little Whinging");
        patient.setPhone("791-112-3456");
        patient = patientCreationService.createPatient(patient);
        Patient actualPatient = patientRepository.findById(patient.getPatientId()).get();

        assertTrue(patient.equals(actualPatient));
    }
}
