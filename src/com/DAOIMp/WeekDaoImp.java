/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.WeekDao;
import com.dbManager.dbConnection;
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
public class WeekDaoImp implements WeekDao {
    static Connection con = dbConnection.getDbConnection();

    @Override
    public List<Week> getAllWeeks() {
        List<Week> list=new ArrayList<>();
        try {
            String query = "select * from week where Status=1";
            PreparedStatement smt = con.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
              Week f  =new Week();
               f.setWeek_id(rst.getInt("week_id"));
               f.setWeek(rst.getString("week"));
                list.add(f);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Integer getWeekIdByWeek(String week) {
         Integer week_Id=0;
        try {
            String delete = "select week_id from week where week=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setString(1, week);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                week_Id=rst.getInt("week_id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return week_Id;
    }

    @Override
    public Week getWeekById(Integer week_id) {
         Week f  =new Week();
        try {
            String delete = "select * from week where week_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, week_id);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                f.setWeek_id(rst.getInt("week_id"));
                f.setWeek(rst.getString("week"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return f;
    }

    @Override
    public Integer addWeek(Week week) {
       Integer row = null;
        try {
            Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into week(week,Status) values(?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
            
            smt.setString(1,week.getWeek());
            row = smt.executeUpdate();
            System.out.println("Row : " + row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;

    }

    @Override
    public void updateWeek(Week week) {
        try {
            String update = "update week set week=? where week_id=?";
            PreparedStatement smt = con.prepareStatement(update);
            smt.setString(1, week.getWeek());
            smt.setInt(2, week.getWeek_id());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteWeek(Integer week_id) {
        try {

            String delete = "update week set Status=0 where week_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, week_id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }
    

