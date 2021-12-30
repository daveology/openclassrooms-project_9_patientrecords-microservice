package com.mediscreen.service;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import com.mediscreen.service.PatientDeletionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PatientDeletionServiceTests {

    @Autowired
    private PatientDeletionService patientDeletionService;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void shouldDeletePatient() {

        Patient patient = patientRepository.save(new Patient("None", "Harry POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456"));
        patientDeletionService.deletePatientById(patient.getPatientId());

        assertFalse(patientRepository.findById(patient.getPatientId()).isPresent());
    }

    @Test
    public void shouldDeletePatientList() {

        Patient patient = patientRepository.save(new Patient("None", "Harry POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456"));
        patientDeletionService.deletePatientList();

        assertTrue(patientRepository.findAll().size() == 0);
    }
}
