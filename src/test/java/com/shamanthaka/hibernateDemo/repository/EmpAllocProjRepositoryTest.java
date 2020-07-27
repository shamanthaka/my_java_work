package com.shamanthaka.hibernateDemo.repository;

import com.shamanthaka.DataPopulator;
import com.shamanthaka.hibernatedemo.model.EmpProjectAllocation;
import com.shamanthaka.hibernatedemo.model.EmployeePersonal;
import com.shamanthaka.hibernatedemo.model.Project;
import com.shamanthaka.hibernatedemo.repository.EmpProjectAllocRepository;
import com.shamanthaka.hibernatedemo.repository.EmployeePersonalRepository;
import com.shamanthaka.hibernatedemo.repository.ProjectRepository;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
@Log4j
public class EmpAllocProjRepositoryTest {

    private EmpProjectAllocRepository projectAllocRepository;
    private ProjectRepository projectRepository;
    private EmployeePersonalRepository employeePersonalRepository;

    @Before
    public void setUp(){
        projectAllocRepository = new EmpProjectAllocRepository();
        projectRepository = new ProjectRepository();
        employeePersonalRepository = new EmployeePersonalRepository();
    }

    @Test
    public void addEmpAllocProject(){
        EmployeePersonal employeePersonal = employeePersonalRepository.get(14);
        EmpProjectAllocation empProjectAllocation = DataPopulator.populateEmpProjectAllocation(2,2,"not alloted");
        empProjectAllocation.setEmployeePersonal(employeePersonal);
        EmpProjectAllocation empProjectAllocation1 = projectAllocRepository.save(empProjectAllocation);
        Assert.assertNotNull(empProjectAllocation1);

    }

    @Test
    public void getAllEmpAllocProject(){
        List<EmpProjectAllocation> empProjectAllocationList = projectAllocRepository.getAll();
        empProjectAllocationList.stream().filter(Objects::nonNull).forEach(empProjectAllocation -> {
            log.info(DataPopulator.populateEmpAllocProjAsString(empProjectAllocation));
        });
    }

    @Test
    public void deleteEmpAllocProject(){

        EmpProjectAllocation empProjectAllocation = projectAllocRepository.delete(3);
        if(empProjectAllocation != null){
            log.info(DataPopulator.populateEmpAllocProjAsString(empProjectAllocation));
        }
    }

    @Test
    public  void updateEmpAllocProject(){
        EmpProjectAllocation empProjectAllocation = projectAllocRepository.get(4);
        if(empProjectAllocation!= null){
            empProjectAllocation.setAllocationStatus("Alloted");
            empProjectAllocation.setProjectId(2);
            EmpProjectAllocation empProjectAllocation1 = projectAllocRepository.update(empProjectAllocation);
            log.info(DataPopulator.populateEmpAllocProjAsString(empProjectAllocation1));
        }

    }

    @Test
    public void testProjectAllocation(){
        Project project = projectRepository.get(1);
        EmpProjectAllocation allocation = DataPopulator.populateEmpProjectAllocation(1,1, "In Progress");

        //fetch employee record to get the employee id
        EmployeePersonal ep = employeePersonalRepository.get(17);
        allocation.setEmployeePersonal(ep);
        Set<Project> projects = new HashSet<>();
        projects.add(project);
        allocation.setProjectSet(projects);
        EmpProjectAllocation newAllocation = projectAllocRepository.save(allocation);
        Assert.assertNotNull(newAllocation);
    }
}
