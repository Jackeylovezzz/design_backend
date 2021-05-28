package com.pilot.hospitalmanagement.service;

import java.util.List;

import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.Po.User;

/**
 * @author Paul
 * @date 2021/1/7 2:46
 * @description
 */
public interface TriageService {
    List<User> getCurrQueue(String id, String type);

    int getOwnNumber(String appointId);

    boolean executeTriage(String appointId);
}
