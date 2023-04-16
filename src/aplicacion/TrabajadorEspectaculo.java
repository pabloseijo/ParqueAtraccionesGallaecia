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
public class TrabajadorEspectaculo extends Trabajador {
    private int espectaculo;

    public TrabajadorEspectaculo(String dni, String nombre, String direccion, float salario, String telefono, Date fechaInicio, Date fechaNacimiento, String formacion, int espectaculo) {
        super.setDni(dni);
        super.setNombre(nombre);
        super.setDireccion(direccion);
        super.setSalario(salario);
        super.setTelefono(telefono);
        super.setFechaInicio(fechaInicio);
        super.setFechaNacimiento(fechaNacimiento);
        super.setFormacion(formacion);
        this.espectaculo = espectaculo;
    }

    //Getters

    public int getEspectaculo() {
        return espectaculo;
    }


    // Setters
    public void setEspectaculo(int espectaculo) {
        this.espectaculo = espectaculo;
    }
    
}
