package com.pilot.hospitalmanagement.service.impl;

import java.util.List;

import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.dao.IMedicineDao;
import com.pilot.hospitalmanagement.service.MedicineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    IMedicineDao iMedicineDao;

    @Override
    public Medicine findMedicineByID(String id) {
        return iMedicineDao.selectBymID(id);
    }

    @Override
    public int addMedicine(Medicine m) {
        return iMedicineDao.insert(m);
    }

    @Override
    public int delMedicine(String mID) {
        return iMedicineDao.deleteBymID(mID);
    }

    @Override
    public List<Medicine> getAllMedicine() {
        return iMedicineDao.findAll();
    }

    @Override
    public List<Medicine> findMedicineByKeyWord(String key_word) {
        return iMedicineDao.selectByKeyWord(key_word);
    }

}