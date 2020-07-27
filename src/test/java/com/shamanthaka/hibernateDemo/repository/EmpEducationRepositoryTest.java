package com.shamanthaka.hibernateDemo.repository;

import com.shamanthaka.DataPopulator;
import com.shamanthaka.hibernatedemo.model.EmpEducation;
import com.shamanthaka.hibernatedemo.model.EmployeePersonal;
import com.shamanthaka.hibernatedemo.repository.EmpEducationRepository;
import com.shamanthaka.hibernatedemo.repository.EmployeePersonalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmpEducationRepositoryTest {
    EmpEducationRepository empEducationRepository;
    EmployeePersonalRepository employeePersonalRepository;

    @Before
    public void init(){
        empEducationRepository = new EmpEducationRepository();
        employeePersonalRepository = new EmployeePersonalRepository();
    }

    @Test
    public void addEmpEducation(){
        EmployeePersonal employeePersonal = employeePersonalRepository.get(13);
        if(employeePersonal != null){
            EmpEducation empEducation = DataPopulator.populateEmpEducation("MS","OhioStateUni",2019,76.89,"Computer Engineering");
            empEducation.setEmployeePersonal(employeePersonal);
            EmpEducation empEducation1 = empEducationRepository.save(empEducation);
            Assert.assertNotNull(empEducation1);
        }
    }
}
