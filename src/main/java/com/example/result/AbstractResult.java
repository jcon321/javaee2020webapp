/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

/**
 *
 * @author jbuntu
 */
public abstract class AbstractResult<T extends Serializable> {

    private static final long serialVersionUID = 1L;

    private Integer returnCode = 0;
    private List<String> returnDescription = new ArrayList<>();

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public List<String> getReturnDescription() {
        return returnDescription;
    }

    public void setReturnDescription(List<String> returnDescription) {
        this.returnDescription = returnDescription;
    }

    public FacesResult getFacesResult() {
        FacesResult facesResult = new FacesResult();

        if (returnCode.equals(0)) {
            facesResult.setSeverity(FacesMessage.SEVERITY_INFO);
            facesResult.setHeader("Success");
        } else {
            facesResult.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesResult.setHeader("Error!");
        }

        return facesResult;
    }

}
