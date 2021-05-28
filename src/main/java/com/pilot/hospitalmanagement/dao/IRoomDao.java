package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Room;

import java.util.List;

public interface IRoomDao {

    // 新增科室
    int insert(Room record);
    Room findByRid(String rID);

    // 删除科室
    int deleteByrID(String rID);

    // 更新科室
    int update(Room record);

    // genju
    Room selectByID(String ID);

    // 查询已有的所有课室
    List<Room> findAll();

}
