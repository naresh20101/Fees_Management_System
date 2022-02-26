/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Batch;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface BatchDao {
    public List<Batch> getAllBatches();
    public Integer getBatchByName(String Batch_name);
    public Batch getBatchById(Integer Batch_id);
    public Integer addBatch( Batch batch);
    public void updateBatch(Batch batch);
    public void deleteBatch(Integer Batch_id);
   
    
    
}
