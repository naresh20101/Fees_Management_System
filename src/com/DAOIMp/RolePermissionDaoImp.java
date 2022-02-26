/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.RolePermissionDao;
import com.dbManager.dbConnection;
import com.pojos.Permissions;
import com.pojos.RolePermissions;
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
public class RolePermissionDaoImp implements RolePermissionDao {

    static Connection con = dbConnection.getDbConnection();
    @Override
    public Integer addRolePermission(RolePermissions rolePermission) { // Roll roll, Permission per
         Integer row = null;
        try {
            Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into role_permissions(permission_id,Roll_id,Status) values(?,?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
            
            smt.setInt(1, rolePermission.getPermission().getPermissionId()); /// roll.getRollId()
            smt.setInt(2, rolePermission.getRole().getRollId());
            row = smt.executeUpdate();
            System.out.println("Row : " + row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;

    }

    @Override
    public void updateRolePermission(RolePermissions rolePermission) {
        try {
            String update = "update role_permissions set permission_id=?,Roll_id=? where id=?";
            PreparedStatement smt = con.prepareStatement(update);
            smt.setInt(1, rolePermission.getPermission().getPermissionId());
            smt.setInt(2, rolePermission.getRole().getRollId());
            smt.setInt(3, rolePermission.getId());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
   
    }

    @Override
    public List<RolePermissions> getRolePermission() {
   List<RolePermissions> list = new ArrayList<>();
        try {
            String query = "select * from role_permissions where Status=1";
            PreparedStatement smt = con.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
               RolePermissions rp=new RolePermissions();
               rp.setId(rst.getInt("id"));
                Roll r=new Roll();
                r.setRollId(rst.getInt("Roll_id"));
                rp.setRole(r);
                Permissions p=new Permissions();
                p.setPermissionId(rst.getInt("permission_id"));
               rp.setPermission(p);
                
                list.add(rp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteRolePermission(Integer id) {
       
       try {

            String delete = "update role_permissions Set Status=0 where id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   
    }

    @Override
    public RolePermissions getRolePermissionById(Integer id) {
     RolePermissions r= new RolePermissions();
         try {
            String delete = "select * from role_permissions where id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, id);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
               r.setId(rst.getInt("id"));
               Roll roll=new Roll();
               roll.setRollId(rst.getInt("Roll_id"));
               r.setRole(roll);
               Permissions p=new Permissions();
               p.setPermissionId(rst.getInt("permission_id"));
               r.setPermission(p);
               
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return r;

    }
    
}
