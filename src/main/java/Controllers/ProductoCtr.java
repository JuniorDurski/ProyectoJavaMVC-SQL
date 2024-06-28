/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.ProductoDao;
import Models.Producto;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProductoCtr {
    Producto mod= new Producto();
    ProductoDao dao= new ProductoDao();
    
    public List<Producto> listaTabla(String obj){
        return dao.Listar(obj);
    }
    
    public void agregar(String desc, int cantidad, int precio) {
        mod.setDescripcion(desc);
        mod.setCantidad(cantidad);
        mod.setPrecio(precio);
        
        dao.agregar(mod);
    }
    public void modificar(String desc, int cantidad, int precio, int cod) {
        
        mod.setDescripcion(desc);
        mod.setCantidad(cantidad);
        mod.setPrecio(precio);
        mod.setId(cod);
        
        dao.actualizar(mod);
    }
    public void eliminar(int cod) {
        dao.eliminar(cod);
    }
    public void modificarInventario(int cantidad, int cod) {
        
        mod.setCantidad(cantidad);
        mod.setId(cod);
        
        dao.inventario(mod);
    }
}
