/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Equipo
 */
public class Conexion {

    Connection con = null;
    ResultSet rs = null;
    Statement cmd = null;
    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se logró establecer la conexion", "Error", 0);
        }
        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/abonos?"
                    + "user=root&password=p4j4r0_c4rp1nt3r0");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }

    public void mostrarTodo(DefaultTableModel m) {

        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();

            rs = cmd.executeQuery("SELECT tbl_alumnos.idalumnos, nombrealumnos, semestrealumnos, saldo FROM tbl_alumnos, tbl_saldo_total"
                    + " where status=1 and tbl_alumnos.idalumnos = tbl_saldo_total.idalumnos");

            while (rs.next()) {
                Object list[] = new Object[4];
                list[0] = rs.getString("idalumnos");
                list[1] = rs.getString("nombrealumnos");
                list[2] = rs.getString("semestrealumnos");
                list[3] = rs.getString("saldo");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void todosAlumnos(DefaultTableModel m) {

        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();

            rs = cmd.executeQuery("SELECT idalumnos, nombrealumnos, semestrealumnos FROM tbl_alumnos"
                    + " where status=1 order by semestrealumnos");

            while (rs.next()) {
                Object list[] = new Object[4];
                list[0] = rs.getString("idalumnos");
                list[1] = rs.getString("nombrealumnos");
                list[2] = rs.getString("semestrealumnos");
                list[3] = false;

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    public void mostrarBusqueda(DefaultTableModel m, String s) {

        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();

            rs = cmd.executeQuery("SELECT tbl_alumnos.idalumnos, nombrealumnos, semestrealumnos, saldo"
                    + " FROM tbl_alumnos, tbl_saldo_total where status=1 "
                    + "and tbl_alumnos.idalumnos = tbl_saldo_total.idalumnos "
                    + "and (tbl_alumnos.idalumnos='" + s + "' or nombrealumnos LIKE '%" + s + "%')");

            while (rs.next()) {
                Object list[] = new Object[4];
                list[0] = rs.getString("idalumnos");
                list[1] = rs.getString("nombrealumnos");
                list[2] = rs.getString("semestrealumnos");
                list[3] = rs.getString("saldo");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }

    }

    public void agregarAlumnos(int NC, String Name, int Semestre) {
        try {

            Statement cmd = con.createStatement();
            cmd.executeUpdate("INSERT INTO tbl_alumnos (idalumnos, nombrealumnos,"
                    + "semestrealumnos) values("+NC+" , '"+Name+"' , "+Semestre+")");
            cmd.executeUpdate("INSERT INTO tbl_alumnos (idalumnos, saldo) values("+NC+",0)");

        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
            
        }

    }
    
    public void editarAlumno(int EXNC, int NC, String Name, int Semestre) {
        try {

            Statement cmd = con.createStatement();
            cmd.executeUpdate("UPDATE tbl_alumnos SET idalumnos = '"+NC+"',"
                    + "nombrealumnos = '"+Name+"',"
                    + " semestrealumnos = '"+Semestre+"' WHERE "+EXNC+" = idalumnos");
            JOptionPane.showMessageDialog(null, "Alumno agregado correctamente", "Correcto", 4);

        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
            
        }

    }
    
    public void mesesCB(JComboBox cb, int id){
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();

            rs = cmd.executeQuery("select distinct pmMes from tbl_pagos_meses where idalumnos = '"+id+"'");
                    
            cb.removeAllItems();
            while(rs.next()){
                
                cb.addItem(rs.getString("pmMes"));
            
            }
            
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void añosCB(JComboBox cb){
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();

            rs = cmd.executeQuery("SELECT pmAño as pa from tbl_pagos_meses group by pmAño");
                    
            cb.removeAllItems();
            while(rs.next()){
                
                cb.addItem(rs.getString("pa"));
            
            }
            
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void infoAlumnoTable(DefaultTableModel m, int id, String año){
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();

            rs = cmd.executeQuery("Select pmMes, pmDeuda, pmPago from tbl_pagos_meses where idalumnos ='"
            +id+"' and pmAño = '"+año+"'");

            while (rs.next()) {
                Object list[] = new Object[3];
                list[0] = rs.getString("pmMes");
                list[1] = rs.getString("pmDeuda");
                list[2] = rs.getString("pmPago");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void infoAbonoTable_mensualidad(DefaultTableModel m, int id, String año){
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();

            rs = cmd.executeQuery("select fecha, cantidad, pmMes, ref from tbl_abonos, tbl_pagos_meses where tbl_abonos.iddeuda "
                    + "= tbl_pagos_meses.idpm and pmAño ='"+año+"' and idalumnos='"+id+"' and tipo_pago=1");

            while (rs.next()) {
                Object list[] = new Object[4];
                list[0] = rs.getString("fecha");
                list[1] = rs.getString("cantidad");
                list[2] = rs.getString("pmMes");
                list[3] = rs.getString("ref");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
        public void Abonar (String ab, String añ, String ms, String ref, int id){

            ResultSet rs = null;
            Statement cmd = null;
            String idpm = "";
            try {

                cmd = con.createStatement();

                rs = cmd.executeQuery("select idpm from tbl_pagos_meses where pmMes= "
                        + "'"+ms+"' and pmAño = '"+añ+"' and idalumnos = '"+id+"'");
                while (rs.next()){

                    idpm = rs.getString("idpm");

                }
                cmd.executeUpdate("INSERT INTO tbl_abonos (iddeuda, tipo_pago, cantidad, fecha, ref) values"
                        + "('"+idpm+"', 1, '"+ab+"', now(), '"+ref+"') ");
                cmd.executeUpdate("UPDATE tbl_pagos_meses set pmPago = (pmPago +'"+ab+"'), pmDeuda= (pmDeuda-'"+ab+"') where"
                        + " idpm ='"+idpm+"'");
                cmd.executeUpdate("UPDATE tbl_saldo_total set saldo = (saldo - '"+ab+"') where idalumnos = '"+id+"'");
            } catch(SQLException e){

                JOptionPane.showMessageDialog(null, e, "Error", 0);

            }
        }
    
    public void AsignarPagosM_Alumno(int nc, int can, String mes, String year){
        Statement cmd = null;
        try{
            cmd = con.createStatement();
            cmd.executeUpdate("INSERT INTO tbl_pagos_meses (idalumnos, pmMes , pmAño, pmDeuda, pmPago)"
                    + " values('"+nc+"', '"+mes+"', '"+year+"', '"+can+"', 0)");
            cmd.executeUpdate("UPDATE tbl_saldo_total set saldo = (saldo + '"+can+"') where idalumnos = '"+nc+"'");
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        
        }
        
    }
    
    public void AsignarPagosM_Tabla(ArrayList arr, int can, String mes, String year){
        
        Statement cmd = null;
        try{
            cmd = con.createStatement();
            for (Object a : arr) {
                cmd.executeUpdate("INSERT INTO tbl_pagos_meses (idalumnos, pmMes , pmAño, pmDeuda, pmPago)"
                    + " values('"+a+"', '"+mes+"', '"+year+"', '"+can+"', 0)");
                cmd.executeUpdate("UPDATE tbl_saldo_total set saldo = (saldo + '"+can+"') where idalumnos = '"+a+"'");
            }
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        
        
        }
    }
    public void todosLosMeses (JComboBox cb){
        
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();

            rs = cmd.executeQuery("select distinct pmMes from tbl_pagos_meses");
                    
            cb.removeAllItems();
            while(rs.next()){
                
                cb.addItem(rs.getString("pmMes"));
            
            }
            
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
        
    }
    
    public void mostrarExt(DefaultTableModel m, String periodo){
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where descripcion = '"+periodo+"'");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("SELECT tbl_alumnos.idalumnos, nombrealumnos, "
                    + "semestrealumnos, saldo_ext FROM tbl_alumnos, tbl_extraordinarios, tbl_periodos "
                    + "where tbl_alumnos.status=1 and tbl_alumnos.idalumnos = tbl_extraordinarios.idalumnos and tbl_periodos.idperiodo = "+idper+""
                    + " and tbl_periodos.idperiodo = tbl_extraordinarios.idperiodo");

            while (rs.next()) {
                Object list[] = new Object[4];
                list[0] = rs.getString("idalumnos");
                list[1] = rs.getString("nombrealumnos");
                list[2] = rs.getString("semestrealumnos");
                list[3] = rs.getString("saldo_ext");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void cbPeriodos(JComboBox cb){
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();
            rs = cmd.executeQuery("select descripcion from tbl_periodos");
                    
            cb.removeAllItems();
            while(rs.next()){
                
                cb.addItem(rs.getString("descripcion"));
            
            }
            
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void asignarExt(ArrayList arr){
        Statement cmd = null;
        ResultSet rs = null;
        try{
            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where status = 1");
            rs.next();
            int periodo = rs.getInt("idperiodo");
            rs = cmd.executeQuery("select valor_ext from tbl_valor_ext where id_valor = 1");
            rs.next();
            int valor = rs.getInt("valor_ext");
            for (Object obj : arr) {
                cmd.executeUpdate("INSERT INTO tbl_extraordinarios (idalumnos, idperiodo, saldo_ext, pago_ext) "
                        + "values("+obj+", "+periodo+", "+valor+", 0)");
            } 
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        
        }
    }
    
    public void todosAlumnosEXT(DefaultTableModel m) {

        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT idperiodo from tbl_periodos where status=1");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("SELECT idalumnos, nombrealumnos, semestrealumnos FROM tbl_alumnos where status=1 and not idalumnos in "
                    + "(select idalumnos from tbl_extraordinarios where idperiodo = "+idper+") order by semestrealumnos");

            while (rs.next()) {
                Object list[] = new Object[4];
                list[0] = rs.getString("idalumnos");
                list[1] = rs.getString("nombrealumnos");
                list[2] = rs.getString("semestrealumnos");
                list[3] = false;

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void cambiar_ext(int v){
        
        Statement cmd = null;
        try{
            cmd = con.createStatement();
                cmd.executeUpdate("UPDATE tbl_valor_ext set valor_ext="+v+" where id_valor=1");
           
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        
        
        }
    }
    public void infoAbonoTable_ext(DefaultTableModel m, int id, String per){
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where descripcion = '"+per+"'");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("select fecha, cantidad, ref from tbl_abonos, tbl_extraordinarios where tbl_abonos.iddeuda "
                    + "=idtbl_extraordinarios and idperiodo ='"+idper+"' and idalumnos='"+id+"' and tipo_pago=2");

            while (rs.next()) {
                Object list[] = new Object[3];
                list[0] = rs.getString("fecha");
                list[1] = rs.getString("cantidad");
                list[2] = rs.getString("ref");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    public void infoAlumnoTable_ext(DefaultTableModel m, int id, String per){
        ResultSet rs = null;
        Statement cmd = null;

        try {

            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where descripcion = '"+per+"'");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("SELECT saldo_ext, pago_ext from tbl_extraordinarios where idalumnos="
                    + ""+id+" and idperiodo ="+idper+"");

            while (rs.next()) {
                Object list[] = new Object[2];
                list[0] = rs.getString("saldo_ext");
                list[1] = rs.getString("pago_ext");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void AbonarExt (String ab, String ref, int id , String ap){
       
        try {
            
            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where descripcion = '"+ap+"'");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("select idtbl_extraordinarios from tbl_extraordinarios where "
                    + "idalumnos = "+id+" and idperiodo = "+idper+"");
            rs.next();
            int idext = rs.getInt("idtbl_extraordinarios");
            cmd.executeUpdate("INSERT INTO tbl_abonos (iddeuda, tipo_pago, cantidad, fecha, ref) values"
                    + "('"+idext+"', 2, '"+ab+"', now(), '"+ref+"') ");
            cmd.executeUpdate("UPDATE tbl_extraordinarios set pago_ext = (pago_ext +'"+ab+"'), saldo_ext= (saldo_ext-'"+ab+"') where"
                    + " idtbl_extraordinarios ='"+idext+"'");
        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
            
        }
    }
    
    public void mostrarTodoInscripcion(DefaultTableModel m) {

        try {
            
            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where status=1");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("SELECT tbl_alumnos.idalumnos, nombrealumnos, semestrealumnos, ins_saldo FROM tbl_alumnos, tbl_inscripcion"
                    + " where status=1 and tbl_alumnos.idalumnos = tbl_inscripcion.idalumnos and idperiodo = "+idper+"");

            while (rs.next()) {
                Object list[] = new Object[4];
                list[0] = rs.getString("idalumnos");
                list[1] = rs.getString("nombrealumnos");
                list[2] = rs.getString("semestrealumnos");
                list[3] = rs.getString("ins_saldo");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
        public void AsignarPagosI_Alumno(int nc, int can){
        
        try{
            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where status=1");
            rs.next();   
            int idper = rs.getInt("idperiodo");
            cmd = con.createStatement();
            cmd.executeUpdate("INSERT INTO tbl_inscripcion (idalumnos, idperiodo,ins_saldo, ins_pago)"
                    + " values('"+nc+"', '"+idper+"','"+can+"', 0)");
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        
        }
        
    }
    
    public void AsignarPagosI_Tabla(ArrayList arr, int can){
        
        try{
            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where status=1");
            rs.next();   
            int idper = rs.getInt("idperiodo");
            for (Object a : arr) {
                cmd.executeUpdate("INSERT INTO tbl_inscripcion(idalumnos, idperiodo,ins_saldo, ins_pago)"
                    + " values('"+a+"', '"+idper+"','"+can+"', 0)");
            }
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        
        
        }
    }
    public void todosAlumnosInscripcion(DefaultTableModel m) {


        try {

            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT idperiodo from tbl_periodos where status=1");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("SELECT idalumnos, nombrealumnos, semestrealumnos FROM tbl_alumnos where status=1 and not idalumnos in "
                    + "(select idalumnos from tbl_inscripcion where idperiodo = "+idper+") order by semestrealumnos");

            while (rs.next()) {
                Object list[] = new Object[4];
                list[0] = rs.getString("idalumnos");
                list[1] = rs.getString("nombrealumnos");
                list[2] = rs.getString("semestrealumnos");
                list[3] = false;

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void infoAbonoTable_ins(DefaultTableModel m, int id, String per){

        try {

            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where descripcion = '"+per+"'");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("select fecha, cantidad, ref from tbl_abonos, tbl_inscripcion where tbl_abonos.iddeuda "
                    + "=idinscripcion and idperiodo ='"+idper+"' and idalumnos='"+id+"' and tipo_pago=3");

            while (rs.next()) {
                Object list[] = new Object[3];
                list[0] = rs.getString("fecha");
                list[1] = rs.getString("cantidad");
                list[2] = rs.getString("ref");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    public void infoAlumnoTable_ins(DefaultTableModel m, int id, String per){

        try {

            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where descripcion = '"+per+"'");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("SELECT ins_saldo, ins_pago from tbl_inscripcion where idalumnos="
                    + ""+id+" and idperiodo ="+idper+"");

            while (rs.next()) {
                Object list[] = new Object[2];
                list[0] = rs.getString("ins_saldo");
                list[1] = rs.getString("ins_pago");

                m.addRow(list);
            }
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error", 0);

        }
    }
    
    public void AbonarIns (String ab, String ref, int id , String ap){
       
        try {
            
            cmd = con.createStatement();
            rs = cmd.executeQuery("select idperiodo from tbl_periodos where descripcion = '"+ap+"'");
            rs.next();
            int idper = rs.getInt("idperiodo");
            rs = cmd.executeQuery("select idinscripcion from tbl_inscripcion where "
                    + "idalumnos = "+id+" and idperiodo = "+idper+"");
            rs.next();
            int idins = rs.getInt("idinscripcion");
            cmd.executeUpdate("INSERT INTO tbl_abonos (iddeuda, tipo_pago, cantidad, fecha, ref) values"
                    + "('"+idins+"', 3, '"+ab+"', now(), '"+ref+"') ");
            cmd.executeUpdate("UPDATE tbl_inscripcion set ins_pago = (ins_pago +'"+ab+"'), ins_saldo= (ins_saldo-'"+ab+"') where"
                    + " idinscripcion ='"+idins+"'");
        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", 0);
            
        }
    }
}
