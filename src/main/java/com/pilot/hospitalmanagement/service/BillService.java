package com.pilot.hospitalmanagement.service;

import java.util.List;

import com.pilot.hospitalmanagement.Po.Bill;
import com.pilot.hospitalmanagement.utils.ReturnInfo;

public interface BillService {
    Bill getTotalByDocID(String ID);

    int gotoPay(String billID);

    ReturnInfo getReturnInfo(String docID);
}