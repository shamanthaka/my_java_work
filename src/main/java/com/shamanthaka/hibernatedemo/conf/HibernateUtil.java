package com.shamanthaka.hibernatedemo.conf;

import com.shamanthaka.hibernatedemo.model.*;
import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

@Log4j
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
            //    properties.put(Environment.DRIVER, "");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/my_test_db_name?useSSL=false");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(EmployeePersonal.class);
                configuration.addAnnotatedClass(EmpEducation.class);
                configuration.addAnnotatedClass(EmpDocument.class);
                configuration.addAnnotatedClass(EmpAddress.class);
                configuration.addAnnotatedClass(EmpProjectAllocation.class);
                configuration.addAnnotatedClass(Project.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }catch (Exception ex) {
            log.info(ex.getMessage());
            }
        }
        return sessionFactory;
    }
}
