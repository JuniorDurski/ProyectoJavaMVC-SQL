/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template conexion
 */
package Dao;

import Models.CompraDetalle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CompraDetalleDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<CompraDetalle> Listar(String obj){
        List<CompraDetalle> lista= new ArrayList<CompraDetalle>();
        String sql;
        if(obj==null){
            sql="Select * From compra_detalle order by com_det_descripcion";
        }else{
            sql="Select * from compra_detalle where com_det_descripcion like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    CompraDetalle pro=new CompraDetalle();
                    pro.setId(rs.getInt(1));
                    pro.setCantidad(rs.getInt(2));
                    pro.setIdCompra(rs.getInt(3));
                    pro.setIdProducto(rs.getInt(4));
                    
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
    
    public boolean agregar(CompraDetalle obj){
        
        boolean ban= false;
        String sql="INSERT INTO compra_detalle (com_det_codigo, com_det_cantidad, com_codigo, pro_codigo) "
                + "VALUES (NULL, ?, ?, ?); ";
        try{
            this.conectar();
            pst= conn.prepareStatement(sql);
            pst.setInt(1,obj.getCantidad());
            pst.setInt(2,obj.getIdCompra());
            pst.setInt(3,obj.getIdProducto());
            
            if(pst.executeUpdate()>0){
                ban=true;
                System.out.println("se registros");
            }
            
        }catch(Exception e){
            System.out.println("error, no se registros "+sql);
        }
        
        return ban;
    }
    public boolean actualizar(CompraDetalle obj) {
        boolean ban = false;

        String sql = "UPDATE compra_detalle SET"
            + " com_det_cantidad = ?,"
            + " com_det_precio = ?, "
            + " com_det_descripcion = ? "
            + " WHERE com_det_codigo = ?";
        try {
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, obj.getCantidad());
            pst.setInt(2, obj.getIdCompra());
            pst.setInt(3, obj.getIdProducto());
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
        
        String sql = "DELETE FROM compra_detalle WHERE com_det_codigo = ?";
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
