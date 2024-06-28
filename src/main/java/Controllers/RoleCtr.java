/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.RoleDao;
import Models.Role;
import java.util.List;
/**
 *
 * @author HP
 */
public class RoleCtr {
    Role mod= new Role();
    RoleDao dao= new RoleDao();
    
    public List<Role> listaTabla(String obj){
        return dao.Listar(obj);
    }
    
    public void agregar(String desc) {
        mod.setDescripcion(desc);
        
        dao.agregar(mod);
    }
    
    public void modificar(String desc, int cod) {
        
        mod.setDescripcion(desc);
        mod.setId(cod);
        
        dao.actualizar(mod);
    }
    
    public void eliminar(int cod) {
        dao.eliminar(cod);
    }
    
    public Role buscarPorId(int id) {
        return dao.buscarPorId(id);
    }
}


