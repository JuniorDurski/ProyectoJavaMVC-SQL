/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.FacturaDao;
import Models.Factura;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author HP
 */
public class FacturaCtr {
    Factura mod= new Factura();
    FacturaDao dao= new FacturaDao();
    
    public List<Factura> listaTabla(String obj){
        return dao.Listar(obj);
    }
    public List<Factura> informeTitulo(String obj){
        return dao.informeCabecera(obj);
    }
    
    public void agregar(String timbrado, int total,int cliente, int empleado, int estado) {
        mod.setTimbrado(timbrado);
        mod.setTotal(total);
        mod.setIdCliente(cliente);
        mod.setIdEmpleado(empleado);
        mod.setIdEstado(estado);
        
        dao.agregar(mod);
    }
    public void modificar(String timbrado,int total,int cliente, int empleado, int estado, int cod) {
        mod.setTimbrado(timbrado);
        mod.setTotal(total);
        mod.setIdCliente(cliente);
        mod.setIdEmpleado(empleado);
        mod.setIdEstado(estado);
        mod.setId(cod);
        
        dao.actualizar(mod);
    }
    public void eliminar(int cod) {
        dao.eliminar(cod);
    }
}
