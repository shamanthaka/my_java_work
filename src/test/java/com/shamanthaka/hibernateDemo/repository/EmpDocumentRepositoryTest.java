package com.shamanthaka.hibernateDemo.repository;
import com.shamanthaka.DataPopulator;
import com.shamanthaka.hibernatedemo.model.EmpDocument;
import com.shamanthaka.hibernatedemo.model.EmployeePersonal;
import com.shamanthaka.hibernatedemo.repository.EmpDocumentRepository;
import com.shamanthaka.hibernatedemo.repository.EmployeePersonalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class EmpDocumentRepositoryTest {
    EmpDocumentRepository empDocumentRepository;
    EmployeePersonalRepository employeePersonalRepository;


    @Before
    public void init(){
        empDocumentRepository = new EmpDocumentRepository();
        employeePersonalRepository = new EmployeePersonalRepository();
    }

    @Test
    public void addEmpDocument(){
        EmployeePersonal employeePersonal = employeePersonalRepository.get(1);
        if(employeePersonal != null){
            EmpDocument empDocument = DataPopulator.populateEmployeeDocument("PAN",45678,new Date());
            empDocument.setEmployeePersonal(employeePersonal);
            EmpDocument savedDocument = empDocumentRepository.save(empDocument);
            Assert.assertNotNull(savedDocument);

        }
    }
}
