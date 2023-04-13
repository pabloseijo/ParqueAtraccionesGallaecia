
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Comer {
    
    private String fecha;
    private Visitante visitante;
    private Hosteleria establecimiento;

    public Comer(String fecha, Visitante visitante, Hosteleria establecimiento) {
        this.fecha = fecha;
        this.visitante = visitante;
        this.establecimiento = establecimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Hosteleria getEstablecimiento() {
        return establecimiento;
    }
       
}
