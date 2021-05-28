package com.pilot.hospitalmanagement.controller;

import java.util.List;

import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.service.MedicineService;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @GetMapping("/allMedicine")
    public Resbody allMedicine() {
        try {
            List<Medicine> medicineList = medicineService.getAllMedicine();
            if (medicineList.size() > 0) {
                return ResbodyUtil.success(medicineList, "获取成功");
            }
            return ResbodyUtil.success("暂无药品");

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }
}