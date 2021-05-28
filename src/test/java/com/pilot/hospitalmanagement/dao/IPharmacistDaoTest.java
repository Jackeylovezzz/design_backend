package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Pharmacist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.Date;

@SpringBootTest
public class IPharmacistDaoTest {
    @Autowired
    IPharmacistDao ipharmacistDao;

    @Test
    void Context()
    {
//        Date date = new Date(1999,6,1);
////
//        Pharmacist pharmacist = new Pharmacist("20174313","weiasdasde","黄维耶","男",date,"5425025045");
//        ipharmacistDao.insert(pharmacist);
//
////        Pharmacist pharmacist1 = new Pharmacist("20174413","weiasdasde","黄维耶","男",date,"5425025045");
////        ipharmacistDao.insert(pharmacist1);
//
//        Pharmacist pharmacist2 = new Pharmacist("20174413","weiasdaasdasdasdasd","黄维耶","男",date,"5425025045");
//        ipharmacistDao.update(pharmacist2);
//
//        ipharmacistDao.deleteByphaID("20174313");
//
//        System.out.println(ipharmacistDao.findAll().get(0).getUserID());
//        System.out.println(ipharmacistDao.selectByphaID("20174213").getUserID());
    }

}
