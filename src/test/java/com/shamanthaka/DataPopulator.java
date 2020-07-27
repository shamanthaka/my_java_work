package com.shamanthaka;

import com.shamanthaka.hibernatedemo.model.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class DataPopulator {
    public static EmployeePersonal populateEmployee(String name, String contact, String email) {
        EmployeePersonal employeePersonal = new EmployeePersonal();
        employeePersonal.setEmpName(name);
        employeePersonal.setEmpContact(contact);
        employeePersonal.setEmpEmail(email);
        employeePersonal.setDob(new Date());
        employeePersonal.setDoj(new Date());
        return employeePersonal;
    }

    public static EmpProjectAllocation populateEmpProjectAllocation(Integer projectId, Integer empId, String allocationStatus) {
        EmpProjectAllocation empAlloc = new EmpProjectAllocation();
        empAlloc.setProjectId(projectId);
        //empAlloc.setEmpId(empId);
        empAlloc.setAllocationStatus(allocationStatus);
        return empAlloc;
    }
    public static String populateEmployeeAsString(EmployeePersonal employeePersonal) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(employeePersonal.getEmpId()+"\t");
        stringBuffer.append(employeePersonal.getEmpName()+"\t");
        stringBuffer.append(!StringUtils.isEmpty(employeePersonal.getEmpContact()) ? employeePersonal.getEmpContact()+"\t" : "\t");
        stringBuffer.append(!StringUtils.isEmpty(employeePersonal.getEmpEmail()) ? employeePersonal.getEmpEmail()+"\t" : "\t");
        stringBuffer.append(employeePersonal.getDob().toString()+"\t");
        stringBuffer.append(employeePersonal.getDoj().toString()+"\t");
        return stringBuffer.toString();
    }
    public static String populateProjectAsString(Project project){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(project.getProjectId() + "\t");
        stringBuffer.append(project.getProjectName()+"\t");
        stringBuffer.append(project.getTechnologies()+"\t");
        stringBuffer.append(project.getRemarks()+"\t");
        stringBuffer.append(project.getStartDate().toString()+"\t");
        stringBuffer.append(project.getEndDate().toString()+"\t");
        stringBuffer.append(project.getProjectStatus()+"\t");
        return stringBuffer.toString();
    }

    public static String populateEmpAllocProjAsString(EmpProjectAllocation empProjectAllocation){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(empProjectAllocation.getProjectId() + "\t");
        stringBuffer.append(empProjectAllocation.getEmployeePersonal().getEmpId()+"\t");
        stringBuffer.append(empProjectAllocation.getAllocationStatus()+"\t");
        stringBuffer.append(empProjectAllocation.getAllocationId()+"\t");
        return stringBuffer.toString();
    }

    public static EmpDocument populateEmployeeDocument(String documentType, int docNumber, Date expiryDate) {
        EmpDocument employeeDocument = new EmpDocument();
        employeeDocument.setDocNumber(docNumber);
        employeeDocument.setDocType(documentType);
        employeeDocument.setExpiryDate(expiryDate);
        return employeeDocument;
    }
    public static EmpAddress populateEmpAddress(String address, String addressType, int zipCode) {
        EmpAddress empAddress = new EmpAddress();
        empAddress.setAddress(address);
        empAddress.setAddressType(addressType);
        empAddress.setZipCode(zipCode);
        return empAddress;
    }
    public static EmpEducation populateEmpEducation(String educationName, String instituteName,
                                                    int passingYear, double percentage, String type) {
        EmpEducation empEducation = new EmpEducation();
        empEducation.setEducationName(educationName);
        empEducation.setInstituteName(instituteName);
        empEducation.setPassingYear(passingYear);
        empEducation.setPercentage(percentage);
        empEducation.setType(type);

        return empEducation;
    }

    public static Project populateProject(String projectName,String technologies,Date startDate,Date endDate, String remarks, String projectStatus){
        Project project = new Project();
        project.setProjectName(projectName);
        project.setTechnologies(technologies);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setRemarks(remarks);
        project.setProjectStatus(projectStatus);

        return project;
    }


    public static String populateEmployeeDocumentAsString(Set<EmpDocument> employeeDocumentSet) {
        StringBuffer stringBuffer = new StringBuffer();
        employeeDocumentSet.stream().filter(Objects::nonNull).forEach(employeeDocument -> {
            stringBuffer.append(employeeDocument.getDocId()+"\t")
                    .append(employeeDocument.getDocNumber()+"\t")
                    .append(employeeDocument.getDocType()+"\t")
                    .append(employeeDocument.getExpiryDate().toString()+"\n");
        });
        return stringBuffer.toString();
    }
}
