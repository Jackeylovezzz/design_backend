package com.pilot.hospitalmanagement.Po;

import lombok.*;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Data
@Setter
@Getter
@Log4j
@NoArgsConstructor
//@AllArgsConstructor
public class Pharmacist extends User {

    public Pharmacist(String phaID, String phaCode, String phaName, String phaGender, String phaBirthday, String phaTel)
    {
        this.userID = phaID;
        this.userCode = phaCode;
        this.userName= phaName;
        this.userGender = phaGender;
        this.userBirthday = phaBirthday;
        this.userTel = phaTel;
    }
}
