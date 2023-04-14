/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class TrabajadorAdministracion extends Trabajador {
    private String nombreEspectaculo, nombreAtraccion;

    public TrabajadorAdministracion(String dni, String nombre, String direccion, float salario, String telefono, String fechaInicio, String fechaNacimiento, String nombreEspectaculo, String nombreAtraccion, String formacion) {
        super.setDni(dni);
        super.setNombre(nombre);
        super.setDireccion(direccion);
        super.setSalario(salario);
        super.setTelefono(telefono);
        super.setFechaInicio(fechaInicio);
        super.setFechaNacimiento(fechaNacimiento);
        this.nombreAtraccion = nombreAtraccion;
        this.nombreEspectaculo = nombreEspectaculo;
        super.setFormacion(formacion);
    }

    // Getters 
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }

    public String getNombreAtraccion() {
        return nombreAtraccion;
    }

    // Setters 

    public void setNombreEspectaculo(String nombreEspectaculo) {
        this.nombreEspectaculo = nombreEspectaculo;
    }

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }
    
}
