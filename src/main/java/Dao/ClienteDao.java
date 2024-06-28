/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ClienteDao extends Conexion{
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    public List<Cliente> Listar(String obj){
        List<Cliente> lista= new ArrayList<Cliente>();
        String sql;
        if(obj==null){
            sql="Select * From cliente order by cli_nombre";
        }else{
            sql="Select * from cliente where cli_nombre like '%"+obj+"%'";
        }
        
        try{
            this.conectar();
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs !=null){
                
                while(rs.next()){
                    Cliente pro=new Cliente();
                    pro.setId(rs.getInt(1));
                    pro.setNombre(rs.getString(2));
                    
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
    
    public boolean agregar(Cliente obj) {
        boolean ban = false;
        if (existeDuplicado("cli_usuario", obj.getUsuario())) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (existeDuplicado("cli_correo", obj.getCorreo())) {
            JOptionPane.showMessageDialog(null, "El correo ya está en uso. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (existeDuplicado("cli_tarjeta", String.valueOf(obj.getTarjeta()))) {
            JOptionPane.showMessageDialog(null, "El número de tarjeta ya está en uso. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (existeDuplicado("cli_ci", String.valueOf(obj.getCi()))) {
            JOptionPane.showMessageDialog(null, "El número de Cedula ya está en uso. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String sql = "INSERT INTO cliente (cli_codigo, cli_ci, cli_nombre, cli_usuario, cli_clave, cli_tarjeta, cli_clave_tarjeta, cli_correo, est_codigo)"
            +"VALUES (null,?, ?, ?, ?, ?, 1, ?,1);";
        try {
            this.conectar();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, obj.getCi());
            pst.setString(2, obj.getNombre());
            pst.setString(3, obj.getUsuario());
            pst.setString(4, obj.getClave());
            pst.setInt(5, obj.getTarjeta());
            pst.setString(6, obj.getCorreo());

            if (pst.executeUpdate() > 0) {
                ban = true;
                System.out.println("Se registró el cliente");
            }
        } catch (Exception e) {
            System.out.println("Error, no se registró el cliente: " + sql);
            e.printStackTrace(); // Para obtener más detalles sobre el error
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ban;
    }

    public boolean actualizar(Cliente obj) {
        boolean ban = false;
        String sql = "UPDATE cliente SET"
                + " cli_ci = ?,"
                + " cli_nombre = ?,"
                + " cli_usuario = ?,"
                + " cli_clave = ?,"
                + " cli_tarjeta = ?,"
                + " cli_clave_tarjeta = ?,"
                + " cli_correo = ?,"
                + " est_codigo = ?"
                + " WHERE cli_codigo = ?";
        try {
            this.conectar();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, obj.getCi());
            pst.setString(2, obj.getNombre());
            pst.setString(3, obj.getUsuario());
            pst.setString(4, obj.getClave());
            pst.setInt(5, obj.getTarjeta());
            pst.setInt(6, 1);
            pst.setString(7, obj.getCorreo());
            pst.setInt(8, 1); // Assuming est_codigo is always 1 for updates
            pst.setInt(9, obj.getId()); // Assuming cli_codigo is the identifier

            if (pst.executeUpdate() > 0) {
                ban = true;
                System.out.println("Se actualizó el cliente: " + sql);
            }
        } catch (Exception e) {
            System.out.println("Error, no se actualizó el cliente: " + sql);
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ban;
    }

    public boolean eliminar(int cod) {
        boolean ban = false;
        
        String sql = "DELETE FROM cliente WHERE cli_codigo = ?";
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
        String sql = "SELECT COUNT(*) FROM cliente WHERE " + campo + " = ?";

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
    
    public int login(Cliente obj) {
        int cliente = 0;
        String sql = "SELECT * FROM cliente WHERE cli_usuario = ? AND cli_clave = ?";

        try {
            this.conectar();

            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, obj.getUsuario());
                pst.setString(2, obj.getClave());

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        // Usuario encontrado
                        cliente=rs.getInt("cli_codigo");
                       
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

        return cliente;
    }

}
