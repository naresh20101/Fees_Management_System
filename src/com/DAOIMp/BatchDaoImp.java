/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.BatchDao;
import com.dbManager.dbConnection;
import com.pojos.Batch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class BatchDaoImp implements BatchDao {

    static Connection con = dbConnection.getDbConnection();

    @Override
    public List<Batch> getAllBatches() {
        List<Batch> list = new ArrayList<>();
        try {
            String query = "select * from batch where Status=1";
            PreparedStatement smt = con.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
                Batch batch = new Batch();
                batch.setBatch_id(rst.getInt("Batch_id"));
                batch.setBatch_name(rst.getString("Batch_name"));
                list.add(batch);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Integer getBatchByName(String Batch_name) {
        Integer batch_Id = 0;
        try {
            String delete = "select Batch_id from batch where Batch_name=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setString(1, Batch_name);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
                batch_Id = rst.getInt("Batch_id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return batch_Id;

    }

    @Override
    public Batch getBatchById(Integer Batch_id) {
        Batch db = new Batch();
        try {
            String delete = "select * from batch where Batch_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, Batch_id);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
                db.setBatch_id(rst.getInt("Batch_id"));
                db.setBatch_name(rst.getString("Batch_name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return db;
    }

    @Override
    public Integer addBatch(Batch batch) {
        Integer row = null;
        try {
            Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into batch(Batch_name,Status) values(?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
            
            smt.setString(1, batch.getBatch_name());
            row = smt.executeUpdate();
            System.out.println("Row : " + row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;

    }

    @Override
    public void updateBatch(Batch batch) {
        try {
            String update = "update batch set Batch_name=? where Batch_id=?";
            PreparedStatement smt = con.prepareStatement(update);
            smt.setString(1, batch.getBatch_name());
            smt.setInt(2, batch.getBatch_id());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBatch(Integer Batch_id) {
        try {

            String delete = "update  batch set Status=0 where Batch_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, Batch_id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
