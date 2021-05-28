package com.pilot.hospitalmanagement.Po;

import java.util.Date;

public class Prescription {
    private String preID;  //处方ID
    private Medicine preMedicines;  //药
    private int preMedicicesCnt;   //药品数量
    private Date preCreateTime;    //处方开具时间
    private String preStatus;      //药品状态
    private Pharmacist prePharmacist; // 改配方的配药师
}
