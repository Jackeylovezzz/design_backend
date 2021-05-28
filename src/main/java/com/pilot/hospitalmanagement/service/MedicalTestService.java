package com.pilot.hospitalmanagement.service;

import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.Po.MedicalTest;
import com.pilot.hospitalmanagement.Po.MedicalTestItem;
import com.pilot.hospitalmanagement.Po.MedicalTests;

import java.text.ParseException;
import java.util.List;

/**
 * @author Paul
 * @date 2021/1/6 22:53
 * @description
 */
public interface MedicalTestService {
    int addMedicalTest(List<MedicalTestItem> medicalTestItems, String doctorId) throws ParseException;

    int deleteMedicalTest(String id);

    List<MedicalTest> findAllMedicalTest();

    List<MedicalTest> findMedicalTestById(String id);

    int modifyMedicalTest(MedicalTest record);

    List<MedicalTest> findMedicalTestByDocid(String id);

    int addMedicalTestItems(List<MedicalTestItem> mItems);

    List<MedicalTest> findMedicalTestByKeyWord(String key);

    // List<MedicalTestItem> findMedicalTestItems(String mTestsID);

}
