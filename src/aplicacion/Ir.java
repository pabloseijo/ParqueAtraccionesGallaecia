
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Ir {
    private String fechaVisita, visitante, atraccion;
    private Integer puntuacion;
    

    public Ir(String fechaVisita, String visitante, String atraccion, Integer puntuacion) {
        this.fechaVisita = fechaVisita;
        this.visitante = visitante;
        this.atraccion = atraccion;
        this.puntuacion = puntuacion;
        
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public String getVisitante() {
        return visitante;
    }

    public String getAtraccion() {
        return atraccion;
    }
    
    public Integer getPuntuacion(){
        return puntuacion;
    }

    
    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public void setAtraccion(String atraccion) {
        this.atraccion = atraccion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
    
}
