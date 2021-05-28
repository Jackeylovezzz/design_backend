package com.pilot.hospitalmanagement.Po;

import lombok.*;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Data
@Setter
@Getter
@Log4j
//@NoArgsConstructor
@AllArgsConstructor
public class Cashier extends User{

    public Cashier(String casID, String casCode, String casName, String casGender, String casBirthday, String casTel)
    {
        this.userID = casID;
        this.userCode = casCode;
        this.userName= casName;
        this.userGender = casGender;
        this.userBirthday = casBirthday;
        this.userTel = casTel;
    }

}
