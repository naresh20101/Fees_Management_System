 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.FeesDao;
import com.dbManager.dbConnection;
import com.pojos.Fees;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class FeesDaoImp implements FeesDao {
static Connection con = dbConnection.getDbConnection();
    @Override
    public List<Fees> getAllFees() {
        List<Fees> list=new ArrayList<>();
        try {
            String query = "select * from fees where Status=1";
            PreparedStatement smt = con.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
              Fees f  =new Fees();
               f.setFees_id(rst.getInt("fees_id"));
               f.setFees(rst.getInt("fees"));
                list.add(f);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
       
    }

    @Override
    public Integer getFeesIdByFees(Integer fees) {
        Integer fees_Id=0;
        try {
            String delete = "select fees_id from fees where fees=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, fees);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                fees_Id=rst.getInt("fees_id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fees_Id;
    }

    @Override
    public Fees getFeesById(Integer fees_id) {
        Fees f  =new Fees();
        try {
            String delete = "select * from fees where fees_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, fees_id);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                f.setFees_id(rst.getInt("fees_id"));
                f.setFees(rst.getInt("fees"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return f;
    }

    @Override
    public Integer addFees(Fees fees) {
      Integer row = null;
        try {
            Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into fees(fees,Status) values(?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
           
            smt.setInt(1, fees.getFees());
            row = smt.executeUpdate();
            System.out.println("Row : " + row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;

    }

    @Override
    public void updateFees(Fees fees) {
         try {
            String update = "update fees set fees=? where fees_id=?";
            PreparedStatement smt = con.prepareStatement(update);
            smt.setInt(1, fees.getFees());
            smt.setInt(2, fees.getFees_id());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteFees(Integer fees_id) {
        try {

            String delete = "update  fees set Status=0 where fees_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, fees_id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
