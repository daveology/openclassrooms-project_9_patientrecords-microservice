package com.mediscreen.unit;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void patientTest() {

        Patient patient = new Patient();
        patient.setFirstName("Harry");
        patient.setLastName("Potter");
        patient.setGender("M");
        patient.setBirthDate(LocalDate.now().minusYears(12));
        patient.setAddress("4, Privet Drive, Little Whinging");
        patient.setPhone("791-112-3456");

        /**
         * Create
         */
        patient = patientRepository.save(patient);
        assertEquals("Harry", patient.getFirstName());
    }
}
