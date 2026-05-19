/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */

import java.sql.*;

public class Connector {
    private static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static String nama_db = "recruit_db";
    private static String url_db = "jdbc:mysql://localhost:3307/" + nama_db;
    private static String user = "root";
    private static String pass = "";
    
    static Connection conn;
    
    public static Connection Connect(){
        try{
            Class.forName(jdbc_driver);
            
            conn = DriverManager.getConnection(url_db, user, pass);
            
            System.out.println("Sistem Berhasil");
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Koneksi Gagal terhubung" + e.getLocalizedMessage());
        }
        return conn;
    }
            
}
