/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOIMp;

import com.DAO.StudentFeesDao;
import com.dbManager.dbConnection;
import com.pojos.Batch;
import com.pojos.Student_Fees;
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
public class StudentFeesDaoImp implements StudentFeesDao{
  static Connection con = dbConnection.getDbConnection();
    @Override
    public Integer addStudentFees(Student_Fees studentFees) {
          Integer row=null;
      try
      {
          Connection con1 = dbConnection.getDbConnection();
            String addQuery = "insert into student_fees(id,Batch_id,week_id,No_of_classes,class_date,Status) values(?,?,?,?,?,1)";
            PreparedStatement smt = con1.prepareStatement(addQuery);
            smt.setInt(1,studentFees.getId());
            smt.setInt(2,studentFees.getBatch().getBatch_id());
            smt.setInt(3, studentFees.getWeek().getWeek_id());
            smt.setInt(4,studentFees.getNo_of_classes());
            smt.setDate(5, studentFees.getClass_date());
            row = smt.executeUpdate();
            System.out.println("Row : "+row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
    @Override
    public void updateStudentFees(Student_Fees studentFees) {
         try {
            String update = "update student_fees set Batch_id,week_id,No_of_classes,class_date where id=?";
            PreparedStatement smt = con.prepareStatement(update);
            smt.setInt(1,studentFees.getBatch().getBatch_id());
            smt.setInt(2, studentFees.getWeek().getWeek_id());
            smt.setInt(3,studentFees.getNo_of_classes());
            smt.setDate(4, studentFees.getClass_date());
            smt.setInt(5,studentFees.getId());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Student_Fees> getStudentsFees() {
        List<Student_Fees> list=new ArrayList<>();
        Connection con2 = dbConnection.getDbConnection();
        try {
            String query = "select * from student_fees where Status=1";
            PreparedStatement smt = con2.prepareStatement(query);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                Student_Fees s=new Student_Fees();
                s.setId(rst.getInt("id"));
                Batch b=new Batch();
                b.setBatch_id(rst.getInt("Batch_id"));
                s.setBatch(b);
                Week f=new Week();
                f.setWeek_id(rst.getInt("week_id"));
                s.setWeek(f);
                s.setNo_of_classes(rst.getInt("No_of_classes"));
                s.setClass_date(rst.getDate("class_date"));
                list.add(s);
            }
        } catch (Exception ex) {
    }
        return list;
        
       
    }

    @Override
    public void deleteStudentFees(Integer id) {
        try
        {
            
            String delete = "update  student_fees set Status=0 where id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Student_Fees getStudentFeesById(Integer id) {
         Student_Fees s=new Student_Fees();
        try {
            String delete = "select * from student_fees where id=?";
            PreparedStatement smt = con.prepareStatement(delete);
            smt.setInt(1, id);
            ResultSet rst = smt.executeQuery();
            while(rst.next()){
                s.setId(rst.getInt("id"));
                s.setNo_of_classes(rst.getInt("No_of_classes"));
                s.setClass_date(rst.getDate("class_date"));
               
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return s;
        
    }

   
    
}
