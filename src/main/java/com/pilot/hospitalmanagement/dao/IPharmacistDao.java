package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.Po.Pharmacist;

import java.util.List;

public interface IPharmacistDao {


    void insert (Pharmacist record);      //添加配药师
    int deleteByphaID(String phaID);  //按ID删除配药师

    int update(Pharmacist record); //更新配药师

    //按配药师ID 查询配药师
    Pharmacist selectByphaID(String phaID); //按逐渐查询配药师

    //查询所有配药师
    List<Pharmacist> findAll();
}
