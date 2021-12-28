package com.mediscreen.service;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientReadService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient readPatientById(Long patientId) {

        return patientRepository.getById(patientId);
    }
}
