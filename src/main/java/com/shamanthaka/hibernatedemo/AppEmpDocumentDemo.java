package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.model.EmpDocument;
import com.shamanthaka.hibernatedemo.repository.EmpDocumentRepository;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Log4j
public class AppEmpDocumentDemo {
    EmpDocumentRepository empDocumentRepository =new EmpDocumentRepository();
    public  void getAllEmpDocument(){
        empDocumentRepository.getAll().stream().forEach(e->{
            log.info(e.getDocNumber() + "\t" + e.getDocType());
        });
    }
    public void addEmpDocument(){
        EmpDocument empDocument = new EmpDocument();
        empDocument.setExpiryDate(new Date());
        empDocument.setDocType("JSON");
        empDocument.setDocNumber(6);
        //empDocument.setEmpId(1);
        empDocumentRepository.save(empDocument);
    }

    public static void main(String[] args) {
        AppEmpDocumentDemo appEmpDocument = new AppEmpDocumentDemo();
        appEmpDocument.addEmpDocument();
        appEmpDocument.getAllEmpDocument();
    }
}
