package com.pilot.hospitalmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.Po.Doctor;
import com.pilot.hospitalmanagement.Po.InfoCheck;
import com.pilot.hospitalmanagement.Po.MedicalTest;
import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.Po.Patient;
import com.pilot.hospitalmanagement.Po.PrescriptionItem;
import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.service.DocService;
import com.pilot.hospitalmanagement.service.MedicalTestService;
import com.pilot.hospitalmanagement.service.MedicineService;
import com.pilot.hospitalmanagement.service.PatientService;
import com.pilot.hospitalmanagement.service.PrescriptionService;
import com.pilot.hospitalmanagement.service.TriageService;
import com.pilot.hospitalmanagement.service.UserService;
import com.pilot.hospitalmanagement.service.impl.AppointServiceImpl;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Paul
 */
@CrossOrigin
@RestController
@RequestMapping("/doc")
public class DocController {
    @Autowired
    DocService docService;

    @Autowired
    PatientService patientService;

    @Qualifier("doctor")
    @Autowired
    UserService userService;

    @Autowired
    PrescriptionService prescriptionService;

    @Autowired
    MedicineService medicineService;

    @Autowired
    MedicalTestService medicalTestService;

    @Autowired
    AppointServiceImpl appointServiceImpl;

    @Autowired
    TriageService triageService;

    @PostMapping("/submitRecord")
    public Resbody submitDoc(Doc doc) {
        try {

            Doc resCode = docService.addDoc(doc);
            if (resCode == null) {
                return ResbodyUtil.success(resCode, "????????????");
            } else {
                return ResbodyUtil.error(0, "????????????");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    @GetMapping("/deleteRecord/{docId}")
    public Resbody deleteRecord(@PathVariable("docId") String docId) {
        try {
            int resCode = docService.deleteDoc(docId);
            if (resCode == 1) {
                return ResbodyUtil.success("????????????");
            } else {
                return ResbodyUtil.error(0, "????????????");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    @GetMapping("/queryAllRecord/{patientId}")
    public Resbody queryAllRecord(@PathVariable("patientId") String patientId) {
        try {
            List<Doc> res = docService.findDocByPid(patientId);

            if (res != null) {
                return ResbodyUtil.success(res, "????????????");
            } else {
                return ResbodyUtil.error(0, "????????????");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    @GetMapping("/queryRecord/{recordId}")
    public Resbody queryRecord(@PathVariable("recordId") String recordId) {
        try {
            Doc res = docService.findDocById(recordId);
            if (res != null) {
                return ResbodyUtil.success(res, "????????????");
            } else {
                return ResbodyUtil.error(0, "????????????");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    @PostMapping("/modifyRecord")
    public Resbody modifyRecord(@RequestBody Map<String, String> param) {
        try {
            Doc doc = JSON.parseObject(JSON.toJSONString(param), Doc.class);
            int res = docService.modifyDoc(doc);
            if (res == 1) {
                return ResbodyUtil.success("????????????");
            } else {
                return ResbodyUtil.error(0, "????????????");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    @GetMapping("/delRecord/{docID}")
    public Resbody delRecord(@PathVariable String docID) {
        try {
            int res = docService.deleteDoc(docID);
            if (res == 1) {
                return ResbodyUtil.success("????????????");
            } else {
                return ResbodyUtil.error(0, "????????????");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    @GetMapping("/finishRecord/{docID}")
    public Resbody finishRecord(@PathVariable String docID) {
        try {
            int res = docService.finishDoc(docID);
            if (res == 1) {
                Doc doc = docService.findDocById(docID);
                User patient = patientService.loadPatientById(doc.getPID());
                User doctor = userService.findUserById(doc.getDID());
                // Prescription prescription = prescriptionService.findPresById(doc.getPreID());
                List<PrescriptionItem> prescriptionItems = prescriptionService.findPresItemByPID(doc.getPreID());
                List<Medicine> medicines = new ArrayList<>();
                for (PrescriptionItem prescriptionItem : prescriptionItems) {
                    medicines.add(medicineService.findMedicineByID(prescriptionItem.getMID()));
                }
                List<MedicalTest> medicalTest = medicalTestService.findMedicalTestByDocid(doc.getDocID());
                InfoCheck infoCheck = new InfoCheck(patient, doc, doctor, medicines, medicalTest);
                return ResbodyUtil.success(infoCheck, "????????????");
            } else {
                return ResbodyUtil.error(0, "????????????");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    @GetMapping("/callNext/{docID}")
    public Resbody callNext(@PathVariable String docID) {
        try {
            Doctor doctor = (Doctor) userService.findUserById(docID);
            String type = "dept";
            if (doctor.isExpert()) {
                type = "expert";
            }
            List<User> userList = triageService.getCurrQueue(docID, type);
            if (userList.size() > 0) {
                for (User targetUser : userList) {
                    // User targetUser = userList.get(0);
                    Appointment appointment = appointServiceImpl.findMyAppointment(targetUser.getUserID());

                    if (doctor.isExpert()) {
                        if ("expert".equals(appointment.getAType())
                                && appointment.getDID().equals(doctor.getUserID())) {
                            appointServiceImpl.changeStatus(appointment.getAID(), "?????????");
                            return ResbodyUtil.success((Patient) targetUser, "???????????????");
                        }
                    } else {
                        if ("dept".equals(appointment.getAType()) && appointment.getRID().equals(doctor.getRID())) {
                            appointServiceImpl.changeStatus(appointment.getAID(), "?????????");
                            return ResbodyUtil.success((Patient) targetUser, "???????????????");
                        }
                    }
                }
                return ResbodyUtil.success("???????????????");
            } else {
                return ResbodyUtil.success("???????????????");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

}
