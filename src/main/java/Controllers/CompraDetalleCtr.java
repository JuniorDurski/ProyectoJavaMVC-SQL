/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.CompraDetalleDao;
import Models.CompraDetalle;
import java.util.List;

/**
 *
 * @author HP
 */
public class CompraDetalleCtr {
    CompraDetalle mod= new CompraDetalle();
    CompraDetalleDao dao= new CompraDetalleDao();
    
    public List<CompraDetalle> listaTabla(String obj){
        return dao.Listar(obj);
    }
    
    public void agregar(int cantidad, int compra,int producto) {
        mod.setCantidad(cantidad);
        mod.setIdCompra(compra);
        mod.setIdProducto(producto);
        
        dao.agregar(mod);
    }
    public void modificar(int cantidad, int compra,int producto, int cod) {
        
        mod.setCantidad(cantidad);
        mod.setIdCompra(compra);
        mod.setIdProducto(producto);
        mod.setId(cod);
        
        dao.actualizar(mod);
    }
    public void eliminar(int cod) {
        dao.eliminar(cod);
    }
}
