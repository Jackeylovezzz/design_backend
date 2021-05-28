package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.MedicalTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class IMedicalTestsDaoTest {
    @Autowired
    IMedicalTestsDao iMedicalTestsDao;

    @Test
    void context()
    {
        Date date = new Date(2012,12,12);
        MedicalTests medicalTests = new MedicalTests("12345","20174291","rinige",date);
        iMedicalTestsDao.insert(medicalTests);

        System.out.println(iMedicalTestsDao.selectBycID("12345"));
        System.out.println(iMedicalTestsDao.selectBydocID("20174291"));
    }
}
