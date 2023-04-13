
package aplicacion;

/**
 *
@author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Hosteleria {
    
    private int codigoRegistro;
    private String nombre;
    private String ubicacion;
    private int aforo;
    private String horaInicio;
    private String horaFin;

    public Hosteleria(int codigoRegistro, String nombre, String ubicacion, int aforo, String horaInicio, String horaFin) {
        this.codigoRegistro = codigoRegistro;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.aforo = aforo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }
    
    
    
}
