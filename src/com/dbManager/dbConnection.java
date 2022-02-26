/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbManager;

/**
 *
 * @author Dell
 */
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dell
 */
public class dbConnection {

    private static Connection con = null;

    public static Connection getDbConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management", "root", "engineer");
                System.out.println("Suucessfully Connected");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return con;
    }

}
