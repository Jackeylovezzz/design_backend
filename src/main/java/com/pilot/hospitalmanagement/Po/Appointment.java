package com.pilot.hospitalmanagement.Po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.SplittableRandom;

@Data
@Setter
@Getter
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private String aID; // 预约ID

    private String dID; // 预约医生的ID
    private String pID; // 预约患者的ID
    private String rID; // 预约科室

    private String aStatus; // 预约的状态

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date aCreateTime; // 预约创建的时间

    private Date aTime; // 1~5代表预约的时间

    private String aType; // 预约类型

    private boolean hasArrived; // 病人是否已到场

    private int queueNum; // 生成的排队号

    // public Appointment(
    // String aID,
    // String dID,
    // String pID,
    // String rID,
    // String aStatus,
    // Date aCreateTime,
    // Integer aTime,
    // String aType,
    // boolean hasArrived)
    // {
    //
    // }

}
