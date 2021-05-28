package com.pilot.hospitalmanagement;

import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.dao.IUserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalmanagementApplicationTests {
	@Autowired
	IUserDao iUserDao;

	@Test
	void contextLoads() {
		System.out.println(iUserDao.findAll());
	}

}
