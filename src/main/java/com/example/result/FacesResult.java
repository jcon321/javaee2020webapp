/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.result;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

/**
 *
 * @author jbuntu
 */
public class FacesResult {

    private Severity severity;
    private String header;

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}
