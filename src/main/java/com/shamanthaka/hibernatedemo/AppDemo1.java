package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.model.EmpDocument;
import com.shamanthaka.hibernatedemo.model.EmployeePersonal;
import com.shamanthaka.hibernatedemo.repository.EmployeePersonalRepository;
import lombok.extern.log4j.Log4j;

import java.util.Iterator;
import java.util.Set;

@Log4j
public class AppDemo1 {
    EmployeePersonalRepository employeePersonalRepository = new EmployeePersonalRepository();
    public void getAllEmp(){
        employeePersonalRepository.getAll().stream().forEach(e-> {
            log.info(e.getEmpId() + "\t"+ e.getEmpEmail());
        });
    }

    public void addEmp(){
        EmployeePersonal employeePersonal = App1.populateEmployee();

        employeePersonalRepository.save(employeePersonal);
    }
    //getting employee personal by id
    public void getEmpById(Integer id){

        EmployeePersonal ep = employeePersonalRepository.get(1);
        log.info("********Emplpoyee Record******");
        log.info(ep.getEmpId() + " " + ep.getEmpEmail() + ", " + ep.getEmpName());

        Set<EmpDocument> empDocumentSet = ep.getEmpDocumentSet();
        Iterator<EmpDocument> iter = empDocumentSet.iterator();
        log.info("*********Correspoinding Emplpoyee Record Documents ******");
        while(iter.hasNext()){
            EmpDocument doc = iter.next();
            log.info(doc.getDocNumber() + ", " + doc.getDocType() + ", " + doc.getDocId());
        }
    }

    public static void main(String[] args) {
        AppDemo1 appDemo1 = new AppDemo1();
        //appDemo1.getAllEmp();
        //appDemo1.addEmp();
        appDemo1.getEmpById(1);
    }
}
