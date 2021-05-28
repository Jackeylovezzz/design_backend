package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.MedicalTestItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IMedicalTestItemDaoTest {
    @Autowired
    IMedicalTestItemDao iMedicalTestItemDao;

    @Test
    void context(){
        MedicalTestItem medicalTestItem1 = new MedicalTestItem("12345","001");
        MedicalTestItem medicalTestItem2 = new MedicalTestItem("12345","002");

        iMedicalTestItemDao.insert(medicalTestItem1);
        iMedicalTestItemDao.insert(medicalTestItem2);

        System.out.println(iMedicalTestItemDao.selectBycID("12345"));
        System.out.println(iMedicalTestItemDao.selectBytestID("001"));
        System.out.println(iMedicalTestItemDao.selectByBoth("12345","001"));

    }
}
