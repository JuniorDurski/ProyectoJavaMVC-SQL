/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.FacturaDetalleDao;
import Models.FacturaDetalle;
import java.util.List;

/**
 *
 * @author HP
 */
public class FacturaDetalleCtr {
    FacturaDetalle mod= new FacturaDetalle();
    FacturaDetalleDao dao= new FacturaDetalleDao();
    
    public List<FacturaDetalle> listaTabla(String obj){
        return dao.Listar(obj);
    }
    
    public void agregar(int idFactura, int idProducto, int cantidad, int subtotal) {
        mod.setIdFac(idFactura);
        mod.setIdProducto(idProducto);
        mod.setFacDetCantidad(cantidad);
        mod.setFacDetSubtotal(subtotal);
        
        dao.agregar(mod);
    }
    public void modificar(int idFactura, int idProducto, int cantidad, int subtotal, int cod) {
        mod.setIdFac(idFactura);
        mod.setIdProducto(idProducto);
        mod.setFacDetCantidad(cantidad);
        mod.setFacDetSubtotal(subtotal);
        
        mod.setId(cod);
        
        dao.actualizar(mod);
    }
    public void eliminar(int cod) {
        dao.eliminar(cod);
    }
}
