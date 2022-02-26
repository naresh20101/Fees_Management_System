/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.RolePermissions;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface RolePermissionDao {
    public Integer addRolePermission(RolePermissions rolePermission);
    public void updateRolePermission(RolePermissions rolePermission);
    public List<RolePermissions> getRolePermission();
    public void deleteRolePermission(Integer id);
    public RolePermissions getRolePermissionById(Integer id);
    
}
