package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.Po.Doctor;
import com.pilot.hospitalmanagement.Po.Room;
import com.pilot.hospitalmanagement.dao.IAppointmentDao;
import com.pilot.hospitalmanagement.dao.IAppointmentDao;
import com.pilot.hospitalmanagement.dao.IDocDao;
import com.pilot.hospitalmanagement.dao.IDoctorDao;
import com.pilot.hospitalmanagement.dao.IPatientDao;
import com.pilot.hospitalmanagement.dao.IRoomDao;
import com.pilot.hospitalmanagement.dao.IUserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Paul
 * @date 2021/1/5 19:45
 * @description
 */
@Service
public class AppointServiceImpl {
    @Autowired
    IAppointmentDao iAppointmentDAO;
    @Autowired
    IRoomDao iRoomDao;
    @Autowired
    IDoctorDao iDoctorDao;

    public int addAppointment(Appointment appointment) {
        String aid = UUID.randomUUID().toString().replaceAll("-", "");
        appointment.setAID(aid);
        appointment.setAStatus("待排队");

        appointment.setACreateTime(new Date());
        if ("expert".equals(appointment.getAType())) {
            return iAppointmentDAO.insert_doctor(appointment);
        } else {
            return iAppointmentDAO.insert_room(appointment);
        }

    }

    public int deleteAppointmentById(String appointmentId) {
        return iAppointmentDAO.deleteByaID(appointmentId);

    }

    public Appointment findAppointmentByAppointId(String appointmentId) {
        return iAppointmentDAO.selectByaID(appointmentId);
    }

    public List<Room> getAllDept() {

        return iRoomDao.findAll();

    }

    public Appointment findMyAppointment(String UserID) {
        return iAppointmentDAO.selectBypID(UserID).get(0);
    }

    public Map<String, String> findAppointmentByUserId(String userId) {
        List<Appointment> appointments = iAppointmentDAO.selectBypID(userId);
        Map<String, String> res = new HashMap<>();
        ;
        for (Appointment appointment : appointments) {
            if ("待排队".equals(appointment.getAStatus())) {
                System.out.println(appointment.toString());
                if ("expert".equals(appointment.getAType())) {
                    res.put("expert", iDoctorDao.selectByPrimaryID(appointment.getDID()).getUserName());
                    res.put("type", appointment.getAType());

                } else {
                    res.put("dept", iRoomDao.findByRid(appointment.getRID()).getRName());
                    res.put("type", appointment.getAType());

                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                res.put("date", (sdf.format(appointment.getATime())));

            }
        }

        return res;
    }

    public List<Doctor> getAllExpertByDept(String deptId) {
        return iDoctorDao.selectByrID(deptId);
    }

    public List<Appointment> findAppointmentByDoctorId(String doctorId, String date) throws ParseException {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        return iAppointmentDAO.selectBydID(doctorId, fmt.parse(date));
    }

    public List<Appointment> findAppointmentByDeptId(String deptId, String date) throws ParseException {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return iAppointmentDAO.selectByrID(deptId, fmt.parse(date));
    }

    public int changeStatus(String id, String status) {
        return iAppointmentDAO.updateaStatus(id, status);
    }

    public int changeAppointmentTime(String id, String type, String appointTime) {
        if ("expert".equals(type)) {
            Doctor doctor = iDoctorDao.selectByPrimaryID(id);
            doctor.setDAppointmentTime(appointTime);
            return iDoctorDao.updateAppointmentTime(doctor);
        } else {
            Room room = iRoomDao.selectByID(id);
            room.setRAppointmentTime(appointTime);
            return iRoomDao.update(room);
        }
    }

    public int changeAppointmentLimit(String id, String type, int limit) {
        Doctor doctor = iDoctorDao.selectByPrimaryID(id);
        doctor.setDAppointmentLimit(limit);
        return iDoctorDao.updateAppointmentLimit(doctor);
    }
}
