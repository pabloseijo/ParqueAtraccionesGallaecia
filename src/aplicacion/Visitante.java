package aplicacion;

import java.sql.Date;



/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Visitante {

    private String DNI;
    private String nombre;
    private String correoElectronico;
    private Date fechaNacimiento;
    private int altura;
    private int edad;
    

    public Visitante (String DNI, String nombre, Date fechaNacimiento, int edad){
        this.DNI = DNI;
        this.nombre = nombre;
        //this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.edad = edad;
    }
    
    public String getDNI (){
        return this.DNI;
    }

    public String getNombre (){
        return this.nombre;
    }

    public String getCorreoElectronico (){
        return this.correoElectronico;
    }

    public Date getFechaNacimiento (){
        return this.fechaNacimiento;
    }

    public int getAltura(){
        return this.altura;
    }

    public int getEdad (){
        return this.edad;
    }
}
