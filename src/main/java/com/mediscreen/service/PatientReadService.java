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

        logger.debug("[SERVICE] read Patient by ID=" + patientId);
        Patient patient = patientRepository.getById(patientId);
        logger.debug("[SERVICE] Patient " + "(ID " + patientId + ") result=" + patient);

        return patient;
    }

    public Collection<Patient> readPatientList() {

        logger.debug("[SERVICE] read PatientList");
        Collection<Patient> patientList = patientRepository.findAll();
        logger.debug("[SERVICE] PatientList result=" + patientList);

        return patientList;
    }
}
