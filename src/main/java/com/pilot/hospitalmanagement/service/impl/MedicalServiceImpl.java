package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.MedicalTest;
import com.pilot.hospitalmanagement.Po.MedicalTestItem;
import com.pilot.hospitalmanagement.Po.MedicalTests;
import com.pilot.hospitalmanagement.dao.IMedicalTestDao;
import com.pilot.hospitalmanagement.dao.IMedicalTestItemDao;
import com.pilot.hospitalmanagement.dao.IMedicalTestsDao;
import com.pilot.hospitalmanagement.service.MedicalTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.UUID;

/**
 * @author Paul
 * @date 2021/1/6 23:09
 * @description
 */
@Service
public class MedicalServiceImpl implements MedicalTestService {
    @Autowired
    IMedicalTestsDao iMedicalTestsDao;
    @Autowired
    IMedicalTestItemDao iMedicalTestItemDao;
    @Autowired
    IMedicalTestDao iMedicalTestDao;

    @Override
    public int addMedicalTest(List<MedicalTestItem> medicalTestListItems, String doctorId) throws ParseException {
        MedicalTests medicalTests = new MedicalTests();

        Date date = new Date();
        String cid = UUID.randomUUID().toString().replaceAll("-", "");
        medicalTests.setCID(cid);
        medicalTests.setCCreatTime(date);
        int cnt = iMedicalTestsDao.insert(medicalTests);
        for (MedicalTestItem t : medicalTestListItems) {
            t.setCID(cid);
            cnt += iMedicalTestItemDao.insert(t);
        }
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // medicalTests.setCCreatTime(df.parse(df.format(date.getTime())));
        // medicalTests.setDocID(doctorId);
        // iMedicalTestsDao.insert(medicalTests);
        // return iMedicalTestsDao.insert(medicalTests);
        return cnt;

    }

    @Override
    public int deleteMedicalTest(String id) {
        return 1;
    }

    @Override
    public List<MedicalTest> findAllMedicalTest() {
        return iMedicalTestDao.findAll();

    }

    // 根据检查单的ID获取所有的检查项目
    @Override
    public List<MedicalTest> findMedicalTestById(String cId) {
        List<MedicalTestItem> medicalTestItems = iMedicalTestItemDao.selectBycID(cId);
        List<MedicalTest> res = new ArrayList<>();
        for (MedicalTestItem item : medicalTestItems) {
            res.add(iMedicalTestDao.selectBytestID(item.getTestID()));
        }
        return res;

    }

    @Override
    public int modifyMedicalTest(MedicalTest record) {
        return 0;
    }

    @Override
    public List<MedicalTest> findMedicalTestByDocid(String id) {
        String testsID = iMedicalTestsDao.selectBydocID(id).getCID();
        List<MedicalTestItem> medicalTestItems = iMedicalTestItemDao.selectBytestID(testsID);
        List<MedicalTest> arr = new ArrayList<>();
        for (MedicalTestItem m : medicalTestItems) {
            arr.add(iMedicalTestDao.selectBytestID(m.getTestID()));
        }
        return arr;
    }

    @Override
    public int addMedicalTestItems(List<MedicalTestItem> mItems) {
        int cnt = 0;
        for (MedicalTestItem item : mItems) {
            cnt += iMedicalTestItemDao.insert(item);
        }
        return cnt;
    }

    @Override
    public List<MedicalTest> findMedicalTestByKeyWord(String key) {
        // 根据关键字获取检查项目
        return iMedicalTestDao.searchByKey(key);
    }

}
