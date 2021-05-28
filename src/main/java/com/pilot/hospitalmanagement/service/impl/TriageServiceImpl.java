package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.dao.IAppointmentDao;
import com.pilot.hospitalmanagement.dao.IPatientDao;
import com.pilot.hospitalmanagement.service.AppointService;
import com.pilot.hospitalmanagement.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Paul
 * @date 2021/1/6 0:58
 * @description
 */
@Service
public class TriageServiceImpl implements TriageService {
    @Autowired
    IAppointmentDao iAppointmentDAO;

    @Autowired
    IPatientDao ipatientDao;

    @Override
    public List<User> getCurrQueue(String id, String type) {
        List<Appointment> appointmentUserList = new ArrayList<Appointment>();
        if ("expert".equals(type)) {
            appointmentUserList = iAppointmentDAO.CountBydID(id); // 获取有效的预约列表
        } else {
            appointmentUserList = iAppointmentDAO.CountByrID(id);
        }
        List<User> allQueueuser = new ArrayList<>();
        for (Appointment appointment : appointmentUserList) {
            allQueueuser.add(ipatientDao.selectByPrimaryKey(appointment.getPID()));
        }
        return allQueueuser;
    }

    @Override
    public int getOwnNumber(String appointId) {
        Appointment appointment = iAppointmentDAO.selectByaID(appointId);
        String atype = appointment.getAType();
        String queryId = appointment.getDID(); // 默认医师
        if ("dept".equals(atype)) {
            queryId = appointment.getRID();
        }
        List<User> allUser = getCurrQueue(queryId, atype);
        int index = 0;
        for (User u : allUser) {
            if (u.getUserID().equals(appointment.getPID())) {
                return index;
            }
            index++;
        }
        return -1;// 没查到
    }

    @Override
    public boolean executeTriage(String appointId) {
        int affectrows = iAppointmentDAO.updateaStatus(appointId, "已完成");
        if (affectrows > 0) {
            return true;
        }
        return false;
    }
}
