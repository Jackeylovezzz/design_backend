package com.pilot.hospitalmanagement.Po;

import java.util.Date;

public class Bill {
    private String bID;         //账单ID
    private double dAmount;     //账单金额
    private Date bTime;       //开具时间
    private String bStatus;     //当前状态
    private Cashier bCashier;   //收银员
}
