package com.pilot.hospitalmanagement.dao;


import com.pilot.hospitalmanagement.Po.Patient;

public interface IPatientDao {
    int deleteByPrimaryKey(String pID);

    int insert (Patient record);

    Patient selectByPrimaryKey(String pID);

    String selectCodeByPrimaryKey(String pID);



    int updateByPrimaryKeySelective(Patient record);
}
