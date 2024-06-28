/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template conexion
 */
package Dao;

import Models.FacturaDetalle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class FacturaDetalleDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<FacturaDetalle> Listar(String obj){
        List<FacturaDetalle> lista= new ArrayList<FacturaDetalle>();
        String sql;
        if(obj==null){
            sql="Select * From factura_detalle";
        }else{
            sql="Select * from factura_detalle where pro_descripcion like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    FacturaDetalle pro=new FacturaDetalle();
                    pro.setId(rs.getInt(1));
                    pro.setIdFac(rs.getInt(2));
                    pro.setIdProducto(rs.getInt(3));
                    pro.setFacDetCantidad(rs.getInt(4));
                    pro.setFacDetSubtotal(rs.getInt(5));
                    
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
    
    public boolean agregar(FacturaDetalle obj){
        
        boolean ban= false;
        String sql="INSERT INTO factura_detalle (fac_det_codigo, fac_codigo, pro_codigo, fac_det_cantidad, fac_det_subtotal) "
                + "VALUES (NULL, ?, ?, ?, ?); ";
        try{
            this.conectar();
            pst= conn.prepareStatement(sql);
            pst.setInt(1,obj.getIdFac());
            pst.setInt(2,obj.getIdProducto());
            pst.setInt(3,obj.getFacDetCantidad());
            pst.setInt(4,obj.getFacDetSubtotal());
                        
            if(pst.executeUpdate()>0){
                ban=true;
                System.out.println("se registros");
            }
            
            
        }catch(Exception e){
            System.out.println("error, no se registros "+sql);
        }
        
        
        return ban;
    }
    public boolean actualizar(FacturaDetalle obj) {
        boolean ban = false;

        String sql = "UPDATE factura_detalle SET"
            + " fac_codigo = ?,"
            + " pro_codigo = ?, "
            + " fac_det_cantidad = ? "
            + " fac_det_subtotal = ? "
            + " WHERE fac_det_codigo = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,obj.getIdFac());
            pst.setInt(2,obj.getIdProducto());
            pst.setInt(3,obj.getFacDetCantidad());
            pst.setInt(4,obj.getFacDetSubtotal());
            pst.setInt(5,obj.getId());
            
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
        
        String sql = "DELETE FROM factura_detalle WHERE fac_det_codigo = ?";
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
