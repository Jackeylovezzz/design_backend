package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.User;
//import org.apache.ibatis.annotations.Select;


import java.util.List;


public interface IUserDao {

    List<User> findAll();
}
