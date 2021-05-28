package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.Bill;
import com.pilot.hospitalmanagement.Po.Prescription;
import com.pilot.hospitalmanagement.dao.IBillDao;
import com.pilot.hospitalmanagement.service.BillService;
import com.pilot.hospitalmanagement.utils.ReturnInfo;

import org.springframework.beans.factory.annotation.Autowired;

public class BillServiceImpl implements BillService {

    @Autowired
    IBillDao iBillDao;

    @Override
    public Bill getTotalByDocID(String ID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int gotoPay(String billID) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ReturnInfo getReturnInfo(String docID) {

        return null;
    }

}