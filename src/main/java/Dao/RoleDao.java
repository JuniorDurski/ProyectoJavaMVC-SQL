/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class RoleDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Role> Listar(String obj){
        List<Role> lista= new ArrayList<Role>();
        String sql;
        if(obj==null){
            sql="Select * From tipo_empleado order by tip_codigo";
        }else {
            sql="Select * from tipo_empleado where tip_descripcion like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Role pro=new Role();
                    pro.setId(rs.getInt(1));
                    pro.setDescripcion(rs.getString(2));
                    
                    lista.add(pro);
                }
                
            }else{
                System.out.println("no hay registros");
            }
            
        }catch(Exception e){
            System.out.println("error select");
        }        
        
        return lista;
    }
    
    public boolean agregar(Role obj){
        
        boolean ban= false;
        String sql="INSERT INTO tipo_empleado (tip_codigo, tip_descripcion) "
                + "VALUES (NULL, ?); ";
        try{
            this.conectar();
            pst= conn.prepareStatement(sql);
           
            pst.setString(1,obj.getDescripcion());
            
            if(pst.executeUpdate()>0){
                ban=true;
                System.out.println("se registros");
            }
            
            
        }catch(Exception e){
            System.out.println("error, no se registros "+sql);
        }
        
        
        return ban;
    }
    public boolean actualizar(Role obj) {
        boolean ban = false;

        String sql = "UPDATE tipo_empleado SET"
            + " tip_descripcion = ? "
            + " WHERE tip_codigo = ?";
        try {
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, obj.getDescripcion());
            pst.setInt(2, obj.getId());
            if (pst.executeUpdate() > 0) {
            ban = true;
            System.out.println("se registro "+sql);
        }
        } catch (Exception e) {
            System.out.println("error, no se registro "+sql);
        }
        return ban;
    
    }
    public boolean eliminar(int cod) {
        boolean ban = false;
        
        String sql = "DELETE FROM tipo_empleado WHERE tip_codigo = ?";
        try {
            
            pst = this.conn.prepareStatement(sql);
            pst.setInt(1, cod);
            
            if(pst.executeUpdate()>0) {
                ban = true;
                pst.close();
            }
            System.out.println("se registro "+sql);

        }catch (Exception e) {
            System.out.println("error, no se registro "+sql);
            ban=false;
        }
        
        return ban;

    } 
    
    public Role buscarPorId(int id) {
        Role role = null;
        String sql = "SELECT * FROM tipo_empleado WHERE tip_codigo = ?";

        try {
            this.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                role = new Role();
                role.setId(rs.getInt("tip_codigo"));
                role.setDescripcion(rs.getString("tip_descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por ID: " + e.getMessage());
        } 

        return role;
    }
    

}
