package com.mediscreen.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
public class PatientControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreatePatient() throws Exception {

        Patient patient = new Patient("Harry", "POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456");

        mockMvc.perform(post("/patient/add")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(patient))
                ).andExpect(status().isOk());
    }

    @Test
    public void shouldCreatePatientList() throws Exception {

        Collection<Patient> patientList = new ArrayList<>();
        Patient firstPatient = new Patient("Harry", "POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456");
        patientList.add(firstPatient);
        Patient secondPatient = new Patient("Ron", "WEASLEY", "M", LocalDate.now().minusYears(12),
                "The Borrow, Ottery St. Catchpole", "791-145-6752");
        patientList.add(secondPatient);
        Patient thirdPatient = new Patient("Hermione", "GRANGER", "F", LocalDate.now().minusYears(12),
                "8 Heathgate, Hampstead Garden Suburb, London", "791-963-4175");
        patientList.add(thirdPatient);

        mockMvc.perform(post("/patientList/add")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(patientList))
        ).andExpect(status().isOk());
    }
}
