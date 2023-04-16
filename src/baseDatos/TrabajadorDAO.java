/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import aplicacion.TrabajadorEspectaculo;
import aplicacion.TrabajadorMantenimiento;
import aplicacion.TrabajadorAdministracion;
import aplicacion.Trabajador;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class TrabajadorDAO extends AbstractDAO{

    public TrabajadorDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
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
        public void anhadirTrabajadorAdministracion(String dni, String nombre, String direccion, float salario, String telefono, Date fechaContratacion,  Date fechaNacimiento, String formacion, int espectaculo, int atraccion) throws SQLException {
            Connection con;
    
            con = super.getConexion();
            
            PreparedStatement stmTrabajador = null;
            stmTrabajador = con.prepareStatement("INSERT INTO TrabajadoresAdministracion (DNI,Nombre,Direccion,Salario,Telefono,fechaContratacion,fechaNacimiento,Formacion,Espectaculo, Atraccion) values(?,?,?,?,now(),?,?,?)");
            stmTrabajador.setString(1, dni);
            stmTrabajador.setString(2, nombre);
            stmTrabajador.setString(3, direccion);
            stmTrabajador.setFloat(4, salario);
            stmTrabajador.setString(5, telefono);
            stmTrabajador.setDate(6, fechaContratacion);
            stmTrabajador.setDate(7, fechaNacimiento);
            stmTrabajador.setString(8, formacion);
            stmTrabajador.setInt(9, espectaculo);
            stmTrabajador.setInt(10, atraccion);
            stmTrabajador.executeUpdate();
            stmTrabajador.close();
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
    public void anhadirTrabajadorMantenimiento(String dni, String nombre, String direccion, float salario, String telefono, Date fechaContratacion,  Date fechaNacimiento, String formacion, int atraccion) throws SQLException {
        Connection con;
        con = super.getConexion();
        
        PreparedStatement stmTrabajador = null;
        try {
            stmTrabajador = con.prepareStatement("INSERT INTO TrabajadoresMantenimiento (DNI,Nombre,Direccion,Salario,Telefono,fechaContratacion,fechaNacimiento,Formacion,Espectaculo, Atraccion) values(?,?,?,?,now(),?,?,?)");
            stmTrabajador.setString(1, dni);
            stmTrabajador.setString(2, nombre);
            stmTrabajador.setString(3, direccion);
            stmTrabajador.setFloat(4, salario);
            stmTrabajador.setString(5, telefono);
            stmTrabajador.setDate(6, fechaContratacion);
            stmTrabajador.setDate(7, fechaNacimiento);
            stmTrabajador.setString(8, formacion);
            stmTrabajador.setInt(10, atraccion);
            stmTrabajador.executeUpdate();
            stmTrabajador.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmTrabajador.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
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
    public void anhadirTrabajadorEspectaculo(String dni, String nombre, String direccion, float salario, String telefono, Date fechaContratacion,  Date fechaNacimiento, String formacion, int espectaculo) throws SQLException {
        Connection con;

        con = super.getConexion();
        
        PreparedStatement stmTrabajador = null;
        try {
            stmTrabajador = con.prepareStatement("INSERT INTO TrabajadoresAdministracion (DNI,Nombre,Direccion,Salario,Telefono,fechaContratacion,fechaNacimiento,Formacion,Espectaculo, Atraccion) values(?,?,?,?,now(),?,?,?)");
            stmTrabajador.setString(1, dni);
            stmTrabajador.setString(2, nombre);
            stmTrabajador.setString(3, direccion);
            stmTrabajador.setFloat(4, salario);
            stmTrabajador.setString(5, telefono);
            stmTrabajador.setDate(6, fechaContratacion);
            stmTrabajador.setDate(7, fechaNacimiento);
            stmTrabajador.setString(8, formacion);
            stmTrabajador.setInt(9, espectaculo);
            stmTrabajador.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                stmTrabajador.close();
                } catch (SQLException e) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
 
    }

         /**
         * Despide a un trabajador de administracion
         * 
         * @param dni el dni del trabajador.
         * @throws SQLException si hay un error al acceder a la base de datos
         */
    public void despedirTrabajadorAdministracion(String dni) throws SQLException {

        PreparedStatement stmTrabajador = null;
        Connection con;
        con = super.getConexion();
        try {
            stmTrabajador = con.prepareStatement("DELETE from TrabajadoresAdministracion where DNI = ?");
            stmTrabajador.setString(1, dni);
            stmTrabajador.executeUpdate();
            stmTrabajador.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmTrabajador.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

  
    }
         /**
         * Despide a un trabajador de mantenimiento
         * 
         * @param dni el dni del trabajador.
         * @throws SQLException si hay un error al acceder a la base de datos
         */
    public void despedirTrabajadorMantenimiento(String dni) throws SQLException {

        PreparedStatement stmTrabajador = null;
        Connection con;
        con = super.getConexion();
        try {
            stmTrabajador = con.prepareStatement("DELETE from TrabajadoresMantenimiento where DNI = ?");
            stmTrabajador.setString(1, dni);
            stmTrabajador.executeUpdate();
            stmTrabajador.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmTrabajador.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
         /**
         * Despide a un trabajador de espectaculos
         * 
         * @param dni el dni del trabajador.
         * @throws SQLException si hay un error al acceder a la base de datos
         */
    public void despedirTrabajadorEspectaculo(String dni) throws SQLException {

        PreparedStatement stmTrabajador = null;
        Connection con;
        con = super.getConexion();
        try {
            stmTrabajador = con.prepareStatement("DELETE from TrabajadoresEspectaculo where DNI = ?");
            stmTrabajador.setString(1, dni);
            stmTrabajador.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmTrabajador.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    

         /**
         * Obtiene una lista de todos los trabajadores de administracion.
         * 
         * @throws SQLException si hay un error al acceder a la base de datos
         * @return un ArrayList<TrabajadorAdministracion> con todos los trabajadores de administracion.
         */
    public ArrayList<TrabajadorAdministracion> getTrabajadoresAdministracion() throws SQLException {
        ArrayList<TrabajadorAdministracion> resultado = new ArrayList<>();
        ResultSet rsTrabajadores;
        PreparedStatement stmTrabajadores = null;
        Connection con;
        con = super.getConexion();

        try {
            stmTrabajadores = con.prepareStatement("SELECT * FROM TrabajadoresAdministracion ORDER BY fechaContratacion");
            rsTrabajadores = stmTrabajadores.executeQuery();
            TrabajadorAdministracion trabajador;
            while (rsTrabajadores.next()) {
                trabajador = new TrabajadorAdministracion(rsTrabajadores.getString("DNI"), rsTrabajadores.getString("Nombre"), rsTrabajadores.getString("Direccion"), rsTrabajadores.getFloat("Salario"), rsTrabajadores.getString("Telefono"), rsTrabajadores.getDate("fechaContratacion"), rsTrabajadores.getDate("fechaNacimiento"), rsTrabajadores.getString("Formacion"), rsTrabajadores.getInt("Espectaculo"), rsTrabajadores.getInt("Atraccion"));
                resultado.add(trabajador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmTrabajadores.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    /**
    * Obtiene una lista de todos los trabajadores de mantenimiento.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<TrabajadorMantenimiento> con todos los trabajadores de mantenimiento.
    */
    public ArrayList<TrabajadorMantenimiento> getTrabajadoresMantenimiento() throws SQLException {
        ArrayList<TrabajadorMantenimiento> resultado = new ArrayList<>();
        ResultSet rsTrabajadores;
        PreparedStatement stmTrabajadores = null;
        Connection con;
        con = super.getConexion();

        try {
            stmTrabajadores = con.prepareStatement("SELECT * FROM TrabajadoresMantenimiento ORDER BY fechaContratacion");
            rsTrabajadores = stmTrabajadores.executeQuery();
            TrabajadorMantenimiento trabajador;
            while (rsTrabajadores.next()) {
                trabajador = new TrabajadorMantenimiento(rsTrabajadores.getString("DNI"), rsTrabajadores.getString("Nombre"), rsTrabajadores.getString("Direccion"), rsTrabajadores.getFloat("Salario"), rsTrabajadores.getString("Telefono"), rsTrabajadores.getDate("fechaContratacion"), rsTrabajadores.getDate("fechaNacimiento"), rsTrabajadores.getString("Formacion"), rsTrabajadores.getInt("Atraccion"));
                resultado.add(trabajador);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmTrabajadores.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
    /**
    * Obtiene una lista de todos los trabajadores de espectaculos.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<TrabajadorEspectaculo> con todos los trabajadores de espectaculos.
    */
    public ArrayList<TrabajadorEspectaculo> getTrabajadoresEspectaculos() throws SQLException {
        ArrayList<TrabajadorEspectaculo> resultado = new ArrayList<>();
        ResultSet rsTrabajadores;
        PreparedStatement stmTrabajadores = null;
        Connection con;
        con = super.getConexion();

        try {
            stmTrabajadores = con.prepareStatement("SELECT * FROM TrabajadoresEspectaculo ORDER BY fechaContratacion");
            rsTrabajadores = stmTrabajadores.executeQuery();
            TrabajadorEspectaculo trabajador;
            while (rsTrabajadores.next()) {
                trabajador = new TrabajadorEspectaculo(rsTrabajadores.getString("DNI"), rsTrabajadores.getString("Nombre"), rsTrabajadores.getString("Direccion"), rsTrabajadores.getFloat("Salario"), rsTrabajadores.getString("Telefono"), rsTrabajadores.getDate("fechaContratacion"), rsTrabajadores.getDate("fechaNacimiento"), rsTrabajadores.getString("Formacion"), rsTrabajadores.getInt("Espectaculo"));
                resultado.add(trabajador);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmTrabajadores.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

         /**
         * Obtiene una lista de todos los trabajadores
         * 
         * @throws SQLException si hay un error al acceder a la base de datos
         * @return un ArrayList<Trabajador> con todos los trabajadores.
         */
        public ArrayList<Trabajador> getTrabajadores() throws SQLException {
            ArrayList<Trabajador> resultado = new ArrayList<>();

            // Trabajadores Administracion
            resultado.addAll(this.getTrabajadoresAdministracion());
    
            // Trabajadores mantenimiento
            resultado.addAll(this.getTrabajadoresMantenimiento());
    
            // Trabajadores Espectaculo
            resultado.addAll(this.getTrabajadoresEspectaculos());
    
            return resultado;
        }
}
