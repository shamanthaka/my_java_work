package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.conf.HibernateUtil;
import com.shamanthaka.hibernatedemo.model.EmpAddress;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

@Log4j
public class App4 {
    public void addEmpAddress(){
        EmpAddress empAddress = populateAddress();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(empAddress);
            transaction.commit();;
        }catch (Exception ex){
            log.info( "Error" +ex.getMessage());
        }
    }

    public void getAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Query query =(Query) session.createQuery("from EmpAddress");

            List<EmpAddress> empAddressList = query.getResultList();
            empAddressList.stream().forEach(e->{
                log.info(e.getAddress() + "\t"+ e.getZipCode());
            });
            transaction.commit();
        } catch (Exception ex){
            log.info("Error" + ex.getMessage());
        }
    }

    public static  EmpAddress populateAddress(){
        EmpAddress empAddress = new EmpAddress();
        //empAddress.setEmpId(1);
        empAddress.setAddress("Dayton");
        empAddress.setAddressType("Work");
        empAddress.setZipCode(34567);

        return empAddress;
    }

    public static void main(String[] args) {
        App4 app4 = new App4();
        //app4.addEmpAddress();
        app4.getAll();
    }
}
