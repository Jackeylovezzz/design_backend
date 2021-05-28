package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.MedicalTest;

import java.util.List;

public interface IMedicalTestDao {

    // 按项目ID查询
    MedicalTest selectBytestID(String testID);

    // 按项目名查询
    MedicalTest selectBytestName(String testName);

    // 按科室ID查询
    List<MedicalTest> selectByrID(String rID);

    // all
    List<MedicalTest> findAll();

    // 模糊查询
    List<MedicalTest> searchByKey(String key);

}
