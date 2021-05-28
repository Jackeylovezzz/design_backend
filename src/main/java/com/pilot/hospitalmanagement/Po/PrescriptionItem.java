package com.pilot.hospitalmanagement.Po;

import lombok.*;
import lombok.extern.log4j.Log4j;

@Data
@Setter
@Getter
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionItem {
    private String preID; // 所属处方ID
    private String mID; // 所对应药物ID

    private Integer preItemMedicineCnt; // 所对应药品数量
    private String dosage; // 药品用量
    private String notice; // 注意事项
    private boolean isReturn; // 是否已被退回
    private String preStatus; // 所对应药品的状态
}
