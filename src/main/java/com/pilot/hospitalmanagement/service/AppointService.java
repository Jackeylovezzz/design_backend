package com.pilot.hospitalmanagement.service;

import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.Po.Doctor;
import com.pilot.hospitalmanagement.Po.Room;

import java.util.List;
import java.util.Map;

/**
 * @author Paul
 * @date 2021/1/6 1:34
 * @description
 */
public interface AppointService {
    int addAppointment(Appointment appointment);

    int deleteAppointmentById(String appointmentId);

    Appointment findAppointmentByAppointId(String appointmentId);

    List<Room> getAllDept();

    Map<String, String> findAppointmentByUserId(String userId);

    List<Doctor> getAllExpertByDept(String deptId);

    Appointment findAppointmentByDoctorId(String doctorId);

    int changeStatus(String id);

    int changeAppointmentTime(String id, String type, String appointTime);

}
