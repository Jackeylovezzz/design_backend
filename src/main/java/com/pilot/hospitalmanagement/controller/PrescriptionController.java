package com.pilot.hospitalmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.pilot.hospitalmanagement.Po.MedicalTest;
import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.Po.Prescription;
import com.pilot.hospitalmanagement.Po.PrescriptionItem;
import com.pilot.hospitalmanagement.service.MedicineService;
import com.pilot.hospitalmanagement.service.PrescriptionService;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/pres", method = RequestMethod.POST)
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;

    @Autowired
    MedicineService medicineService;

    @PostMapping("/submitPres")
    public Resbody submitCheck(@RequestBody Map<String, Object> params) {
        try {
            // 接收之间转化为item条目
            String docID = (String) params.get("docID");
            List<Map<String, String>> mapItems = (List<Map<String, String>>) params.get("items");
            List<PrescriptionItem> prescriptionItems = new ArrayList<>();
            for (Map<String, String> p : mapItems) {
                PrescriptionItem prescriptionItem = JSON.parseObject(JSON.toJSONString(p), PrescriptionItem.class);
                prescriptionItems.add(prescriptionItem);
            }
            int resCode = prescriptionService.addPrescription(prescriptionItems, docID);
            if (resCode == 1 + prescriptionItems.size()) {
                return ResbodyUtil.success("创建成功");
            } else {
                return ResbodyUtil.error(0, "创建失败");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    // 根据处方单号获取药品
    @GetMapping("/queryPresMedicine/{preId}")
    public Resbody queryCheck(@PathVariable("preId") String preId) {
        try {
            List<PrescriptionItem> res = prescriptionService.findPresItemByPID(preId);
            if (res != null) {
                List<Medicine> allMedicine = new ArrayList<>();
                for (PrescriptionItem pItem : res) {
                    allMedicine.add(medicineService.findMedicineByID(pItem.getMID()));
                }
                return ResbodyUtil.success(allMedicine, "查找成功");
            } else {
                return ResbodyUtil.error(0, "查找失败");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 根据处方单号获取检验项
    @GetMapping("/needProcessList")
    public Resbody needProcessList() {
        try {
            List<Prescription> res = prescriptionService.findAllPreNeedProcess();

            if (res != null) {
                return ResbodyUtil.success(res, "查找成功");
            } else {
                return ResbodyUtil.error(0, "查找失败");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 修改处方状态
    @GetMapping("/setPreStatus/{preID}/{status}")
    public Resbody setPreStatus(@PathVariable("preID") String preID, @PathVariable("status") String status) {
        try {
            Prescription prescription = prescriptionService.findPresById(preID);
            if (prescription != null) {
                prescription.setStatus(status);
                int res = prescriptionService.modifyPrescription(prescription);
                if (res == 1) {
                    return ResbodyUtil.success("修改成功");
                }
                return ResbodyUtil.success("修改失败");
            } else {
                return ResbodyUtil.error(0, "修改失败");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    @PostMapping("/returnMedicine")
    public Resbody returnMedicine(@RequestBody Map<String, Object> params) {
        try {
            // 接收之间转化为item条目
            String preID = (String) params.get("preID");
            List<String> medicineList = (List<String>) params.get("medicineIDList");
            int resCode = prescriptionService.returnMedicine(preID, medicineList);
            if (resCode > 0) {
                return ResbodyUtil.success("创建成功");
            } else {
                return ResbodyUtil.error(0, "创建失败");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

}
