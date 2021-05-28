package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Bill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class IBillDaoTest {
    @Autowired
    IBillDao iBillDao;

    @Test
    void context()
    {
        Date date = new Date(2020,12,12);
        Bill bill = new Bill("123","20174213","20174291",20,date,"asd");
        iBillDao.insert(bill);

        System.out.println(iBillDao.selectBybID("123"));
        System.out.println(iBillDao.selectBydocID("20174291"));
    }
}
