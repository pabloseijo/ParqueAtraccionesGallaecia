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
     private DAOUsuarios daoUsuarios;
     private HosteleriaDAO hosteleriaDAO;
     private IrDAO irDAO;
     private AsistirDAO asistirDAO;
     private ComerDAO comerDAO;
     private TrabajadorEspectaculoDAO trabajadoresEspectaculoDAO;
     private TrabajadorAdministracionDAO trabajadoresAdministracionDAO;
     private TrabajadorMantenimientoDAO trabajadoresMantenimientoDAO;
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
            daoUsuarios = new DAOUsuarios(conexion, fa);
            espectaculosDAO = new EspectaculosDAO(conexion, fa);
            hosteleriaDAO = new HosteleriaDAO(conexion, fa);
            irDAO = new IrDAO(conexion, fa);
            asistirDAO = new AsistirDAO(conexion, fa);
            comerDAO = new ComerDAO(conexion, fa);
            trabajadoresEspectaculoDAO = new TrabajadorEspectaculoDAO(conexion, fa);
            trabajadoresMantenimientoDAO = new TrabajadorMantenimientoDAO(conexion, fa);
            trabajadoresAdministracionDAO = new TrabajadorAdministracionDAO(conexion, fa);
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

}