/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProveedorDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Proveedor> Listar(String obj){
        List<Proveedor> lista= new ArrayList<Proveedor>();
        String sql;
        if(obj==null){
            sql="Select * From proveedor order by pro_descripcion";
        }else{
            sql="Select * from proveedor where pro_descripcion like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Proveedor pro=new Proveedor();
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
    
    public boolean agregar(Proveedor obj){
        
        boolean ban= false;
        String sql="INSERT INTO proveedor (pro_codigo, pro_descripcion) "
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
    public boolean actualizar(Proveedor obj) {
        boolean ban = false;

        String sql = "UPDATE proveedor SET"
            + " pro_descripcion = ? "
            + " WHERE pro_codigo = ?";
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
        
        String sql = "DELETE FROM proveedor WHERE pro_codigo = ?";
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

}
