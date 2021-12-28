package com.mediscreen.controller;

import com.mediscreen.model.Patient;
import com.mediscreen.service.PatientCreationService;
import com.mediscreen.service.PatientReadService;
import com.mediscreen.service.PatientUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PatientController {

    @Autowired
    PatientCreationService patientCreationService;
    @Autowired
    PatientReadService patientReadService;
    @Autowired
    PatientUpdateService patientUpdateService;

    @PostMapping("/patient/add")
    public Patient addPatient(@RequestBody Patient patient) {

        return patientCreationService.createPatient(patient);
    }

    @PostMapping("/patientList/add")
    public Collection<Patient> addPatientList(@RequestBody Collection<Patient> patientList) {

        return patientCreationService.createPatientList(patientList);
    }

    @GetMapping("/patient/{patientId}")
    public Patient readPatientById(@PathVariable Long patientId) {

        return patientReadService.readPatientById(patientId);
    }

    @GetMapping("/patientList")
    public Collection<Patient> readPatientList() {

        return patientReadService.readPatientList();
    }
}
