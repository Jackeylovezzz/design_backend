package com.pilot.hospitalmanagement.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Paul
 * @date 2021/1/5 9:08
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resbody {
    public int status;
    public String code;
    public String message;
    Object body;

}
