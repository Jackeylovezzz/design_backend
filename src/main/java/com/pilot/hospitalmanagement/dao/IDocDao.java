package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Doc;

import java.util.List;

public interface IDocDao {

    // 新建病历
    int insert(Doc record);

    // 按病历ID删除病历
    int deleteBydocID(String docID);

    // 查询所有病历
    List<Doc> findAll();

    // 按病历ID查询病历
    Doc selectBydocID(String docID);

    // 按照病人ID查询其所有病历
    List<Doc> selectBypID(String pID);

    // 修改病历
    int updateBydocID(Doc record);

    int setPreID(String pID, String docID);

}
