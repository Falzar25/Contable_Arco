/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import sql.Conexion;


/**
 *
 * @author Equipo
 */
public class CrearReportes {
    Connection con = null;
    public void crearReporteMensual(String year, String month) {
        try {
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se logró establecer la conexion", "Error", 0);
        }
        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/abonos?"
                    + "user=root&password=Falzar250");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("month", month);
            parametros.put("year", year);
            File f = new File("reporte_pagos_mensuales.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(f);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, con);
            JRExporter exporter = new JRPdfExporter();
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("reporte_mensual_"+month+"_"+year+".pdf"));
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(CrearReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearReporteExt(int id, String descripcion) {
        try {
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se logró establecer la conexion", "Error", 0);
        }
        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/abonos?"
                    + "user=root&password=Falzar250");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("id_periodo", id);
            parametros.put("descripcion", descripcion);
            File f = new File("reporte_pagos_extraordinarios.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(f);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, con);
            JRExporter exporter = new JRPdfExporter();
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("reporte_ext_"+descripcion+".pdf"));
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(CrearReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearReporteIns(int id, String descripcion) {
        try {
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se logró establecer la conexion", "Error", 0);
        }
        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/abonos?"
                    + "user=root&password=Falzar250");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("id_periodo", id);
            parametros.put("descripcion", descripcion);
            File f = new File("reporte_pagos_extraordinarios.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(f);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, con);
            JRExporter exporter = new JRPdfExporter();
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("reporte_inscripcion_"+descripcion+".pdf"));
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(CrearReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
