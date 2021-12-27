package com.mediscreen.service;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PatientCreationService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {

        return patientRepository.save(patient);
    }

    public Collection<Patient> createPatients(Collection<Patient> patients) {

        return patientRepository.saveAll(patients);
    }
}
