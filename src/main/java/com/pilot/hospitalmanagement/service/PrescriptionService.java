package com.pilot.hospitalmanagement.service;

import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.Po.Prescription;
import com.pilot.hospitalmanagement.Po.PrescriptionItem;

import java.util.List;

/**
 * @author Paul
 * @date 2021/1/6 23:12
 * @description
 */
public interface PrescriptionService {
    int addPrescription(List<PrescriptionItem> prescription, String docId);

    int deletePrescription(String id);

    List<Prescription> findAllPreNeedProcess();

    Prescription findPresById(String id);

    int modifyPrescription(Prescription record);

    List<PrescriptionItem> findPresItemByPID(String id);

    int returnMedicine(String preID, List<String> medicineList);
    // List<Medicine> findMedicineByPreItemID(String PreItemID);
}
