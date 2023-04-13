
package aplicacion;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Ir {
    private String fechaVisita;
    private String hora;
    private Visitante visitante;
    private Atraccion atraccion;

    public Ir(String fechaVisita, String hora, Visitante visitante, Atraccion atraccion) {
        this.fechaVisita = fechaVisita;
        this.hora = hora;
        this.visitante = visitante;
        this.atraccion = atraccion;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public String getHora() {
        return hora;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Atraccion getAtraccion() {
        return atraccion;
    }

    

}

