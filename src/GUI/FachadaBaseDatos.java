/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package baseDatos;

 import aplicacion.*;

 import java.sql.Date;
 import java.sql.SQLException;
 import java.sql.DriverManager;
 import java.util.ArrayList;

/**
  *
@author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
  */
 public class FachadaBaseDatos {
     private aplicacion.FachadaAplicacion fachadaAplicacion;
     private java.sql.Connection conexion;
     private AtraccionesDAO atraccionesDAO;
     private EspectaculosDAO espectaculosDAO;
     private UsuariosDAO usuariosDAO;
     private static TrabajadorDAO trabajadoresDAO;
     private HosteleriaDAO hosteleriaDAO;
     private IrDAO irDAO;
     private AsistirDAO asistirDAO;
     private ComerDAO comerDAO;
     private HostelerosDAO hostelerosDAO;
     private VisitantesDAO visitantesDAO;

     public FachadaBaseDatos (aplicacion.FachadaAplicacion fachadaAplicacion){
         
         this.fachadaAplicacion = fachadaAplicacion;
 
         try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error");
            }
            // Propiedades de la base de datos
            String gestor = "postgresql";
            String servidor = "localhost";
            String puerto = "5432";
            String baseDatos = "ParqueAtraccionesGallaecia";
            String url = "jdbc:postgresql://localhost:5432/parqueatraccionesgallaecia";

            String usuario = "alumnogreibd";
            String clave = "greibd2021";
 
            this.conexion = DriverManager.getConnection(url,
                      usuario, clave);
 
            // Inicializamos los DAOs
            atraccionesDAO = new AtraccionesDAO(conexion, fachadaAplicacion);
            usuariosDAO = new UsuariosDAO(conexion, fachadaAplicacion);
            espectaculosDAO = new EspectaculosDAO(conexion, fachadaAplicacion);
            hosteleriaDAO = new HosteleriaDAO(conexion, fachadaAplicacion);
            irDAO = new IrDAO(conexion, fachadaAplicacion);
            asistirDAO = new AsistirDAO(conexion, fachadaAplicacion);
            comerDAO = new ComerDAO(conexion, fachadaAplicacion);
            trabajadoresDAO = new TrabajadorDAO(conexion, fachadaAplicacion);
            hostelerosDAO = new HostelerosDAO(conexion, fachadaAplicacion);
            visitantesDAO = new VisitantesDAO(conexion, fachadaAplicacion);    
        
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

     public static ArrayList<Trabajador> getTrabajadores() throws SQLException {
         return trabajadoresDAO.getTrabajadores();
     }

     public void anhadirTrabajadorAdministracion(String dni, String nombre, String direccion, float salario, int telefono, Date fechaContratacion, Date fechaNacimiento, String formacion, int espectaculo, int atraccion) throws SQLException {
         trabajadoresDAO.anhadirTrabajadorAdministracion(dni, nombre, direccion, salario, telefono, fechaContratacion, fechaNacimiento, formacion, espectaculo, atraccion);
     }

     public void anhadirTrabajadorMantenimiento(String dni, String nombre, String direccion, float salario, int telefono, Date fechaContratacion, Date fechaNacimiento, String formacion, int atraccion) throws SQLException {
         trabajadoresDAO.anhadirTrabajadorMantenimiento(dni, nombre, direccion, salario, telefono, fechaContratacion, fechaNacimiento, formacion, atraccion);
     }

     public void anhadirTrabajadorEspectaculo(String dni, String nombre, String direccion, float salario, int telefono, Date fechaContratacion, Date fechaNacimiento, String formacion, int espectaculo) throws SQLException {
         trabajadoresDAO.anhadirTrabajadorEspectaculo(dni, nombre, direccion, salario, telefono, fechaContratacion, fechaNacimiento, formacion, espectaculo);
     }
}