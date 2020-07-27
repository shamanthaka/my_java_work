package com.shamanthaka.hibernatedemo.conf;


import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
@Log4j
@SuppressWarnings("unchecked")
public abstract class AbstractSimpleGenericDao<C, I extends Serializable> {

    Class<C> entityClass;

    protected Session hSession;
    protected Transaction hTransaction;

    public AbstractSimpleGenericDao() {
        hSession = HibernateUtil.getSessionFactory().openSession();
        hTransaction = hSession.getTransaction();
        entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<C> getAll() {
        try {
            CriteriaQuery<C> criteriaQuery = hSession.getCriteriaBuilder().createQuery(entityClass);
             criteriaQuery.from(entityClass);
            return hSession.createQuery(criteriaQuery).list();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public C get(I id) {
        try {
            return (C) hSession.get(entityClass, id);
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public C save(C object) {
        try {
            hTransaction.begin();
            hSession.save(object);
            hTransaction.commit();
        } catch (HibernateException e) {
            hTransaction.rollback();
            log.error(e.getMessage());
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
        return object;
    }

    public C update(C object) {
        try {
            hTransaction.begin();
            hSession.update(object);
            hTransaction.commit();
        } catch (HibernateException e) {
            hTransaction.rollback();
            log.error(e.getMessage());
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
        return object;
    }

    public C delete(I id) {
        C actual;
        try {
            hTransaction.begin();
             actual = get(id);
            hSession.delete(actual);
            hTransaction.commit();
        } catch (HibernateException e) {
            hTransaction.rollback();
            log.error(e.getMessage());
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
        return actual;
    }
}
