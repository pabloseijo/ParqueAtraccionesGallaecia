package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Visitante {

    private String DNI;
    private String nombre;
    private String correoElectronico;
    private String fechaNacimiento;
    private float altura;
    private int edad;
    
    /*private java.util.List<String> autores;
    private java.util.List<Categoria> categorias;
    private java.util.List<Ejemplar> ejemplares;*/

    public Visitante (String DNI, String nombre, String correoElectronico, String fechaNacimiento, float altura, int edad){
        this.DNI = DNI;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.edad = edad;
        
        /*autores = new java.util.ArrayList<String>();
        categorias = new java.util.ArrayList<Categoria>();
        ejemplares = new java.util.ArrayList<Ejemplar>();*/
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

    public String getFechaNacimiento (){
        return this.fechaNacimiento;
    }

    public float getAltura(){
        return this.altura;
    }

    public int getEdad (){
        return this.edad;
    }

    /*public java.util.List<String> getAutores (){
        return this.autores;
    }

    public void setAutores(java.util.List<String> autores){
        this.autores=autores;
    }

    public void addAutor (String autor){
        this.autores.add(autor);
    }

    public java.util.List<Categoria> getCategorias (){
        return this.categorias;
    }

    public void addCategoria (Categoria categoria){
        this.categorias.add(categoria);
    }

    public java.util.List<Ejemplar> getEjemplares (){
        return this.ejemplares;
    }
    
    public void addEjemplar (Ejemplar ejemplar){
        this.ejemplares.add(ejemplar);
    }
    
    public String getAutoresAsString(){
        String resultado="";
        Boolean inicial=true;

        for (String a:this.autores){
            if (inicial) {
                resultado=a;
                inicial=false;
            }
            else
            resultado=resultado+", "+a;
        }
        return resultado;
    }
    */

}
