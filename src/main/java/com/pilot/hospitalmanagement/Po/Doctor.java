package com.pilot.hospitalmanagement.Po;


import lombok.*;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Data
@Setter
@Getter
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User{

    private String rID;       //所属科室
    private boolean isExpert;     //是否是专家
    private String status;     //当前状态
    private String dAppointmentTime; //可预约时间
    private Integer dAppointmentLimit; //预约限制人数


    public Doctor(
            String userID,
            String userCode,
            String userName,
            String userGender,
            String userBirthday,
            String userTel,
            String rID,
            boolean isExpert,
            String status,
            String dAppointmentTime,
            Integer dAppointmentLimit)
    {
        this.userID = userID;
        this.userCode=userCode;
        this.userName = userName;
        this.userGender = userGender;
        this.userBirthday = userBirthday;
        this.userTel = userTel;
        this.rID = rID;
        this.isExpert = isExpert;
        this.status = status;
        this.dAppointmentTime = dAppointmentTime;
        this.dAppointmentLimit = dAppointmentLimit;


    }



}
