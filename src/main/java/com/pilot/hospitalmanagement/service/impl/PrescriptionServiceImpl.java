package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.service.PrescriptionService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.Po.Prescription;
import com.pilot.hospitalmanagement.Po.PrescriptionItem;
import com.pilot.hospitalmanagement.dao.IDocDao;
import com.pilot.hospitalmanagement.dao.IMedicineDao;
import com.pilot.hospitalmanagement.dao.IPreItemDao;
import com.pilot.hospitalmanagement.dao.IPrescriptionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    IPrescriptionDao iPrescriptionDao;

    @Autowired
    IPreItemDao iPreItemDao;

    @Autowired
    IMedicineDao iMedicineDao;

    @Autowired
    IDocDao iDocDao;

    @Override
    public int addPrescription(List<PrescriptionItem> prescriptionItems, String docId) {
        // iPrescriptionDao.insert(record)
        Date date = new Date();
        String pID = UUID.randomUUID().toString().replaceAll("-", "");
        Prescription prescription = new Prescription(pID, docId, null, date, "待配药");
        // Doc doc = iDocDao.selectBydocID(docId);
        // doc.setPreID(pID);
        int cnt = iPrescriptionDao.insert(prescription);
        for (PrescriptionItem p : prescriptionItems) {
            p.setPreID(pID);
            p.setPreStatus("待配药");
            cnt += iPreItemDao.insert(p);
        }
        // iDocDao.updateBydocID(doc);
        iDocDao.setPreID(pID, docId);

        return cnt;
    }

    @Override
    public int deletePrescription(String id) {
        return iPrescriptionDao.deleteBypreID(id);
    }

    @Override
    public List<Prescription> findAllPreNeedProcess() {
        // iPrescriptionDao.selectBypreID()

        return iPrescriptionDao.findAllPresNeedProcess();
    }

    @Override
    public Prescription findPresById(String id) {
        return iPrescriptionDao.selectBypreID(id);
    }

    @Override
    public int modifyPrescription(Prescription record) {
        return iPrescriptionDao.update(record);
    }

    @Override
    public List<PrescriptionItem> findPresItemByPID(String id) {
        // Prescription prescription = iPrescriptionDao.selectBypreID(id);
        return iPreItemDao.selectBypreID(id);
        // return new ArrayList<>();
    }

    @Override
    public int returnMedicine(String preID, List<String> medicineList) {
        List<PrescriptionItem> prescriptionItems = iPreItemDao.selectBypreID(preID);
        int cnt = 0;
        for (PrescriptionItem p : prescriptionItems) {
            for (String s : medicineList) {
                if (s.equals(p.getMID())) {
                    cnt += iPreItemDao.changeReturn(p.getPreID(), true);
                }
            }
        }
        return cnt;
    }

    // @Override
    // public List<Medicine> findMedicineByPreItemID(String PreItemID) {

    // return null;
    // }
}