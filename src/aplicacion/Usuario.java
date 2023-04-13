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
    private String idUsuario; //será el DNI
    private String clave;
    private TipoUsuario tipo;

   public Usuario (String idUsuario, String clave, TipoUsuario tipo){
    this.idUsuario=idUsuario;
    this.clave=clave;
    this.tipo=tipo;
   }

   public String getIdUsuario(){

       return this.idUsuario;
   }

   public String getClave(){

       return this.clave;
   }

   public TipoUsuario getTipoUsuario(){

       return this.tipo;
   }

}
