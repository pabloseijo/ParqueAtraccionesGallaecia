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

    private Integer id;
    private String nombre;
    private String sesion;
    private String horaInicio;
    private String horaFin;
    private String tematica;
    private String descripcion;
    private String ubicacion;

    public Espectaculo(Integer id, String nombre, String sesion, String horaInicio, String horaFin, String tematica, String descripcion, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.sesion = sesion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tematica = tematica;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSesion() {
        return sesion;
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

    
    
}

