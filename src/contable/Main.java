/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contable;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sql.Conexion;

/**
 *
 * @author g04rtx
 */
public class Main extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Model m = new Model();

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        con.conectar();
        con.periodoActual();
    }
   
    
    public static int count = 0;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Contable");

        desktopPane.setBackground(new java.awt.Color(0, 51, 51));

        fileMenu.setMnemonic('f');
        fileMenu.setText("Alumno");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Agregar alumnos");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Ver Alumnos");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Mensualidades");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Ver mensualidades");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Extraordinarios");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Asignar Extraordinarios");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        menuBar.add(helpMenu);

        jMenu1.setText("Inscripciones");

        jMenuItem1.setText("Ver Inscripciones");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        jMenu2.setText("Periodos y Años");

        jMenuItem2.setText("Activar nuevo periodo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Agregar un nuevo Año");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        new Agregar_Alumnos(null, true).setVisible(true);        
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        VerAlumnos ver_alumnos = VerAlumnos.getInstance();
        
        desktopPane.remove(ver_alumnos);
        desktopPane.add(ver_alumnos);
        
        ver_alumnos.setVisible(true);
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        MainExtraordinario mainExtraordinario = MainExtraordinario.getInstance();
        desktopPane.remove(mainExtraordinario);
        desktopPane.add(mainExtraordinario);
        mainExtraordinario.setVisible(true);
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        MainMensualidades mainForm = MainMensualidades.getInstance();
        desktopPane.remove(mainForm);
        desktopPane.add(mainForm);
        mainForm.setVisible(true);
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MainInscripcion mainInscricion =  MainInscripcion.getInstance();
        desktopPane.remove(mainInscricion);
        desktopPane.add(mainInscricion);
        mainInscricion.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new ActivarPeriodo(null, true).setVisible(true);        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            String s = (String) JOptionPane.showInputDialog(this, "Ingrese el nuevo año", "Agregar un año", 1);
            int valor = Integer.parseInt(s);
            if (valor <= 2010) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un valor mayor que 2010");
            } else {
                
                int n = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas asignar ese valor?", "Atención", JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    con.agregarYear(valor);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor correcto");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
