/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template conexion
 */
package Dao;

import Models.Factura;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class FacturaDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Factura> Listar(String obj){
        List<Factura> lista= new ArrayList<Factura>();
        String sql;
        if(obj==null){
            sql="SELECT * FROM Factura,Cliente,Empleado order by fac_codigo";
        }else{
            sql="SELECT * FROM factura WHERE cli_codigo = "+obj+"";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Factura pro=new Factura();
                    pro.setId(rs.getInt(1));
                    pro.setTimbrado(rs.getString(2));
                    
                    java.sql.Date sqlDate = rs.getDate(3); // Asumiendo que la columna de fecha es la tercera
                    if (sqlDate != null) {
                        pro.setFecha(sqlDate.toLocalDate());
                    }
                   
                    pro.setTotal(rs.getInt(4));
                    pro.setIdCliente(rs.getInt(5));
                    pro.setIdEmpleado(rs.getInt(6));
                    pro.setIdEstado(rs.getInt(7));
                    
                    lista.add(pro);
                }
            }else{
                System.out.println("no hay registros");
            }
            
        }catch(Exception e){
            System.out.println("error select "+sql);
        }        
        
        return lista;
    }
    
    public boolean agregar(Factura obj){
        
        boolean ban= false;
        String sql="INSERT INTO factura (fac_codigo, fac_timbrado, fac_fecha, fac_total, cli_codigo, emp_codigo, est_codigo)"
                +"VALUES (null, ?, CURDATE(), ?, ?, ?, ?);";
        try{
            this.conectar();
            pst= conn.prepareStatement(sql);
            pst.setString(1, obj.getTimbrado());
            pst.setInt(2,obj.getTotal());
            pst.setInt(3,obj.getIdCliente());
            pst.setInt(4,obj.getIdEmpleado());
            pst.setInt(5,obj.getIdEstado());
            
            
            if(pst.executeUpdate()>0){
                ban=true;
                System.out.println("se registros");
            }
            
            
        }catch(Exception e){
            System.out.println("error, no se registros "+sql);
        }
        
        
        return ban;
    }
    public boolean actualizar(Factura obj) {
        boolean ban = false;

        String sql = "UPDATE factura SET "
            + "fac_timbrado= ?,"
            + "fac_total = ?, "
            + "cli_codigo = ?, "
            + "emp_codigo = ?, "
            + "est_codigo = ? "
            + "WHERE fac_codigo = ?;";
        try {
            
            this.conectar();
            pst= conn.prepareStatement(sql);
            
            pst.setString(1, obj.getTimbrado());
            pst.setInt(2,obj.getTotal());
            pst.setInt(3,obj.getIdCliente());
            pst.setInt(4,obj.getIdEmpleado());
            pst.setInt(5,obj.getIdEstado());
            
            pst.setInt(6, obj.getId());
           
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
        
        String sql = "DELETE FROM Factura WHERE fac_codigo = ?";
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

    public List<Factura> informeCabecera(String obj){
        List<Factura> lista= new ArrayList<Factura>();
        String sql;
        if(obj==null){
            sql="SELECT fac_codigo, cli_nombre, fac_timbrado, fac_fecha,fac_total, estado.est_descripcion FROM cliente, factura, estado WHERE cliente.cli_codigo=factura.cli_codigo and estado.est_codigo=factura.est_codigo ORDER by factura.fac_codigo;";
        }else{
            sql="SELECT fac_codigo, cli_nombre, fac_timbrado, fac_fecha,fac_total, estado.est_descripcion FROM cliente, factura, estado WHERE cliente.cli_codigo=factura.cli_codigo and estado.est_codigo=factura.est_codigo, and factura.fac_codigo="+obj+" ORDER by factura.fac_codigo;";
                    
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Factura pro=new Factura();
                    pro.setId(rs.getInt(1));
                    
                    pro.setNombreCliente(rs.getString(2));
                    pro.setTimbrado(rs.getString(3));
                    
                    java.sql.Date sqlDate = rs.getDate(4);
                    if (sqlDate != null) {
                        pro.setFecha(sqlDate.toLocalDate());
                    }
                    pro.setTotal(rs.getInt(5));
                    pro.setDesEstado(rs.getString(6));
                    
                    lista.add(pro);
                }
            }else{
                System.out.println("no hay registros");
            }
            
        }catch(Exception e){
            System.out.println("error select"+sql);
        }        
        
        return lista;
    }
}
