package com.pilot.hospitalmanagement.utils;

/**
 * @author Paul
 * @date 2021/1/5 19:54
 * @description
 */
public class ResbodyUtil {

    public static Resbody success(Object object, String msg) {
        Resbody result = new Resbody();
        result.setStatus(1);
        result.setMessage(msg);
        result.setBody(object);
        result.setCode("200");
        return result;
    }

    public static Resbody success(String msg) {
        return success(null, msg);
    }

    public static Resbody error(Integer status, String msg) {
        Resbody result = new Resbody();
        result.setStatus(status);
        result.setMessage(msg);
        return result;
    }
}