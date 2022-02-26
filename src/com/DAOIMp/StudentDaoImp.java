/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.StudentDao;
import com.dbManager.dbConnection;
import com.pojos.Batch;
import com.pojos.Fees;
import com.pojos.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class StudentDaoImp implements StudentDao {
  static Connection con = dbConnection.getDbConnection();

    @Override
    public Integer addStudent(Student student) {
         Integer row=null;
      try
      {
          Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into student(name,department,Phone_No,Address,date_of_addmition,Batch_id,fees_id,Status) values(?,?,?,?,?,?,?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
    
            
//            Date d = (Date)student.getDate_of_addmition();
            java.sql.Date sqlDate = new java.sql.Date(student.getDate_of_addmition().getTime());
            smt.setString(1, student.getName());
            smt.setString(2,student.getDepartment());
            smt.setInt(3,student.getPhone_No());
            smt.setString(4,student.getAddress());
            smt.setDate(5, sqlDate);
            smt.setInt(6, student.getBatch().getBatch_id());
            smt.setInt(7, student.getFees().getFees_id());
               
               
            row = smt.executeUpdate();
            System.out.println("Row : "+row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public void updateStudent(Student student) {
         try {
            String update = "update student set name=?,department=?,Phone_No=?,Address=?,date_of_addmition=?,Batch_id=?,fees_id=? where std_id=?";
            PreparedStatement smt = con.prepareStatement(update);
            java.sql.Date sqlDate = new java.sql.Date(student.getDate_of_addmition().getTime());
            smt.setString(1, student.getName());
            smt.setString(2,student.getDepartment());
            smt.setInt(3,student.getPhone_No());
            smt.setString(4,student.getAddress());
            smt.setDate(5, sqlDate);
            smt.setInt(6,student.getBatch().getBatch_id());
            smt.setInt(7,student.getFees().getFees_id());
            smt.setInt(8,student.getStd_id());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override 
    public List<Student> getStudents() {
         List<Student> list=new ArrayList<>();
        Connection con2 = dbConnection.getDbConnection();
        try {
            String query = "select * from student where Status=1";
            PreparedStatement smt = con2.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                Student s=new Student();
                s.setStd_id(rst.getInt("std_id"));
                s.setName(rst.getString("name"));
                s.setDepartment(rst.getString("department"));
                s.setPhone_No(rst.getInt("Phone_No"));
                s.setAddress(rst.getString("Address"));
                s.setDate_of_addmition(rst.getDate("date_of_addmition"));
                Batch b=new Batch();
                b.setBatch_id(rst.getInt("Batch_id"));
                s.setBatch(b);
                Fees f=new Fees();
                f.setFees_id(rst.getInt("fees_id"));
                s.setFees(f);
                list.add(s);
            }
        } catch (Exception ex) {
    }
        return list;
        
       
    }

    @Override
    public void deleteStudent(Integer std_id) {
         try
        {
            
            String delete = "update student set Status=0 where std_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, std_id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(Integer id) {
        Student s=new Student();
        try {
            String delete = "select * from student where std_id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, id);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                s.setStd_id(rst.getInt("std_id"));
                s.setName(rst.getString("name"));
                s.setDepartment(rst.getString("department"));
                s.setPhone_No(rst.getInt("Phone_No"));
                s.setAddress(rst.getString("Address"));
                s.setPhone_No(rst.getInt("Phone_No"));
                s.setDate_of_addmition(rst.getDate("date_of_addmition"));
               Batch b=new Batch();
               b.setBatch_id(rst.getInt("Batch_id"));
               s.setBatch(b);
               Fees f=new Fees();
               f.setFees_id(rst.getInt("fees_id"));
               s.setFees(f);
               
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return s;
    }

}