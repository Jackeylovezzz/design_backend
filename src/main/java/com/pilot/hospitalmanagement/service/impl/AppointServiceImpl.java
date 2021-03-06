package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.Po.Doctor;
import com.pilot.hospitalmanagement.Po.Paper;
import com.pilot.hospitalmanagement.Po.Room;
import com.pilot.hospitalmanagement.dao.IAppointmentDao;
import com.pilot.hospitalmanagement.dao.IPaperDao;
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
import java.util.Random;

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

    @Autowired
    IPaperDao iPaperDao;

    public int addAppointment(Appointment appointment) {
        String aid = UUID.randomUUID().toString().replaceAll("-", "");
        appointment.setAID(aid);
        appointment.setAStatus("εΎζι");
        appointment.setACreateTime(new Date());
        return iAppointmentDAO.insert_room(appointment);

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

    public Appointment findAppointmentByUserId(String userId) {
        List<Appointment> appointments = iAppointmentDAO.selectBypID(userId);
        // Map<String, String> res = new HashMap<>();
        // ;
        // for (Appointment appointment : appointments) {
        // if ("εΎζι".equals(appointment.getAStatus())) {
        // System.out.println(appointment.toString());
        // if ("expert".equals(appointment.getAType())) {
        // res.put("expert",
        // iDoctorDao.selectByPrimaryID(appointment.getDID()).getUserName());
        // res.put("type", appointment.getAType());

        // } else {
        // res.put("dept", iRoomDao.findByRid(appointment.getRID()).getRName());
        // res.put("type", appointment.getAType());

        // }
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // res.put("date", (sdf.format(appointment.getATime())));

        // }
        // }

        return appointments.get(0);
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

    public Room getOneDept(String rID) {
        return iRoomDao.findByRid(rID);
    }

    public List<Paper> getAllPaperUnderDept(String rID) {
        // return iRoomDao.findByRid(rID);
        // θΏεη¬¦εζ‘δ»Άηζη« εθ‘¨
        return iPaperDao.selectByrID(rID);
    }

    public int addPaper(Paper paper) {
        String paperid = UUID.randomUUID().toString().replaceAll("-", "");
        paper.setPaperID(paperid);
        paper.setPaperState("εΎθ―ε?‘");

        List<Doctor> doctorList = iDoctorDao.findAll();
        Random r = new Random();
        int idx = r.nextInt(doctorList.size());
        paper.setDID(doctorList.get(idx).getUserID());

        return iPaperDao.insert(paper);
    }

    public int addComment(String comment, String paperId, String score) {
        Paper paper = iPaperDao.selectBypaperID(paperId);
        paper.setPaperAdvice(comment);
        paper.setPaperScore(score);
        paper.setPaperState("ε·²θ―ε?‘");
        return iPaperDao.updatepaper(paper);
    }

    public int addMeeting(Room room) {
        String roomID = UUID.randomUUID().toString().replaceAll("-", "");
        room.setRID(roomID);
        return iRoomDao.insert(room);
    }
}
