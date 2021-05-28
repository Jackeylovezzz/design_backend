package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Medicine;

import java.util.List;

public interface IMedicineDao {
    // 增添药品
    int insert(Medicine record);

    // 按照药品ID删除药品
    int deleteBymID(String mID);

    // 更改药品
    int update(Medicine record);

    // 按照药品ID找到药品
    Medicine selectBymID(String mID);

    // 查询所有药品
    List<Medicine> findAll();

    // 根据药品名称查询药品
    List<Medicine> selectBymName(String mName);

    // 根据药品类型查询药品
    List<Medicine> selectBymSpecs(String mSpecs);

    // 根据生产厂家查询药品
    List<Medicine> selectBymFactory(String mFactory);

    // 模糊查询
    List<Medicine> selectByKeyWord(String Key);
}
