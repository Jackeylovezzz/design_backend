package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.Po.PrescriptionItem;

import java.util.List;

public interface IPreItemDao {

    // 新增一个处方条目
    int insert(PrescriptionItem prescriptionItem);

    // 更新一个处方条目
    int update(PrescriptionItem prescriptionItem);

    List<PrescriptionItem> selectBypreID(String preID);

    List<PrescriptionItem> selectBymID(String mID);

    int changeReturn(String preID, Boolean status);

    // int changeReturn(String preID, String string);

}
