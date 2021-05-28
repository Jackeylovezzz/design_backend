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
@ToString(callSuper = true)
public class Patient extends User{

    private String pAddress;     //病人住址
    private String pHistoryIllness; //病史

    private boolean isValid;    //有效位

    public  Patient (String pID, String pCode, String pName, String pGender, String pBirthday, String pTel,String pAddress,String pHistoryIllness ,boolean isValid)
    {
        this.userID = pID;
        this.userCode = pCode;
        this.userName = pName;
        this.userGender = pGender;
        this.userBirthday = pBirthday;
        this.userTel = pTel;
        this.pAddress = pAddress;
        this.pHistoryIllness = pHistoryIllness;
        this.isValid = isValid;

    }

}
