package com.mediscreen.service;

import com.mediscreen.model.Patient;
import com.mediscreen.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PatientReadService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PatientRepository patientRepository;

    public Patient readPatientById(Long patientId) {

        return patientRepository.getById(patientId);
    }

    public Collection<Patient> readPatientList() {

        return patientRepository.findAll();
    }
}
