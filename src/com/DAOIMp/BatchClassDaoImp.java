/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.BatchClassDao;
import com.dbManager.dbConnection;
import com.pojos.Batch;
import com.pojos.BatchClass;
import com.pojos.Student;
import com.pojos.Week;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class BatchClassDaoImp implements BatchClassDao{
     static Connection con = dbConnection.getDbConnection();

    @Override
    public Integer addBatchClass(BatchClass batchClass) {
         Integer row=null;
      try
      {
          Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into batch_class(Batch_id,week_id,no_of_classes,class_date,Status) values(?,?,?,?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
    
            
//            Date d = (Date)student.getDate_of_addmition();
            java.sql.Date sqlDate = new java.sql.Date(batchClass.getClassDate().getTime());
            
           
          
            smt.setInt(1, batchClass.getBatch().getBatch_id());
            smt.setInt(2, batchClass.getWeek().getWeek_id());
            smt.setInt(3, batchClass.getNoOfClasses());
            smt.setDate(4, sqlDate);
            
               
               
            row = smt.executeUpdate();
            System.out.println("Row : "+row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
        
    }

    @Override
    public void updateBatchClass(BatchClass batchClass) {
        try {
            String update = "update batch_class set Batch_id=?,week_id=?,no_of_classes=?,class_date=? where Id=?";
            PreparedStatement smt = con.prepareStatement(update);
            java.sql.Date sqlDate = new java.sql.Date(batchClass.getClassDate().getTime());
            
           
            smt.setInt(1, batchClass.getBatch().getBatch_id());
            smt.setInt(2, batchClass.getWeek().getWeek_id());
            smt.setInt(3, batchClass.getNoOfClasses());
            smt.setDate(4, sqlDate);
            smt.setInt(5, batchClass.getId());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<BatchClass> getBatchClass() {
       List<BatchClass> list=new ArrayList<>();
        Connection con2 = dbConnection.getDbConnection();
        try {
            String query = "select * from batch_class where Status=1";
            PreparedStatement smt = con2.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                BatchClass batchClass=new BatchClass();
                batchClass.setId(rst.getInt("Id"));
                Batch b=new Batch();
                b.setBatch_id(rst.getInt("Batch_id"));
                batchClass.setBatch(b);
                Week w=new Week();
                w.setWeek_id(rst.getInt("week_id"));
                batchClass.setWeek(w);
                batchClass.setNoOfClasses(rst.getInt("no_of_classes"));
                batchClass.setClassDate(rst.getDate("class_date"));
                list.add(batchClass);
            }
        } catch (Exception ex) {
    }
        return list;
    }
    

    @Override
    public void deleteBatchClass(Integer id) {
         try
        {
            
            String delete = "update  batch_class set Status=0 where Id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public BatchClass getBatchClassById(Integer id) {
       BatchClass batchClass=new BatchClass();
        try {
            String delete = "select * from batch_class  where Id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, id);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                batchClass.setId(rst.getInt("Id"));
                Batch b=new Batch();
                b.setBatch_id(rst.getInt("Batch_id"));
                batchClass.setBatch(b);
                Week w=new Week();
                w.setWeek_id(rst.getInt("week_id"));
                batchClass.setWeek(w);
                batchClass.setNoOfClasses(rst.getInt("no_of_classes"));
                batchClass.setClassDate(rst.getDate("class_date"));
                
        }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return batchClass;
    }
        
    }
    

