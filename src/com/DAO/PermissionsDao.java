/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Permissions;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface PermissionsDao {
    public List<Permissions> getAllPermissions();
    public Integer getPermissionIdByName(String permissionName);
    public Permissions getPermissionById(Integer permissionId);
    public Integer addPermission( Permissions permission);
    public void updatePermission(Permissions permission);
    public void deletePermission(Integer permissionId);
   
    
}
