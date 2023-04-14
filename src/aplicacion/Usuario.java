package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Usuario {
    private String nombreUsuario; 
    private String clave;
    private TipoUsuario tipo;

   public Usuario (String nombreUsuario, String clave, TipoUsuario tipo){
    this.nombreUsuario = nombreUsuario;
    this.clave=clave;
    this.tipo=tipo;
   }

   public String getIdUsuario(){

       return this.nombreUsuario;
   }

   public String getClave(){

       return this.clave;
   }

   public TipoUsuario getTipoUsuario(){

       return this.tipo;
   }

}
