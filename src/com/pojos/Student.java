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
public class Student extends MainPojo {
    private Integer std_id;
     private String name;
    private String Department;
    private Integer Phone_No;
    private String Address;
    private Date date_of_addmition;
    private Batch batch;
    private Fees fees;

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
    
            

    public Integer getStd_id() {
        return std_id;
    }

    public void setStd_id(Integer std_id) {
        this.std_id = std_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public Integer getPhone_No() {
        return Phone_No;
    }

    public void setPhone_No(Integer Phone_No) {
        this.Phone_No = Phone_No;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDate_of_addmition() {
        return date_of_addmition;
    }

    public void setDate_of_addmition(Date date_of_addmition) {
        this.date_of_addmition = date_of_addmition;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }
   
          
    
}
