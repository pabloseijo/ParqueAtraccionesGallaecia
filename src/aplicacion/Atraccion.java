/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Atraccion {
    private String nombre, ubicacion, descripcion;
    private int aforo, alturaMin;   
    private float costeMantenimiento;
    private float beneficios;
    private int visitantes;

    public Atraccion(String nombre, String ubicacion, String descripcion, int aforo, int alturaMin, float costeMantenimiento) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.aforo = aforo;
        this.alturaMin = alturaMin;
        this.costeMantenimiento = costeMantenimiento;
    }
    //Constructor sin coste para consulta usuario 
      public Atraccion(String nombre, int aforo, int alturaMin, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.aforo = aforo;
        this.alturaMin = alturaMin;
    }
      
    //Constructor con beneficios para la función de administrador1
      
      public Atraccion(String nombre,Float beneficios, int visitantes) {
        this.nombre = nombre;
        this.beneficios=beneficios;
        this.visitantes=visitantes;
    }

    public String getNombre() {
        return nombre;
    }
    

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
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
    
    public float getBeneficios(){
        return this.beneficios;
    }
    
    public int getVisitantes(){
        return this.visitantes;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public void setAlturaMin(int alturaMin) {
        this.alturaMin = alturaMin;
    }

    public void setCosteMantenimiento(float costeMantenimiento) {
        this.costeMantenimiento = costeMantenimiento;
    }
    
    
    
}
