package com.pilot.hospitalmanagement.dao;

import com.pilot.hospitalmanagement.Po.Medicine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IMedicineDaoTest {
    @Autowired
    IMedicineDao iMedicineDao;

    @Test
    void context()
    {
        Medicine medicine = new Medicine("006","拉拉霉素素",22.3,"退烧","伟业收到制药",35);
        iMedicineDao.insert(medicine);

//        iMedicineDao.deleteBymID("003");
        System.out.println(iMedicineDao.selectBymSpecs("退烧"));
        System.out.println(iMedicineDao.selectBymFactory("伟业制药"));
        System.out.println(iMedicineDao.selectBymName("拉拉霉素素"));
        System.out.println(iMedicineDao.findAll());

    }
}
