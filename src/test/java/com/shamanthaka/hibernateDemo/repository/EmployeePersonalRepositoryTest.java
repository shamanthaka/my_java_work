package com.shamanthaka.hibernateDemo.repository;

import com.shamanthaka.DataPopulator;
import com.shamanthaka.hibernatedemo.model.EmpDocument;
import com.shamanthaka.hibernatedemo.model.EmployeePersonal;
import com.shamanthaka.hibernatedemo.repository.EmployeePersonalRepository;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

@Log4j
public class EmployeePersonalRepositoryTest {
    EmployeePersonalRepository employeePersonalRepository;

    @Before
    public  void init(){
        employeePersonalRepository = new EmployeePersonalRepository();
    }


    @Test
    public  void addEmployeePersonalWithDocumentTest(){
        EmployeePersonal employeePersonal = DataPopulator.populateEmployee("gagandeep", "23455","gagan@gmail.com");

        EmpDocument empDocument =DataPopulator.populateEmployeeDocument("Aadhar", 12345,new Date());
        empDocument.setEmployeePersonal(employeePersonal);

        Set<EmpDocument> empDocumentSet = new HashSet<>();
        empDocumentSet.add(empDocument);

        employeePersonal.setEmpDocumentSet(empDocumentSet);
        EmployeePersonal savedEmp = employeePersonalRepository.save(employeePersonal);

        log.info(DataPopulator.populateEmployeeAsString(savedEmp));
        Assert.assertNotNull(savedEmp);
    }

    @Test
    public void getAllEmployeesWithDocument() {
        List<EmployeePersonal> empList = employeePersonalRepository.getAll();
        Assert.assertNotNull(empList);
        empList.stream().filter(Objects::nonNull).forEach(employeePersonal -> {
            log.info("==============================================================");
            log.info(DataPopulator.populateEmployeeAsString(employeePersonal));
            log.info(employeePersonal.getEmpDocumentSet().size());
            log.info(DataPopulator.populateEmployeeDocumentAsString(employeePersonal.getEmpDocumentSet()));
            log.info("==============================================================");
        });
    }

}
