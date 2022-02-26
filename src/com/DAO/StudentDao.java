/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Student;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface StudentDao {
    public Integer addStudent(Student student);
    public void updateStudent(Student student);
    public List<Student> getStudents();
    public void deleteStudent(Integer std_id);
    public Student getStudentById(Integer id);
   
}
