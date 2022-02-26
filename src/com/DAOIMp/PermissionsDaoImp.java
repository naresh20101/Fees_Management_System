/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.PermissionsDao;
import com.dbManager.dbConnection;
import com.pojos.Permissions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class PermissionsDaoImp implements PermissionsDao{
    static Connection con = dbConnection.getDbConnection();

    @Override
    public List<Permissions> getAllPermissions() {
          List<Permissions> list = new ArrayList<>();
        try {
            String query = "select * from permissions where Status=1";
            PreparedStatement smt = con.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
                Permissions p=new Permissions();
                p.setPermissionId(rst.getInt("permission_id"));
                p.setPermission(rst.getString("permission"));
                list.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
   
    }

    @Override
    public Integer getPermissionIdByName(String permissionName) {
         Integer permissionId = 0;
        try {
            String delete = "select permission_id from permissions where permission=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setString(1, permissionName);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
                permissionId = rst.getInt("permission_id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return permissionId;
        
    }

    @Override
    public Permissions getPermissionById(Integer permissionId) {
       Permissions p = new Permissions();
        try {
            String delete = "select * from permissions where permission_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, permissionId);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
                p.setPermissionId(rst.getInt("permission_id"));
                p.setPermission(rst.getString("permission"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return p;
    }

    @Override
    public Integer addPermission(Permissions permission) {
    Integer row = null;
        try {
            Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into permissions(permission,Status) values(?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
            
            smt.setString(1, permission.getPermission());
            row = smt.executeUpdate();
            System.out.println("Row : " + row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public void updatePermission(Permissions permission) {
        try {
            String update = "update permissions set permission=? where permission_id=?";
            PreparedStatement smt = con.prepareStatement(update);
            smt.setString(1, permission.getPermission());
            smt.setInt(2, permission.getPermissionId());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePermission(Integer permissionId) {
         try {

            String delete = "update permissions Set Status=0 where permission_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, permissionId);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   
    }
    
}
