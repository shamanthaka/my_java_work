package com.shamanthaka.hibernatedemo.util;

import com.shamanthaka.hibernatedemo.model.EmployeePersonal;
import com.shamanthaka.hibernatedemo.model.Project;

import java.util.Date;

public class ObjectPopulator {
    public static EmployeePersonal populateEmployeePersonal(String name, String contact, String email,Date dob, Date doj){
        EmployeePersonal employeePersonal = new EmployeePersonal();
        employeePersonal.setEmpName(name);
        employeePersonal.setEmpContact(contact);
        employeePersonal.setEmpEmail(email);
        employeePersonal.setDob(dob);
        employeePersonal.setDoj(doj);
        return employeePersonal;
    }

    public static Project populateProject(String projectName, String technologies, Date startDate, Date endDate,
                                          String remarks, String projectStatus){
        Project project = new Project();
        project.setProjectName(projectName);
        project.setTechnologies(technologies);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setRemarks(remarks);
        project.setProjectStatus(projectStatus);
        return  project;
    }
}
