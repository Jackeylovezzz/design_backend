package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.Po.Cashier;

import java.util.List;

public interface ICashierDao {

    void insert (Cashier record);      //添加配药师

    int deleteBycasID(String casID);  //按ID删除配药师

    int update(Cashier record); //更新配药师

    //按配药师ID 查询配药师
    Cashier selectBycasID(String casID); //按逐渐查询配药师

    //查询所有配药师
    List<Cashier> findAll();
}
