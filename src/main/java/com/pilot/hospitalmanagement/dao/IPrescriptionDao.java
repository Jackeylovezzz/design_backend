package com.pilot.hospitalmanagement.dao;

import java.util.List;

import com.pilot.hospitalmanagement.Po.Prescription;

public interface IPrescriptionDao {
    // 新建处方
    int insert(Prescription record);

    // 删除处方
    int deleteBypreID(String preID);

    // 更新处方
    int update(Prescription record);

    // 按处方ID查找处方
    Prescription selectBypreID(String preID);

    // 按照病历ID查找处方
    Prescription selectBydocID(String docID);

    // 获取所有代培要的处方
    List<Prescription> findAllPresNeedProcess();
}
