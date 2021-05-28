package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Doctor;
import com.pilot.hospitalmanagement.Po.Patient;
import com.pilot.hospitalmanagement.Po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class IDoctorTest {
    @Autowired
    IDoctorDao iDoctorDao;

    @Test
    void context()
    {
//        Date date = new Date(2012,12,23);
//        Doctor doctor =new Doctor("20174312","123123","leizasdqiang","男",date,"123123","106",true,"可预约","10101",23);
//        iDoctorDao.insert(doctor);
////        Doctor doctor = iDoctorDao.selectByPrimaryID("20174292");
////        System.out.print(doctor.getUserID());
//        System.out.println(iDoctorDao.selectByrID("105"));



    }
}
