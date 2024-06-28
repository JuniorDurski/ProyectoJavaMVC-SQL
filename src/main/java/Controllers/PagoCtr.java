/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.PagoDao;
import Models.Pago;
import java.util.List;
/**
 *
 * @author HP
 */
public class PagoCtr {
    Pago mod= new Pago();
    PagoDao dao= new PagoDao();
    
    public List<Pago> listaTabla(String obj){
        return dao.Listar(obj);
    }
    
    public void agregar(int cliente, int factura) {
        mod.setIdCliente(cliente);
        mod.setIdFactura(factura);
        
        dao.agregar(mod);
    }
    public void modificar(int cliente, int factura, int cod) {
        mod.setIdCliente(cliente);
        mod.setIdFactura(factura);
        mod.setId(cod);
        
        dao.actualizar(mod);
    }
    public void eliminar(int cod) {
        dao.eliminar(cod);
    }
}


