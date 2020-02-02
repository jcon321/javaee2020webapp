/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import javax.persistence.Entity;

/**
 *
 * @author jbuntu
 */
@Entity
public class Employee extends AbstractEntity {

    private String name;

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
