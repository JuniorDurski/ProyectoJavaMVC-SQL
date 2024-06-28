/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template conexion
 */
package Dao;

import Models.Compra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CompraDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Compra> Listar(String obj){
        List<Compra> lista= new ArrayList<Compra>();
        String sql;
        if(obj==null){
            sql="SELECT * FROM compra,proveedor,Empleado order by fac_codigo";
        }else{
            sql="SELECT * FROM compra WHERE emp_codigo = "+obj+" ORDER BY com_codigo DESC LIMIT 1";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Compra pro=new Compra();
                    pro.setId(rs.getInt(1));
                    
                    java.sql.Date sqlDate = rs.getDate(2);
                    if (sqlDate != null) {
                        pro.setFecha(sqlDate.toLocalDate());
                    }
                   
                    pro.setIdProveedor(rs.getInt(3));
                    pro.setIdEmpleado(rs.getInt(4));
                    
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
    
    public boolean agregar(Compra obj){
        
        boolean ban= false;
        String sql="INSERT INTO compra (com_codigo, com_fecha, pro_codigo ,emp_codigo)"
                +"VALUES (null, CURDATE(), ?, ?);";
        try{
            this.conectar();
            pst= conn.prepareStatement(sql);
            pst.setInt(1,obj.getIdProveedor());
            pst.setInt(2,obj.getIdEmpleado());
            
            
            if(pst.executeUpdate()>0){
                ban=true;
                System.out.println("se registros");
            }
            
            
        }catch(Exception e){
            System.out.println("error, no se registros "+sql);
        }
        
        
        return ban;
    }
    public boolean actualizar(Compra obj) {
        boolean ban = false;

        String sql = "UPDATE compra SET "
            + "pro_codigo = ?, "
            + "emp_codigo = ?, "
            + "WHERE com_codigo = ?;";
        try {
            
            this.conectar();
            pst= conn.prepareStatement(sql);
            
            pst.setInt(1,obj.getIdProveedor());
            pst.setInt(2,obj.getIdEmpleado());
            
            pst.setInt(3, obj.getId());
           
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
        
        String sql = "DELETE FROM compra WHERE com_codigo = ?";
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

    public List<Compra> informeCabecera(String obj){
        List<Compra> lista= new ArrayList<Compra>();
        String sql;
        if(obj==null){
            sql="SELECT compra.com_codigo, compra.com_fecha,proveedor.pro_descripcion, empleado.emp_nombre, empleado.emp_apellido "
                    + "FROM compra, compra_detalle, proveedor,empleado "
                    + "WHERE compra.pro_codigo=proveedor.pro_codigo "
                    + "and compra.com_codigo=compra_detalle.com_codigo "
                    + "and empleado.emp_codigo=compra.emp_codigo "
                    + "ORDER by com_codigo;";
        }else{
            sql="SELECT compra.com_codigo, compra.com_fecha,proveedor.pro_descripcion, empleado.emp_nombre, empleado.emp_apellido "
                    + "FROM compra, compra_detalle, proveedor,empleado "
                    + "WHERE compra.pro_codigo=proveedor.pro_codigo "
                    + "and compra.com_codigo=compra_detalle.com_codigo "
                    + "and empleado.emp_codigo=compra.emp_codigo "
                    + "and compra.com_codigo="+obj+" "
                    + "ORDER by com_codigo;";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Compra pro=new Compra();
                    pro.setId(rs.getInt(1));
                    
                    java.sql.Date sqlDate = rs.getDate(2);
                    if (sqlDate != null) {
                        pro.setFecha(sqlDate.toLocalDate());
                    }
                   
                    pro.setDesProveedor(rs.getString(3));
                    pro.setDesEmpleado(rs.getString(4)+" "+rs.getString(5));
                    
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
