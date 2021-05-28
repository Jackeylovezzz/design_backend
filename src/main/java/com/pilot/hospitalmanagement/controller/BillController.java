package com.pilot.hospitalmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.Po.InfoCheck;
import com.pilot.hospitalmanagement.Po.MedicalTest;
import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.Po.PrescriptionItem;
import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.dao.IDocDao;
import com.pilot.hospitalmanagement.service.DocService;
import com.pilot.hospitalmanagement.service.MedicalTestService;
import com.pilot.hospitalmanagement.service.MedicineService;
import com.pilot.hospitalmanagement.service.PatientService;
import com.pilot.hospitalmanagement.service.PrescriptionService;
import com.pilot.hospitalmanagement.service.UserService;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    IDocDao iDocDao;

    @Autowired
    DocService docService;

    @Autowired
    @Qualifier("doctor")
    UserService userService;

    @Autowired
    PatientService patientService;

    @Autowired
    PrescriptionService prescriptionService;

    @Autowired
    MedicineService medicineService;

    @Autowired
    MedicalTestService medicalTestService;

    @GetMapping("/getReturnInfo/{docID}")
    public Resbody getReturnInfo(@PathVariable("docID") String docID) {
        try {
            Doc doc = docService.findDocById(docID);
            List<PrescriptionItem> prescriptionItems = prescriptionService.findPresItemByPID(doc.getPreID());
            List<Medicine> medicines = new ArrayList<>();
            for (PrescriptionItem prescriptionItem : prescriptionItems) {
                if (prescriptionItem.isReturn()) {
                    medicines.add(medicineService.findMedicineByID(prescriptionItem.getMID()));
                }
            }
            if (medicines.size() > 0) {
                return ResbodyUtil.success(medicines, "获取成功");
            }
            return ResbodyUtil.success(medicines, "暂无退费");
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

}
