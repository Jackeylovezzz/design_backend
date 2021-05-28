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
public class Prescription {
    private String preID; // 处方ID

    private String docID; // 病历ID
    private String phaID; // 配药师ID

    private Date preCreateTime; // 处方创建时间

    private String status;

}
