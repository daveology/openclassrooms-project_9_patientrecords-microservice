package com.mediscreen.controller;

import com.mediscreen.model.Patient;
import com.mediscreen.service.PatientCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    PatientCreationService patientCreationService;

    @PostMapping("/patient/add")
    public Patient addPatient(@RequestBody Patient patient) {

        return patientCreationService.createPatient(patient);
    }
}
