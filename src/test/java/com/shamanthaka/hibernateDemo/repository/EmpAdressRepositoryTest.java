package com.shamanthaka.hibernateDemo.repository;

import com.shamanthaka.DataPopulator;
import com.shamanthaka.hibernatedemo.model.EmpAddress;
import com.shamanthaka.hibernatedemo.model.EmployeePersonal;
import com.shamanthaka.hibernatedemo.repository.EmpAddressRepository;
import com.shamanthaka.hibernatedemo.repository.EmployeePersonalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmpAdressRepositoryTest {
    EmpAddressRepository empAddressRepository;
    EmployeePersonalRepository employeePersonalRepository;

    @Before
    public void init(){
        empAddressRepository = new EmpAddressRepository();
        employeePersonalRepository = new EmployeePersonalRepository();

    }

    @Test
    public void addEmpAddress(){
        EmployeePersonal employeePersonal = employeePersonalRepository.get(2);
        if(employeePersonal != null){
            EmpAddress empAddress = DataPopulator.populateEmpAddress("Delhi","Home",4589);
            empAddress.setEmployeePersonal(employeePersonal);
            EmpAddress empAddress1 = empAddressRepository.save(empAddress);
            Assert.assertNotNull(empAddress1);

        }
    }


}
