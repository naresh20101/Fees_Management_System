/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.BatchClass;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface BatchClassDao {
    public Integer addBatchClass(BatchClass batchClass);
    public void updateBatchClass(BatchClass batchClass);
    public List<BatchClass> getBatchClass();
    public void deleteBatchClass(Integer id);
    public BatchClass getBatchClassById(Integer id);
    
}
