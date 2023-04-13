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

    private Integer numeroRegistro;
    private String nombre;
    private Integer aforo;
    private Integer alturaMin;
    private Float costeMantenimiento;
    private Boolean enReparacion;
    private String ubicacion;
    private String descripcion;

    public Atraccion (Integer numeroRegistro, String nombre, Integer aforo, Integer alturaMin, Float costeMantenimiento, Boolean enReparacion, String ubicacion, String descripcion){
        this.numeroRegistro=numeroRegistro;
        this.nombre=nombre;
        this.aforo=aforo;
        this.alturaMin=alturaMin;
        this.costeMantenimiento=costeMantenimiento;
        this.enReparacion=enReparacion;
        this.ubicacion=ubicacion;
        this.descripcion=descripcion;
    }

    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAforo() {
        return aforo;
    }

    public Integer getAlturaMin() {
        return alturaMin;
    }

    public Float getCosteMantenimiento() {
        return costeMantenimiento;
    }

    public Boolean getEnReparacion() {
        return enReparacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}

