
package Views;

import Controllers.FacturaCtr;
import Models.Factura;
import Controllers.FacturaDetalleCtr;
import Models.FacturaDetalle;
import Controllers.ProductoCtr;
import Models.Producto;
import Controllers.ClienteCtr;
import Models.Cliente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class frmFactura extends javax.swing.JInternalFrame {
    FacturaCtr ctrol=new FacturaCtr();
    Factura mod= new Factura();
    
    ProductoCtr ctrolPro=new ProductoCtr();
    Producto modPro = new Producto();
    ClienteCtr ctrolCli=new ClienteCtr();
    Cliente modCli = new Cliente();
    FacturaDetalleCtr ctrolDetalle=new FacturaDetalleCtr();
    FacturaDetalle modDetalle = new FacturaDetalle();
    
    private Map<Integer, Integer> inventarioOriginal = new HashMap<>();
    int flag=0;
    public int idCliente; // Variable para almacenar el ID del cliente
    
    public frmFactura(int idCliente) {
        initComponents();
        
        this.idCliente = idCliente;
        System.out.println(idCliente);
        leerTabla(null);
        setClosable(true);
        setFechaActual();
        jButton1.setEnabled(false);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Facturacion - Cliente");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cod", "pro", "pre", "cant"
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

            },
            new String [] {
                "Cod", "Producto", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jTextField1.setEditable(false);

        jLabel2.setText("Fecha");

        jLabel3.setText("Total");

        jTextField3.setEditable(false);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Detalle de la facturacion");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(25, 25, 25)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cargar Factura
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        if (model2.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "La tabla de detalles está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verificar que los campos de texto tengan datos
        if (jTextField1.getText().trim().isEmpty() || jTextField3.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String timbrado = "2024-0000-";
        int total = Integer.parseInt(jTextField3.getText());
        int idEmpleado = 1;
        int idEstado = 4; //4=no pagado y 3=pagado
        int idFactura=0;
        
        ctrol.agregar(timbrado, total, idCliente,idEmpleado, idEstado);
       
        // Cargar Detalle
        String idClienteStr = String.valueOf(idCliente)+" ORDER BY fac_codigo DESC LIMIT 1";
        System.out.println(idCliente);
        
        List<Factura> ultimaFactura = new ArrayList<>();
        ultimaFactura= ctrol.listaTabla(idClienteStr);
        
        for(Factura tab : ultimaFactura){            
            idFactura= tab.getId();
        }
        
        timbrado = String.format("2024-0000-%d", idFactura);
        
        ctrol.modificar(timbrado, total, idCliente,idEmpleado, idEstado, idFactura);
        System.out.println("Timbrado"+timbrado);

        for (int i = 0; i < model2.getRowCount(); i++) {
            int idProducto = (int) model2.getValueAt(i, 0);  
            int cantidad = (int) model2.getValueAt(i, 3);    
            int subtotal = (int) model2.getValueAt(i, 4);    

            ctrolDetalle.agregar(idFactura, idProducto, cantidad, subtotal);
            
             // Obtener la cantidad original del mapa
            int stockActual = inventarioOriginal.getOrDefault(idProducto, 0);
            int resta = stockActual - cantidad;
            ctrolPro.modificarInventario(resta, idProducto);
        }
        
        System.out.println(idClienteStr);
        restablecer();
  
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

                JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, valor4, 1)); // valor4 es la cantidad máxima disponible
                int option = JOptionPane.showOptionDialog(null, spinner, "Seleccione la cantidad", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    int cantidadSeleccionada = (int) spinner.getValue();

                    DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
                    model2.addRow(new Object[]{valor1, valor2, valor3, cantidadSeleccionada});
                    DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();

                    model1.removeRow(linea);
                    calcularTotal();
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
                calcularTotal();
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        restablecer();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        flag = 1;
        jButton3.setEnabled(false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
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
    
    private void calcularTotal() {
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        int total = 0;
        for (int i = 0; i < model2.getRowCount(); i++) {
            int precio = (int) model2.getValueAt(i, 2);
            int cantidad = (int) model2.getValueAt(i, 3);
            int subtotal = precio * cantidad;
            total= total+subtotal;
            jTable2.setValueAt(subtotal,i,4);
        }
        jTextField3.setText(String.valueOf(total));
    }
  
    private void setFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        jTextField1.setText(fechaActual.format(formatter));
    }
    
    private void restablecer() {
        flag=0;
        leerTabla(null);  
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel(); 
        for(int i=model2.getRowCount()-1; i>=0 ;i--){
            model2.removeRow(i);
        }
        jButton3.setEnabled(true);
        jButton1.setEnabled(false);
        jTextField3.setText("");
    }
}
