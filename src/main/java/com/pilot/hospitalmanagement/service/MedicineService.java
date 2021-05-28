package com.pilot.hospitalmanagement.service;

import java.util.List;

import com.pilot.hospitalmanagement.Po.Medicine;
import com.pilot.hospitalmanagement.Po.Prescription;

public interface MedicineService {
    Medicine findMedicineByID(String id);

    int addMedicine(Medicine m);

    int delMedicine(String mID);

    List<Medicine> getAllMedicine();

    List<Medicine> findMedicineByKeyWord(String key_word);

}