package aplicacion;

import java.sql.Date;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public abstract class Trabajador {
    private String dni; 
    private String nombre;
    private String direccion;
    private float salario;
    private String telefono;
    private String formacion;
    private Date fechaInicio;
    private Date fechaNacimiento;

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public float getSalario() {
        return salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFormacion() {
        return formacion;
    }

    
    
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }
}
