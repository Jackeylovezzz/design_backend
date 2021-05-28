package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.dao.IDoctorDao;
import com.pilot.hospitalmanagement.dao.IPharmacistDao;
import com.pilot.hospitalmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Paul
 * @date 2021/1/6 17:08
 * @description
 */
@Service("pharmacist")
public class PharmacistServiceImpl implements UserService {
    @Autowired
    IPharmacistDao iPharmacistDao;
    @Override
    public User findUserById(String id) {
        return iPharmacistDao.selectByphaID(id);
    }
}
