/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Compra {
    int id;
    LocalDate fecha;
    int idProveedor;
    int idEmpleado;
    String desEmpleado;
    String desProveedor;

    public Compra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    public String getDesEmpleado() {
        return desEmpleado;
    }

    public void setDesEmpleado(String desEmpleado) {
        this.desEmpleado = desEmpleado;
    }

    public String getDesProveedor() {
        return desProveedor;
    }

    public void setDesProveedor(String desProveedor) {
        this.desProveedor = desProveedor;
    }
    
}
