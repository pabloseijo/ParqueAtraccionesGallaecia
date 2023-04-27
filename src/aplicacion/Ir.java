
package aplicacion;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Ir {
    private Date fechaVisita;
    private Time hora;
    private String visitante;
    private int atraccion;

    public Ir(Date fechaVisita, Time hora, String visitante, int atraccion) {
        this.fechaVisita = fechaVisita;
        this.hora = hora;
        this.visitante = visitante;
        this.atraccion = atraccion;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public Time getHora() {
        return hora;
    }

    public String getVisitante() {
        return visitante;
    }

    public int getAtraccion() {
        return atraccion;
    }

    

}

