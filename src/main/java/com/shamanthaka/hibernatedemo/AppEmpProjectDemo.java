package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.model.Project;
import com.shamanthaka.hibernatedemo.repository.ProjectRepository;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Log4j
public class AppEmpProjectDemo {
    ProjectRepository projectRepository= new ProjectRepository();
    public void addEmpProject(){
        Project project = new Project();
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setProjectStatus("Progress");
        project.setRemarks("going fine");
        project.setTechnologies("Java");
        project.setProjectName("HRMS");
        projectRepository.save(project);
    }
    public void getAllEmpProject(){
        projectRepository.getAll().stream().forEach(e->{
            log.info(e.getProjectName()+ "\t" +e.getProjectStatus());
        });
    }

    public static void main(String[] args) {
        AppEmpProjectDemo appEmpProjectDemo = new AppEmpProjectDemo();
        appEmpProjectDemo.addEmpProject();
        appEmpProjectDemo.getAllEmpProject();
    }
}
