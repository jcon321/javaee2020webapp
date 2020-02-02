/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author jbuntu
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Transient
    private final ObjectMapper mapper = new ObjectMapper();

    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @Column(name = "date_revised")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRevised;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateRevised() {
        return dateRevised;
    }

    public void setDateRevised(Date dateRevised) {
        this.dateRevised = dateRevised;
    }

    @PrePersist
    private void preCreate() {
        this.setDateAdded(new Timestamp(new Date().getTime()));
    }

    @PreUpdate
    private void preUpdate() {
        this.setDateRevised(new Timestamp(new Date().getTime()));
    }

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (IOException e) {
            return null;
        }
    }
}
