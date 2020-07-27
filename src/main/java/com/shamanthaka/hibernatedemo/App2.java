package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.conf.HibernateUtil;
import com.shamanthaka.hibernatedemo.model.EmpEducation;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.transaction.Transactional;

import javax.persistence.Query;
import java.util.List;

@Log4j
public class App2 {
    public void addEmpEducation() {
        EmpEducation empEducation = populateEmployee();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(empEducation);
            transaction.commit();
        } catch (Exception ex) {
            log.info("Error " + ex.getMessage());
        }
    }

    private void retrieveAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = (Query) session.createQuery("from EmpEducation");

            List<EmpEducation> empEducationList = query.getResultList();

            empEducationList.stream().forEach(ep -> {
                log.info(ep.getInstituteName() + "\t" + ep.getEducationName());
            });
            transaction.commit();
        } catch (Exception ex) {
            log.info("Error " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        App2 app2 = new App2();
        //app2.addEmpEducation();
        app2.retrieveAll();
    }


    private EmpEducation populateEmployee() {
        EmpEducation empEducation = new EmpEducation();
        //empEducation.setEmpId(2); // foreign key
        empEducation.setEducationName("Btech");
        empEducation.setInstituteName("WSU");
        empEducation.setPassingYear(2019);
        empEducation.setPercentage(78.88);
        empEducation.setType("ECE");

        return empEducation;
    }
}

