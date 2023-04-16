/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Atraccion {

    private int numeroRegistro;
    private String nombre;
    private int aforo;
    private int alturaMin;
    private float costeMantenimiento;
    private boolean enReparacion;
    private String ubicacion;
    private String descripcion;

    public Atraccion (int numeroRegistro, String nombre, int aforo, int alturaMin, float costeMantenimiento, boolean enReparacion, String ubicacion, String descripcion){
        this.numeroRegistro=numeroRegistro;
        this.nombre=nombre;
        this.aforo=aforo;
        this.alturaMin=alturaMin;
        this.costeMantenimiento=costeMantenimiento;
        this.enReparacion=enReparacion;
        this.ubicacion=ubicacion;
        this.descripcion=descripcion;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAforo() {
        return aforo;
    }

    public int getAlturaMin() {
        return alturaMin;
    }

    public float getCosteMantenimiento() {
        return costeMantenimiento;
    }

    public boolean getEnReparacion() {
        return enReparacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}

