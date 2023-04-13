/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 * 
 */
public class Asistir {
    private String visitante, fecha, espectaculo;
 
    public Asistir(String dni, String fecha, String nombreEspectaculo) {
        this.visitante = dni;
        this.fecha = fecha;
        this.espectaculo = nombreEspectaculo;
    }

    public String getVisitante() {
        return visitante;
    }

    public String getFecha() {
        return fecha;
    }

    public int getEspectaculo() {
        return espectaculo;
    }

    public void setVisitante(String dni) {
        this.visitante = dni;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEspectaculo(String nombreEspectaculo) {
        this.espectaculo = nombreEspectaculo;
    }

   
    
    
}
