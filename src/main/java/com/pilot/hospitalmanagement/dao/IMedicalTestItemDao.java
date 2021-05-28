package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.MedicalTestItem;

import java.util.List;

public interface IMedicalTestItemDao {
    //新增一个检查条目
    int insert(MedicalTestItem record);

    //按检查单ID查询
    List<MedicalTestItem> selectBycID(String cID);

    //按检查项目ID查询
    List<MedicalTestItem> selectBytestID(String testID);
    //二者确定一个
    MedicalTestItem selectByBoth(String cID,String testID);

}
