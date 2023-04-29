package aplicacion;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class Usuario {
    private String nombreUsuario; 
    private String email;
    private String clave;
    private TipoUsuario tipo;

   public Usuario (String nombreUsuario, String email, String clave, TipoUsuario tipo){
    this.nombreUsuario = nombreUsuario;
    this.email = email;
    this.clave = clave;
    this.tipo = tipo;
   }

   public String getIdUsuario(){

       return this.nombreUsuario;
   }

   public String getEmail(){

    return this.email;
}

   public String getClave(){

       return this.clave;
   }

   public TipoUsuario getTipoUsuario(){

       return this.tipo;
   }

 
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }   
}
