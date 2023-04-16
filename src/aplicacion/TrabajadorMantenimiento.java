/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.sql.Date;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class TrabajadorMantenimiento extends Trabajador {
    private int atraccion;

    public TrabajadorMantenimiento(String dni, String nombre, String direccion, float salario, String telefono, Date fechaInicio, Date fechaNacimiento, String formacion, int atraccion) {
        super.setDni(dni);
        super.setNombre(nombre);
        super.setDireccion(direccion);
        super.setSalario(salario);
        super.setTelefono(telefono);
        super.setFechaInicio(fechaInicio);
        super.setFechaNacimiento(fechaNacimiento);
        super.setFormacion(formacion);
        this.atraccion = atraccion;
    }

    // Getters

    public int getAtraccion() {
        return atraccion;
    }

   // Setters

    public void setAtraccion(int atraccion) {
        this.atraccion = atraccion;
    }
    
    
}
