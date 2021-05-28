package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.MedicalTests;

public interface IMedicalTestsDao {
    //创建检查单
    int insert(MedicalTests medicalTests);



    //根据检查单ID查找
    MedicalTests selectBycID(String cID);

    //根据病历ID查找检查单
    MedicalTests selectBydocID(String docID);


}
