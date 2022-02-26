/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class BatchClass extends MainPojo {
    private Integer id;
    private Batch batch;
    private Week week;

    @Override
    public void setStatus(Integer status) {
        super.setStatus(status); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getStatus() {
        return super.getStatus(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setModifiedBy(String modifiedBy) {
        super.setModifiedBy(modifiedBy); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModifiedBy() {
        return super.getModifiedBy(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        super.setModifiedDate(modifiedDate); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getModifiedDate() {
        return super.getModifiedDate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCreatedBy(String createdBy) {
        super.setCreatedBy(createdBy); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCreatedBy() {
        return super.getCreatedBy(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        super.setCreatedDate(createdDate); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getCreatedDate() {
        return super.getCreatedDate(); //To change body of generated methods, choose Tools | Templates.
    }
    private Integer noOfClasses;
    private Date classDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Integer getNoOfClasses() {
        return noOfClasses;
    }

    public void setNoOfClasses(Integer noOfClasses) {
        this.noOfClasses = noOfClasses;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }
    
    
    
}
