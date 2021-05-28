package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.dao.IDocDao;
import com.pilot.hospitalmanagement.dao.IDoctorDao;
import com.pilot.hospitalmanagement.dao.IMedicalTestsDao;
import com.pilot.hospitalmanagement.dao.IPatientDao;
import com.pilot.hospitalmanagement.dao.IPrescriptionDao;
import com.pilot.hospitalmanagement.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;



/**
 * @author Paul
 * @date 2021/1/6 22:29
 * @description
 */
@Service
public class DocServiceImpl implements DocService {
    @Autowired
    IDocDao iDocDao;

    @Autowired
    IPatientDao iPatientDao;

    @Autowired
    IDoctorDao iDoctorDao;

    @Autowired
    IMedicalTestsDao iMedicalTestsDao;

    @Autowired
    IPrescriptionDao iPrescriptionDao;

    @Override
    public Doc addDoc(Doc doc) {
        Date date = new Date();
        String dID = UUID.randomUUID().toString().replaceAll("-", "");
        doc.setDocID(dID);
        doc.setDocCreateTime(date);
        doc.setDocStatus("未完成");
        iDocDao.insert(doc);
        return iDocDao.selectBydocID(dID);
    }

    @Override
    public int deleteDoc(String id) {
        return iDocDao.deleteBydocID(id);
    }

    @Override
    public List<Doc> findAllDoc() {
        return iDocDao.findAll();
    }

    @Override
    public Doc findDocById(String id) {
        return iDocDao.selectBydocID(id);
    }

    @Override
    public int modifyDoc(Doc record) {
        return iDocDao.updateBydocID(record);
    }

    @Override
    public List<Doc> findDocByPid(String id) {
        return iDocDao.selectBypID(id);
    }

    @Override
    public int finishDoc(String id) {
        Doc doc = new Doc();
        doc.setDocID(id);
        doc.setDocStatus("已完成");
        return iDocDao.updateBydocID(doc);
    }

}
