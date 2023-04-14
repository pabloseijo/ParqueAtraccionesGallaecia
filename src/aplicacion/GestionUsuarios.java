
 package aplicacion;
 import GUI.FachadaGUI;
 import baseDatos.FachadaBaseDatos;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

 public class GestionUsuarios {
      
     FachadaGUI fgui;
     FachadaBaseDatos fbd;
     
    
     public GestionUsuarios(FachadaGUI fgui, FachadaBaseDatos fbd) {
      this.fgui = fgui;
      this.fbd = fbd;
     }  
     
     
   public Boolean comprobarAutentificacion(String idUsuario, String clave){
       Usuario u;
 
       u = fbd.validarUsuario(idUsuario, clave);
       if (u!=null){
           return u.getTipoUsuario()==TipoUsuario.Administrador;
       } else return false;
   }
   
 }