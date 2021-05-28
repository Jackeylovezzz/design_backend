package com.pilot.hospitalmanagement.Po;

import lombok.*;
import lombok.extern.log4j.Log4j;

@Data
@Setter
@Getter
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private String mID; //药品ID
    private String mName; //药品名称
    private double mPrice; //药品单价
    private String mSpecs; //药品种类
    private String mFactory; //生产厂家
    private Integer mStock;  //库存

}
