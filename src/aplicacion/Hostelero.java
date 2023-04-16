
package aplicacion;

import java.sql.Date;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Hostelero extends Trabajador{
    
    private int establecimiento;


    public Hostelero(String dni, String nombre, String direccion, float salario, String telefono, Date fechaInicio, Date fechaNacimiento, String formacion, int establecimiento) {
        super.setDni(dni);
        super.setNombre(nombre);
        super.setDireccion(direccion);
        super.setSalario(salario);
        super.setTelefono(telefono);
        super.setFechaInicio(fechaInicio);
        super.setFechaNacimiento(fechaNacimiento);
        super.setFormacion(formacion);
        this.establecimiento = establecimiento;
    }

    //Getters

    public int getEstablecimiento() {
        return establecimiento;
    }


    // Setters
    public void setEstablecimiento(int establecimiento) {
        this.establecimiento = establecimiento;
    }
    
}
