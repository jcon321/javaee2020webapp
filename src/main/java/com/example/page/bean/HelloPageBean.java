/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.page.bean;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jbuntu
 */
@Named
@SessionScoped
public class HelloPageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(HelloPageBean.class.getName());

    public String getHello() {
        return "Hello from JSF";
    }
    
}
