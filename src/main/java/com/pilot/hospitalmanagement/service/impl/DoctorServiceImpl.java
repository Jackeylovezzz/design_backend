package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.dao.IDoctorDao;
import com.pilot.hospitalmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Paul
 * @date 2021/1/6 16:38
 * @description
 */
@Service("doctor")
public class DoctorServiceImpl implements UserService {
    @Autowired
    IDoctorDao iDoctorDao;
    @Override
    public User findUserById(String id) {

        return iDoctorDao.selectByPrimaryID(id);
    }
}
