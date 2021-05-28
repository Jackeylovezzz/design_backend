package com.pilot.hospitalmanagement.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class IAdministratorDaoTest {
    @Autowired
    IAdministratorDao iAdministratorDao;

    @Test
    void context()
    {
        System.out.println(iAdministratorDao.selectByadminID("20174291"));
    }
}
