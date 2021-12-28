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

        Patient updatedPatient;
        Optional<Patient> optionalUser = patientRepository.findById(patient.getPatientId());

        if (optionalUser.isPresent()) {
            updatedPatient = optionalUser.get();
            patientRepository.save(updatedPatient);
        } else {
            return new Patient();
        }

        return updatedPatient;
    }
}
