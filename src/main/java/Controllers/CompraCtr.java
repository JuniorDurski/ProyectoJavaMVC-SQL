/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.CompraDao;
import Models.Compra;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author HP
 */
public class CompraCtr {
    Compra mod= new Compra();
    CompraDao dao= new CompraDao();
    
    public List<Compra> listaTabla(String obj){
        return dao.Listar(obj);
    }
    
    public List<Compra> informeTitulo(String obj){
        return dao.informeCabecera(obj);
    }
    
    public void agregar(int proveedor, int empleado) {
        mod.setIdProveedor(proveedor);
        mod.setIdEmpleado(empleado);
        
        
        dao.agregar(mod);
    }
    public void modificar(int proveedor, int empleado, int cod) {
        mod.setIdProveedor(proveedor);
        mod.setIdEmpleado(empleado);
        mod.setId(cod);
        
        dao.actualizar(mod);
    }
    public void eliminar(int cod) {
        dao.eliminar(cod);
    }
}
