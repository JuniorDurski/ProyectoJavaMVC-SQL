/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.ProveedorDao;
import Models.Proveedor;
import java.util.List;
/**
 *
 * @author HP
 */
public class ProveedorCtr {
    Proveedor mod= new Proveedor();
    ProveedorDao dao= new ProveedorDao();
    
    public List<Proveedor> listaTabla(String obj){
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
}


