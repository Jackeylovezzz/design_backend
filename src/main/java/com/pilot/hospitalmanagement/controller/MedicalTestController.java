package com.pilot.hospitalmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.Po.MedicalTest;
import com.pilot.hospitalmanagement.Po.MedicalTestItem;
import com.pilot.hospitalmanagement.Po.MedicalTests;
import com.pilot.hospitalmanagement.Po.PrescriptionItem;
import com.pilot.hospitalmanagement.service.MedicalTestService;
import com.pilot.hospitalmanagement.service.impl.DocServiceImpl;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Paul
 * @date 2021/1/6 23:48
 * @description
 */
@CrossOrigin
@RestController
@RequestMapping("/medicalTest")
public class MedicalTestController {
    @Autowired
    MedicalTestService medicalTestService;

    // 提交检验单
    @PostMapping("/submitCheck")
    public Resbody submitCheck(@RequestBody Map<String, Object> params) {
        try {
            String docID = (String) params.get("docID"); // 病历ID
            List<Map<String, String>> mapItems = (List<Map<String, String>>) params.get("items");
            List<MedicalTestItem> medicalTestItems = new ArrayList<>();
            for (Map<String, String> m : mapItems) {
                MedicalTestItem medicalTestItem = JSON.parseObject(JSON.toJSONString(m), MedicalTestItem.class);
                medicalTestItems.add(medicalTestItem);
            }
            int resCode = medicalTestService.addMedicalTest(medicalTestItems, docID);
            if (resCode == 1 + medicalTestItems.size()) {
                return ResbodyUtil.success("创建成功");
            } else {
                return ResbodyUtil.error(0, "创建失败");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    // 删除检验单 废弃
    @GetMapping("/deleteCheck/{checkId}")
    public Resbody deleteCheck(@PathVariable("checkId") String checkId) {
        try {
            int resCode = medicalTestService.deleteMedicalTest(checkId);
            if (resCode == 1) {
                return ResbodyUtil.success("删除成功");
            } else {
                return ResbodyUtil.error(0, "删除失败");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    // 根据检验单号获取检验项
    @GetMapping("/queryCheck/{checkId}")
    public Resbody queryCheck(@PathVariable("checkId") String checkId) {
        try {
            List<MedicalTest> res = medicalTestService.findMedicalTestById(checkId);

            if (res != null) {
                return ResbodyUtil.success(res, "查找成功");
            } else {
                return ResbodyUtil.error(0, "查找失败");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    // 获取所有检验条目
    @GetMapping("/queryAllCheck")
    public Resbody queryRecord() {
        try {
            List<MedicalTest> res = medicalTestService.findAllMedicalTest();
            if (res != null) {
                return ResbodyUtil.success(res, "查找成功");
            } else {
                return ResbodyUtil.error(0, "查找失败");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    // 获取所有检验条目
    @GetMapping("/queryMedicalTest/{search_word}")
    public Resbody queryMedicalTest(@PathVariable("search_word") String search_word) {
        try {
            List<MedicalTest> res = medicalTestService.findMedicalTestByKeyWord(search_word);
            if (res != null) {
                return ResbodyUtil.success(res, "查找成功");
            } else {
                return ResbodyUtil.error(0, "查找失败");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }
    /*
     * @PostMapping("/modifyRecord") public Resbody modifyRecord(Doc doc){ try{ int
     * res = medicalTestService.modifyMedicalTest(doc); if( res == 1){ return
     * ResbodyUtil.success("修改成功"); }else { return ResbodyUtil.error(0,"修改失败"); }
     * 
     * }catch (Exception e){ return ResbodyUtil.error(0,e.toString()); }
     * 
     * }
     */
}
