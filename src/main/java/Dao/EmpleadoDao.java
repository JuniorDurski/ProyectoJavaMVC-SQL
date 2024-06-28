/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class EmpleadoDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Empleado> Listar(String obj){
        List<Empleado> lista= new ArrayList<Empleado>();
        String sql;
        if(obj==null){
            sql="Select * From empleado";
        }else{
            sql="Select * from empleado where emp_nombre like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Empleado pro=new Empleado();
                    pro.setId(rs.getInt(1));
                    pro.setCi(rs.getInt(2));
                    pro.setNombre(rs.getString(3));
                    pro.setApellido(rs.getString(4));
                    pro.setUsuario(rs.getString(5));
                    pro.setClave(rs.getString(6));
                    pro.setRole(rs.getInt(7));
                    pro.setEstado(rs.getInt(8));
                    
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
    
    public boolean agregar(Empleado obj){
        boolean ban = false;
        if (existeDuplicado("emp_usuario", obj.getUsuario())) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (existeDuplicado("emp_ci", String.valueOf(obj.getCi()))) {
            JOptionPane.showMessageDialog(null, "El número de Cedula ya está en uso. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String sql="INSERT INTO empleado (emp_codigo, emp_ci, emp_nombre, emp_apellido, emp_usuario, emp_clave, tip_codigo, est_codigo) "
                + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?); ";
        try{
            this.conectar();
            pst= conn.prepareStatement(sql);
            
            pst.setInt(1,obj.getCi());
            pst.setString(2, obj.getNombre());
            pst.setString(3, obj.getApellido());
            pst.setString(4, obj.getUsuario());
            pst.setString(5, obj.getClave());
            pst.setInt(6, obj.getRole());
            pst.setInt(7, obj.getEstado());
            
            if(pst.executeUpdate()>0){
                ban=true;
                System.out.println("se registros");
            }
            
            
        }catch(Exception e){
            System.out.println("error, no se registros "+sql);
        }
        
        
        return ban;
    }
    public boolean actualizar(Empleado obj) {
        boolean ban = false;
        
        String sql = "UPDATE Empleado SET  "
                + "emp_ci = ?, "
                + "emp_nombre = ?, "
                + "emp_apellido = ?, "
                + "emp_usuario = ?, "
                + "emp_clave = ?, "
                + "tip_codigo = ?, "
                + "est_codigo= ? "
                + "WHERE emp_codigo = ?";
//        System.out.println("emp_ci ="+obj.getCi()+",emp_nombre ="+obj.getNombre()
//                    +",emp_apellido ="+obj.getApellido()+",emp_usuario = "+obj.getUsuario()
//                    +",emp_clave ="+obj.getClave()+",tip_codigo = ?"+obj.getRole()+",est_codigo= ?"
//                    +obj.getEstado()+"WHERE emp_codigo = "+obj.getId());
        try {
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1,obj.getCi());
            pst.setString(2, obj.getNombre());
            pst.setString(3, obj.getApellido());
            pst.setString(4, obj.getUsuario());
            pst.setString(5, obj.getClave());
            pst.setInt(6, obj.getRole());
            pst.setInt(7, obj.getEstado());

            pst.setInt(8, obj.getId());
            
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
        
        String sql = "DELETE FROM empleado WHERE emp_codigo = ?";
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
    
    public boolean existeDuplicado(String campo, String valor) {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM empleado WHERE " + campo + " = ?";

        try {
            this.conectar();
            pst = conn.prepareStatement(sql);
            pst.setString(1, valor);
            rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                existe = true;
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return existe;
    }
    
    public int login(Empleado obj) {
        int empleado = 0;
        String sql = "SELECT * FROM empleado WHERE emp_usuario = ? AND emp_clave = ?";

        try {
            this.conectar();

            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, obj.getUsuario());
                pst.setString(2, obj.getClave());

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        // Usuario encontrado
                        empleado=rs.getInt("emp_codigo");
                       
                    } else {
                        // Usuario no encontrado
                        System.out.println("No se encontraron registros");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return empleado;
    }
    public int cargo(Empleado obj) {
        int empleado = 0;
        String sql = "SELECT * FROM empleado WHERE emp_codigo = ?";

        try {
            this.conectar();

            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, obj.getId());

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        // Usuario encontrado
                        empleado=rs.getInt("tip_codigo");
                       
                    } else {
                        // Usuario no encontrado
                        System.out.println("No se encontraron registros");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return empleado;
    }
}
