package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.conf.HibernateUtil;
import com.shamanthaka.hibernatedemo.model.EmployeePersonal;
import com.shamanthaka.hibernatedemo.util.ObjectPopulator;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Log4j
public class App1 {
    public void addEmp() {
        EmployeePersonal employeePersonal = populateEmployee();
             Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employeePersonal);
            transaction.commit();
        } catch (Exception ex) {
            log.info("Error " + ex.getMessage());
        }

    }

    public void updateEmp(EmployeePersonal employeePersonal) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(employeePersonal);
            transaction.commit();;
            log.info("updated employee" + employeePersonal.getEmpName());
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            };
        } finally {
            try {
                if(session != null){
                    session.close();
                }
            } catch(Exception ex) {

            }
        }


    }


    public void deleteEmployee(EmployeePersonal emp) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(emp);
            transaction.commit();
            log.info("deleted employee: "+emp.getEmpName());
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
    }

    public void getAll(){
        EmployeePersonal employeePersonal = populateEmployee();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query query =  session.createQuery("from EmployeePersonal ");// use class name

            List<EmployeePersonal> employeePersonalList = query.getResultList();

            /*for(EmployeePersonal e : employeePersonalList){
                log.info(e.getEmpName() + "  \t" +e.getEmpName());
            }*/
            employeePersonalList.stream().forEach( ep -> {
                log.info(ep.getEmpName() + "\t" + ep.getEmpEmail());
            });
//            employeePersonalList.stream().forEach(e ->{
//                log.info(e.getEmpName() + "  \t" +e.getEmpName());
//            });

            transaction.commit();
        } catch (Exception ex) {
            log.info("Error " + ex.getMessage());
        }

    }


    public static void main(String[] args) {
        App1 app1 = new App1();
        //app1.addEmp();
        app1.getAll();
        //app1.deleteEmployee(new EmployeePersonal(12, "Suman", new Date(),"", "",new Date()));
        app1.updateEmp(ObjectPopulator.populateEmployeePersonal("Srijan","343434","srijan@email.com",new Date(),new Date()));
        app1.getAll();
    }

    public static EmployeePersonal populateEmployee() {
        EmployeePersonal employeePersonal = new EmployeePersonal();
        employeePersonal.setEmpName("Shamanthaka");
        employeePersonal.setDob(new Date());
        employeePersonal.setDoj(new Date());
        employeePersonal.setEmpContact("3433434434");
        employeePersonal.setEmpEmail("vinny@yahoo.in");


        return employeePersonal;
    }
}
