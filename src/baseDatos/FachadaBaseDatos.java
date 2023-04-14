/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package baseDatos;

 import aplicacion.*;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.PreparedStatement;
 import java.sql.SQLException;
 import java.util.Properties;
 
 /**
  *
@author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
  */
 public class FachadaBaseDatos {
     private aplicacion.FachadaAplicacion fa;
     private java.sql.Connection conexion;
     private AtraccionesDAO atraccionesDAO;
     private EspectaculosDAO espectaculosDAO;
     private UsuariosDAO usuariosDAO;
     private TrabajadorDAO trabajadoresDAO;
     private HosteleriaDAO hosteleriaDAO;
     private IrDAO irDAO;
     private AsistirDAO asistirDAO;
     private ComerDAO comerDAO;
     private HostelerosDAO hostelerosDAO;
     private VisitantesDAO visitantesDAO;

     public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
         
         Properties configuracion = new Properties();
         this.fa=fa;
         FileInputStream arqConfiguracion;
 
         try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();
 
             Properties usuario = new Properties();
      
 
             String gestor = configuracion.getProperty("gestor");
 
             usuario.setProperty("user", configuracion.getProperty("usuario"));
             usuario.setProperty("password", configuracion.getProperty("clave"));
             this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                      configuracion.getProperty("servidor")+":"+
                      configuracion.getProperty("puerto")+"/"+
                      configuracion.getProperty("baseDatos"),
                      usuario);
 
            atraccionesDAO = new AtraccionesDAO(conexion, fa);
            usuariosDAO = new UsuariosDAO(conexion, fa);
            espectaculosDAO = new EspectaculosDAO(conexion, fa);
            hosteleriaDAO = new HosteleriaDAO(conexion, fa);
            irDAO = new IrDAO(conexion, fa);
            asistirDAO = new AsistirDAO(conexion, fa);
            comerDAO = new ComerDAO(conexion, fa);
            trabajadoresDAO = new TrabajadorDAO(conexion, fa);
            hostelerosDAO = new HostelerosDAO(conexion, fa);
            visitantesDAO = new VisitantesDAO(conexion, fa);    
        
        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
        } catch (IOException i){
          System.out.println(i.getMessage());
        } catch (java.sql.SQLException e){
          System.out.println(e.getMessage());
        }
          
      
    }

        /**
     * Comprueba si un usuario está en la base de datos
     * 
     * @param nombreUsuario el nombre del usuario.
     * @param clave la contraseña del usuario.
     * @return el usuario si existe.
     */
    public Usuario validarUsuario(String nombreUsuario, String clave){
      return usuariosDAO.validarUsuario(nombreUsuario, clave);
  }

}