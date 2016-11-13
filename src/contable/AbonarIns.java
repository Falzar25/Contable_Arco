package contable;

import java.awt.Frame;
import javax.swing.JOptionPane;
import sql.Conexion;

public class AbonarIns extends javax.swing.JDialog {

    String nocontrol, ref, desc;
    int abono;
    Conexion c = new Conexion();

    public AbonarIns(Frame parent, Boolean modal) {
        super(parent, modal);
        System.out.println("Si");
        initComponents();
        setLocationRelativeTo(parent);

        Model m = new Model();
        c.conectar();
        c.cbPeriodos(cbPeriodo);
        nocontrol = m.getNocontrol();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAbono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbPeriodo = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        txtRef = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAbonar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Abonar Inscripciones");

        jLabel5.setText("¿Cuanto se abonó?:");

        btnCancelar.setText("Cancelar");

        jLabel2.setText("Seleccione el periodo:");

        btnAbonar2.setText("Abonar");
        btnAbonar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonar2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Por favor inserte la referencia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(btnAbonar2)
                            .addGap(42, 42, 42)
                            .addComponent(btnCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbonar2)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbonar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonar2ActionPerformed
        try {
            abono = Integer.parseInt(txtAbono.getText());
            ref = txtRef.getText();
            desc = cbPeriodo.getSelectedItem().toString();
            c.AbonarIns(abono, ref, Integer.parseInt(nocontrol), desc);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor introduzca valores correctos", "Error", 0);
        }

    }//GEN-LAST:event_btnAbonar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAbono;
    private javax.swing.JTextField txtRef;
    // End of variables declaration//GEN-END:variables
}
