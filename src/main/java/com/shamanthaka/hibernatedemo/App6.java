package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.conf.HibernateUtil;
import com.shamanthaka.hibernatedemo.model.EmpProjectAllocation;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

@Log4j
public class App6 {
    public void addEmpProjAlloc(){
        EmpProjectAllocation empProjectAllocation = populateProjectAlloc();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(empProjectAllocation);
            transaction.commit();
        } catch (Exception ex){
            log.info("Error"  + ex.getMessage());
        }

    }

    public void getAll(){
        EmpProjectAllocation empProjectAllocation = populateProjectAlloc();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query query = (Query) session.createQuery("from EmpProjectAllocation");

            List<EmpProjectAllocation> empProjectAllocationList = query.getResultList();
            empProjectAllocationList.stream().forEach(e-> log.info(e.getAllocationStatus()));

            transaction.commit();;
        }catch(Exception ex){
            log.info(ex.getMessage());
        }

    }

    static  public EmpProjectAllocation populateProjectAlloc(){
        EmpProjectAllocation empProjectAllocation = new EmpProjectAllocation();
       //empProjectAllocation.setEmpId(1);
        empProjectAllocation.setProjectId(2);
        empProjectAllocation.setAllocationStatus("allocate");

        return empProjectAllocation;
    }

    public static void main(String[] args) {
        App6 app6 = new App6();
        app6.addEmpProjAlloc();
        //app6.getAll();
    }


}
