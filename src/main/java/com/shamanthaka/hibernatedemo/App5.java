package com.shamanthaka.hibernatedemo;

import com.shamanthaka.hibernatedemo.conf.HibernateUtil;
import com.shamanthaka.hibernatedemo.model.Project;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Log4j
public class App5 {
    public void addProject(){
        Project project = populateProject();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(project);
            transaction.commit();
        } catch (Exception ex){
            log.info("Error" + ex.getMessage());
        }

    }
    public void  updateProject(Project empProject){
        Session session = null;
        Transaction transaction = null;
        try{
            //session = HibernateUtil.getSessionFactory().openSession();
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.update(empProject);
            transaction.commit();
            log.info("updated project" + empProject.getProjectName());
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            };
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex) {
            }
        }
    }
    public void getAll(){
        Project project = populateProject();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            Query query = session.createQuery("from EmpProject");

            List<Project> empProjects = query.getResultList();
            empProjects.stream().forEach(e-> log.info(e.getProjectName() + "\t"+e.getProjectStatus()));

            transaction.commit();
        } catch (Exception ex){
            log.info(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        App5 app5 = new App5();
        app5.addProject();
        app5.getAll();
        //app5.updateProject(new EmpProject(2,"HotelManagement","Java","Incomplete",new Date(),new Date(),"Documentation"));
    }
    static  public Project populateProject(){
        Project project = new Project();
        project.setProjectName("ChatBot");
        project.setTechnologies("Python");
        project.setRemarks("has to be completed");
        project.setProjectStatus("Deployment");
        project.setStartDate(new Date());
        project.setEndDate(new Date());

        return project;
    }
}
