package com.pilot.hospitalmanagement.controller;

import java.util.List;

import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.service.impl.TriageServiceImpl;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Paul
 * @date 2021/1/5 23:25
 * @description
 */
@CrossOrigin
@RestController
@RequestMapping("/Triage")
public class TriageController {
    @Autowired
    TriageServiceImpl triageService;

    // 当前排队队列(专家/科室) type为expert或者d
    @GetMapping("/queryCurrQueue/{id}/{type}")
    public Resbody queryCurrQueue(@PathVariable("id") String id, @PathVariable("type") String type) {
        try {
            List<User> res = triageService.getCurrQueue(id, type);
            if (res == null) {
                return ResbodyUtil.error(0, "查询失败");
            } else {
                return ResbodyUtil.success(res, "查询成功");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 挂号排队信息
    @GetMapping("/queryStatus/{appointId}")
    public Resbody queryStatus(@PathVariable("appointId") String appointId) {
        try {
            int queueNo = triageService.getOwnNumber(appointId);
            return ResbodyUtil.success(queueNo, "查询成功");

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 扫描挂号码进入分诊队列
    @GetMapping("/executeTriage/{appointId}")
    // todo
    public Resbody executeTriage(@PathVariable("appointId") String appointId) {
        boolean res = triageService.executeTriage(appointId);
        if (res) {
            return ResbodyUtil.success("执行成功");
        }
        return ResbodyUtil.error(0, "执行失败");
    }

}
