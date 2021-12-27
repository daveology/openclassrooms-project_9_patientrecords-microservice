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
        Patient retrievedPatient = patientRepository.save(patient);
        patient.setPatientId(retrievedPatient.getPatientId());
        assertEquals("Harry", retrievedPatient.getFirstName());
        assertEquals("Potter", retrievedPatient.getLastName());
        assertEquals("M", retrievedPatient.getGender());
        assertEquals(LocalDate.now().minusYears(12), retrievedPatient.getBirthDate());
        assertEquals("4, Privet Drive, Little Whinging", retrievedPatient.getAddress());

        /**
         * Read
         */

        Patient newPatient = new Patient("Harry", "Potter", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456");
        patientRepository.save(newPatient);
        List<Patient> listResult = patientRepository.findAll();
        assertTrue(listResult.size() > 0);

        /**
         * Update
         */
        patient.setPhone("791-224-2487");
        patient = patientRepository.save(patient);
        assertEquals("791-224-2487", patient.getPhone());

        /**
         * Delete
         */
        patientRepository.delete(patient);
        Optional<Patient> patientList = patientRepository.findById(patient.getPatientId());
        assertFalse(patientList.isPresent());
    }
}
