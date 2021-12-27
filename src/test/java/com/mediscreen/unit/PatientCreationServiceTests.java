package com.mediscreen.unit;

import com.mediscreen.service.PatientCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientCreationServiceTests {

    @Autowired
    PatientCreationService patientCreationService;
}
