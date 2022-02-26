/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Student;
import com.pojos.User;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface userDao {
    public Integer addUser(User user);
    public void updateUser(User user);
    public List<User> getUsers();
    public void deleteStudent(Integer userId);
    public User getUserById(Integer userId);
    
}
