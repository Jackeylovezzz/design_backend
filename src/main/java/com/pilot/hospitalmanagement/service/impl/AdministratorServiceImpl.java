package com.pilot.hospitalmanagement.service.impl;

import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Paul
 * @date 2021/1/6 17:04
 * @description
 */
@Service("administrator")
public class AdministratorServiceImpl  implements UserService {

    @Override
    public User findUserById(String id) {
        return null;
    }

}
