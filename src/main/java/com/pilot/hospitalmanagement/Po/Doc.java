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
@Builder
public class Doc {
    private String docID; // 病历ID

    private String pID; // 病人ID
    private String cID; // 检查ID
    private String dID; // 医生ID
    private String preID; // 处方ID
    private String bID; // Bill ID

    public String docUserSay; // 患者嘱咐
    public Date docCreateTime; // 创建时间
    public Date docFinishTime; // 完成时间
    public String docStatus; // 当前状态

    public String docAdvice; // 门诊建议
}
