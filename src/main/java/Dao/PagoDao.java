/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Pago;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PagoDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Pago> Listar(String obj){
        List<Pago> lista= new ArrayList<Pago>();
        String sql;
        if(obj==null){
            sql="Select * From pago ";
        }else {
            sql="Select * from pago where cli_codigo like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Pago pro=new Pago();
                    pro.setId(rs.getInt(1));
                    pro.setIdCliente(rs.getInt(2));
                    pro.setIdFactura(rs.getInt(3));
                    
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
    
    public boolean agregar(Pago obj){
        
        boolean ban= false;
        String sql="INSERT INTO pago (pago_codigo, cli_codigo, fac_codigo) "
                + "VALUES (NULL, ?, ?); ";
        try{
            this.conectar();
            pst= conn.prepareStatement(sql);
           
            pst.setInt(1,obj.getIdCliente());
            pst.setInt(2,obj.getIdFactura());
            
            if(pst.executeUpdate()>0){
                ban=true;
                System.out.println("se registros");
            }
            
            
        }catch(Exception e){
            System.out.println("error, no se registros "+sql);
        }
        
        
        return ban;
    }
    public boolean actualizar(Pago obj) {
        boolean ban = false;

        String sql = "UPDATE factura SET "
                + "fac_timbrado= ?,"
                + "fac_fecha = ?, "
                + "fac_total = ?, "
                + "cli_codigo = ?, "
                + "emp_codigo = ?, "
                + "est_codigo = ? "
                + "WHERE fac_codigo` = ?;";
        try {
            pst = conn.prepareStatement(sql);
            
//            pst.setString(1, obj.getTimbrado());
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
        
        String sql = "DELETE FROM pago WHERE pago_codigo = ?";
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
