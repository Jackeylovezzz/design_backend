package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IRoomDaoTest {
    @Autowired
    IRoomDao iRoomDao;

    @Test
    void context()
    {
//        Room room = new Room("106","泌尿科","大铁棍子医院铜柱任","10101");
//        iRoomDao.insert(room);
//        iRoomDao.deleteByrID("103");
        System.out.println(iRoomDao.findAll());

    }
}
