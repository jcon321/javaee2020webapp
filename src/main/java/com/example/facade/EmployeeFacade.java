/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.facade;

import com.example.entity.Employee;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jbuntu
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> {

    private static final Logger log = Logger.getLogger(EmployeeFacade.class.getName());

    @PersistenceContext(unitName = "MainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    public List<Employee> findByName(String name) {

        Query q = getEntityManager().createQuery("select b from Employee b where b.name = :name").setParameter("name", name);

        List<Employee> result = (List<Employee>) q.getResultList();

        return (result);
    }
}
