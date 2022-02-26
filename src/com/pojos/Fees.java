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
public class Fees extends MainPojo{
    private Integer fees_id;

    public Integer getFees_id() {
        return fees_id;
    }

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

    public void setFees_id(Integer fees_id) {
        this.fees_id = fees_id;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }
    private Integer fees;
    
}
