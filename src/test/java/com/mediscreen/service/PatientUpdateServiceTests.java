package com.mediscreen.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import com.mediscreen.service.PatientUpdateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PatientUpdateServiceTests {

    @Autowired
    private PatientUpdateService patientUpdateService;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void shouldUpdatePatient() {

        Patient patient = patientRepository.save(new Patient("Harry", "POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456"));
        patient.setFirstName("Dudley");
        patient.setLastName("DURSLEY");
        Patient actualPatient = patientUpdateService.updatePatient(patient);

        assertTrue(patient.equals(actualPatient));
    }

    @Test
    public void shouldReturnEmptyPatient() {

        Patient patient = patientRepository.save(new Patient("Harry", "POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456"));
        patient.setPatientId(51611L);
        Patient actualPatient = patientUpdateService.updatePatient(patient);

        assertTrue(actualPatient.equals(new Patient()));
    }
}
