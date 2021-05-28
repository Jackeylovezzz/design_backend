package com.pilot.hospitalmanagement.Po;

import lombok.*;
import lombok.extern.log4j.Log4j;

@Data
@Setter
@Getter
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class MedicalTest {

    private String testID;    //检查项目ID
    private String rID;        //所属科室ID

    private String testName;   //检查项目名称
    private double testPrice;   //检查价格

}
