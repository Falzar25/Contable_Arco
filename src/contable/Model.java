/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contable;

/**
 *
 * @author Equipo
 */
public class Model {
    private static String nocontrol;
    private static String nombreAlumno;
    private static String saldoAlumno;
    private static int periodoActual;

    public int getPeriodoActual() {
        return periodoActual;
    }

    public void setPeriodoActual(int periodoActual) {
        Model.periodoActual = periodoActual;
    }
    
    public String getSaldoAlumno() {
        return saldoAlumno;
    }

    public void setSaldoAlumno(String saldoAlumno) {
       this.saldoAlumno = saldoAlumno;
    }    

    public String getNocontrol() {
        return nocontrol;
    }

    public void setNocontrol(String nocontrol) {
        this.nocontrol = nocontrol;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
}
