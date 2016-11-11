/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contable;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;

/**
 *
 * @author Equipo
 */
public class AsignarPagosI extends javax.swing.JDialog {

    
    DefaultTableModel m;
    Conexion con = new Conexion();
    public AsignarPagosI(Frame parent, Boolean modal) {
        super(parent, modal);
        initComponents();
                setLocationRelativeTo(parent);

        m = (DefaultTableModel) tblAll.getModel();
        con.conectar();
        ButtonGroup gp = new ButtonGroup();
        gp.add(rbAlumno);
        gp.add(rbLista);
        rbAlumno.setSelected(true);
        con.todosAlumnosInscripcion(m);
        tblAll.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAll = new javax.swing.JTable();
        rbLista = new javax.swing.JRadioButton();
        rbAlumno = new javax.swing.JRadioButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Introduzca la cantidad:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Control", "Nombre", "Semestre", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAll);

        rbLista.setText("Asignar el pago a una lista de alumnos:");
        rbLista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbListaisSelectedTable(evt);
            }
        });
        rbLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbListaActionPerformed(evt);
            }
        });

        rbAlumno.setSelected(true);
        rbAlumno.setText("Asignar el pago a un alumno");
        rbAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbAlumnoisSelectedAlumno(evt);
            }
        });

        jLabel1.setText("Introduzca el numero de control:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbLista)
                            .addComponent(rbAlumno)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNC, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(rbLista)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cantidad = Integer.parseInt(txtCantidad.getText());
        if(rbAlumno.isSelected()){

            con.AsignarPagosI_Alumno(Integer.parseInt(txtNC.getText()), cantidad);

        } else if (rbLista.isSelected()){

            ArrayList <Object> arr = new ArrayList();
            for (int x = 0; x<m.getRowCount(); x++){
                if((Boolean)m.getValueAt(x, 3)==true){
                    arr.add(m.getValueAt(x, 0));
                }
            }
            con.AsignarPagosI_Tabla(arr, cantidad);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rbListaisSelectedTable(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbListaisSelectedTable
        if(evt.getStateChange() == 1){
            tblAll.setVisible(true);
            txtNC.setText("");
            txtNC.disable();
        }
    }//GEN-LAST:event_rbListaisSelectedTable

    private void rbListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbListaActionPerformed

    private void rbAlumnoisSelectedAlumno(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbAlumnoisSelectedAlumno
        if(evt.getStateChange() == 1){
            tblAll.setVisible(false);
            txtNC.enable();
        }
    }//GEN-LAST:event_rbAlumnoisSelectedAlumno


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAlumno;
    private javax.swing.JRadioButton rbLista;
    private javax.swing.JTable tblAll;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNC;
    // End of variables declaration//GEN-END:variables
}
