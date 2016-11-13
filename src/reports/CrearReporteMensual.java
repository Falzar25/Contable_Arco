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
public class CrearReporteMensual {
    Connection con = null;
    public void crearReporte(String year) {
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
            parametros.put("year", year);
            File f = new File("reporte_pagos_mensuales.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(f);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, con);
            JRExporter exporter = new JRPdfExporter();
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("reportePDF.pdf"));
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(CrearReporteMensual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
