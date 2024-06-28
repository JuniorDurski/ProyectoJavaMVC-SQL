/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author HP
 */
public class FacturaDetalle {
    int id;
    int idFac;
    int idProducto;
    int facDetCantidad;
    int facDetSubtotal;

    public FacturaDetalle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFac() {
        return idFac;
    }

    public void setIdFac(int idFac) {
        this.idFac = idFac;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getFacDetCantidad() {
        return facDetCantidad;
    }

    public void setFacDetCantidad(int facDetCantidad) {
        this.facDetCantidad = facDetCantidad;
    }

    public int getFacDetSubtotal() {
        return facDetSubtotal;
    }

    public void setFacDetSubtotal(int facDetSubtotal) {
        this.facDetSubtotal = facDetSubtotal;
    }
    
    
    
}
