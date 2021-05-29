package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Doctor;

import java.util.List;

public interface IDoctorDao {

    // 添加医生
    void insert(Doctor record);

    //获取所有医生
    List<Doctor> findAll();

    // 按ID查询医生
    Doctor selectByPrimaryID(String dID);

    // 查询某科室的所有医生
    List<Doctor> selectByrID(String rID);

    // 更新医师的预约时间
    int updateAppointmentTime(Doctor doctor);

    int updateAppointmentLimit(Doctor doctor);
}
