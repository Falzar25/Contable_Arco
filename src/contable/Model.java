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
    private static int semestre;
    private static int year;
    private static String month;
    private static int periodo;

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemestre() {
        return semestre;
    }

    public  void setSemestre(int semestre) {
        this.semestre = semestre;
    }

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
