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
public class Bill {

    private String bID;         //账单ID
    private String casID;       //收银员ID
    private String docID;       //病历ID

    private double bAmount;     //账单金额
    private Date bTime;       //开具时间
    private String bStatus;     //当前状态

}
