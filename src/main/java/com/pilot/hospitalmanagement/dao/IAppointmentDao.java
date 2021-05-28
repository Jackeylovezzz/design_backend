package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Appointment;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface IAppointmentDao {
    // 新建专家预约
    int insert_doctor(Appointment record);

    // 新建科室预约
    int insert_room(Appointment record);

    // 取消预约
    int deleteByaID(String aid);

    // 修改预约状态
    int updateaStatus(String aID, String aStatus);

    // 查看某科室当前排队人数
    List<Appointment> CountByrID(String rID); // 并没有进行时间上的比较

    // 查看某专家当前排队人数
    List<Appointment> CountBydID(String dID); // 同上

    // 按病人ID查询预约 当前的
    List<Appointment> selectBypID(String pID);

    // 查看某专家某天的预约
    List<Appointment> selectBydID(String dID, Date aTime); // 医生ID, 1~5

    // 查看某科室当前预约的预约
    List<Appointment> selectByrID(String rID, Date aTime);// 同上

    // 按预约ID查询预约
    Appointment selectByaID(String aID);

    // List<Appointment> selectValidAppBydID(String dID);
}
