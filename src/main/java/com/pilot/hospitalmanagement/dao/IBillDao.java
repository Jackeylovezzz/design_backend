package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Bill;

public interface IBillDao {

    //新增一个账单
    int insert(Bill bill);

    //按账单ID查询账单
    Bill selectBybID (String bID);

    //按病历查询账单
    Bill selectBydocID (String docID);
}
