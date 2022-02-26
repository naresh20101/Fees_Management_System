/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.RollDao;
import com.dbManager.dbConnection;
import com.pojos.Roll;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class RollDooImp implements RollDao{
    static Connection con = dbConnection.getDbConnection();

    @Override
    public List<Roll> getAllRoll() {
         List<Roll> list = new ArrayList<>();
        try {
            String query = "select * from role where Status=1";
            PreparedStatement smt = con.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
               
                Roll r=new Roll();
                r.setRollId(rst.getInt("Roll_id"));
                r.setRoleName(rst.getString("role"));
                list.add(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Integer getRollByName(String rollName) {
         Integer rollId = 0;
        try {
            String delete = "select Roll_Id from role where role=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setString(1, rollName);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
                rollId = rst.getInt("Roll_id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rollId;

    }

    @Override
    public Roll getRollById(Integer rollId) {
        Roll r= new Roll();
         try {
            String delete = "select * from role where Roll_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, rollId);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
               r.setRollId(rst.getInt("Roll_id"));
               r.setRoleName(rst.getString("role"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return r;

    }

    @Override
    public Integer addRoll(Roll roll) {
         Integer row = null;
        try {
            Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into role(role,Status) values(?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
            
            smt.setString(1, roll.getRoleName());
            row = smt.executeUpdate();
            System.out.println("Row : " + row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;

    }

    @Override
    public void updateRoll(Roll roll) {
         try {
            String update = "update role set role=? where Roll_id=?";
            PreparedStatement smt = con.prepareStatement(update);
            smt.setString(1, roll.getRoleName());
            smt.setInt(2, roll.getRollId());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteRoll(Integer rollId) {
      try {

            String delete = "update role Set Status=0 where Roll_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, rollId);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
