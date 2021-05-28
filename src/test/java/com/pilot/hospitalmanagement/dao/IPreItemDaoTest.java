package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.PrescriptionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IPreItemDaoTest {
    @Autowired
    IPreItemDao iPreItemDao;

    @Test
    void context()
    {
        PrescriptionItem prescriptionItem = new PrescriptionItem("001","002",52,"多吃","少吃会死",true,"lalal");
        iPreItemDao.insert(prescriptionItem);

        System.out.println(iPreItemDao.selectBypreID("001"));
        System.out.println(iPreItemDao.selectBymID("002"));
    }
}
