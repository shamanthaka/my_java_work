package com.shamanthaka.hibernateDemo.repository;

import com.shamanthaka.DataPopulator;
import com.shamanthaka.hibernatedemo.model.EmpProjectAllocation;
import com.shamanthaka.hibernatedemo.model.Project;
import com.shamanthaka.hibernatedemo.repository.EmpProjectAllocRepository;
import com.shamanthaka.hibernatedemo.repository.EmployeePersonalRepository;
import com.shamanthaka.hibernatedemo.repository.ProjectRepository;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
@Log4j
public class ProjectRepositoryTest {
    ProjectRepository projectRepository;
    private EmpProjectAllocRepository projectAllocRepository;

    @Before
    public void init(){
        projectRepository = new ProjectRepository();
        projectAllocRepository = new EmpProjectAllocRepository();

    }

    @Test
    public void addProject(){
        Project project = DataPopulator.populateProject("BankApp","SQL",new Date(), new Date()," incomplete","testing");
        Project project1 = projectRepository.save(project);
        Assert.assertNotNull(project1);

    }

    @Test
    public void getAllProjects(){
        List<Project> projectList = projectRepository.getAll();
        projectList.stream().filter(Objects::nonNull).forEach(project -> {
            log.info(DataPopulator.populateProjectAsString(project));
        });
    }
    @Test
    public void getProject(){
        Project project = projectRepository.get(3);
        if(project != null){
            log.info(DataPopulator.populateProjectAsString(project));
        }
    }
    @Test
    public void deleteProject(){

        Project project = projectRepository.delete(3);
        if(project != null){
            log.info(DataPopulator.populateProjectAsString(project));
        }
    }
    @Test
    public  void updateProject(){
        Project project = projectRepository.get(4);
        if(project != null){
            project.setProjectName("New project");
            Project project1 = projectRepository.update(project);
            log.info(DataPopulator.populateProjectAsString(project1));
        }

    }


    @Test
    public void testProjects(){
        EmpProjectAllocation projectAllocation = projectAllocRepository.get(1);
        EmpProjectAllocation projectAllocation2 = projectAllocRepository.get(2);

        Project project = DataPopulator.populateProject("BankApp","SQL",new Date(), new Date()," incomplete","testing");
        //Project project2 = DataPopulator.populateProject("HRMS","MongoDB",new Date(), new Date()," progress","testing");
        Set<EmpProjectAllocation> pSet = new HashSet<>();
        pSet.add(projectAllocation);
        pSet.add(projectAllocation2);
        project.setProjectAllocationSet(pSet);
        Project newProject = projectRepository.save(project);
        Assert.assertNotNull(newProject);
    }

}

