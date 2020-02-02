/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bean;

import com.example.entity.Employee;
import com.example.facade.EmployeeFacade;
import com.example.result.EmployeeResult;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jbuntu
 */
@Stateless
public class MaintainEmployee {

    private static final Logger log = Logger.getLogger(MaintainEmployee.class.getName());

    @EJB
    private EmployeeFacade employeeFacade;

    public EmployeeResult addEmployee(Employee employee) {
        EmployeeResult result = validate(employee);
        if (result.getReturnCode().equals(0)) {
            try {
                employeeFacade.create(employee);
                result.setReturnCode(0);
                result.getReturnDescription().add("Employee added.");
                result.getData().add(employee);
                
                log.log(Level.INFO, "Employee added. {0}", employee.toString());
            } catch (Exception e) {
                result.setReturnCode(-1);
                result.getReturnDescription().add("Employee not added.");
                
                log.log(Level.SEVERE, "Employee not added. {0} with exception {1}", 
                        new Object[]{employee.toString(), e.toString()});
            }
        }
        
        return result;
    }

    public EmployeeResult validate(Employee employee) {
        EmployeeResult result = new EmployeeResult();
        List<String> errors = new ArrayList<>();

        // validate name
        if (employee.getName() == null || employee.getName().isBlank()) {
            errors.add("Name may not be blank.");
        }

        
        if (errors.size() > 0) {
            result.setReturnCode(-1);
            result.setReturnDescription(errors);
        }

        return result;
    }
}
