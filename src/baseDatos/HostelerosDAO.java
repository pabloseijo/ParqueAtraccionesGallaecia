/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import aplicacion.Hostelero;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class HostelerosDAO extends AbstractDAO{

    public HostelerosDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
    * Obtiene una lista de todos los hosteleros.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<Hostelero> con todos los hosteleros.
    */
    public ArrayList<Hostelero> getHosteleros() throws SQLException {
        ArrayList<Hostelero> resultado = new ArrayList<>();
        ResultSet rsHosteleros;
        PreparedStatement stmHosteleros = null;
        Connection con;
        con = super.getConexion();

        try {
            stmHosteleros = con.prepareStatement("SELECT * FROM Hosteleros ORDER BY fechaContratacion");
            rsHosteleros = stmHosteleros.executeQuery();
            Hostelero hostelero;
            while (rsHosteleros.next()) {
                hostelero = new Hostelero(rsHosteleros.getString("DNI"), rsHosteleros.getString("Nombre"), rsHosteleros.getString("Direccion"), rsHosteleros.getFloat("Salario"), rsHosteleros.getString("Telefono"), rsHosteleros.getDate("fechaContratacion"), rsHosteleros.getDate("fechaNacimiento"), rsHosteleros.getString("Formacion"), rsHosteleros.getInt("Espectaculo"));
                resultado.add(hostelero);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HostelerosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmHosteleros.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    /**
     * Elimina un hostelero de la base de datos
     *
     * @param dni: dni del hostelero
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarHostelero(String dni) throws SQLException{

        //Preparo la variable donde va a estar el statement
        PreparedStatement stmHostelero = null;

        //concecto con la base
        Connection con;
        con = super.getConexion();

        //intento la consulta y si se cumple la base de datos se actualiza
        try {
            stmHostelero = con.prepareStatement("DELETE from Hosteleros where DNI = ?");
            stmHostelero.setString(1, dni);
            stmHostelero.executeUpdate();
            stmHostelero.close();
        } catch (SQLException ex) {
            Logger.getLogger(EspectaculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmHostelero.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
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
    public void anhadirHostelero(String dni, String nombre, String direccion, float salario, int telefono, Date fechaContratacion, Date fechaNacimiento, String formacion, int establecimiento) throws SQLException {
        Connection con;
        con = super.getConexion();

        PreparedStatement stmHosteleros = null;
        try {
            stmHosteleros = con.prepareStatement("INSERT INTO Hosteleros (DNI,Nombre,Direccion,Salario,Telefono,fechaContratacion,fechaNacimiento,Formacion, Establecimiento) values(?,?,?,?,?,?,?,?,?)");
            stmHosteleros.setString(1, dni);
            stmHosteleros.setString(2, nombre);
            stmHosteleros.setString(3, direccion);
            stmHosteleros.setFloat(4, salario);
            stmHosteleros.setInt(5, telefono);
            stmHosteleros.setDate(6, fechaContratacion);
            stmHosteleros.setDate(7, fechaNacimiento);
            stmHosteleros.setString(8, formacion);
            stmHosteleros.setInt(9, establecimiento);
            stmHosteleros.executeUpdate();
            stmHosteleros.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmHosteleros.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}