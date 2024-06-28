/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import Dao.ClienteDao;
import Models.Cliente;
import java.util.List;

/**
 *
 * @author HP
 */
public class ClienteCtr {
    Cliente mod= new Cliente();
    ClienteDao dao= new ClienteDao();
    
    public List<Cliente> listaTabla(String obj){
        return dao.Listar(obj);
    }
    
    public boolean agregar(String nombre, int ci, String usuario, String clave, String correo, int tarjeta) {
        mod.setNombre(nombre);
        mod.setCi(ci);
        mod.setUsuario(usuario);
        mod.setClave(clave);
        mod.setCorreo(correo);
        mod.setTarjeta(tarjeta);

        // Llamar al método agregar del DAO
        boolean nice= dao.agregar(mod);
        return nice;
    }
    public void modificar(String nombre, int ci, String usuario, String clave, String correo, int tarjeta, int cod) {
        
        mod.setNombre(nombre);
        mod.setCi(ci);
        mod.setUsuario(usuario);
        mod.setClave(clave);
        mod.setCorreo(correo);
        mod.setTarjeta(tarjeta);
        mod.setId(cod);
        
        dao.actualizar(mod);
    }
    public void eliminar(int cod) {
        dao.eliminar(cod);
    }   
    public int login(String usuario, String clave) {
        mod.setUsuario(usuario);
        mod.setClave(clave);
        return dao.login(mod);
    }
}
