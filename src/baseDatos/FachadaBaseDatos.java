/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package baseDatos;

 import aplicacion.*;

 import java.sql.Date;
 import java.sql.SQLException;
 import java.sql.DriverManager;
 import java.sql.Time;
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
    /** AUTENTIFICACION **/
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


    /** TRABAJADORES **/
    /**
     * Obtiene una lista de todos los trabajadores
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return un ArrayList<Trabajador> con todos los trabajadores.
     */
     public static ArrayList<Trabajador> getTrabajadores() throws SQLException {
         return trabajadoresDAO.getTrabajadores();
     }

    /**
     * Añade un nuevo trabajador de administracion
     *
     * @param dni el dni del trabajador.
     * @param nombre el nombre del trabajador.
     * @param direccion la direccion del trabajador.
     * @param salario el salario del trabajador.
     * @param telefono el telefono del trabajador.
     * @param fechaContratacion la fecha en la que el trabajador empezó a trabajar en el parque.
     * @param fechaNacimiento la fecha en la que el trabajador nació.
     * @param formacion descripcion de los estudios del trabajador.
     * @param espectaculo el espectaculo que supervisa el trabajador.
     * @param atraccion la atraccion que supervisa el trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
     public void anhadirTrabajadorAdministracion(String dni, String nombre, String direccion, float salario, int telefono, Date fechaContratacion, Date fechaNacimiento, String formacion, int espectaculo, int atraccion) throws SQLException {
         trabajadoresDAO.anhadirTrabajadorAdministracion(dni, nombre, direccion, salario, telefono, fechaContratacion, fechaNacimiento, formacion, espectaculo, atraccion);
     }

    /**
     * Añade un nuevo trabajador de mantenimiento
     *
     * @param dni el dni del trabajador.
     * @param nombre el nombre del trabajador.
     * @param direccion la direccion del trabajador.
     * @param salario el salario del trabajador.
     * @param telefono el telefono del trabajador.
     * @param fechaContratacion la fecha en la que el trabajador empezó a trabajar en el parque.
     * @param fechaNacimiento la fecha en la que el trabajador nació.
     * @param formacion descripcion de los estudios del trabajador.
     * @param atraccion la atraccion que supervisa el trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
     public void anhadirTrabajadorMantenimiento(String dni, String nombre, String direccion, float salario, int telefono, Date fechaContratacion, Date fechaNacimiento, String formacion, int atraccion) throws SQLException {
         trabajadoresDAO.anhadirTrabajadorMantenimiento(dni, nombre, direccion, salario, telefono, fechaContratacion, fechaNacimiento, formacion, atraccion);
     }

    /**
     * Añade un nuevo trabajador de espectaculos
     *
     * @param dni el dni del trabajador.
     * @param nombre el nombre del trabajador.
     * @param direccion la direccion del trabajador.
     * @param salario el salario del trabajador.
     * @param telefono el telefono del trabajador.
     * @param fechaContratacion la fecha en la que el trabajador empezó a trabajar en el parque.
     * @param fechaNacimiento la fecha en la que el trabajador nació.
     * @param formacion descripcion de los estudios del trabajador.
     * @param espectaculo el espectaculo que supervisa el trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
     public void anhadirTrabajadorEspectaculo(String dni, String nombre, String direccion, float salario, int telefono, Date fechaContratacion, Date fechaNacimiento, String formacion, int espectaculo) throws SQLException {
         trabajadoresDAO.anhadirTrabajadorEspectaculo(dni, nombre, direccion, salario, telefono, fechaContratacion, fechaNacimiento, formacion, espectaculo);
     }

    /**
     * Despide a un trabajador de mantenimiento
     *
     * @param dni el dni del trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void despedirTrabajadorMantenimiento(String dni) throws SQLException{
        trabajadoresDAO.despedirTrabajadorMantenimiento(dni);
    }

    /**
     * Despide a un trabajador de administracion
     *
     * @param dni el dni del trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void despedirTrabajadorAdministracion(String dni) throws SQLException{
        trabajadoresDAO.despedirTrabajadorAdministracion(dni);
    }

    /**
     * Despide a un trabajador de espectaculos
     *
     * @param dni el dni del trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void despedirTrabajadorEspectaculo(String dni) throws SQLException{
        trabajadoresDAO.despedirTrabajadorEspectaculo(dni);
    }


    /** ATRACCIONES **/
    /**
     * Elimina una atraccion
     *
     * @param id: identificador de la atraccion
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarAtraccion(int id) throws SQLException{
        atraccionesDAO.eliminarAtraccion(id);
    }

    /**
     * Añade una nueva atraccion.
     *
     * @param nombre el nombre de la atraccion.
     * @param aforo aforo de la atraccion.
     * @param alturaMin altura minima para entrar a la atraccion.
     * @param costeMantenimiento coste del mantenimiento de la atraccion.
     * @param enReparacion boolean, true si la atraccion esta en reparacion.
     * @param ubicaciones ubicacion de la atraccion.
     * @param descripcion descripcion de la atraccion.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void anhadirAtraccion(String nombre, int aforo, int alturaMin, float costeMantenimiento, boolean enReparacion, String ubicaciones, String descripcion) throws SQLException{
        atraccionesDAO.anhadirAtraccion(nombre, aforo, alturaMin, costeMantenimiento, enReparacion, ubicaciones, descripcion);
    }

    /** ESPECTACULOS **/
    /**
     * Elimina un espectaculo
     *
     * @param id: identificador de la atraccion
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarEspectaculo(int id) throws SQLException{
        espectaculosDAO.eliminarEspectaculo(id);
    }
    /**
     * Añade un nuevo espectaculo
     *
     * @param nombre el nombre del espectaculo.
     * @param sesion mañana,tarde o noche.
     * @param horaInicio hora de inicio del espectaculo.
     * @param horaFin hora de fin del espectaculo.
     * @param tematica la tematica del espectaculo.
     * @param descripcion descripcion del espectaculos.
     * @param ubicaciones ubicacion del espectaculos.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void anhadirEspectaculo(String nombre, String sesion, Time horaInicio, Time horaFin, String tematica, String descripcion, String ubicaciones) throws SQLException{
        espectaculosDAO.anhadirEspectaculo(nombre, sesion, horaInicio, horaFin, tematica, descripcion, ubicaciones);
    }


    /** RESTAURANTES **/
    /**
     * Elimina el restaurante seleccionada de la base de datos
     *
     * @param id: identificador del restaurante
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarRestaurante(int id) throws SQLException{
        hosteleriaDAO.eliminarRestaurante(id);
    }

    /**
     * Añade un nuevo restaurante
     *
     * @param nombre el nombre del restaurante.
     * @param aforo el limite de personas del restaurante.
     * @param ubicaciones ubicacion del restaurante.
     * @param horaApertura hora en la que abre el restaurante.
     * @param horaCierre hora de cierre del restaurante.
     * @param recaudacion recaudacion en el ultimo año fiscal del restaurante.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void anhadirRestaurante(String nombre, int aforo, String ubicaciones, Time horaApertura, Time horaCierre, float recaudacion) throws SQLException{
        hosteleriaDAO.anhadirRestaurante(nombre, aforo, ubicaciones, horaApertura, horaCierre, recaudacion);
    }

    /** HOSTELEROS **/

    /**
     * Elimina un hostelero de la base de datos
     *
     * @param dni: dni del hostelero
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarHostelero(String dni) throws SQLException{
        hostelerosDAO.eliminarHostelero(dni);
    }
}