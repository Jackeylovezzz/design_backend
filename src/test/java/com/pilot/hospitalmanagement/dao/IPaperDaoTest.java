package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Paper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class IPaperDaoTest {
    @Autowired
    IPaperDao iPaperDao;

    @Test
    void Context()
    {
        Paper paper1 = new Paper("0012","20174303","20174291","104","母猪的产后护理","啦啦啦","黄伟业","0","建议重写","正在查重","123");
//        Date date1 = new Date(2020,11,11,10,24,11);
//        Date date2 = new Date(2020,12,11,22,23,21);
//        Doc record = new Doc("123asddfg","20174303",null,null,null,"怕死",date1,date2,"未完成");
        Paper paper2 = new Paper("0012","20174303","20174291","104","母猪的产后护理2","啦啦啦","黄伟业","0","建议重写","正在查重","123");
//
//        iPaperDao.insert(paper1);
//        iDocDao.deleteBydocID("123asddfg");
//        System.out.println(iPaperDao.selectBypaperID("0012"));
//        System.out.println(iPaperDao.selectByrID("104"));
//        System.out.println(iPaperDao.selectBydID("20174291"));


        iPaperDao.updatepaper(paper2);
        System.out.println(iPaperDao.selectBypaperID("0012"));




//


    }
}
