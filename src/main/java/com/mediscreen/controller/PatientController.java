package com.mediscreen.controller;

import com.mediscreen.service.PatientCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    PatientCreationService patientCreationService;
}
