package com.pilot.hospitalmanagement.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IAppointmentDaoTest {
    @Autowired
    IAppointmentDao iAppointmentDAO;

    @Test
    void context()
    {
//        Date date = new Date(2012,2,12);
//        Appointment appointment = new Appointment("a65465","20174291","20174307","103","未完成",date,2,"0",true);
//        iAppointmentDAO.insert_doctor(appointment);
//        iAppointmentDAO.insert_room(appointment);

//        iAppointmentDAO.deleteByaID("a65465");

//        System.out.println(iAppointmentDAO.CountBydID("20174291"));
//        System.out.println(iAppointmentDAO.CountByrID("103"));
//
//        System.out.println(iAppointmentDAO.selectBypID("20174303"));
//
//        System.out.println(iAppointmentDAO.selectBydID("20174291",2));
//        System.out.println(iAppointmentDAO.selectByrID("103",2));
        System.out.println(iAppointmentDAO.selectBypID("20174303"));
        System.out.println(iAppointmentDAO.selectByaID("123123"));

    }
}
