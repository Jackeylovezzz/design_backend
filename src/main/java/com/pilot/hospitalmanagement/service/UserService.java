package com.pilot.hospitalmanagement.service;

import com.pilot.hospitalmanagement.Po.User;

/**
 * @author Paul
 * @date 2021/1/6 16:51
 * @description
 */
public interface UserService {
    User findUserById(String id);
}
