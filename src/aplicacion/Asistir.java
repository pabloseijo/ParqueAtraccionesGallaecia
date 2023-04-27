/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 * 
 */
public class Asistir {
    private Date fecha;
    private Time hora;
    private String visitante;
    private int espectaculo;

    public Asistir(Date fecha, Time hora, String dni, int espectaculo) {
        this.fecha = fecha;
        this.hora = hora;
        this.visitante = dni;
        this.espectaculo = espectaculo;
    }

    public String getVisitante() {
        return visitante;
    }

    public Date getFecha() {
        return fecha;
    }
    public Time getHora(){
        return hora;
    }

    public int getEspectaculo() {
        return espectaculo;
    }

    public void setVisitante(String dni) {
        this.visitante = dni;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEspectaculo(int espectaculo) {
        this.espectaculo = espectaculo;
    }

}
