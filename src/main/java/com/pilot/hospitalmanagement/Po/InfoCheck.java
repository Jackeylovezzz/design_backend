package com.pilot.hospitalmanagement.Po;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class InfoCheck {
    User patient;
    Doc doc;
    User doctor;
    // Prescription prescription;
    // List<PrescriptionItem> prescriptionItems;
    List<Medicine> medicines;
    List<MedicalTest> allMedicalTests;
}