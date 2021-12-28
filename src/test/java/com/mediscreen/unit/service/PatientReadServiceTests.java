package com.mediscreen.unit.service;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import com.mediscreen.service.PatientReadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientReadServiceTests {

    @Autowired
    PatientReadService patientReadService;
    @Autowired
    PatientRepository patientRepository;

    @Test
    public void shouldGetPatientById() {

        Patient patient = patientRepository.save(new Patient("Ron", "WEASLEY", "M", LocalDate.now().minusYears(12),
                "The Borrow, Ottery St. Catchpole", "791-145-6752"));
        Long patientId = patient.getPatientId();
        Patient actualPatient = patientReadService.readPatientById(patientId);

        assertEquals(patient, actualPatient);
    }
}
