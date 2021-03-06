package com.pilot.hospitalmanagement.Po;

import lombok.*;
import lombok.extern.log4j.Log4j;

/**
 * @author Paul
 * @date 2021/1/5 22:34
 * @description
 */
@Data
@Setter
@Getter
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    public String rID;    //科室ID
    public String rName;  //科室名称
    public String rDescription; //科室描述
    public String rAppointmentTime; //可预约时间

    public String rCreateTime ; //会议创建时间
    public String rTime;        //会议时间
    public String rTheme;       //会议主题
    public String rAdress;      //会议地址
    public String phalD;        //会议管理者ID
}
