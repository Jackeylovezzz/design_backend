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
public class Paper {
    private String paperID; // 论文编号

    private String pID; // tou稿者ID
    private String dID; // shen稿者ID
    private String rID; // 会议ID

    public String paperName; // 论文题目
    public String paperAbstract; // 论文摘要
    public String paperZuozhe; // 论文作者
    public String paperScore; // 评审成绩
    public String paperAdvice; // 评审建议
    public String paperState; // 评审状态
    public String paperFileName; // 存放路径

}
