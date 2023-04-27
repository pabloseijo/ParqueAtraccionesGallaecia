
package aplicacion;

import java.sql.Date;
import java.sql.Time;

/**
 *
@author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Comer {
    
    private Date fecha;
    private Time hora;
    private String visitante;
    private int establecimiento;

    public Comer(Date fecha, Time hora, String visitante, int establecimiento) {
        this.fecha = fecha;
        this.hora = hora;
        this.visitante = visitante;
        this.establecimiento = establecimiento;
    }

    public Date getFecha() {
        return fecha;
    }
    public Time getHora() {
        return hora;
    }

    public String getVisitante() {
        return visitante;
    }

    public int getEstablecimiento() {
        return establecimiento;
    }
       
}
