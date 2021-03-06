/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contable;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;

/**
 *
 * @author Equipo
 */
public class InfoAlumno extends javax.swing.JDialog {

    String nocontrol, nombre, saldo, año, month, ref;
    DefaultTableModel mMeses, mAbono;
    Model m = new Model();
    Conexion c = new Conexion();

    public InfoAlumno(java.awt.Frame parent, boolean modal) {

        //public InfoAlumno() {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

        setData();
        cbAños.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                año = cbAños.getSelectedItem().toString();
                for (int i = 0; i < tblMeses.getRowCount(); i++) {
                    mMeses.removeRow(i);
                    i -= 1;
                }
                for (int i = 0; i < tblAbonos.getRowCount(); i++) {
                    mAbono.removeRow(i);
                    i -= 1;
                }
                c.infoAlumnoTable(mMeses, Integer.parseInt(nocontrol), año);
                c.infoAbonoTable_mensualidad(mAbono, Integer.parseInt(nocontrol), año);
            }
        });
    }

    final void setData() {

        c.conectar();
        nocontrol = m.getNocontrol();
        nombre = m.getNombreAlumno();
        saldo = m.getSaldoAlumno();
        lblnocontrol.setText(nocontrol);
        lblNombre.setText(nombre);
        lblSaldo.setText(saldo);
        mMeses = (DefaultTableModel) tblMeses.getModel();
        mAbono = (DefaultTableModel) tblAbonos.getModel();
        c.añosCB(cbAños);
        año = cbAños.getSelectedItem().toString();
        c.infoAlumnoTable(mMeses, Integer.parseInt(nocontrol), año);
        c.infoAbonoTable_mensualidad(mAbono, Integer.parseInt(nocontrol), año);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAbonos = new javax.swing.JTable();
        btnAbonar = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblnocontrol = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMeses = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbAños = new javax.swing.JComboBox<>();
        btnEliminarMes = new javax.swing.JButton();
        btnEliminarAbono = new javax.swing.JButton();

        setTitle("Informacion del alumno en mensualidades");

        tblAbonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha de abono", "Abono", "Mes", "Referencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAbonos);

        btnAbonar.setText("Abonar");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });

        btnBack.setText("Volver");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        lblNombre.setText("Aqui va el nombre del alumno");

        jLabel2.setText("No. Contro: ");

        lblnocontrol.setText("Aqui va el numero de control");

        jLabel3.setText("Saldo total:");

        lblSaldo.setText("Aqui va el saldo");

        tblMeses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mes", "Deuda", "Cantidad Pagada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblMeses);

        jLabel4.setText("Buscar por año:");

        cbAños.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEliminarMes.setText("Eliminar");
        btnEliminarMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMesActionPerformed(evt);
            }
        });

        btnEliminarAbono.setText("Eliminar");
        btnEliminarAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAbonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNombre))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblnocontrol)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSaldo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(btnAbonar)
                                .addGap(56, 56, 56)
                                .addComponent(btnBack))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbAños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminarMes)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEliminarAbono)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblnocontrol)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblSaldo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbAños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnEliminarMes)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarAbono)
                        .addGap(53, 53, 53)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbonar)
                    .addComponent(btnBack))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
        if (Integer.parseInt(saldo) == 0) {
            JOptionPane.showMessageDialog(null, "¡Este alumno ya no debe ningun pago!", "Error", 0);
        } else {
            new ProcesoAbono(null, true).setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnAbonarActionPerformed

    private void btnEliminarMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMesActionPerformed
        try {

            nocontrol = m.getNocontrol();
            month = (String.valueOf(mMeses.getValueAt(tblMeses.getSelectedRow(), 0)));
            int n = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar esta deuda? se eliminaran todas las referencias vinculadas", "Atención", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                c.eliminarMensualidad(Integer.parseInt(nocontrol), month, año);          
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna deuda", "Error", 0);
        }
    }//GEN-LAST:event_btnEliminarMesActionPerformed

    private void btnEliminarAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAbonoActionPerformed
        try {

            nocontrol = m.getNocontrol();
            ref = (String.valueOf(mAbono.getValueAt(tblAbonos.getSelectedRow(), 3)));
            int n = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar este abono? se agregará lo abonado a su deuda", "Atención", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                c.eliminarMensuAbono(ref, Integer.parseInt(nocontrol));          
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun abono", "Error", 0);
        }
    }//GEN-LAST:event_btnEliminarAbonoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEliminarAbono;
    private javax.swing.JButton btnEliminarMes;
    private javax.swing.JComboBox<String> cbAños;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblnocontrol;
    private javax.swing.JTable tblAbonos;
    private javax.swing.JTable tblMeses;
    // End of variables declaration//GEN-END:variables
}
