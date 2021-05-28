package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.Patient;
import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.dao.IPatientDao;
import com.pilot.hospitalmanagement.service.PatientService;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author Paul
 * @date 2021/1/5 9:16
 * @description
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private IPatientDao iPatientDao;

    @Override
    public Patient loadPatientById(String patientId){
        //从数据库查询的user
            return iPatientDao.selectByPrimaryKey(patientId);
    }

    @Override
    public int register(Patient patient){
          Patient patientById = iPatientDao.selectByPrimaryKey(patient.getUserID());
          if(patientById != null){
              //用户已注册
              return 2;
          }
          patient.setValid(true);
          patient.setValid(true);
        return iPatientDao.insert(patient);
    }



    @Override
    public int modify(Patient patient) {
        return iPatientDao.updateByPrimaryKeySelective(patient);

    }
}
