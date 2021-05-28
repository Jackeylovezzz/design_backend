package com.pilot.hospitalmanagement.Po;

import java.util.Date;

public class Appointment {
    private String aID;    //预约ID
    private User aUser;    //发起预约的用户
    private Date aCreateTime; //发起预约的时间
    private String aStatus;  //预约的状态
    private String aRoom;    //预约科室
    private String aExpert;  //预约专家的ID
}
