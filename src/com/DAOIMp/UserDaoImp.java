/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.userDao;
import com.dbManager.dbConnection;
import com.pojos.Roll;
import com.pojos.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class UserDaoImp implements userDao {
    static Connection con = dbConnection.getDbConnection();
    @Override
    public Integer addUser(User user) {
        Integer row=null;
      try
      {
          Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into user(user_name,passward,email,phone_No,address,Roll_id,Status) values(?,?,?,?,?,?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
            smt.setString(1, user.getUserName());
            smt.setString(2,user.getPassword());
            smt.setString(3,user.getEmail());
            smt.setString(4,user.getPhoneNo());
            smt.setString(5,user.getAddress() );
            smt.setInt(6, user.getRoll().getRollId());
            row = smt.executeUpdate();
            System.out.println("Row : "+row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public void updateUser(User user) {
        try
      {
        
            String addQuery = "update user set user_name=?,passward=?,email=?,phone_No=?,address=?,Roll_id=? where user_id=?";
            PreparedStatement smt = con.prepareStatement(addQuery);
            smt.setString(1, user.getUserName());
            smt.setString(2,user.getPassword());
            smt.setString(3,user.getEmail());
            smt.setString(4,user.getPhoneNo());
            smt.setString(5,user.getAddress() );
            smt.setInt(6, user.getRoll().getRollId());
            smt.setInt(7, user.getUserId());
            smt.executeUpdate();
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public List<User> getUsers() {
        List<User> list=new ArrayList<>();
        Connection con2 = dbConnection.getDbConnection();
        try {
            String query = "select * from user where Status=1";
            PreparedStatement smt = con2.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                
                User u=new User();
                u.setUserId(rst.getInt("user_id"));
                u.setUserName(rst.getString("user_name"));
                u.setPassword(rst.getString("passward"));
                u.setEmail(rst.getString("email"));
                u.setPhoneNo(rst.getString("phone_No"));
                u.setAddress(rst.getString("address"));
               Roll r=new Roll();
               r.setRollId(rst.getInt("Roll_id"));
               u.setRoll(r);
                
                list.add(u);
            }
        } catch (Exception ex) {
    }
        return list;
        
    }

    @Override
    public void deleteStudent(Integer userId) {
        try
        {
         String delete = "update user set Status=0 where user_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, userId);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User getUserById(Integer userId) {
         User u=new User();
        try {
            String delete = "select * from user where user_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, userId);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                
                u.setUserId(rst.getInt("user_id"));
                u.setUserName(rst.getString("user_name"));
                u.setPassword(rst.getString("passward"));
                u.setEmail(rst.getString("email"));
                u.setPhoneNo(rst.getString("phone_No"));
                u.setAddress(rst.getString("address"));
                Roll r=new Roll();
               r.setRollId(rst.getInt("Roll_id"));
               u.setRoll(r);
                
                
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return u  ;
    }
    }
    
