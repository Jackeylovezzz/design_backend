package com.pilot.hospitalmanagement.service;

import com.pilot.hospitalmanagement.Po.Patient;
import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.utils.Resbody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Paul
 * @date 2021/1/5 10:18
 * @description
 */
public interface PatientService {
    Patient loadPatientById(String patientId);
    int  register(Patient patient);
    int modify(Patient patient);

}
