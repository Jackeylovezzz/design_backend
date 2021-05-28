package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Prescription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class IPrescriptionDaoTest {
    @Autowired
    IPrescriptionDao iPrescriptionDao;

    @Test
    void context()
    {
//        Date date = new Date(2017,12,21);
//        Prescription prescription = new Prescription("001","20174292",date);
//
//        iPrescriptionDao.update(prescription);

        System.out.println(iPrescriptionDao.selectBydocID("20174292"));
        System.out.println(iPrescriptionDao.selectBypreID("001"));
    }
}
