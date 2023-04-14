package aplicacion;

public abstract class Trabajador {
    private String dni, nombre, direccion;
    private float salario;
    private String telefono, fechaInicio, fechaNacimiento, formacion;

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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaNacimiento() {
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

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }
}
