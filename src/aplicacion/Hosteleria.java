
package aplicacion;

import java.sql.Time;

/**
 *
@author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Hosteleria {
    
    private int codigoRegistro;
    private String nombre;
    private String ubicacion;
    private int aforo;
    private Time horaInicio;
    private Time horaFin;
    float recaudacion;

    public Hosteleria(int codigoRegistro, String nombre, int aforo, String ubicacion, Time horaInicio, Time horaFin, float recaudacion) {
        this.codigoRegistro = codigoRegistro;
        this.nombre = nombre;
        this.aforo = aforo;
        this.ubicacion = ubicacion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.recaudacion = recaudacion;
    }

    public int getCodigoRegistro() {
        return codigoRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getAforo() {
        return aforo;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public float getRecaudacion() {
        return recaudacion;
    }


    
    
    
}
