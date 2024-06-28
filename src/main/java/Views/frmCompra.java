/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;

import javax.swing.table.DefaultTableModel;
import Controllers.FacturaCtr;
import Models.Factura;
import Controllers.FacturaDetalleCtr;
import Models.FacturaDetalle;
import Controllers.ProductoCtr;
import Models.Producto;
import Controllers.ClienteCtr;
import Controllers.CompraCtr;
import Controllers.CompraDetalleCtr;
import Controllers.EmpleadoCtr;
import Controllers.ProveedorCtr;
import Models.Cliente;
import Models.Compra;
import Models.CompraDetalle;
import Models.Empleado;
import Models.Proveedor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author HP
 */
public class frmCompra extends javax.swing.JInternalFrame {
    
    CompraCtr ctrol=new CompraCtr();
    Compra mod= new Compra();
    
    
    ProductoCtr ctrolPro=new ProductoCtr();
    Producto modPro = new Producto();
    EmpleadoCtr ctrolEmp = new EmpleadoCtr();
    Empleado modEmp = new Empleado();
    CompraDetalleCtr ctrolDetalle=new CompraDetalleCtr();
    CompraDetalle modDetalle = new CompraDetalle();
    ProveedorCtr ctrolprov=new ProveedorCtr();   
    Proveedor modprov = new Proveedor();
    
    List<Proveedor> listaProveedor = ctrolprov.listaTabla(null);
    private Map<Integer, Integer> inventarioOriginal = new HashMap<>();
    int flag=0;
    public int idEmpleado; // Variable para almacenar el ID del empleado
    
    public frmCompra(int idEmpleado) {
        initComponents();
        this.idEmpleado = idEmpleado;
        System.out.println(idEmpleado);
        leerTabla(null); 
        setClosable(true);
        
        setFechaActual();
        restablecer();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Compra - Empleado");

        jTextField1.setEditable(false);

        jLabel2.setText("Fecha");

        jLabel3.setText("Proveedor");

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod", "Producto", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Productos");

        jLabel5.setText("Compras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        restablecer();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        flag = 1;
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        System.out.println("click");
        if(flag==1){
            Integer linea = jTable1.getSelectedRow();

            if (linea != -1) {
                int valor1 = (int) jTable1.getValueAt(linea, 0);
                String valor2 = (String) jTable1.getValueAt(linea, 1);
                int valor3 = (int) jTable1.getValueAt(linea, 2);
                int valor4 = (int) jTable1.getValueAt(linea, 3);

                JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, null, 1)); //si es null ,no tiene limite maximo
                int option = JOptionPane.showOptionDialog(null, spinner, "Seleccione la cantidad", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    int cantidadSeleccionada = (int) spinner.getValue();

                    DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
                    model2.addRow(new Object[]{valor1, valor2, valor3, cantidadSeleccionada});
                    DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();

                    model1.removeRow(linea);
                  
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        System.out.println("click");
        if(flag==1){
            Integer linea = jTable2.getSelectedRow();

            if (linea != -1) {
                int valor1 = (int) jTable2.getValueAt(linea, 0);
                String valor2 = (String) jTable2.getValueAt(linea, 1);
                int valor3 = (int) jTable2.getValueAt(linea, 2);
                int valor4 = (int) jTable2.getValueAt(linea, 3);

                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                model1.addRow(new Object[]{valor1, valor2, valor3, valor4});
                DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();

                model2.removeRow(linea);
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        if (model2.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "La tabla de productos está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verificar que se haya seleccionado un proveedor en el JComboBox
        if (jComboBox1.getSelectedIndex() == 0) { // El índice 0 es "Seleccionar"
            JOptionPane.showMessageDialog(this, "Debe seleccionar un proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String proveedorBusqueda = (String) jComboBox1.getSelectedItem();//busca elemento
        int proveedorId=0;
        for (Proveedor prov : listaProveedor) {//itera
            if (prov.getDescripcion().equals(proveedorBusqueda)) {//ccompara elemento
                proveedorId = prov.getId(); // consige id del elemento
                break;
            }
        }
        System.out.println("proveedor ID: " + proveedorId);
        
        ctrol.agregar(idEmpleado, proveedorId);
        
        // Cargar Detalle
        String idEmpleadoStr = String.valueOf(idEmpleado);
        System.out.println(idEmpleado);
        
        List<Compra> ultimaCompra = new ArrayList<>();
        ultimaCompra= ctrol.listaTabla(idEmpleadoStr);
        int idCompra=0;
        for(Compra tab : ultimaCompra){            
            idCompra= tab.getId();
        }

        for (int i = 0; i < model2.getRowCount(); i++) {
            int idProducto = (int) model2.getValueAt(i, 0);  
            int cantidad = (int) model2.getValueAt(i, 3);    

            ctrolDetalle.agregar(cantidad, idCompra, idProducto);
             // Obtener la cantidad original del mapa
            int stockActual = inventarioOriginal.getOrDefault(idProducto, 0);
            int resta = stockActual + cantidad;
            ctrolPro.modificarInventario(resta, idProducto);
        }
        System.out.println(idEmpleadoStr);
        restablecer();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
    private void leerTabla(String dato) {
        List<Producto> listaProductos = new ArrayList<>();
        String idato=dato;
        listaProductos= ctrolPro.listaTabla(dato);
        
        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        tbm.setColumnIdentifiers(new String[]{"cod","Producto","Precio","Cantidad",});
        
        tbm.setRowCount(0);
        inventarioOriginal.clear();
        
        int i=0;
        for(Producto tab : listaProductos){
            
            tbm.addRow(new String[1]);
            
            jTable1.setValueAt(tab.getId(),i,0);
            jTable1.setValueAt(tab.getCantidad(),i,3);
            jTable1.setValueAt(tab.getPrecio(),i,2);
            jTable1.setValueAt(tab.getDescripcion(),i,1);
            
            inventarioOriginal.put(tab.getId(), tab.getCantidad());
            
            i++;
        }
        jTable1.requestFocus();
    }
    
    private void restablecer() {
        flag=0;
        leerTabla(null);  
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel(); 
        for(int i=model2.getRowCount()-1; i>=0 ;i--){
            model2.removeRow(i);
        }
        
        llenarComboBox(jComboBox1, listaProveedor);
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
    }
    
    private void llenarComboBox(JComboBox<String> comboBox, List<?> listaItems) {
        comboBox.removeAllItems();
        comboBox.addItem("Seleccionar");

        for (Object item : listaItems) {
            if (item instanceof Proveedor) {
                Proveedor role = (Proveedor) item;
                comboBox.addItem(role.getDescripcion());
            
            }
        }
    }
    
    private void setFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        jTextField1.setText(fechaActual.format(formatter));
    }
    
}
