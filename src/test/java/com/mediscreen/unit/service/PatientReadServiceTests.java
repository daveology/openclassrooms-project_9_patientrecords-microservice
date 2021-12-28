package com.mediscreen.unit.service;

import com.mediscreen.repository.PatientRepository;
import com.mediscreen.service.PatientCreationService;
import com.mediscreen.service.PatientReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientReadServiceTests {

    @Autowired
    PatientReadService patientReadService;
    @Autowired
    PatientRepository patientRepository;
}
