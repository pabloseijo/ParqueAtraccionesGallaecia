/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class VisitanteResumen {
    private String DNI, nombre;
    private float dineroGastado;

    public VisitanteResumen(String DNI, String nombre, float dineroGastado) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.dineroGastado = dineroGastado;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public float getDineroGastado() {
        return dineroGastado;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDineroGastado(float dineroGastado) {
        this.dineroGastado = dineroGastado;
    }
    
    
}
