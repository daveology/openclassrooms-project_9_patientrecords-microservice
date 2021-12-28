package com.mediscreen.service;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientUpdateService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient updatePatient(Patient patient) {

        Optional<Patient> optionalPatient =
                patientRepository.findById(patient.getPatientId());
        if (!optionalPatient.isPresent()) {
            return new Patient();
        }

        return patientRepository.save(patient);
    }
}
