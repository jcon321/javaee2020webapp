/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.page.bean;

import com.example.entity.Employee;
import com.example.result.EmployeeResult;
import com.example.webapplication.resources.EmployeeResource;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jbuntu
 */
@Named
@SessionScoped
public class EmployeePageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(EmployeePageBean.class.getName());

    @EJB
    private EmployeeResource employeeResource;

    private String name;

    public void addEmployee() {
        Employee employee = new Employee();
        employee.setName(name);

        EmployeeResult result = (EmployeeResult) employeeResource.addEmployee(employee).getEntity();

        for (String returnDescription : result.getReturnDescription()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    result.getFacesResult().getSeverity(),
                    result.getFacesResult().getHeader(),
                    returnDescription));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
