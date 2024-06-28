/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.EmpleadoDao;
import Models.Empleado;
import java.util.List;
/**
 *
 * @author HP
 */
public class EmpleadoCtr {
    Empleado mod= new Empleado();
    EmpleadoDao dao= new EmpleadoDao();
    
    public List<Empleado> listaTabla(String obj){
        return dao.Listar(obj);
    }
    
    public void agregar(int ci, String nombre, String apellido, String usuario, String clave, int role, int estado) {
        mod.setCi(ci);      
        mod.setNombre(nombre);
        mod.setApellido(apellido);
        mod.setUsuario(usuario);
        mod.setClave(clave);
        mod.setRole(role);
        mod.setEstado(estado);
        
        dao.agregar(mod);
    }
    public void modificar(int ci, String nombre, String apellido, String usuario, String clave, int role, int estado, int cod) {
        mod.setCi(ci);
        mod.setNombre(nombre);
        mod.setApellido(apellido);
        mod.setUsuario(usuario);
        mod.setClave(clave);
        mod.setRole(role);
        mod.setEstado(estado);
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
    public int role(int IdEmpleado) {
        mod.setId(IdEmpleado);
        
        return dao.cargo(mod);
    }
}


