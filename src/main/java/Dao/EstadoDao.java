/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Estado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class EstadoDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Estado> Listar(String obj){
        List<Estado> lista= new ArrayList<Estado>();
        String sql;
        if(obj==null){
            sql="Select * From estado order by est_codigo";
        }else{
            sql="Select * from estado where est_descripcion like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Estado pro=new Estado();
                    pro.setId(rs.getInt(1));
                    pro.setDescripcion(rs.getString(2));
                    
                    lista.add(pro);
                }
            }else{
                System.out.println("no hay registros");
            }
            
        }catch(Exception e){
            System.out.println("error select estado");
        }        
        
        return lista;
    }
    
    public boolean agregar(Estado obj){
        
        boolean ban= false;
        String sql="INSERT INTO estado (est_codigo, est_descripcion) "
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
    public boolean actualizar(Estado obj) {
        boolean ban = false;

        String sql = "UPDATE estado SET"
            + " est_descripcion = ? "
            + " WHERE est_codigo = ?";
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
        
        String sql = "DELETE FROM estado WHERE est_codigo = ?";
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
    public Estado buscarPorId(String id) {
        Estado est = null;
        String sql = "SELECT * FROM estado WHERE "+id+"";
        System.out.println("buscar"+sql);
        try {
            this.conectar();
            pst = conn.prepareStatement(sql);
            //pst.setString(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                est = new Estado();
                est.setId(rs.getInt("est_codigo"));
                est.setDescripcion(rs.getString("est_descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por ID: " + e.getMessage());
        } 

        return est;
    }
}
