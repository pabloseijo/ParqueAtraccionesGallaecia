/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package baseDatos;

 import aplicacion.*;

 import java.sql.*;
 import java.util.ArrayList;

/**
  *
@author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
  */
 public class FachadaBaseDatos {
     private aplicacion.FachadaAplicacion fachadaAplicacion;
     private java.sql.Connection conexion;
     private static AtraccionesDAO atraccionesDAO;
     private static EspectaculosDAO espectaculosDAO;
     private UsuariosDAO usuariosDAO;
     private static TrabajadorDAO trabajadoresDAO;
     private static HosteleriaDAO hosteleriaDAO;
     private IrDAO irDAO;
     private AsistirDAO asistirDAO;
     private ComerDAO comerDAO;
     private HostelerosDAO hostelerosDAO;
     private static VisitantesDAO visitantesDAO;

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


    //////////////////////////////////////////////////** ATRACCIONES **/////////////////////////////////////////////////
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
    /**
     * Busca una atraccion en concreto por su nombre
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return la Atraccion buscada si existe.
     */
    public Atraccion buscaAtraccion(String nombreAtraccion) throws SQLException {
        return atraccionesDAO.buscaAtraccion(nombreAtraccion);
    }

    /**
     * Obtiene una lista de todos las atracciones.
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return un ArrayList<Atraccion> con todas las atracciones.
     */
    public static ArrayList<Atraccion> consultarAtracciones() throws SQLException{
        return atraccionesDAO.consultarAtracciones();
    }

    public void reservarEntrada(Date fecha, Time hora, String dni, String nombreAtraccion) throws SQLException {
        irDAO.reservarEntrada(fecha, hora, dni, nombreAtraccion);
    }

    ////////////////////////////////////////////////** ESPECTACULOS **//////////////////////////////////////////////////
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
    /**
     * Obtiene un espectaculo por su nombre.
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return el Espectaculo buscado si existe
     */
    public Espectaculo buscaEspectaculo(String nombreEspectaculo) throws SQLException {
        return espectaculosDAO.buscaEspectaculo(nombreEspectaculo);
    }

    /**
     * Obtiene una lista de todos los espectaculos.
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return un ArrayList<Espectaculo> con todos los espectaculos.
     */
    public static java.util.List<Espectaculo> consultarEspectaculos() throws SQLException{
        return espectaculosDAO.consultarEspectaculos();
    }

    ///////////////////////////////////////////////** RESTAURANTES **///////////////////////////////////////////////////
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
    /**
     * Obtiene un establecimiento por su nombre.
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return el Hosteleria buscado si existe.
     */
    public Hosteleria buscaEstablecimiento(String nombreEstablecimiento) throws SQLException {
        return hosteleriaDAO.buscaEstablecimiento(nombreEstablecimiento);
    }

    ////////////////////////////////////////////////** HOSTELEROS **////////////////////////////////////////////////////

    /**
     * Elimina un hostelero de la base de datos
     *
     * @param dni: dni del hostelero
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarHostelero(String dni) throws SQLException{
        hostelerosDAO.eliminarHostelero(dni);
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
     * @param establecimiento la atraccion que supervisa el trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void anhadirHostelero(String dni, String nombre, String direccion, float salario, int telefono, Date fechaContratacion, Date fechaNacimiento, String formacion, int establecimiento) throws SQLException{
        hostelerosDAO.anhadirHostelero(dni, nombre, direccion, salario, telefono, fechaContratacion, fechaNacimiento, formacion, establecimiento);
    }

    ////////////////////////////////////* FUNCIONES DE ACTUALIZACION *//////////////////////////////////////////////////

    /**
     * Añade un nuevo trabajador de espectaculos
     *
     * @param dni el dni del trabajador.
     * @param nombre el nombre del trabajador.
     * @param atraccion la atraccion en la que trabaja.
     * @param espectaculo el espectaculo que supervisa el trabajador.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void actualizarTrabajadorAdministracion(String dni, String nombre, int atraccion, int espectaculo) throws SQLException {
        trabajadoresDAO.actualizarTrabajadorAdministracion(dni, nombre, atraccion, espectaculo);
    }

    /**
     * Añade un nuevo trabajador de espectaculos
     *
     * @param dni el dni del trabajador.
     * @param nombre el nombre del trabajador.
     * @param atraccion la atraccion en la que trabaja
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void actualizarTrabajadorMantenimiento(String dni, String nombre, int atraccion) throws SQLException{
        trabajadoresDAO.actualizarTrabajadorMantenimiento(dni, nombre, atraccion);
    }


    /**
     * Añade un nuevo trabajador de espectaculos
     *
     * @param dni el dni del trabajador.
     * @param nombre el nombre del trabajador.
     * @param espectaculo el espectaculo en el que trabaja
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void actualizarTrabajadoresEspectaculo(String dni, String nombre, int espectaculo) throws SQLException{
        trabajadoresDAO.actualizarTrabajadoresEspectaculo(dni, nombre, espectaculo);
    }

    /////////////////////////////////////////////** FUNCIONES DE SALARIOS **////////////////////////////////////////////

    /**
     * Suma los salarios de un tipo de trabajador
     *
     * @param tipo de trabajador del que obtener la suma de salarios
     * @return la suma de los salarios del tipo introducido
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public float sumaSalarios(String tipo) throws SQLException{
        return trabajadoresDAO.sumaSalarios(tipo);
    }

    /**
     * Devuelve
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public float totalSalarios() throws SQLException {
        return trabajadoresDAO.totalSalarios();
    }

    /**
     * Actualiza el salario de los trabajadores de administracion
     *
     * @param dni el dni del trabajador.
     * @param salario el nuevo salario
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void actualizarSalarioAdministracion(String dni, float salario) throws SQLException{
        trabajadoresDAO.actualizarSalarioAdministracion(dni, salario);
    }


    /**
     * Actualiza los trabajadores de Mantenimiento
     *
     * @param dni el dni del trabajador.
     * @param salario el nuevo salario
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void actualizarSalarioMantenimiento(String dni, float salario) throws SQLException{
        trabajadoresDAO.actualizarSalarioMantenimiento(dni, salario);
    }


    /**
     * Actualiza los trabajadores de espectaculo
     *
     * @param dni el dni del trabajador.
     * @param salario el nuevo salario
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void actualizarSalarioEspectaculo(String dni, float salario) throws SQLException{
        trabajadoresDAO.actualizarSalarioEspectaculo(dni, salario);
    }
  
  ///////////////////////////////////////////** USUARIO **//////////////////////////////////////////////////////////////
    /**
     *
     * @param usuario id del usuario
     * @return informacion de los visitantes a los que ese usuario le compro la entrada
     * @throws SQLException si hay una error al acceder a la base de datos
     */
    public static ArrayList<Visitante> getEntradas(String usuario) throws SQLException{
        return visitantesDAO.getEntradas(usuario);
    }

    /**
     * Obtiene una lista de todos los visitantes.
     *
     * @param dni asociado a la entrada.
     * @param nombre asociado a la entrada.
     * @param fechaNacimiento del visitante asociado a la entrada
     * @param nombreUsuario asociado a la entrada
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return un ArrayList<Visitante> con todos los visitantes.
     */
    public void anhadirEntrada(String dni, String nombre, Date fechaNacimiento, String nombreUsuario) throws SQLException {
        visitantesDAO.anhadirEntrada(dni, nombre, fechaNacimiento, nombreUsuario);
    }

    ////////////////////////////////////////////** Hosteleria **////////////////////////////////////////////////////////
    /**
     * Obtiene una lista de todos los establecimientos.
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return un ArrayList<Hosteleria> con todos los establecimientos.
     */
    public static ArrayList<Hosteleria> getEstablecimientos() throws SQLException{
        return  hosteleriaDAO.getEstablecimientos();
    }

    /**
     * Añade una reserva a la tabla comer
     *
     * @param fecha en la que se ira al restaurante.
     * @param hora en la que se ira al restaurante.
     * @param dni de la persona que reserva.
     * @param nombreRestaurante del restaurante.
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void anhadirReserva( java.sql.Date fecha, Time hora, String dni, String nombreRestaurante) throws SQLException{
        hosteleriaDAO.anhadirReserva(fecha, hora, dni, nombreRestaurante);
    }

}
