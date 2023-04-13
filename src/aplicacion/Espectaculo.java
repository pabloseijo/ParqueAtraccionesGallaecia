/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Espectaculo {
    private String nombre, horaInicio, horaFin, tematica, descripcion, ubicacion, activo;
    

    public Espectaculo(String nombre, String horaInicio, String horaFin, String tematica, String descripcion, String ubicacion, String activo) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tematica = tematica;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.activo = activo;
    }
    
    public Espectaculo(String nombre, String horaInicio, String horaFin, String tematica, String descripcion, String ubicacion) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tematica = tematica;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getTematica() {
        return tematica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getActivo() {
        return activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    
    
}
