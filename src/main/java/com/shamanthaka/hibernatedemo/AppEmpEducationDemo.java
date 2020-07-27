package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.model.EmpEducation;
import com.shamanthaka.hibernatedemo.repository.EmpEducationRepository;
import lombok.extern.log4j.Log4j;

@Log4j
public class AppEmpEducationDemo {
    EmpEducationRepository empEducationRepository = new EmpEducationRepository();
    public void addEmpEducation(){
        EmpEducation empEducation = new EmpEducation();
        //empEducation.setEmpId(13);
        empEducation.setType("CS");
        empEducation.setPercentage(89.99);
        empEducation.setPassingYear(2016);
        empEducation.setInstituteName("OU");
        empEducation.setEducationName("B.E");
        empEducationRepository.save(empEducation);

    }
    public void getAllEmpEducation(){
        empEducationRepository.getAll().stream().forEach(e->{
            log.info(e.getInstituteName() + "\t" + e.getType());
        });
    }

    public static void main(String[] args) {
        AppEmpEducationDemo appEmpEducationDemo = new AppEmpEducationDemo();
        appEmpEducationDemo.addEmpEducation();
        appEmpEducationDemo.getAllEmpEducation();
    }
}
