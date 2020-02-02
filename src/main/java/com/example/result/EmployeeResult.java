/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.result;

import com.example.entity.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jbuntu
 */
public class EmployeeResult extends AbstractResult<Employee> {

    private List<Employee> data = new ArrayList<>();

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }

}
