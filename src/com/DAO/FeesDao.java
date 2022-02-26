/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Fees;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface FeesDao {
    public List<Fees> getAllFees();
    public Integer getFeesIdByFees(Integer fees);
    public Fees getFeesById(Integer fees_id);
     public Integer addFees( Fees fees);
    public void updateFees(Fees fees);
    public void deleteFees(Integer fees_id);
    
}
