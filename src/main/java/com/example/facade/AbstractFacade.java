/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.facade;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author jbuntu
 */
public abstract class AbstractFacade<T extends Serializable> {

    private static final Logger log = Logger.getLogger(AbstractFacade.class.getName());

    private final Class<T> entityClass;
    
    protected abstract EntityManager getEntityManager();

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) throws Exception {
        try {
            getEntityManager().persist(entity);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception: ", e);
            throw (e);
        }
    }

    public void edit(T entity) throws Exception {
        try {
            getEntityManager().merge(entity);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception: ", e);
            throw (e);
        }
    }

    public void remove(T entity) throws Exception {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception: ", e);
            throw (e);
        }
    }

    public T findById(Object id) {
        return (getEntityManager().find(entityClass, id));
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

}
