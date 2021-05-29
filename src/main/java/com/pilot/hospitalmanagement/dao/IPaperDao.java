package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Paper;

import java.util.List;

public interface IPaperDao {

    //新建论文
    int insert(Paper record);

    // 修改论文
    int updatepaper(Paper record);

    // 按照论文ID查询
    Paper selectBypaperID(String paperID);

    //根据会议ID查询论文
    List<Paper> selectByrID(String rID);

    //根据审稿者查询论文
    List<Paper> selectBydID(String dID);
//    // 查询所有病历
//    List<Paper> findAll();
//

//
//    //根据投稿者查询论文
//    List<Paper> selectBypID(String pID);


}
