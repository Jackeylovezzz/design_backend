package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Patient;
import com.pilot.hospitalmanagement.Po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class IPatientDaoTest {
    @Autowired
    IPatientDao iPatientDao;

    @Test
    void context(){

//        String s = iPatientDao.selectCodeByPrimaryKey("20174303");
//        System.out.print(s);
//        Date date = new Date(2020,12,12);
//        Patient patient =new Patient("20174303","234234456","黄伟业","男",date,"123123","黄土高坡","四次元",true);
////        iPatientDao.insert(patient);
//        iPatientDao.updateByPrimaryKeySelective(patient);

        System.out.println(iPatientDao.selectByPrimaryKey("20174304"));
    }
}
