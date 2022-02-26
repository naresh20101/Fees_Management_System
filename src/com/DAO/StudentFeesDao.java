/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Student;
import com.pojos.Student_Fees;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface StudentFeesDao {
    public Integer addStudentFees(Student_Fees studentFees);
    public void updateStudentFees(Student_Fees studentFees);
    public List<Student_Fees>getStudentsFees();
    public void deleteStudentFees(Integer id);
    public Student_Fees getStudentFeesById(Integer id);
}
 
