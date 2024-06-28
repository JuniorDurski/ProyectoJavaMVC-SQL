/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template conexion
 */
package Dao;

import Models.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProductoDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Producto> Listar(String obj){
        List<Producto> lista= new ArrayList<Producto>();
        String sql;
        if(obj==null){
            sql="Select * From producto order by pro_descripcion";
        }else{
            sql="Select * from producto where pro_descripcion like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Producto pro=new Producto();
                    pro.setId(rs.getInt(1));
                    pro.setCantidad(rs.getInt(2));
                    pro.setPrecio(rs.getInt(3));
                    pro.setDescripcion(rs.getString(4));
                    
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
    
    public boolean agregar(Producto obj){
        
        boolean ban= false;
        String sql="INSERT INTO producto (pro_codigo, pro_cantidad, pro_precio, pro_descripcion) "
                + "VALUES (NULL, ?, ?, ?); ";
        try{
            this.conectar();
            pst= conn.prepareStatement(sql);
            pst.setInt(1,obj.getCantidad());
            pst.setInt(2,obj.getPrecio());
            pst.setString(3,obj.getDescripcion());
            
            if(pst.executeUpdate()>0){
                ban=true;
                System.out.println("se registros");
            }
            
            
        }catch(Exception e){
            System.out.println("error, no se registros "+sql);
        }
        
        
        return ban;
    }
    public boolean actualizar(Producto obj) {
        boolean ban = false;

        String sql = "UPDATE producto SET"
            + " pro_cantidad = ?,"
            + " pro_precio = ?, "
            + " pro_descripcion = ? "
            + " WHERE pro_codigo = ?";
        try {
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, obj.getCantidad());
            pst.setInt(2, obj.getPrecio());
            pst.setString(3, obj.getDescripcion());
            pst.setInt(4, obj.getId());
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
        
        String sql = "DELETE FROM producto WHERE pro_codigo = ?";
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
    
    public boolean inventario(Producto obj) {
        boolean ban = false;

        String sql = "UPDATE producto SET"
            + " pro_cantidad = ?"
            + " WHERE pro_codigo = ?";
        try {
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, obj.getCantidad());
            pst.setInt(2, obj.getId());
            
            if (pst.executeUpdate() > 0) {
            ban = true;
            System.out.println("se registro "+sql);
        }
        } catch (Exception e) {
            System.out.println("error, no se registro m-i "+sql);
            System.out.println("error, no se registro m-i "+pst);
        }
        return ban;
    
    }
    
}
