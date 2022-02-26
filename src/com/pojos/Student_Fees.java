/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class Student_Fees extends MainPojo{
    private Integer id;
   
    private Week week;
    private Batch batch;
    private Integer No_of_classes;
    private Date class_date;

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
    public void setModifiedDate(java.util.Date modifiedDate) {
        super.setModifiedDate(modifiedDate); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public java.util.Date getModifiedDate() {
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
    public void setCreatedDate(java.util.Date createdDate) {
        super.setCreatedDate(createdDate); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public java.util.Date getCreatedDate() {
        return super.getCreatedDate(); //To change body of generated methods, choose Tools | Templates.
    }


    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Integer getNo_of_classes() {
        return No_of_classes;
    }

    public void setNo_of_classes(Integer No_of_classes) {
        this.No_of_classes = No_of_classes;
    }

    public Date getClass_date() {
        return class_date;
    }

    public void setClass_date(Date class_date) {
        this.class_date = class_date;
    }
    
    
}
