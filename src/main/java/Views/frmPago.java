/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;
import Models.Cliente;
import Models.Pago;

import Controllers.FacturaCtr;
import Models.Factura;
import Controllers.ProductoCtr;
import Models.Producto;
import Controllers.ClienteCtr;
import Controllers.PagoCtr;
import Controllers.EstadoCtr;
import Models.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmPago extends javax.swing.JInternalFrame {
    PagoCtr ctrol=new PagoCtr();
    Pago mod= new Pago();
    
    FacturaCtr ctrolFac=new FacturaCtr();
    Factura modFac= new Factura();
    ProductoCtr ctrolPro=new ProductoCtr();
    Producto modPro = new Producto();
    ClienteCtr ctrolCli=new ClienteCtr();
    Cliente modCli = new Cliente();
    
    EstadoCtr ctrolEstado = new EstadoCtr();
    Estado modEstado = new Estado();
    
    
    int flag=0;
    public int idCliente; // Variable para almacenar el ID del cliente
   
    public frmPago(int idCliente) {
        initComponents();
        
        this.idCliente = idCliente;
        String idClienteStr = String.valueOf(idCliente);
        
        System.out.println(idCliente);
     
        idClienteStr = String.valueOf(idCliente);
        leerTablaFacturas(idClienteStr);
        
        jButton1.setEnabled(false);
        setClosable(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Timbrado", "Fecha", "Total", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel1.setText("Pagos - Cliente");

        jLabel2.setText("Fecha");

        jLabel3.setText("Timbrado");

        jLabel4.setText("Total");

        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Codigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2))
                                .addGap(63, 63, 63))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Integer linea = jTable1.getSelectedRow();
        
        String pin = JOptionPane.showInputDialog(this, "Ingrese su Pin de Tarjeta:", "Autenticación", JOptionPane.PLAIN_MESSAGE);

        // Verificar si el usuario presionó "Aceptar" o "Cancelar"
        if (pin != null) {

            String timbrado = jTextField1.getText();
            int total = Integer.parseInt(jTextField3.getText());
            int idFactura = Integer.parseInt(jTextField4.getText());

            ctrolFac.modificar(timbrado, total, idCliente, 1, 3, idFactura);

            ctrol.agregar(idCliente, idFactura);

            String idClienteStr = String.valueOf(idCliente);
            idClienteStr = String.valueOf(idCliente);
            leerTablaFacturas(idClienteStr);
            jButton1.setEnabled(false);
            limpiar();
        } else {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(this, "Operación cancelada", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        System.out.println("click");
        
        
        Integer linea = jTable1.getSelectedRow();
        String est= String.valueOf(jTable1.getValueAt(linea, 4));
        if(est.equals("No Pagado")){
            jButton1.setEnabled(true);
            this.jTextField1.setText(String.valueOf(jTable1.getValueAt(linea, 1)));
            this.jTextField2.setText(String.valueOf(jTable1.getValueAt(linea, 2)));
            this.jTextField3.setText(String.valueOf(jTable1.getValueAt(linea, 3)));
            this.jTextField4.setText(String.valueOf(jTable1.getValueAt(linea, 0)));
        }else{
            limpiar();
        }
                
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
    private void leerTablaFacturas(String dato) {
        List<Factura> listaFactura = ctrolFac.listaTabla(dato);

        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        tbm.setColumnIdentifiers(new String[]{"cod", "Timbrado", "Fecha", "Total", "Estado"});

        // Eliminar filas existentes en la tabla
        tbm.setRowCount(0);

        // Recorrer lista de facturas y añadir filas a la tabla
        for (Factura tab : listaFactura) {
            // Obtener el estado
            String query = "est_codigo = " + tab.getIdEstado();
            Estado estado = ctrolEstado.buscarPorId(query);

            // Crear la fila con los valores de la factura y su estado
            tbm.addRow(new Object[]{
                tab.getId(),
                tab.getTimbrado(),
                tab.getFecha(),
                tab.getTotal(),
                (estado != null) ? estado.getDescripcion() : "Estado no encontrado"
            });

            if (estado == null) {
                System.out.println("Estado no encontrado para el ID: " + tab.getIdEstado());
            }
        }

        jTable1.requestFocus();
    }
    public void limpiar(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jButton1.setEnabled(false);
       
    }
}
