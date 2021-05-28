package com.pilot.hospitalmanagement.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IMedicalTestDaoTest {
    @Autowired
    IMedicalTestDao iMedicalTestDao;

    @Test
    void context()
    {
        System.out.println(iMedicalTestDao.selectByrID("105"));
        System.out.println(iMedicalTestDao.selectBytestID("001"));
        System.out.println(iMedicalTestDao.selectBytestName("核磁共振"));
    }
}
