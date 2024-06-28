/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.*;

/**
 *
 * @author HP
 */
public class Conexion {
    Connection conn;
    String url="jdbc:mysql://127.0.0.1/optativoiiproyecto";
    String user="root";
    String pass="";
    
    public Connection conectar(){
        
        try{
           conn=DriverManager.getConnection(url,user,pass);
           
            if(conn!=null){
                System.out.println("si sql");
            }
           
        }catch(SQLException e){ 
            System.out.println("no sql");
        }
        return conn;
    }
    
//    public static void main(String args[]) {
//        Conexion hh= new Conexion();
//        hh.conectar();
//    }
}
