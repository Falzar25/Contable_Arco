/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contable;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;

/**
 *
 * @author Equipo
 */
public class MainExtraordinario extends javax.swing.JInternalFrame {

    Conexion con = new Conexion();
    Model m = new Model();
    DefaultTableModel model;
    String nocontrol, nombre, saldo, periodo;

    /**
     * Creates new form MainExtraordinario
     */
    public MainExtraordinario() {
        initComponents();
        con.conectar();
        con.cbPeriodos(cbPeriodo);
        model = (DefaultTableModel) tblAlumnos.getModel();
        periodo = cbPeriodo.getSelectedItem().toString();
        con.mostrarExt(model, periodo);
        tblAlumnos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                    nocontrol = String.valueOf(model.getValueAt(tblAlumnos.getSelectedRow(), 0));
                    nombre = String.valueOf(model.getValueAt(tblAlumnos.getSelectedRow(), 1));
                    saldo = String.valueOf(model.getValueAt(tblAlumnos.getSelectedRow(), 3));
                    m.setNocontrol(nocontrol);
                    m.setNombreAlumno(nombre);
                    m.setSaldoAlumno(saldo);
                    new InfoExt(new Main(), true).setVisible(true);
                    for (int i = 0; i < tblAlumnos.getRowCount(); i++) {
                        model.removeRow(i);
                        i -= 1;
                    }
                    con.mostrarExt(model, periodo);
                }
            }
        });
        cbPeriodo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                periodo = cbPeriodo.getSelectedItem().toString();
                for (int i = 0; i < tblAlumnos.getRowCount(); i++) {
                    model.removeRow(i);
                    i -= 1;
                }
                con.mostrarExt(model, periodo);
            }
        });

    }

    public void Limpiar(DefaultTableModel m, JTable jt) {
        for (int i = 0; i < jt.getRowCount(); i++) {
            m.removeRow(i);
            i -= 1;
        }
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
        tblAlumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cbPeriodo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Extraordinarios");

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Control", "Nombre", "Semestre", "Deuda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);

        jButton1.setText("Asignar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ok");

        jLabel1.setText("Periodo");

        jButton3.setText("Cambiar valor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(49, 49, 49)
                .addComponent(jButton3)
                .addGap(240, 240, 240))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AsignarExt(new Main(), true).setVisible(true);
        this.Limpiar(model, tblAlumnos);
        con.mostrarExt(model, periodo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String s = (String) JOptionPane.showInputDialog(this, "Seleccione un nuevo valor para los extraordinarios", "Seleccione un precio", 1);
            int valor = Integer.parseInt(s);
            if (valor <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un valor mayor que 0");
            } else {

                int n = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas asignar ese valor?", "Atención", JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    con.cambiar_ext(valor);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor correcto");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbPeriodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlumnos;
    // End of variables declaration//GEN-END:variables
}
