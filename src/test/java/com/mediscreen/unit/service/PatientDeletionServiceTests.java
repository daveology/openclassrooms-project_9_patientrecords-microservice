package com.mediscreen.unit.service;

import com.mediscreen.service.PatientDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientDeletionServiceTests {

    @Autowired
    private PatientDeletionService patientDeletionService;
}
