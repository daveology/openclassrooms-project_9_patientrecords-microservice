package com.mediscreen.controller;

import com.mediscreen.model.Patient;
import com.mediscreen.service.PatientCreationService;
import com.mediscreen.service.PatientReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PatientController {

    @Autowired
    PatientCreationService patientCreationService;
    @Autowired
    PatientReadService patientReadService;

    @PostMapping("/patient/add")
    public Patient addPatient(@RequestBody Patient patient) {

        return patientCreationService.createPatient(patient);
    }

    @PostMapping("/patientList/add")
    public Collection<Patient> addPatientList(@RequestBody Collection<Patient> patientList) {

        return patientCreationService.createPatientList(patientList);
    }
}
