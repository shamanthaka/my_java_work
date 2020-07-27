package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.conf.HibernateUtil;
import com.shamanthaka.hibernatedemo.model.EmpDocument;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Log4j
public class App3 {
    public void addDoc(){
        EmpDocument empDocument = populateDocument();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(empDocument);
            transaction.commit();
        } catch (Exception ex){
            log.info("Error" + ex.getMessage());
        }
    }

    public void getAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Query query =(Query) session.createQuery("from EmpDocument");

            List<EmpDocument>  empDocumentList = query.getResultList();

            empDocumentList.stream().forEach(e->{
                log.info(e.getDocNumber() + "\t"+ e.getDocType());
            });
            transaction.commit();
        } catch (Exception ex){
            log.info("Error" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
            App3 app3 = new App3();
            //app3.addDoc();
            app3.getAll();
    }

    private EmpDocument populateDocument(){
        EmpDocument empDocument = new EmpDocument();
        empDocument.setDocNumber(1234);
        empDocument.setDocType("xml");
        empDocument.setExpiryDate(new Date());

        return empDocument;
    }
}
