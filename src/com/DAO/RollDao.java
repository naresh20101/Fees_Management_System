/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Batch;
import com.pojos.Roll;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface RollDao {
    public List<Roll> getAllRoll();
    public Integer getRollByName(String rollName);
    public Roll getRollById(Integer rollId);
    public Integer addRoll( Roll roll);
    public void updateRoll(Roll roll);
    public void deleteRoll(Integer rollId);
   
    
}
